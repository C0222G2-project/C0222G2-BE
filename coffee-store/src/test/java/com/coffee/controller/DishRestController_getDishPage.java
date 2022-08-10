package com.coffee.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class DishRestController_getDishPage {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getDishPage_5() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/dish/getDishPage/")
        ).andDo(print()).andExpect(status().is(204));
    }

    @Test
    public void getDishPage_6() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/dish/getDishPage/")
        )
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(2))
                .andExpect(jsonPath("content[0].code").value("sv01"))
                .andExpect(jsonPath("content[0].name").value("Cà phê đen"))
                .andExpect(jsonPath("content[0].price").value("15.0"));

    }
}
