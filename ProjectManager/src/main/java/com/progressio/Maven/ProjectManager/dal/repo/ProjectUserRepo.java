package com.progressio.Maven.ProjectManager.dal.repo;

import com.progressio.Maven.ProjectManager.models.ProjectUsers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectUserRepo extends JpaRepository<ProjectUsers, Long> {
}
