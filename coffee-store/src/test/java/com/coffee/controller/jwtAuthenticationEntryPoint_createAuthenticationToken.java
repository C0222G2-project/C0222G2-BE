package com.coffee.controller;

import com.coffee.model.jwt.JwtRequest;
import com.coffee.util.TokenUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class jwtAuthenticationEntryPoint_createAuthenticationToken {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private TokenUtil tokenUtil;

    @Test
    public void createAuthenticationToken_username_7() throws Exception {
        JwtRequest jwtRequest = new JwtRequest();
        jwtRequest.setPassword("123");

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/authenticate")
                        .content(this.objectMapper.writeValueAsString(jwtRequest))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createAuthenticationToken_password_7() throws Exception {
        JwtRequest jwtRequest = new JwtRequest();
        jwtRequest.setUsername("admin");

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/authenticate")
                        .content(this.objectMapper.writeValueAsString(jwtRequest))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    // 91. [item] not found in database => return status 204
    @Test
    public void createAuthenticationToken_username_91() throws Exception {
        JwtRequest jwtRequest = new JwtRequest();
        jwtRequest.setUsername("admin1");
        jwtRequest.setPassword("123");

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/authenticate")
                        .content(this.objectMapper.writeValueAsString(jwtRequest))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    // 92. [item] unauthorized => return status 401
    @Test
    public void createAuthenticationToken_password_92() throws Exception {
        JwtRequest jwtRequest = new JwtRequest();
        jwtRequest.setUsername("admin");
        jwtRequest.setPassword("1234");

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/authenticate")
                        .content(this.objectMapper.writeValueAsString(jwtRequest))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createAuthenticationToken_username_password_18() throws Exception {
        JwtRequest jwtRequest = new JwtRequest();
        jwtRequest.setUsername("admin");
        jwtRequest.setPassword("123");

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/authenticate")
                        .content(this.objectMapper.writeValueAsString(jwtRequest))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("username").value("admin"))
                .andExpect(jsonPath("grantList[0]").value("ROLE_ADMIN"))
                .andExpect(jsonPath("grantList[1]").value("ROLE_STAFF"))
                .andExpect(jsonPath("grantList[2]").value("ROLE_USER"));
    }
}
