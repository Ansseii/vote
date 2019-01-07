package com.lukash.votingsystem.repository;

import com.lukash.votingsystem.model.User;
import com.lukash.votingsystem.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface VoteRepository extends JpaRepository<Vote, Integer> {

    @Override
    @Transactional
    <S extends Vote> S save(final S entity);

    Optional<Vote> findByUserAndDate(final User user, final LocalDate date);
}
