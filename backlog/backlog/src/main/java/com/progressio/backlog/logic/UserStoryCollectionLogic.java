package com.progressio.backlog.logic;

import com.progressio.backlog.dal.repo.UserStoryRepo;
import com.progressio.backlog.models.UserStory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserStoryCollectionLogic {
    @Autowired
    UserStoryRepo userRepo;

    public List<UserStory> getstoriesById(long projectId) {
        List<UserStory> stories = getAllTasks();
        return filterTasksById(stories, projectId);
    }

    public List<UserStory> filterTasksById(List<UserStory> tasks, long projectId) {
        List<UserStory> foundUserStories = new ArrayList<>();

        for (UserStory userStory : tasks) {
            if (userStory.getProjectId() == projectId) {
                foundUserStories.add(userStory);
            }
        }

        return foundUserStories;
    }

    public List<UserStory> getAllTasks() {
        return userRepo.findAll();
    }
}
