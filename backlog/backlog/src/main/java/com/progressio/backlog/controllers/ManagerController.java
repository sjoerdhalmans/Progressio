package com.progressio.backlog.controllers;


import com.progressio.backlog.logic.BacklogCollectionLogic;
import com.progressio.backlog.logic.EpicCollectionLogic;
import com.progressio.backlog.logic.TaskCollectionLogic;
import com.progressio.backlog.logic.UserStoryCollectionLogic;
import com.progressio.backlog.models.Backlog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api", produces = MediaType.APPLICATION_JSON_VALUE)
public class ManagerController {
    @Autowired
    BacklogCollectionLogic backlogCollectionLogic;

//    @GetMapping(value = "/getBacklogById/{backlogid}")
//    public Backlog backlogById(@PathVariable(value = "backlogid") Long id) {
//        return projectCollectionLogic.getProjectById(id);
//    }
//
//    @GetMapping(value = "/getProjectsByUser/{userId}")
//    public List<Project> projectsByUser(@PathVariable(value = "userId") Long id) {
//        return projectCollectionLogic.getAllProjectsByUser(id);
//    }
//
//    @PostMapping(value = "/addProject")
//    public Project addProject(@RequestBody Project project) {
//        return projectCollectionLogic.addProject(project);
//    }
//
//    @PostMapping(value = "/addUserToProject")
//    public ProjectUsers addUserToProject(@RequestBody ProjectUsers projectUsers) {
//        Project project = projectCollectionLogic.getProjectById(projectUsers.getProjectId());
//
//        return projectLogic.addUserToProject(projectUsers, project);
//    }
//
//    @DeleteMapping(value = "/removeProject")
//    public void removeProject(@RequestBody Project project ) {
//        projectCollectionLogic.removeProject(project);
//    }
//
    @GetMapping(value = "/getAllBacklogs")
    public List<Backlog> getAllProject() {
        backlogCollectionLogic.gettest();
        return null;
    }
}
