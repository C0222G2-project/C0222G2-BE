package com.coffee.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.Matchers.hasSize;

@SpringBootTest
@AutoConfigureMockMvc
public class DishOrderRestController_getListNewest {
    @Autowired
    private MockMvc mockMvc;

    public DishOrderRestController_getListNewest() {

    }

    /**
     * Created by: BaoTQ
     * Date create: 10/08/2022
     * Function: test list size = 0
     */
    @Test
    public void getListNewest_5() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/dish-order/newest", new Object[0]))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }



    /**
     * Created by: BaoTQ
     * Date create: 09/08/2022
     * Function: test list size > 0
     */
    @Test
    public void getListDishMostOrder_6() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/dish-order/newest", new Object[0]))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(5)))
                .andExpect(MockMvcResultMatchers.jsonPath("[2].name", new Object[0]).value("Soda dâu"))
                .andExpect(MockMvcResultMatchers.jsonPath("[2].id", new Object[0]).value(3))
                .andExpect(MockMvcResultMatchers.jsonPath("[2].price", new Object[0]).value(20000))
                .andExpect(MockMvcResultMatchers.jsonPath("[2].image", new Object[0]).value("url3"))
                .andExpect(MockMvcResultMatchers.jsonPath("[2].dateCreate", new Object[0]).value("2022-04-11"));
    }

}
