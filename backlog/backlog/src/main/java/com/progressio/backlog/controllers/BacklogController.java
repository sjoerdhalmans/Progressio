package com.progressio.backlog.controllers;


import com.progressio.backlog.logic.BacklogCollectionLogic;
import com.progressio.backlog.logic.EpicCollectionLogic;
import com.progressio.backlog.logic.TaskCollectionLogic;
import com.progressio.backlog.logic.UserStoryCollectionLogic;
import com.progressio.backlog.models.Backlog;
import com.progressio.backlog.models.Epic;
import com.progressio.backlog.models.Task;
import com.progressio.backlog.models.UserStory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api", produces = MediaType.APPLICATION_JSON_VALUE)
public class BacklogController {
    @Autowired
    BacklogCollectionLogic backlogCollectionLogic;
    @Autowired
    EpicCollectionLogic epicCollectionLogic;
    @Autowired
    UserStoryCollectionLogic userStoryCollectionLogic;
    @Autowired
    TaskCollectionLogic taskCollectionLogic;

    @GetMapping(value = "/getBacklogById/{backlogid}")
    public Backlog backlogById(@PathVariable(value = "backlogid") Long id) {
        return backlogCollectionLogic.getBacklogById(id);
    }

    @PostMapping(value ="/addEpic")
    public Epic addEpic(@RequestBody Epic epic) {
        return epicCollectionLogic.addEpic(epic);
    }

    @PostMapping(value ="/addStory")
    public UserStory addStory(@RequestBody UserStory story) {
        return userStoryCollectionLogic.addStory(story);
    }

    //test
    @PostMapping(value ="/addTask")
    public Task addTask(@RequestBody Task task) {
        return taskCollectionLogic.addTask(task);
    }

    @PutMapping(value ="/updateStory")
    public UserStory updateStory(@RequestBody UserStory story) {
        return userStoryCollectionLogic.updateStory(story);
    }

    @PutMapping(value ="/updateTask")
    public Task updateTask(@RequestBody Task task) {
        return taskCollectionLogic.updateTask(task);
    }

    @PutMapping(value ="/updateEpic")
    public Epic updateEpic(@RequestBody Epic epic) {
        return epicCollectionLogic.updateEpic(epic);
    }

    @DeleteMapping(value ="/deleteEpic/{epicid}")
    public void deleteEpic(@PathVariable(value="epicid") long id) {
        epicCollectionLogic.deleteEpic(id);
    }

    @DeleteMapping(value ="/deleteTask/{taskid}")
    public void deleteTask(@PathVariable(value="taskid") long id) {
        taskCollectionLogic.deleteTask(id);
    }

    @DeleteMapping(value ="/deleteStory/{storyid}")
    public void deleteStory(@PathVariable(value="storyid") long id) {
        userStoryCollectionLogic.deleteStory(id);
    }
}
