package com.lukash.votingsystem.repository;

import com.lukash.votingsystem.model.Lunch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(readOnly = true)
public interface LunchRepository extends JpaRepository<Lunch, Integer> {

    @Override
    @Transactional
    <S extends Lunch> List<S> saveAll(final Iterable<S> entities);

    List<Lunch> findByRestaurant_Id(final Integer restaurantId);

    @Transactional
    void deleteAllByRestaurant_Id(final Integer restaurantId);
}
