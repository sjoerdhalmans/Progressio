package com.progressio.backlog.logic;

import com.progressio.backlog.dal.repo.EpicRepo;
import com.progressio.backlog.models.Epic;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class EpicCollectionLogic {

    @Autowired
    EpicRepo epicRepo;

    public List<Epic> getAllEpics() {
        return epicRepo.findAll();
    }
}

