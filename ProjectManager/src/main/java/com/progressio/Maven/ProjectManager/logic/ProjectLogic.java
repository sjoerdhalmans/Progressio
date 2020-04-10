package com.progressio.Maven.ProjectManager.logic;

import com.progressio.Maven.ProjectManager.dal.repo.ProjectUserRepo;
import com.progressio.Maven.ProjectManager.models.Project;
import com.progressio.Maven.ProjectManager.models.ProjectUsers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectLogic {
    @Autowired
    ProjectUserRepo projectUserRepo;

    public ProjectUsers addUserToProject(ProjectUsers projectUsers, Project project) {
        projectUsers.setProject(project);

        projectUsers.getProject().addUser(projectUsers);

        return projectUserRepo.save(projectUsers);
    }
}
