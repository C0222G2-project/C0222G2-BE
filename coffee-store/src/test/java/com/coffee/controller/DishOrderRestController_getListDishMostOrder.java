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
public class DishOrderRestController_getListDishMostOrder {
    @Autowired
    private MockMvc mockMvc;

    public DishOrderRestController_getListDishMostOrder() {
    }

    /**
     * Created by: BaoTQ
     * Date create: 10/08/2022
     * Function: test list size = 0
     */
    @Test
    public void getListDishMostOrder_5() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/dish-order/most-order", new Object[0]))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }



    /**
     * Created by: BaoTQ
     * Date create: 10/08/2022
     * Function: test list size > 0, and check first dish in list
     */
    @Test
    public void getListDishMostOrderFirst_6() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/dish-order/most-order", new Object[0]))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(5)))
                .andExpect(MockMvcResultMatchers.jsonPath("[0].name", new Object[0]).value("Trà đào"))
                .andExpect(MockMvcResultMatchers.jsonPath("[0].price", new Object[0]).value(15000))
                .andExpect(MockMvcResultMatchers.jsonPath("[0].image", new Object[0]).value("url4"))
                .andExpect(MockMvcResultMatchers.jsonPath("[0].timeOrder", new Object[0]).value(17))
                .andExpect(MockMvcResultMatchers.jsonPath("[0].dishId", new Object[0]).value(4));
    }


    /**
     * Created by: BaoTQ
     * Date create: 10/08/2022
     * Function: test list size > 0, and check last dish in list
     */
    @Test
    public void getListDishMostOrderLast_6() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/dish-order/most-order", new Object[0]))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(5)))
                .andExpect(MockMvcResultMatchers.jsonPath("[4].name", new Object[0]).value("Sữa tươi"))
                .andExpect(MockMvcResultMatchers.jsonPath("[4].price", new Object[0]).value(10000))
                .andExpect(MockMvcResultMatchers.jsonPath("[4].image", new Object[0]).value("url1"))
                .andExpect(MockMvcResultMatchers.jsonPath("[4].timeOrder", new Object[0]).value(5))
                .andExpect(MockMvcResultMatchers.jsonPath("[4].dishId", new Object[0]).value(1));
    }


}
