package com.zaki.myexam.repositories;

import com.zaki.myexam.models.Trip;
import com.zaki.myexam.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findAll();

    Optional<User> findByEmail(String email);

//    List<User> findByJoinTripsNotContains(Trip trip);
//
//    List<User> findAllByJoinTrips(Trip trip);
}