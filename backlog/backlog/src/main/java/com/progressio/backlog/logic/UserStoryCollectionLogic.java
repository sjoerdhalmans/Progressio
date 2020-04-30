package com.progressio.backlog.logic;

import com.progressio.backlog.dal.repo.UserStoryRepo;
import com.progressio.backlog.exception.ResourceNotFoundException;
import com.progressio.backlog.models.UserStory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserStoryCollectionLogic {
    @Autowired
    UserStoryRepo storyRepo;
    @Autowired
    EpicCollectionLogic epicLogic;

    public List<UserStory> getstoriesById(long projectId) {
        List<UserStory> stories = getAllStories();
        return filterstoriesById(stories, projectId);
    }

    private List<UserStory> filterstoriesById(List<UserStory> tasks, long projectId) {
        List<UserStory> foundUserStories = new ArrayList<>();

        for (UserStory userStory : tasks) {
            if (userStory.getProjectId() == projectId) {
                foundUserStories.add(userStory);
            }
        }

        return foundUserStories;
    }

    private List<UserStory> getAllStories() {
        return storyRepo.findAll();
    }

    public UserStory addStory(UserStory story) {
        int storyAmount = getstoriesById(story.getProjectId()).size();

        story.setPriority((long) storyAmount + 1);
        return storyRepo.save(story);
    }

    public UserStory getStoryById(long storyId) {
        return storyRepo.findById(storyId).orElseThrow(() -> new ResourceNotFoundException("UserStory", "id", storyId));
    }

    public UserStory updateStory(UserStory story) {
        if (story.getEpicId() != 0) {
            story.setEpic(epicLogic.getEpicById(story.getEpicId()));
        }
        if (story.getPriority() == null || story.getPriority() == 0) {
            story.setPriority(getStoryById(story.getId()).getPriority());
        }

        return storyRepo.save(story);
    }

    public void deleteStory(long id) {
        storyRepo.deleteById(id);
    }
}
