package com.lukash.votingsystem.service;

import com.lukash.votingsystem.exception.LateForVoteException;
import com.lukash.votingsystem.model.Restaurant;
import com.lukash.votingsystem.model.User;
import com.lukash.votingsystem.model.Vote;
import com.lukash.votingsystem.repository.UserRepository;
import com.lukash.votingsystem.repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
public class VoteService {

    private static final LocalTime DEADLINE = LocalTime.parse("11:00");

    private final VoteRepository voteRepository;

    private final UserRepository userRepository;

    @Autowired
    public VoteService(final VoteRepository voteRepository, final UserRepository userRepository) {
        this.voteRepository = voteRepository;
        this.userRepository = userRepository;
    }

    public List<Vote> getAll() {
        return voteRepository.findAll();
    }

    @Transactional
    public Vote saveOrUpdate(final Integer userId, final Restaurant restaurant) {

        LocalDate today = LocalDate.now();
        User user = userRepository.getOne(userId);
        Optional<Vote> current = voteRepository.findByUserAndDate(user, today);
        Vote created;

        if (current.isPresent()) {
            if (LocalTime.now().isAfter(DEADLINE)) {
                throw new LateForVoteException("You were voting today already");
            }
            created = current.get();
            created.setRestaurant(restaurant);
        } else {
            created = new Vote(user, restaurant, today);
        }
        return voteRepository.save(created);
    }
}
