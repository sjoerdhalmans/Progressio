package com.progressio.backlog.logic;

import com.progressio.backlog.dal.repo.EpicRepo;
import com.progressio.backlog.models.Epic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EpicCollectionLogic {
    @Autowired
    EpicRepo epicRepo;

    public List<Epic> getEpicsById(long projectId) {
        List<Epic> epics = getAllEpics();
        return filterEpicsById(epics, projectId);
    }

    public List<Epic> filterEpicsById(List<Epic> epics, long projectId) {
        List<Epic> foundEpics = new ArrayList<>();

        for (Epic epic : epics) {
            if (epic.getProjectId() == projectId) {
                foundEpics.add(epic);
            }
        }

        return foundEpics;
    }

    public List<Epic> getAllEpics() {
        return epicRepo.findAll();
    }
}

