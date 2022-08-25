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
public class FeedbackRestController_getFeedbackById {

    @Autowired
    private MockMvc mockMvc;

    /**
     * Created by : LuanTV
     * Date created: 10/08/2022
     * function: check find by id feedback
     *
     * @throws Exception
     */

    @Test
    public void getFeedbackById_id_1() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/feedback/null")
                        .header("authorization",
                                "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJtYW5hZ2VyIiwiZXhwIjoxNjYxMzE2NTA2LCJpYXQiOjE2NjExMzY1MDZ9.5lz2df8Nu6cfWENXqVyZU9G3cN77A6mu7hyVMJjxYLr2CLe-8o70nI5FLvs0uqMzcmEg8hOFW_Ma17VNy7TqSQ"))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    @Test
    public void getFeedbackById_id_2() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/feedback/")
                        .header("authorization",
                                "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJtYW5hZ2VyIiwiZXhwIjoxNjYxMzE2NTA2LCJpYXQiOjE2NjExMzY1MDZ9.5lz2df8Nu6cfWENXqVyZU9G3cN77A6mu7hyVMJjxYLr2CLe-8o70nI5FLvs0uqMzcmEg8hOFW_Ma17VNy7TqSQ"))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    @Test
    public void getFeedbackById_id_3() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/feedback/99")
                        .header("authorization",
                                "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJtYW5hZ2VyIiwiZXhwIjoxNjYxMzE2NTA2LCJpYXQiOjE2NjExMzY1MDZ9.5lz2df8Nu6cfWENXqVyZU9G3cN77A6mu7hyVMJjxYLr2CLe-8o70nI5FLvs0uqMzcmEg8hOFW_Ma17VNy7TqSQ"))
                .andDo(print())
                .andExpect(status().is(204));

    }

    /**
     * Created by : LuanTV
     * Date created: 10/08/2022
     * function: check exact id search results
     *
     * @throws Exception
     */

    @Test
    public void getFeedbackById_id_4() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/feedback/3")
                        .header("authorization",
                                "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJtYW5hZ2VyIiwiZXhwIjoxNjYxMzE2NTA2LCJpYXQiOjE2NjExMzY1MDZ9.5lz2df8Nu6cfWENXqVyZU9G3cN77A6mu7hyVMJjxYLr2CLe-8o70nI5FLvs0uqMzcmEg8hOFW_Ma17VNy7TqSQ"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("id").value(3))
                .andExpect(jsonPath("code").value("FB0003"))
                .andExpect(jsonPath("creator").value("Quỳnh Thị Điệp"))
                .andExpect(jsonPath("email").value("quynhdiepdiepdn@gmail.com"))
                .andExpect(jsonPath("content").value("Giá đồ uống rẻ"))
                .andExpect(jsonPath("rating").value(3))
                .andExpect(jsonPath("feedbackDate").value("2022-02-01"))
                .andExpect(jsonPath("image").value("https://firebasestorage.googleapis.com/v0/b/c0222g2-4cf09.appspot.com/o/16-08-YYYca%CC%80%20phe%CC%82%20bo%CC%A3t%20bie%CC%82%CC%89n.jpeg?alt=media&token=d9c32f95-b80e-4a20-8f35-64992b37d344"));
    }
}
