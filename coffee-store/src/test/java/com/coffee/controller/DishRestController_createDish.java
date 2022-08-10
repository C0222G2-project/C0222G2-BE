package com.coffee.controller;

import com.coffee.dto.DishDto;
import com.coffee.dto.DishTypeDto;
import com.coffee.model.dish.DishType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class DishRestController_createDish {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void createDish_name_ok() throws Exception {

        DishDto dishDto = new DishDto();

        dishDto.setCode("C-F077");
        dishDto.setPrice(10000);
        dishDto.setName("cà phê sữa");
        dishDto.setImage("ảnh");

        DishType dishType = new DishType();
        dishType.setId(1);
        dishDto.setDishType(dishType);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/dish/create")
                        .content(this.objectMapper.writeValueAsString(dishDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void createDish_name_not_ok1() throws Exception {

        DishDto dishDto = new DishDto();

        dishDto.setCode("CF");
        dishDto.setPrice(10000);
        dishDto.setName("cà phê sữa");
        dishDto.setImage("ảnh");

        DishType dishType = new DishType();
        dishType.setId(1);
        dishDto.setDishType(dishType);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/dish/create")
                        .content(this.objectMapper.writeValueAsString(dishDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void createDish_name_not_ok2() throws Exception {

        DishDto dishDto = new DishDto();

        dishDto.setCode(null);
        dishDto.setPrice(10000);
        dishDto.setName("cà phê sữa");
        dishDto.setImage("ảnh");

        DishType dishType = new DishType();
        dishType.setId(1);
        dishDto.setDishType(dishType);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/dish/create")
                        .content(this.objectMapper.writeValueAsString(dishDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void createDish_name_not_ok6() throws Exception {

        DishDto dishDto = new DishDto();

        dishDto.setCode("");
        dishDto.setPrice(10000);
        dishDto.setName("cà phê sữa");
        dishDto.setImage("ảnh");

        DishType dishType = new DishType();
        dishType.setId(1);
        dishDto.setDishType(dishType);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/dish/create")
                        .content(this.objectMapper.writeValueAsString(dishDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createDish_name_not_ok3() throws Exception {

        DishDto dishDto = new DishDto();

        dishDto.setCode("CF");
        dishDto.setPrice(null);
        dishDto.setName("cà phê sữa");
        dishDto.setImage("ảnh");

        DishType dishType = new DishType();
        dishType.setId(1);
        dishDto.setDishType(dishType);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/dish/create")
                        .content(this.objectMapper.writeValueAsString(dishDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createDish_name_not_ok4() throws Exception {

        DishDto dishDto = new DishDto();

        dishDto.setCode("CF--01");
        dishDto.setPrice(100);
        dishDto.setName("cà phê sữa");
        dishDto.setImage("ảnh");

        DishType dishType = new DishType();
        dishType.setId(1);
        dishDto.setDishType(dishType);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/dish/create")
                        .content(this.objectMapper.writeValueAsString(dishDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void createDish_name_not_ok5() throws Exception {

        DishDto dishDto = new DishDto();

        dishDto.setCode("CF--01");
        dishDto.setPrice(10000);
        dishDto.setName("");
        dishDto.setImage("ảnh");

        DishType dishType = new DishType();
        dishType.setId(1);
        dishDto.setDishType(dishType);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/dish/create")
                        .content(this.objectMapper.writeValueAsString(dishDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void createDish_name_not_ok8() throws Exception {

        DishDto dishDto = new DishDto();

        dishDto.setCode("CF--01");
        dishDto.setPrice(10000);
        dishDto.setName("CÀ");
        dishDto.setImage("ảnh");

        DishType dishType = new DishType();
        dishType.setId(1);
        dishDto.setDishType(dishType);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/dish/create")
                        .content(this.objectMapper.writeValueAsString(dishDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void createDish_name_not_ok9() throws Exception {

        DishDto dishDto = new DishDto();

        dishDto.setCode("CF--01");
        dishDto.setPrice(10000);
        dishDto.setName(null);
        dishDto.setImage("ảnh");

        DishType dishType = new DishType();
        dishType.setId(1);
        dishDto.setDishType(dishType);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/dish/create")
                        .content(this.objectMapper.writeValueAsString(dishDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void createDish_name_not_ok10() throws Exception {

        DishDto dishDto = new DishDto();

        dishDto.setCode("CF--01");
        dishDto.setPrice(10000);
        dishDto.setName("Cà Phê Sữa");
        dishDto.setImage(null);

        DishType dishType = new DishType();
        dishType.setId(1);
        dishDto.setDishType(dishType);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/dish/create")
                        .content(this.objectMapper.writeValueAsString(dishDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void createDish_name_not_ok11() throws Exception {

        DishDto dishDto = new DishDto();

        dishDto.setCode("CF--01");
        dishDto.setPrice(10000);
        dishDto.setName("Cà Phê Sữa");
        dishDto.setImage("");

        DishType dishType = new DishType();
        dishType.setId(1);
        dishDto.setDishType(dishType);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/dish/create")
                        .content(this.objectMapper.writeValueAsString(dishDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

}
