package com.progressio.backlog.logic;

import com.progressio.backlog.dal.repo.TaskRepo;
import com.progressio.backlog.models.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskCollectionLogic {
    @Autowired
    TaskRepo taskRepo;

    public List<Task> getTasksById(long projectId) {
        List<Task> tasks = getAllTasks();
        return filterTasksById(tasks, projectId);
    }

    public List<Task> filterTasksById(List<Task> tasks, long projectId) {
        List<Task> foundTasks = new ArrayList<>();

        for (Task task : tasks) {
            if (task.getProjectId() == projectId) {
                foundTasks.add(task);
            }
        }

        return foundTasks;
    }

    public List<Task> getAllTasks() {
        return taskRepo.findAll();
    }
}
