package com.lukash.votingsystem.service;

import com.lukash.votingsystem.model.User;
import com.lukash.votingsystem.util.TestUtil;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static com.lukash.votingsystem.util.TestData.*;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserService service;

    @Test
    void getByEmail() {
        User actual = service.getByEmail(USER_1.getEmail());
        TestUtil.assertMatch(actual, USER_1, "password");
    }

    @Test
    void getAllUsers() {
        assertIterableEquals(List.of(ADMIN, USER_1, USER_2), service.getAllUsers());
    }
}