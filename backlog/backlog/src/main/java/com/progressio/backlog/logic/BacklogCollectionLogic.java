package com.progressio.backlog.logic;

import com.progressio.backlog.dal.repo.EpicRepo;
import com.progressio.backlog.models.Backlog;
import com.progressio.backlog.models.Epic;
import com.progressio.backlog.models.Task;
import com.progressio.backlog.models.UserStory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BacklogCollectionLogic {
    @Autowired
    EpicRepo epicRepo;

    @Autowired
    private EpicCollectionLogic epicCollectionLogic;
    @Autowired
    private TaskCollectionLogic taskCollectionLogic;
    @Autowired
    private UserStoryCollectionLogic userStoryCollectionLogic;

    public Backlog getBacklogById(long projectId) {
        DuplicateFilter duplicateFilter = new DuplicateFilter();

        List<Epic> epics = epicCollectionLogic.getEpicsById(projectId);
        List<Task> tasks = taskCollectionLogic.getTasksById(projectId);
        List<UserStory> userStories = userStoryCollectionLogic.getstoriesById(projectId);
        Backlog backlog = new Backlog(epics, userStories, tasks);
        backlog = duplicateFilter.filterDuplicates(backlog);

        return backlog;
    }
}
