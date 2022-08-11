package com.coffee.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class DishOrderRestController_getOrderHaveCode {
    @Autowired
    private MockMvc mockMvc;

    /**
     *  Author: BinhPX
     *  Date: 10/08/2022
     *  This function run check, and check fail when param is null
     * @throws Exception
     */
    @Test
    public void getOrderHaveCode_code_1() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/dish-order/get-order-have-code/null/"))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    /**
     *  Author: BinhPX
     *  Date: 10/08/2022
     *  This function run check, and check fail when param is empty
     * @throws Exception
     */
    @Test
    public void getOrderHaveCode_code_2() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/dish-order/get-order-have-code/"))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    /**
     *  Author: BinhPX
     *  Date: 10/08/2022
     *  This function run check, and return list data, param is a path variable on URI
     * @throws Exception
     */
    @Test
    public void getOrderHaveCode_code_4() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/dish-order/get-order-have-code/2"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
