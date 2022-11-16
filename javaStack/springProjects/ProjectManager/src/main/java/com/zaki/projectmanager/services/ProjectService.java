package com.zaki.projectmanager.services;

import com.zaki.projectmanager.models.Project;
import com.zaki.projectmanager.models.User;
import com.zaki.projectmanager.repositories.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepo projectRepo;

    public List<Project> findAllProjectNotAsProjectLead(User currentUser) {
        List<Project> projectsNotForUser = projectRepo.findAllByUsers(currentUser);
        return projectsNotForUser;
    }

    public List<Project> findAllProjectsAsProjectLeader(User currentUser) {
        List<Project> projectsForUser = projectRepo.findByUsersNotContains(currentUser);
        return projectsForUser;
    }

    public Project createProject(Project project) {
        return projectRepo.save(project);
    }

    public Project findProject(Long projectId) {
        Optional<Project> optionalProject = projectRepo.findById(projectId);
        if (optionalProject.isPresent()) {
            return optionalProject.get();
        } else {
            return null;
        }
    }

    public void deleteProject(Long id) {
        Project projectDelete = findProject(id);
        projectRepo.delete(projectDelete);
    }

    public Project updateProject(Project project) {
        return projectRepo.save(project);
    }
}