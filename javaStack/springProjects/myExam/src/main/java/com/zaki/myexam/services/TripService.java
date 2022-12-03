package com.zaki.myexam.services;

import com.zaki.myexam.models.Trip;
import com.zaki.myexam.models.User;
import com.zaki.myexam.repositories.TripRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TripService {
    private final TripRepository tripRepo;

    public TripService(TripRepository tripRepo) {
        this.tripRepo = tripRepo;
    }

    public List<Trip> allTrips() {
        return tripRepo.findAll();
    }

    public Trip createTrip(Trip trip) {
        return tripRepo.save(trip);
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
    //            return tripRepo.save(trip);
    //        } else {
    //            result.rejectValue("gameDay", "d", "Please input a valid day of the week!!");
    //            return null;
    //        }
    //    }

    public void deleteTrip(Long id) {
        tripRepo.deleteById(id);
    }

    public Trip singleTrip(Long id) {
        Optional<Trip> optTrip = tripRepo.findById(id);
        if (optTrip.isPresent()) {
            return optTrip.get();
        } else {
            return null;
        }
    }

    public Trip updateTrip(Trip trip) {
        Trip tripToBeUpdated = tripRepo.findById(trip.getId()).get();
        if(trip!=null) {
            tripToBeUpdated.setCapacity(trip.getCapacity());
            tripToBeUpdated.setTitle(trip.getTitle());
            tripToBeUpdated.setDetails(trip.getDetails());
        }
        return tripRepo.save(tripToBeUpdated);
    }
}