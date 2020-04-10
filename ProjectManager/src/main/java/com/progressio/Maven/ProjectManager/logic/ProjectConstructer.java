package com.progressio.Maven.ProjectManager.logic;

import com.progressio.Maven.ProjectManager.dal.repo.ProjectRepo;
import com.progressio.Maven.ProjectManager.models.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectConstructer {

    public ProjectConstructer() {
    }

    private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public Project generateProjectCode(Project project, List<Project> projects) {
        boolean availableProjectCode = false;

        while (!availableProjectCode) {
            project.setProjectCode(randomAlphaNumeric(10));
            availableProjectCode = checkProjectCodeAvailability(project.getProjectCode(), projects);
        }

        return project;
    }

    private static String randomAlphaNumeric(int count) {
        StringBuilder builder = new StringBuilder();
        while (count-- != 0) {
            int character = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());
            builder.append(ALPHA_NUMERIC_STRING.charAt(character));
        }

        return builder.toString();
    }

    private boolean checkProjectCodeAvailability(String projectCode, List<Project> projects) {
        ProjectCollectionLogic projectCollectionLogic = new ProjectCollectionLogic();
        List<Project> conflictingProjects = projects.stream().filter(project -> project.getProjectCode().equals(projectCode))
                .collect(Collectors.toList());

        if (conflictingProjects.size() == 0) {
            return true;
        }
        else {
            return false;
        }
    }
}
