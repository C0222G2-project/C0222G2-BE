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
     * function: check searchCreator
     *
     * @throws Exception
     */


    @Test
    public void getAllFeedback_7_searchCreator() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/feedback/page?searchCreator=null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getAllFeedback_8_searchCreator() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/feedback/page?searchCreator= "))
                .andDo(print())
                .andExpect(status().is(204));
    }
    @Test
    public void getAllFeedback_9_searchCreator() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/feedback/page?searchCreator=cong"))
                .andDo(print())
                .andExpect(status().is(204));
    }

    @Test
    public void getAllFeedback_10_searchCreator() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/feedback/page?searchCreator=hau"))
                .andDo(print())
                .andExpect(status().is(204));
    }


    /**
     * Created by : LuanTV
     * Date created: 10/08/2022
     * function: check searchStartDate, searchEndDate
     *
     * @throws Exception
     */

    @Test
    public void getAllFeedback_7_searchStartDate_searchEndDate() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/feedback/page?searchStartDate=null&searchEndDate=null"))
                .andDo(print())
                .andExpect(status().is(204));
    }

    @Test
    public void getAllFeedback_8_searchStartDate_searchEndDate() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/feedback/page?searchStartDate= &searchEndDate= "))
                .andDo(print())
                .andExpect(status().is(204));
    }
    @Test
    public void getAllFeedback_9_searchStartDate_searchEndDate() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/feedback/page?searchStartDate=2022-03-05&searchEndDate=2022-03-30"))
                .andDo(print())
                .andExpect(status().is(204));
    }

    @Test
    public void getAllFeedback_10_searchStartDate_searchEndDate() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/feedback/page?&searchStartDate=2022-02-06&searchEndDate=2022-02-06"))
                .andDo(print())
                .andExpect(status().is(204));
    }

    /**
     * Created by : LuanTV
     * Date created: 10/08/2022
     * function: check exact search results
     *
     *
     * @throws Exception
     */

    @Test
    public void getListStudent_11() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/feedback/page?searchCreator=hau&searchStartDate=2022-02-06&searchEndDate=2022-02-07"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(1))
                .andExpect(jsonPath("content[3].id").value(4))
                .andExpect(jsonPath("content[3].code").value("FB004"))
                .andExpect(jsonPath("content[3].creator").value("Hậu"))
                .andExpect(jsonPath("content[3].email").value("haudn@gmail.com"))
                .andExpect(jsonPath("content[3].content").value("Ngon, bổ rẻ"))
                .andExpect(jsonPath("content[3].rating").value(4))
                .andExpect(jsonPath("content[3].feedbackDate").value("2022-02-06"))
                .andExpect(jsonPath("content[3].image").value("https://www.vivosmartphone.vn/uploads/MANGOADS/ch%E1%BB%A5p%20%E1%BA%A3nh/%E1%BA%A2nh%20%C4%91%E1%BB%93%20u%E1%BB%91ng/fD6Mguu.jpg"));
    }

}
