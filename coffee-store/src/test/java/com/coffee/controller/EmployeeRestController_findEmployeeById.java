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
public class EmployeeRestController_findEmployeeById {

    @Autowired
    private MockMvc mockMvc;

    /**
     * Create by TuyenTN
     * create date:10/08/2022
     * findEmployeeById() have param id = null
     */
    //find id = null
    @Test
    public void findEmployeeById_id_1() {
        try {
            this.mockMvc.perform(MockMvcRequestBuilders.get("/rest/employee/find/null"))
                    .andDo(print()).andExpect(status().is4xxClientError());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Create by TuyenTN
     * create date:10/08/2022
     * findEmployeeById() have param id = ''
     */
    @Test
    public void findEmployeeById_id_2() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/rest/employee/find/"))
                .andDo(print()).andExpect(status().is4xxClientError());
    }

    /**
     * Create by TuyenTN
     * create date:10/08/2022
     * findEmployeeById() have param id not have in database
     */
    @Test
    public void findEmployeeById_id_3() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/rest/employee/find/15"))
                .andDo(print()).andExpect(status().is4xxClientError());
    }

    /**
     * Create by TuyenTN
     * create date:10/08/2022
     * findEmployeeById() have param id have in database
     */
    @Test
    public void findEmployeeById_id_4() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/rest/employee/find/1"))
                .andDo(print()).andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("id").value(1))
                .andExpect(jsonPath("name").value("Tuyến"))
                .andExpect(jsonPath("birthday").value("1990-01-01"))
                .andExpect(jsonPath("phoneNumber").value("0935933888"))
                .andExpect(jsonPath("address").value("Đà Nẵng"))
                .andExpect(jsonPath("email").value("abc@gmail.com"))
                .andExpect(jsonPath("salary").value(1500000))
                .andExpect(jsonPath("image").value("aaaaaaa"))
                .andExpect(jsonPath("position").value("Quản Lý"))
                .andExpect(jsonPath("appUser").value("admin"))
                .andExpect(jsonPath("gender").value(1));
    }
}
