package com.progressio.backlog.dal.repo;

import com.progressio.backlog.models.Epic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EpicRepo extends JpaRepository<Epic, Long> {
}
