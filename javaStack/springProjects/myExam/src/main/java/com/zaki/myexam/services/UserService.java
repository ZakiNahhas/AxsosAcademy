package com.zaki.myexam.services;

import com.zaki.myexam.models.LoginUser;
import com.zaki.myexam.models.Trip;
import com.zaki.myexam.models.User;
import com.zaki.myexam.repositories.UserRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private final UserRepository userRepo;

    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public User oneUser(Long id) {
        Optional<User> optUser = userRepo.findById(id);
        if (optUser.isPresent()) {
            return optUser.get();
        } else {
            return null;
        }
    }

    public User register(User newUser, BindingResult result) {

        if (userRepo.findByEmail(newUser.getEmail()).isPresent()) {
            result.rejectValue("email", "Unquie", "You better think of a new email");
        }
        if (!newUser.getPassword().equals(newUser.getConfirm())) {
            result.rejectValue("confirm", "Matches", "Passwords do not match");
        }
        if (result.hasErrors()) {
            return null;
        } else {
            String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
            newUser.setPassword(hashed);

            return userRepo.save(newUser);
        }
    }

    public User login(LoginUser newLogin, BindingResult result) {
        if (result.hasErrors()) {
            return null;
        }

        Optional<User> potentialUser = userRepo.findByEmail(newLogin.getEmail());
        if (!potentialUser.isPresent()) {
            System.out.println("not present");
            result.rejectValue("email", "notFound", "Email not found");
            return null;
        }

        User user = potentialUser.get();
        if (!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
            result.rejectValue("password", "Matches", "Is this really your account?");
        }

        if (result.hasErrors()) {
            return null;
        } else {
            return user;
        }
    }

    public User findUser(Long id) {
        Optional<User> user = userRepo.findById(id);
        if (user.isPresent()) {
            return user.get();
        } else {
            return null;
        }
    }

//    public List<User> getAssignedTrips(Trip trip) {
//        return userRepo.findAllByJoinTrips(trip);
//    }
//
//    public List<User> getUnassignedTrips(Trip trip) {
//        return userRepo.findByJoinTripsNotContains(trip);
//    }
}