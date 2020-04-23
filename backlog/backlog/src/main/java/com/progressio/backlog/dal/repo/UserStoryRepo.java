package com.progressio.backlog.dal.repo;

import com.progressio.backlog.models.UserStory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserStoryRepo extends JpaRepository<UserStory, Long> {
}
