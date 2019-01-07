package com.lukash.votingsystem.controller;

import com.lukash.votingsystem.CustomUser;
import com.lukash.votingsystem.model.Restaurant;
import com.lukash.votingsystem.model.Vote;
import com.lukash.votingsystem.service.RestaurantService;
import com.lukash.votingsystem.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = VoteController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class VoteController {

    static final String REST_URL = "rest/vote";

    private final VoteService voteService;

    private final RestaurantService restaurantService;

    @Autowired
    public VoteController(final VoteService voteService, final RestaurantService restaurantService) {
        this.voteService = voteService;
        this.restaurantService = restaurantService;
    }

    @GetMapping
    public List<Vote> getAll() {
        return voteService.getAll();
    }

    @PostMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Vote> vote(@PathVariable("id") final Integer restaurantId) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        CustomUser customUser = (CustomUser) auth.getPrincipal();
        Integer userId = customUser.getUserId();
        Restaurant chosen = restaurantService.get(restaurantId);
        return new ResponseEntity<>(voteService.saveOrUpdate(userId, chosen), HttpStatus.CREATED);
    }
}
