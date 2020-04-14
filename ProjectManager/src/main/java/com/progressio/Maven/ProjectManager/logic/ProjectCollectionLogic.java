package com.progressio.Maven.ProjectManager.logic;

import com.progressio.Maven.ProjectManager.dal.repo.ProjectRepo;
import com.progressio.Maven.ProjectManager.exception.ResourceNotFoundException;
import com.progressio.Maven.ProjectManager.models.Project;
import com.progressio.Maven.ProjectManager.models.ProjectUsers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectCollectionLogic {
    @Autowired
    ProjectRepo projectRepo;

    @Autowired
    ProjectConstructer projectConstructer = new ProjectConstructer();

    public Project addProject(Project project) {
        project = projectConstructer.generateProjectCode(project, getAllProjects());

        return projectRepo.save(project);
    }

    public void removeProject(Project project) {
        long projectId = project.getId();
        project = projectRepo.findById(projectId)
                .orElseThrow(() -> new ResourceNotFoundException("Project", "id", projectId));

        projectRepo.delete(project);
    }
    
    public List<Project> getAllProjectsByUser(long userId) {
        List<Project> projects = new ArrayList<>();
        for (Project project : getAllProjects()) {
            List<ProjectUsers> founduser = project.getUsers().stream()
                    .filter(user ->  user.getUser() == userId).collect(Collectors.toList());
            if (founduser.size() != 0) {
                projects.add(project);
            }
        }
        return projects;
    }

    public List<Project> getAllProjects() {
        String test = projectRepo.findAll().toString();
        return projectRepo.findAll(); }

    public Project getProjectById(Long id) { return projectRepo.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Project", "id", id));
    }

    public List<ProjectUsers> getUsersByProject() {
        return null;
    }
}
