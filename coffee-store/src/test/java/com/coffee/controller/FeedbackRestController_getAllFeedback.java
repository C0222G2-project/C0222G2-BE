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
public class FeedbackRestController_getAllFeedback {

    @Autowired
    private MockMvc mockMvc;

    /**
     * Created by : LuanTV
     * Date created: 10/08/2022
     * Function: check searchCreator
     *
     * @throws Exception
     */
    @Test
    public void getAllFeedback_7_searchCreator() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/feedback/page?searchCreator=null")
                        .header("authorization",
                                "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJtYW5hZ2VyIiwiZXhwIjoxNjYxMzE2NTA2LCJpYXQiOjE2NjExMzY1MDZ9.5lz2df8Nu6cfWENXqVyZU9G3cN77A6mu7hyVMJjxYLr2CLe-8o70nI5FLvs0uqMzcmEg8hOFW_Ma17VNy7TqSQ"))
                .andDo(print())
                .andExpect(status().is(204));
    }

    @Test
    public void getAllFeedback_8_searchCreator() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/feedback/page?searchCreator=        ")
                        .header("authorization",
                                "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJtYW5hZ2VyIiwiZXhwIjoxNjYxMzE2NTA2LCJpYXQiOjE2NjExMzY1MDZ9.5lz2df8Nu6cfWENXqVyZU9G3cN77A6mu7hyVMJjxYLr2CLe-8o70nI5FLvs0uqMzcmEg8hOFW_Ma17VNy7TqSQ"))
                .andDo(print())
                .andExpect(status().is(204));
    }
    @Test
    public void getAllFeedback_9_searchCreator() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/feedback/page?searchCreator=congrr")
                        .header("authorization",
                                "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJtYW5hZ2VyIiwiZXhwIjoxNjYxMzE2NTA2LCJpYXQiOjE2NjExMzY1MDZ9.5lz2df8Nu6cfWENXqVyZU9G3cN77A6mu7hyVMJjxYLr2CLe-8o70nI5FLvs0uqMzcmEg8hOFW_Ma17VNy7TqSQ"))
                .andDo(print())
                .andExpect(status().is(204));
    }

    @Test
    public void getAllFeedback_10_searchCreator() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/feedback/page?searchCreator=hau")
                        .header("authorization",
                                "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJtYW5hZ2VyIiwiZXhwIjoxNjYxMzE2NTA2LCJpYXQiOjE2NjExMzY1MDZ9.5lz2df8Nu6cfWENXqVyZU9G3cN77A6mu7hyVMJjxYLr2CLe-8o70nI5FLvs0uqMzcmEg8hOFW_Ma17VNy7TqSQ"))
                .andDo(print())
                .andExpect(status().is(204));
    }


    /**
     * Created by : LuanTV
     * Date created: 10/08/2022
     * Function: check searchStartDate
     *
     * @throws Exception
     */
    @Test
    public void getAllFeedback_7_searchStartDate() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/feedback/page?searchStartDate=null&searchEndDate=2022-02-04")
                        .header("authorization",
                                "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJtYW5hZ2VyIiwiZXhwIjoxNjYxMzE2NTA2LCJpYXQiOjE2NjExMzY1MDZ9.5lz2df8Nu6cfWENXqVyZU9G3cN77A6mu7hyVMJjxYLr2CLe-8o70nI5FLvs0uqMzcmEg8hOFW_Ma17VNy7TqSQ"))
                .andDo(print())
                .andExpect(status().is(204));
    }

    @Test
    public void getAllFeedback_8_searchStartDate() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/feedback/page?searchStartDate= &searchEndDate=2022-01-01")
                        .header("authorization",
                                "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJtYW5hZ2VyIiwiZXhwIjoxNjYxMzE2NTA2LCJpYXQiOjE2NjExMzY1MDZ9.5lz2df8Nu6cfWENXqVyZU9G3cN77A6mu7hyVMJjxYLr2CLe-8o70nI5FLvs0uqMzcmEg8hOFW_Ma17VNy7TqSQ"))
                .andDo(print())
                .andExpect(status().is(204));
    }
    @Test
    public void getAllFeedback_9_searchStartDate() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/feedback/page?searchStartDate=2022-03-10&searchEndDate=2022-03-30")
                        .header("authorization",
                                "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJtYW5hZ2VyIiwiZXhwIjoxNjYxMzE2NTA2LCJpYXQiOjE2NjExMzY1MDZ9.5lz2df8Nu6cfWENXqVyZU9G3cN77A6mu7hyVMJjxYLr2CLe-8o70nI5FLvs0uqMzcmEg8hOFW_Ma17VNy7TqSQ"))
                .andDo(print())
                .andExpect(status().is(204));
    }

    @Test
    public void getAllFeedback_10_searchStartDate() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/feedback/page?searchStartDate=2022-02-06&searchEndDate=2022-02-06")
                        .header("authorization",
                                "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJtYW5hZ2VyIiwiZXhwIjoxNjYxMzE2NTA2LCJpYXQiOjE2NjExMzY1MDZ9.5lz2df8Nu6cfWENXqVyZU9G3cN77A6mu7hyVMJjxYLr2CLe-8o70nI5FLvs0uqMzcmEg8hOFW_Ma17VNy7TqSQ"))
                .andDo(print())
                .andExpect(status().is(204));
    }


    /**
     * Created by : LuanTV
     * Date created: 11/08/2022
     * Function: check searchEndDate
     *
     * @throws Exception
     */
    @Test
    public void getAllFeedback_7_searchEndDate() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/feedback/page?searchStartDate=2022-08-20&searchEndDate=null")
                        .header("authorization",
                                "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJtYW5hZ2VyIiwiZXhwIjoxNjYxMzE2NTA2LCJpYXQiOjE2NjExMzY1MDZ9.5lz2df8Nu6cfWENXqVyZU9G3cN77A6mu7hyVMJjxYLr2CLe-8o70nI5FLvs0uqMzcmEg8hOFW_Ma17VNy7TqSQ"))
                .andDo(print())
                .andExpect(status().is(204));
    }

    @Test
    public void getAllFeedback_8_searchEndDate() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/feedback/page?searchStartDate=2022-02-04&searchEndDate= ")
                        .header("authorization",
                                "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJtYW5hZ2VyIiwiZXhwIjoxNjYxMzE2NTA2LCJpYXQiOjE2NjExMzY1MDZ9.5lz2df8Nu6cfWENXqVyZU9G3cN77A6mu7hyVMJjxYLr2CLe-8o70nI5FLvs0uqMzcmEg8hOFW_Ma17VNy7TqSQ"))
                .andDo(print())
                .andExpect(status().is(204));
    }
    @Test
    public void getAllFeedback_9_searchEndDate() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/feedback/page?searchStartDate=2022-02-19&searchEndDate=2022-02-28")
                        .header("authorization",
                                "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJtYW5hZ2VyIiwiZXhwIjoxNjYxMzE2NTA2LCJpYXQiOjE2NjExMzY1MDZ9.5lz2df8Nu6cfWENXqVyZU9G3cN77A6mu7hyVMJjxYLr2CLe-8o70nI5FLvs0uqMzcmEg8hOFW_Ma17VNy7TqSQ"))
                .andDo(print())
                .andExpect(status().is(204));
    }

    @Test
    public void getAllFeedback_10_searchEndDate() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/feedback/page?searchStartDate=2022-08-06&searchEndDate=2022-02-09")
                        .header("authorization",
                                "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJtYW5hZ2VyIiwiZXhwIjoxNjYxMzE2NTA2LCJpYXQiOjE2NjExMzY1MDZ9.5lz2df8Nu6cfWENXqVyZU9G3cN77A6mu7hyVMJjxYLr2CLe-8o70nI5FLvs0uqMzcmEg8hOFW_Ma17VNy7TqSQ"))
                .andDo(print())
                .andExpect(status().is(204));
    }


    /**
     * Created by : LuanTV
     * Date created: 10/08/2022
     * Function: check exact search results
     *
     * @throws Exception
     */
    @Test
    public void getAllFeedback_11() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/feedback/page?searchCreator=tai&searchStartDate=2022-02-01&searchEndDate=2022-03-03")
                        .header("authorization",
                                "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJtYW5hZ2VyIiwiZXhwIjoxNjYxMzE2NTA2LCJpYXQiOjE2NjExMzY1MDZ9.5lz2df8Nu6cfWENXqVyZU9G3cN77A6mu7hyVMJjxYLr2CLe-8o70nI5FLvs0uqMzcmEg8hOFW_Ma17VNy7TqSQ"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(1))
                .andExpect(jsonPath("content[0].id").value(1))
                .andExpect(jsonPath("content[0].code").value("FB0001"))
                .andExpect(jsonPath("content[0].creator").value("Lê Văn Tài"))
                .andExpect(jsonPath("content[0].email").value("tailevandn@gmail.com"))
                .andExpect(jsonPath("content[0].content").value("Đồ uống ngon"))
                .andExpect(jsonPath("content[0].rating").value(3))
                .andExpect(jsonPath("content[0].feedbackDate").value("2022-02-01"))
                .andExpect(jsonPath("content[0].image").value("https://firebasestorage.googleapis.com/v0/b/c0222g2-4cf09.appspot.com/o/16-08-YYYca%CC%80%20Phe%CC%82%20tru%CC%9B%CC%81ng.webp?alt=media&token=b3115e66-854b-412c-905e-5f700e28aacd"));

    }
}
