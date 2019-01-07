package com.lukash.votingsystem.service;

import com.lukash.votingsystem.exception.NotFoundException;
import com.lukash.votingsystem.model.Lunch;
import com.lukash.votingsystem.model.Restaurant;
import com.lukash.votingsystem.repository.LunchRepository;
import com.lukash.votingsystem.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    private final LunchRepository lunchRepository;

    @Autowired
    public RestaurantService(final RestaurantRepository restaurantRepository, final LunchRepository lunchRepository) {
        this.restaurantRepository = restaurantRepository;
        this.lunchRepository = lunchRepository;
    }

    public Restaurant create(final Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    public void update(final Restaurant restaurant) {
        restaurantRepository.save(restaurant);
    }

    public Restaurant get(final Integer restaurantId) {
        return restaurantRepository.findById(restaurantId).orElseThrow(NotFoundException::new);
    }

    public List<Restaurant> getAll() {
        return restaurantRepository.findAll();
    }

    public List<Lunch> createMenu(final Integer restaurantId, final List<Lunch> menu) {
        Restaurant restaurant = get(restaurantId);
        menu.forEach(lunch -> lunch.setRestaurant(restaurant));
        return lunchRepository.saveAll(menu);
    }

    public List<Lunch> getAllMenuByRestaurant(final Integer restaurantId) {
        return lunchRepository.findByRestaurant_Id(restaurantId);
    }

    public void deleteMenu(final Integer restaurantId) {
        lunchRepository.deleteAllByRestaurant_Id(restaurantId);
    }
}
