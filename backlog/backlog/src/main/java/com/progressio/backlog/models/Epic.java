package com.progressio.backlog.models;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name = "epics")
@EntityListeners(AuditingEntityListener.class)
public class Epic {
    public Epic() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    private String name;

    private @NotBlank Long projectId;

    @NotBlank
    private String description;

    @OneToMany(mappedBy = "epic", cascade = CascadeType.ALL, orphanRemoval = true)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<UserStory> stories;

    public void addTask(UserStory story) {
        stories.add(story);
        story.setEpic(this);
    }

    public void removeTask(UserStory story) {
        stories.remove(story);
        story.setEpic(null);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<UserStory> getStories() {
        return stories;
    }

    public void setStories(List<UserStory> stories) {
        this.stories = stories;
    }
}


