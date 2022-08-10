package com.coffee.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
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
class PaymentRestController_displayDishOrderByIdTable {
    @Autowired
    private MockMvc mockMvc;

    /**
     * Create HoaNN
     * test displayDishOrderByIdTable_id_1,
     * displayDishOrderByIdTable_id_2,
     * displayDishOrderByIdTable_id_3,
     * displayDishOrderByIdTable_id_4
     * @throws Exception
     */
    @Test
    public void displayDishOrderByIdTable_id_1() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/payment/list/null")).
                andDo(print()).andExpect(status().is4xxClientError());
    }

    @Test
    public void displayDishOrderByIdTable_id_2() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/payment/list/5")).
                andDo(print()).andExpect(status().is4xxClientError());
    }
    @Test
    public void displayDishOrderByIdTable_id_3() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/payment/list/' '")).
                andDo(print()).andExpect(status().is4xxClientError());
    }

    @Test
    public void displayDishOrderByIdTable_id_4() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/payment/list/1")).
                andDo(print()).andExpect(status().is2xxSuccessful());
    }

}
