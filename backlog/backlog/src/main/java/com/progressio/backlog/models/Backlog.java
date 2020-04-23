package com.progressio.backlog.models;

import java.util.List;

public class Backlog {
    private List<Epic> epics;
    private List<UserStory> lonestories;
    private List<Task> lonetasks;

    public Backlog() {
    }

    public Backlog(List<Epic> epics, List<UserStory> lonestories, List<Task> lonetasks) {
        this.epics = epics;
        this.lonestories = lonestories;
        this.lonetasks = lonetasks;
    }

    public List<Epic> getEpics() {
        return epics;
    }

    public void setEpics(List<Epic> epics) {
        this.epics = epics;
    }

    public List<UserStory> getLonestories() {
        return lonestories;
    }

    public void setLonestories(List<UserStory> lonestories) {
        this.lonestories = lonestories;
    }

    public List<Task> getLonetasks() {
        return lonetasks;
    }

    public void setLonetasks(List<Task> lonetasks) {
        this.lonetasks = lonetasks;
    }
}
