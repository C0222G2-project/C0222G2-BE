package com.coffee.controller;

import com.coffee.dto.DishDto;
import com.coffee.model.dish.Dish;
import com.coffee.model.dish.DishType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@SpringBootTest
@AutoConfigureMockMvc
public class DishRestController_editById {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void editDish_name_not_ok() throws Exception {
        Dish dish = new Dish();
        dish.setCode("C-F078");
        dish.setPrice(1000.0);
        dish.setName("cà phê sữa");
        dish.setImage("ảnh");
        dish.setIsDeleted(false);


        DishType dishType = new DishType();
        dishType.setId(1);
        dish.setDishType(dishType);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/dish/edit/1")
                        .content(this.objectMapper.writeValueAsString(dish))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void editDish_name_ok() throws Exception {
        Dish dish = new Dish();
        dish.setCode("C-F078");
        dish.setPrice(1000.0);
        dish.setName("cà phê sữa");
        dish.setImage("ảnh");
        dish.setIsDeleted(false);


        DishType dishType = new DishType();
        dishType.setId(1);
        dish.setDishType(dishType);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/dish/edit/1")
                        .content(this.objectMapper.writeValueAsString(dish))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
