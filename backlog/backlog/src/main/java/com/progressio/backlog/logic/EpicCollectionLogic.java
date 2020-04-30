package com.progressio.backlog.logic;

import com.progressio.backlog.dal.repo.EpicRepo;
import com.progressio.backlog.exception.ResourceNotFoundException;
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

    private List<Epic> filterEpicsById(List<Epic> epics, long projectId) {
        List<Epic> foundEpics = new ArrayList<>();

        for (Epic epic : epics) {
            if (epic.getProjectId() == projectId) {
                foundEpics.add(epic);
            }
        }

        return foundEpics;
    }

    private List<Epic> getAllEpics() {
        return epicRepo.findAll();
    }

    public Epic addEpic(Epic epic) {
        return epicRepo.save(epic);
    }

    public Epic getEpicById(long epicId) {
        return epicRepo.findById(epicId).orElseThrow(() -> new ResourceNotFoundException("Epic", "id", epicId));
    }

    public Epic updateEpic(Epic epic) {
        return epicRepo.save(epic);
    }

    public void deleteEpic(long id) {
        epicRepo.deleteById(id);
    }
}

