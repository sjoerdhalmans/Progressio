package com.progressio.Maven.ProjectManager.controllers;

import com.progressio.Maven.ProjectManager.logic.ProjectCollectionLogic;
import com.progressio.Maven.ProjectManager.logic.ProjectLogic;
import com.progressio.Maven.ProjectManager.models.Project;
import com.progressio.Maven.ProjectManager.models.ProjectUsers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api", produces = MediaType.APPLICATION_JSON_VALUE)
public class ManagerController {
    @Autowired
    ProjectCollectionLogic projectCollectionLogic;
    @Autowired
    ProjectLogic projectLogic;

    @GetMapping(value = "/getProjectById/{projectId}")
    public Project projectById(@PathVariable(value = "projectId") Long id) {
        return projectCollectionLogic.getProjectById(id);
    }

    @GetMapping(value = "/getProjectsByUser/{userId}")
    public List<Project> projectsByUser(@PathVariable(value = "userId") Long id) {
        return projectCollectionLogic.getAllProjectsByUser(id);
    }

    @PostMapping(value = "/addProject")
    public Project addProject(@RequestBody Project project) {
        return projectCollectionLogic.addProject(project);
    }

    @PostMapping(value = "/addUserToProject")
    public ProjectUsers addUserToProject(@RequestBody ProjectUsers projectUsers) {
        Project project = projectCollectionLogic.getProjectById(projectUsers.getProjectId());

        return projectLogic.addUserToProject(projectUsers, project);
    }

    @DeleteMapping(value = "/removeProject")
    public void removeProject(@RequestBody Project project ) {
        projectCollectionLogic.removeProject(project);
    }

    @GetMapping(value = "/getAllProjects")
    public List<Project> getAllProject() {
        return projectCollectionLogic.getAllProjects();
    }
}
