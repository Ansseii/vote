package com.lukash.votingsystem.controller;

import com.lukash.votingsystem.model.User;
import com.lukash.votingsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = UserController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    static final String REST_URL = "rest/admin/users";

    private final UserService userService;

    @Autowired
    public UserController(final UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/find")
    public User getByEmail(final String email) {
        return userService.getByEmail(email);
    }

    @GetMapping
    public List<User> getAll() {
        return userService.getAllUsers();
    }
}
