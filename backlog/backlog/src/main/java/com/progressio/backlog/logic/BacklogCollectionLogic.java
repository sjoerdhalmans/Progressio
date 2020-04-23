package com.progressio.backlog.logic;

import com.progressio.backlog.dal.repo.EpicRepo;
import com.progressio.backlog.models.Epic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BacklogCollectionLogic {
    @Autowired
    EpicRepo epicRepo;

    EpicCollectionLogic epicCollectionLogic = new EpicCollectionLogic();

    public void gettest() {
        List<Epic> epicss = epicRepo.findAll();
        List<Epic> epics = epicCollectionLogic.getAllEpics();
        System.out.println("test");
    }
}
