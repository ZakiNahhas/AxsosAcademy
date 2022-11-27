package com.zaki.myexam.services;

import com.zaki.myexam.models.Trip;
import com.zaki.myexam.repositories.TeamRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.Optional;

@Service
public class TripService {
    private final TeamRepository teamRepo;

    public TripService(TeamRepository teamRepo) {
        this.teamRepo = teamRepo;
    }

    public List<Trip> allTeams() {
        return teamRepo.findAll();
    }

    public Trip createTeam(Trip trip) {
        return teamRepo.save(trip);
    }

//    public Trip tripDay(Trip trip, BindingResult result) {
//        System.out.println(trip.getDay().equals("Monday"));
//        if (trip.getDay().equals("Monday") ||
//            trip.getDay().equals("Tuesday") || trip.getDay().equals("Wednesday") || trip.getDay().equals("Thursday") || trip.getDay()
//                                                                                                                            .equals("Friday") || trip.getDay()
//                                                                                                                                                     .equals(
//                                                                                                                                                         "Saturday") || trip.getDay()
//                                                                                                                                                                            .equals(
//                                                                                                                                                                                "Sunday") || trip.getDay()
//                                                                                                                                                                                                 .equals(
//                                                                                                                                                                                                     "Sunday") || trip.getDay()
//                                                                                                                                                                                                                      .equals(
//                                                                                                                                                                                                                          "sunday") || trip.getDay()
//                                                                                                                                                                                                                                           .equals(
//                                                                                                                                                                                                                                               "saturday") || trip.getDay()
//                                                                                                                                                                                                                                                                  .equals(
//                                                                                                                                                                                                                                                                      "saturday") || trip.getDay()
//                                                                                                                                                                                                                                                                                         .equals(
//                                                                                                                                                                                                                                                                                             "friday") || trip.getDay()
//                                                                                                                                                                                                                                                                                                              .equals(
//                                                                                                                                                                                                                                                                                                                  "thursday") || trip.getDay()
//                                                                                                                                                                                                                                                                                                                                     .equals(
//                                                                                                                                                                                                                                                                                                                                         "wednesday") || trip.getDay()
//                                                                                                                                                                                                                                                                                                                                                             .equals(
//                                                                                                                                                                                                                                                                                                                                                                 "tuesday") || trip.getDay()
//                                                                                                                                                                                                                                                                                                                                                                                   .equals(
//                                                                                                                                                                                                                                                                                                                                                                                       "monday")
//        ) {
//            return teamRepo.save(trip);
//        } else {
//            result.rejectValue("day", "g", "invalid day!!");
//            return null;
//        }
//    }

    public void deleteTeam(Long id) {
        teamRepo.deleteById(id);
    }

    public Trip singleTeam(Long id) {
        Optional<Trip> optTeam = teamRepo.findById(id);
        if (optTeam.isPresent()) {
            return optTeam.get();
        } else {
            return null;
        }
    }

    public Trip updateTeam(Trip trip) {
        return teamRepo.save(trip);
    }
}