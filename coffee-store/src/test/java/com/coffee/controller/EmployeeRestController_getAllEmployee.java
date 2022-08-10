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
public class EmployeeRestController_getAllEmployee {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getAllEmployee_9() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/rest/employee/list?searchName= null&searchPhone=0935912341&searchAccount=admin"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(1))
                .andExpect(jsonPath("$.content[0].id").value(2))
                .andExpect(jsonPath("$.content[0].name").value("Tuyến 1"))
                .andExpect(jsonPath("$.content[0].address").value("Đà Nẵng 1"))
                .andExpect(jsonPath("$.content[0].position").value("Phục Vụ"))
                .andExpect(jsonPath("$.content[0].email").value("abc1@gmail.com"))
                .andExpect(jsonPath("$.content[0].image").value("aaaaaaa2"))
                .andExpect(jsonPath("$.content[0].gender").value(1))
                .andExpect(jsonPath("$.content[0].phoneNumber").value("0935912341"))
                .andExpect(jsonPath("$.content[0].salary").value(1500000))
                .andExpect(jsonPath("$.content[0].appUser").value( "admin"))
                .andExpect(jsonPath("$.content[0].birthday").value("1990-01-01"));
    }
    @Test
    public void getAllEmployee_10() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/rest/employee/list?searchName=''&searchPhone=0935912341&searchAccount=admin"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(1))
                .andExpect(jsonPath("$.content[0].id").value(2))
                .andExpect(jsonPath("$.content[0].name").value("Tuyến 1"))
                .andExpect(jsonPath("$.content[0].address").value("Đà Nẵng 1"))
                .andExpect(jsonPath("$.content[0].position").value("Phục Vụ"))
                .andExpect(jsonPath("$.content[0].email").value("abc1@gmail.com"))
                .andExpect(jsonPath("$.content[0].image").value("aaaaaaa2"))
                .andExpect(jsonPath("$.content[0].gender").value(1))
                .andExpect(jsonPath("$.content[0].phoneNumber").value("0935912341"))
                .andExpect(jsonPath("$.content[0].salary").value(1500000))
                .andExpect(jsonPath("$.content[0].appUser").value( "admin"))
                .andExpect(jsonPath("$.content[0].birthday").value("1990-01-01"));
    }
    @Test
    public void getAllEmployee_11() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/rest/employee/list?searchName=aaaaaaaaaaaaaaaaaa&searchPhone=0935912341&searchAccount=admin"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(1))
                .andExpect(jsonPath("$.content[0].id").value(2))
                .andExpect(jsonPath("$.content[0].name").value("Tuyến 1"))
                .andExpect(jsonPath("$.content[0].address").value("Đà Nẵng 1"))
                .andExpect(jsonPath("$.content[0].position").value("Phục Vụ"))
                .andExpect(jsonPath("$.content[0].email").value("abc1@gmail.com"))
                .andExpect(jsonPath("$.content[0].image").value("aaaaaaa2"))
                .andExpect(jsonPath("$.content[0].gender").value(1))
                .andExpect(jsonPath("$.content[0].phoneNumber").value("0935912341"))
                .andExpect(jsonPath("$.content[0].salary").value(1500000))
                .andExpect(jsonPath("$.content[0].appUser").value( "admin"))
                .andExpect(jsonPath("$.content[0].birthday").value("1990-01-01"));
    }
    @Test
    public void getAllEmployee_12() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/rest/employee/list?searchName=Tuyến 1&searchPhone=0935912341&searchAccount=admin"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(1))
                .andExpect(jsonPath("$.content[0].id").value(2))
                .andExpect(jsonPath("$.content[0].name").value("Tuyến 1"))
                .andExpect(jsonPath("$.content[0].address").value("Đà Nẵng 1"))
                .andExpect(jsonPath("$.content[0].position").value("Phục Vụ"))
                .andExpect(jsonPath("$.content[0].email").value("abc1@gmail.com"))
                .andExpect(jsonPath("$.content[0].image").value("aaaaaaa2"))
                .andExpect(jsonPath("$.content[0].gender").value(1))
                .andExpect(jsonPath("$.content[0].phoneNumber").value("0935912341"))
                .andExpect(jsonPath("$.content[0].salary").value(1500000))
                .andExpect(jsonPath("$.content[0].appUser").value( "admin"))
                .andExpect(jsonPath("$.content[0].birthday").value("1990-01-01"));
    }
}
