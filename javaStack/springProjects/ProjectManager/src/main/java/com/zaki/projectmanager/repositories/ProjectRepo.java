package com.zaki.projectmanager.repositories;

import com.zaki.projectmanager.models.Project;
import com.zaki.projectmanager.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepo extends CrudRepository<Project, Long> {

    List<Project> findAll();

    List<Project> findAllByUsers(User user);

    List<Project> findByUsersNotContains(User user);
}