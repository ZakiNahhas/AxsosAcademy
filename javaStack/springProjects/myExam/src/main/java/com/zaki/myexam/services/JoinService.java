package com.zaki.myexam.services;

import com.zaki.myexam.models.Join;
import com.zaki.myexam.repositories.JoinRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class JoinService {
    private final JoinRepository joinRepo;

    public JoinService(JoinRepository joinRepo) {
        this.joinRepo = joinRepo;
    }

    public Join createJoin(Join join) {
        return joinRepo.save(join);
    }

    public Join singleJoin(Long id) {
        Optional<Join> optJoin = joinRepo.findById(id);
        if (optJoin.isPresent()) {
            return optJoin.get();
        } else {
            return null;
        }
    }

    public Join singleJoin() {
        Join optJoin = joinRepo.findTopByOrderByIdDesc();
        return optJoin;
    }

    public Join joinThisTrip(Join join) {
        Optional<Join> optJoin = joinRepo.findDistinctByTripAndUser(join.getTrip(), join.getUser());
        if (optJoin.isPresent()) {
            Join thisJoin = optJoin.get();
            joinRepo.deleteById(thisJoin.getId());
            return null;
        } else {
            return joinRepo.save(join);
        }
    }

    public List<Date> joinDate(Long trip_id) {
        List<Date> date =  joinRepo.getJoinDate(trip_id);
        return date;
    }
}
