package com.progressio.backlog.controllers;


import com.progressio.backlog.logic.BacklogCollectionLogic;
import com.progressio.backlog.models.Backlog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api", produces = MediaType.APPLICATION_JSON_VALUE)
public class ManagerController {
    @Autowired
    BacklogCollectionLogic backlogCollectionLogic;

    @GetMapping(value = "/getBacklogById/{backlogid}")
    public Backlog backlogById(@PathVariable(value = "backlogid") Long id) {
        return backlogCollectionLogic.getBacklogById(id);
    }
}
