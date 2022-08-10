package com.coffee.controller;

import com.coffee.controller.jwt.JwtAuthenticationController;
import com.coffee.model.jwt.JwtRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class SimpleEmailController_sendSimpleEmail {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void sendSimpleEmail_username_13() throws Exception {
        JwtRequest jwtRequest = new JwtRequest();

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/sendSimpleEmail")
                        .content(this.objectMapper.writeValueAsString(jwtRequest))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    // 91. [item] not found in database => return status 204
    @Test
    public void sendSimpleEmail_username_91() throws Exception {
        JwtRequest jwtRequest = new JwtRequest();
        jwtRequest.setUsername("staff1");

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/sendSimpleEmail")
                        .content(this.objectMapper.writeValueAsString(jwtRequest))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void createAuthenticationToken_sendSimpleEmail_18() throws Exception {
        JwtRequest jwtRequest = new JwtRequest();
        jwtRequest.setUsername("staff");

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/sendSimpleEmail")
                        .content(this.objectMapper.writeValueAsString(jwtRequest))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void getUsernameForChangePassword_() throws Exception {
        JwtRequest jwtRequest = new JwtRequest();
        jwtRequest.setUsername("staff");
        ResponseEntity<?> response = new JwtAuthenticationController().createAuthenticationToken(jwtRequest);
        System.out.println(response);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/sendSimpleEmail")
                        .content(this.objectMapper.writeValueAsString(jwtRequest))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().is2xxSuccessful());
    }
}
