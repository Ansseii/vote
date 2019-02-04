package com.lukash.votingsystem.util;

import com.lukash.votingsystem.model.Restaurant;
import com.lukash.votingsystem.model.Role;
import com.lukash.votingsystem.model.User;

public class TestData {

    public static final User ADMIN = new User(0, "Admin", "admin_1@gmail.com", "admin", Role.ROLE_ADMIN, Role.ROLE_USER);

    public static final User USER_1 = new User(1, "User_1", "user_1@gmail.com", "user", Role.ROLE_USER);

    public static final User USER_2 = new User(2, "User_2", "user_2@gmail.com", "user", Role.ROLE_USER);

    public static final Restaurant RESTAURANT_1 = new Restaurant(0, "Вино&Вода");

    public static final Restaurant RESTAURANT_2 = new Restaurant(1, "Корюшка");

    public static final Restaurant RESTAURANT_3 = new Restaurant(2, "Hooters");

    public static final Restaurant RESTAURANT_4 = new Restaurant(3, "Хочу Харчо");
}
