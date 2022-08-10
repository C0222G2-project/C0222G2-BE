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
public class DishRestController_deleteDish {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void deleteDish_19() throws Exception{
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/dishType/delete/")
        ).andDo(print()).andExpect(status().is4xxClientError());
    }

    @Test
    public void deleteDish_20() throws Exception{
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/dishType/delete/''")
        ).andDo(print()).andExpect(status().is4xxClientError());
    }

    @Test
    public void deleteDish_21() throws Exception{
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/dishType/delete/'hello'")
        ).andDo(print()).andExpect(status().is4xxClientError());
    }

    @Test
    public void deleteDish_22() throws Exception{
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/dishType/delete/-1")
        ).andDo(print()).andExpect(status().is4xxClientError());
    }

    @Test
    public void deleteDish_23() throws Exception{
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/dishType/delete/2")
        ).andDo(print()).andExpect(status().is4xxClientError());
    }



    @Test
    public void deleteDish_24() throws Exception{
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/dishType/delete/1")
        ).andDo(print()).andExpect(status().is4xxClientError());
    }

}
