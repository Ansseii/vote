package com.lukash.votingsystem.controller;

import com.lukash.votingsystem.model.Restaurant;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static com.lukash.votingsystem.controller.RestaurantController.REST_URL;
import static com.lukash.votingsystem.util.TestData.RESTAURANT_2;
import static com.lukash.votingsystem.util.TestUtil.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@WithUserDetails(value = "admin_1@gmail.com")
class RestaurantControllerTest {

    private static final String RESTAURANT_REST_URL = "/" + REST_URL;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private RestaurantController controller;

    @Test
    void getRestaurantTest() throws Exception {
        mockMvc.perform(get(RESTAURANT_REST_URL + "/2"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

    @Test
    void getAllRestaurantsTest() throws Exception {
        mockMvc.perform(get(RESTAURANT_REST_URL)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void createRestaurantTest() throws Exception {
        Restaurant created = new Restaurant(null, "New");
        ResultActions action = mockMvc.perform(post(RESTAURANT_REST_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(writeValue(created)));

        Restaurant returned = readFromJsonResultActions(action, Restaurant.class);
        created.setId(returned.getId());

        assertMatch(returned, created);
    }

    @Test
    void updateRestaurantTest() throws Exception {
        Restaurant updated = new Restaurant(RESTAURANT_2.getId(), "UpdatedName");
        mockMvc.perform(put(RESTAURANT_REST_URL + "/" + RESTAURANT_2.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(writeValue(updated)));

        assertMatch(controller.get(RESTAURANT_2.getId()), updated, "menu");
    }
}