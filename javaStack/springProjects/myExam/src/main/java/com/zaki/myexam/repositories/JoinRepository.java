package com.zaki.myexam.repositories;

import com.zaki.myexam.models.Join;
import com.zaki.myexam.models.Trip;
import com.zaki.myexam.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface JoinRepository extends CrudRepository<Join, Long> {
    List<Join> findAll();
    @Query(value = "SELECT created_at FROM joins WHERE trip_id =?1", nativeQuery = true)
    List<Date> getJoinDate(Long trip_id);

    Optional<Join> findByUser(User user);
    Join findTopByOrderByIdDesc();
    Optional<Join> findDistinctByTripAndUser(Trip trip, User user);
}
