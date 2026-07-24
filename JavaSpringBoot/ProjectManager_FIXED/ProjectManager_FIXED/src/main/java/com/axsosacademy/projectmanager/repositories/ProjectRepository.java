package com.axsosacademy.projectmanager.repositories;

import com.axsosacademy.projectmanager.models.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {

    List<Project> findAllByLeadIdOrderByDueDateAsc(Long leadId);

    List<Project> findAllByLeadIdNotOrderByDueDateAsc(Long leadId);
}
