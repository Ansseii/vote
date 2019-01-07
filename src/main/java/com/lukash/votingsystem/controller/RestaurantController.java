package com.lukash.votingsystem.controller;

import com.lukash.votingsystem.model.Lunch;
import com.lukash.votingsystem.model.Restaurant;
import com.lukash.votingsystem.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.lukash.votingsystem.util.ValidationUtil.assureIdConsistent;
import static com.lukash.votingsystem.util.ValidationUtil.checkNew;

@RestController
@RequestMapping(value = RestaurantController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class RestaurantController {

    static final String REST_URL = "rest/admin/restaurants";

    private final RestaurantService restaurantService;

    @Autowired
    public RestaurantController(final RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping(value = "/{id}")
    public Restaurant get(@PathVariable("id") final Integer restaurantId) {
        return restaurantService.get(restaurantId);
    }

    @GetMapping
    public List<Restaurant> getAll() {
        return restaurantService.getAll();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Restaurant> create(@RequestBody final Restaurant restaurant) {
        checkNew(restaurant);
        Restaurant created = restaurantService.create(restaurant);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void update(@PathVariable("id") final Integer restaurantId, @RequestBody final Restaurant restaurant) {
        assureIdConsistent(restaurant, restaurantId);
        restaurantService.update(restaurant);
    }

    @GetMapping(value = "/{id}/menu")
    public List<Lunch> getAllMenu(@PathVariable("id") final Integer restaurantId) {
        return restaurantService.getAllMenuByRestaurant(restaurantId);
    }

    @PostMapping(value = "/{id}/menu", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Lunch>> createMenu(@PathVariable("id") final Integer restaurantId,
                                                  @RequestBody final List<Lunch> menu) {
        return new ResponseEntity<>(restaurantService.createMenu(restaurantId, menu), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}/menu")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMenu(@PathVariable("id") final Integer restaurantId) {
        restaurantService.deleteMenu(restaurantId);
    }
}
