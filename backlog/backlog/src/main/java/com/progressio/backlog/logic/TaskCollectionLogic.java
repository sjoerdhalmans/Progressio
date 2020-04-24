package com.progressio.backlog.logic;

import com.progressio.backlog.dal.repo.TaskRepo;
import com.progressio.backlog.models.Task;
import com.progressio.backlog.models.UserStory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskCollectionLogic {
    @Autowired
    TaskRepo taskRepo;
    @Autowired
    UserStoryCollectionLogic storyLogic;

    public List<Task> getTasksById(long projectId) {
        List<Task> tasks = getAllTasks();
        return filterTasksById(tasks, projectId);
    }

    private List<Task> filterTasksById(List<Task> tasks, long projectId) {
        List<Task> foundTasks = new ArrayList<>();

        for (Task task : tasks) {
            if (task.getProjectId() == projectId) {
                foundTasks.add(task);
            }
        }

        return foundTasks;
    }

    private List<Task> getAllTasks() {
        return taskRepo.findAll();
    }

    public Task addTask(Task task) {
        return taskRepo.save(task);
    }

    public Task updateTask(Task task) {
        if (task.getStoryId() != 0) {
            task.setStory(storyLogic.getStoryById(task.getStoryId()));
        }

        return taskRepo.save(task);
    }
}
