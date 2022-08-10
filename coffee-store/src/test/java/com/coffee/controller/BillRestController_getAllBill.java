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
public class BillRestController_getAllBill {

    @Autowired
    private MockMvc mockMvc;


    /**
     * Created by: HauLT
     * Date created: 10/08/2022
     * function: check with case 1 field equals null
     * @throws Exception
     */

    @Test
    public void getAllBill_7_searchDate() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/rest/bill/page?searchCode = BIll-1&searchDate = null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: HauLT
     * Date created: 10/08/2022
     * function: check with case 1 field equals null
     * @throws Exception
     */

    @Test
    public void getAllBill_7_searchCode() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/rest/bill/page?searchCode = null&searchDate = 2022-12-12"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: HauLT
     * Date created: 10/08/2022
     * function: check with case 2 fields are equal to null
     * @throws Exception
     */

    @Test
    public void getAllBill_7() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/rest/bill/page?searchCode = null&searchDate = null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: HauLT
     * Date created: 10/08/2022
     * function: check with case 2 fields are empty
     * @throws Exception
     */

    @Test
    public void getAllBill_8() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/rest/bill/page?searchCode = &searchDate = "))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: HauLT
     * Date created: 10/08/2022
     * function: check with case 1 field is empty
     * @throws Exception
     */

    @Test
    public void getAllBill_8_searchDate() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/rest/bill/page?searchCode = BIll-1&searchDate = "))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: HauLT
     * Date created: 10/08/2022
     * function: check with case 1 field is empty
     * @throws Exception
     */

    @Test
    public void getAllBill_8_searchCode() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/rest/bill/page?searchCode = &searchDate = 2022-12-12"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: HauLT
     * Date created: 10/08/2022
     * function: check with case 1 field does not exist
     * @throws Exception
     */

    @Test
    public void getAllBill_9_searchCode() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/rest/bill/page?searchCode = BIll-2123&searchDate = 2022-12-12"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: HauLT
     * Date created: 10/08/2022
     * function: check with case 1 field does not exist
     * @throws Exception
     */

    @Test
    public void getAllBill_9_searchDate() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/rest/bill/page?searchCode = BIll-1?searchDate = 2050-12-12"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: HauLT
     * Date created: 10/08/2022
     * function: check with case 2 fields do not exist
     * @throws Exception
     */

    @Test
    public void getAllBill_9() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/rest/bill/page?searchCode = BIll1?searchDate = 2050-12-12"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: HauLT
     * Date created: 10/08/2022
     * function: check with case the field exists
     * @throws Exception
     */

    @Test
    public void getAllBill() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/rest/bill"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }


}
