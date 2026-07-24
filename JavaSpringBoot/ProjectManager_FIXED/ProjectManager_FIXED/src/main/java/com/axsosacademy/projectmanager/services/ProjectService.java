package com.axsosacademy.projectmanager.services;

import com.axsosacademy.projectmanager.models.Project;
import com.axsosacademy.projectmanager.repositories.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public List<Project> findMyProjects(Long userId) {
        return projectRepository.findAllByLeadIdOrderByDueDateAsc(userId);
    }

    public List<Project> findOtherProjects(Long userId) {
        return projectRepository.findAllByLeadIdNotOrderByDueDateAsc(userId);
    }

    public Project findById(Long id) {
        return projectRepository.findById(id).orElse(null);
    }

    public Project create(Project project) {
        return projectRepository.save(project);
    }

    public Project update(Project existingProject, Project formProject) {
        existingProject.setTitle(formProject.getTitle());
        existingProject.setDescription(formProject.getDescription());
        existingProject.setDueDate(formProject.getDueDate());

        return projectRepository.save(existingProject);
    }

    public void delete(Project project) {
        projectRepository.delete(project);
    }

    public boolean isOwner(Project project, Long userId) {
        return project != null
                && project.getLead() != null
                && project.getLead().getId().equals(userId);
    }
}
