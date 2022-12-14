package com.zaki.myexam.repositories;

import com.zaki.myexam.models.Trip;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TripRepository extends CrudRepository<Trip, Long> {
    List<Trip> findAll();
    //    Optional<Trip> findByName(String trip);
    Optional<Trip> findById(Long id);
}