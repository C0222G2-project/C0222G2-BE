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
public class AccountEmployeeRestController_getInfoAccountEmployee {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void  getInfoAccountEmployee_id_1() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/api/account/accountEmployee/null")).andDo(print()).andExpect(status().is4xxClientError());
    }
    @Test
    public void getInfoAccountEmployee_id_2() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/api/account/accountEmployee/")
        ).andDo(print()).andExpect(status().is4xxClientError());
    }
    @Test
    public void getInfoAccountEmployee_id_3() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/api/account/accountEmployee/33")
        ).andDo(print()).andExpect(status().is4xxClientError());

    }
    @Test
    public void getInfoAccountEmployee_id_4() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/api/account/accountEmployee/6"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("userName").value("admin"))
                .andExpect(jsonPath("nameEmployee").value("thông"))
                .andExpect(jsonPath("address").value("Quảng Nam"))
                .andExpect(jsonPath("gender").value(1))
                .andExpect(jsonPath("phoneNumber").value("092398989"))
                .andExpect(jsonPath("birthDay").value("1990-09-09"))
                .andExpect(jsonPath("salary").value("1500000.0"))
                .andExpect(jsonPath("positionName").value("quản lí"));
    }
}
