package com.coffee.controller;

import com.coffee.dto.FeedbackDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class FeedbackRestController_createFeedback {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    /**
     * Created by: DiepTT
     * Date created: 10/08/2022
     * Function: Check required of "creator"
     *
     * @throws Exception
     */

    @Test
    public void createFeedback_creator_14() throws Exception {

        FeedbackDto feedbackDto = new FeedbackDto();

        feedbackDto.setCreator("");
        feedbackDto.setEmail("nguyenthihoa@gmail.com");
        feedbackDto.setRating(5);
        feedbackDto.setContent("Quán trang trí đẹp, thức uống ngon.");
        feedbackDto.setImage("anh-quan-cafe-1.jpg");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/feedback/create")
                        .content(this.objectMapper.writeValueAsString(feedbackDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     * Created by: DiepTT
     * Date created: 10/08/2022
     * Function: Check format of "creator"
     *
     * @throws Exception
     */
    @Test
    public void createFeedback_creator_15() throws Exception {

        FeedbackDto feedbackDto = new FeedbackDto();

        feedbackDto.setCreator("thi hoa");
        feedbackDto.setEmail("nguyenthihoa@gmail.com");
        feedbackDto.setRating(5);
        feedbackDto.setContent("Quán trang trí đẹp, thức uống ngon.");
        feedbackDto.setImage("anh-quan-cafe-1.jpg");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/feedback/create")
                        .content(this.objectMapper.writeValueAsString(feedbackDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: DiepTT
     * Date created: 10/08/2022
     * Function: Check max length (30 characters) of "creator"
     *
     * @throws Exception
     */
    @Test
    public void createFeedback_creator_17() throws Exception {

        FeedbackDto feedbackDto = new FeedbackDto();

        feedbackDto.setCreator("Nguyen Thi Hoa Nguyen Thi Hoa Nguyen Thi Hoa Nguyen Thi Hoa");
        feedbackDto.setEmail("nguyenthihoa@gmail.com");
        feedbackDto.setRating(5);
        feedbackDto.setContent("Quán trang trí đẹp, thức uống ngon.");
        feedbackDto.setImage("anh-quan-cafe-1.jpg");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/feedback/create")
                        .content(this.objectMapper.writeValueAsString(feedbackDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: DiepTT
     * Date created: 10/08/2022
     * Function: Check required of "email"
     *
     * @throws Exception
     */
    @Test
    public void createFeedback_email_14() throws Exception {

        FeedbackDto feedbackDto = new FeedbackDto();

        feedbackDto.setCreator("Nguyễn Thị Hoa");
        feedbackDto.setEmail("");
        feedbackDto.setRating(5);
        feedbackDto.setContent("Quán trang trí đẹp, thức uống ngon.");
        feedbackDto.setImage("anh-quan-cafe-1.jpg");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/feedback/create")
                        .content(this.objectMapper.writeValueAsString(feedbackDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: DiepTT
     * Date created: 10/08/2022
     * Function: Check format of "email"
     *
     * @throws Exception
     */
    @Test
    public void createFeedback_email_15() throws Exception {

        FeedbackDto feedbackDto = new FeedbackDto();

        feedbackDto.setCreator("Nguyễn Thị Hoa");
        feedbackDto.setEmail("nguyenthihoa.com");
        feedbackDto.setRating(5);
        feedbackDto.setContent("Quán trang trí đẹp, thức uống ngon.");
        feedbackDto.setImage("anh-quan-cafe-1.jpg");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/feedback/create")
                        .content(this.objectMapper.writeValueAsString(feedbackDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: DiepTT
     * Date created: 10/08/2022
     * Function: Check max length (320 characters) of "email"
     *
     * @throws Exception
     */
    @Test
    public void createFeedback_email_17() throws Exception {

        FeedbackDto feedbackDto = new FeedbackDto();

        feedbackDto.setCreator("Nguyễn Thị Hoa");
        feedbackDto.setEmail("nguyenthihoanguyenthihoanguyenthihoanguyenthihoanguyenthihoanguyenthihoanguyenthihoa" +
                "nguyenthihoanguyenthihoanguyenthihoanguyenthihoanguyenthihoanguyenthihoanguyenthihoanguyenthihoa" +
                "nguyenthihoanguyenthihoanguyenthihoanguyenthihoanguyenthihoanguyenthihoanguyenthihoanguyenthihoa" +
                "nguyenthihoanguyenthihoanguyenthihoanguyenthihoanguyenthihoanguyenthihoanguyenthihoanguyenthihoa" +
                "@gmail.com");
        feedbackDto.setRating(5);
        feedbackDto.setContent("Quán trang trí đẹp, thức uống ngon.");
        feedbackDto.setImage("anh-quan-cafe-1.jpg");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/feedback/create")
                        .content(this.objectMapper.writeValueAsString(feedbackDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: DiepTT
     * Date created: 10/08/2022
     * Function: Check required of "content"
     *
     * @throws Exception
     */
    @Test
    public void createFeedback_content_14() throws Exception {

        FeedbackDto feedbackDto = new FeedbackDto();

        feedbackDto.setCreator("Nguyễn Thị Hoa");
        feedbackDto.setEmail("nguyenthihoa@gmail.com");
        feedbackDto.setRating(5);
        feedbackDto.setContent("");
        feedbackDto.setImage("anh-quan-cafe-1.jpg");

         this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/feedback/create")
                        .content(this.objectMapper.writeValueAsString(feedbackDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: DiepTT
     * Date created: 10/08/2022
     * Function: Check required of "rating"
     *
     * @throws Exception
     */
    @Test
    public void createFeedback_rating_13() throws Exception {

        FeedbackDto feedbackDto = new FeedbackDto();

        feedbackDto.setCreator("Nguyễn Thị Hoa");
        feedbackDto.setEmail("nguyenthihoa@gmail.com");
        feedbackDto.setRating(null);
        feedbackDto.setContent("Quán trang trí đẹp, thức uống ngon.");
        feedbackDto.setImage("anh-quan-cafe-1.jpg");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/feedback/create")
                        .content(this.objectMapper.writeValueAsString(feedbackDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: DiepTT
     * Date created: 10/08/2022
     * Function: Check required of "image"
     *
     * @throws Exception
     */
    @Test
    public void createFeedback_image_14() throws Exception {

        FeedbackDto feedbackDto = new FeedbackDto();

        feedbackDto.setCreator("Nguyễn Thị Hoa");
        feedbackDto.setEmail("nguyenthihoa@gmail.com");
        feedbackDto.setRating(5);
        feedbackDto.setContent("Quán trang trí đẹp, thức uống ngon.");
        feedbackDto.setImage("");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/feedback/create")
                        .content(this.objectMapper.writeValueAsString(feedbackDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: DiepTT
     * Date created: 10/08/2022
     * Function: Check valid input data of "feedback" and save "feedback" to the database
     *
     * @throws Exception
     */
    @Test
    public void createFeedback_18() throws Exception {

        FeedbackDto feedbackDto = new FeedbackDto();

        feedbackDto.setCreator("Nguyễn Thị Hoa");
        feedbackDto.setEmail("nguyenthihoa@gmail.com");
        feedbackDto.setRating(4);
        feedbackDto.setContent("Quán trang trí đẹp, thức uống ngon.");
        feedbackDto.setImage("anh-quan-cafe-1.jpg");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/feedback/create")
                        .content(this.objectMapper.writeValueAsString(feedbackDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }


}
