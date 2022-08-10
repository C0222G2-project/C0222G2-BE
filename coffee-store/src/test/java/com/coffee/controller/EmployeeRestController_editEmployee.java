package com.coffee.controller;

import com.coffee.dto.EmployeeDto;
import com.coffee.model.employee.Position;
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
public class EmployeeRestController_editEmployee {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    // test edit name = null,where id = 6
    @Test
    public void editEmployee_name_19() throws Exception {

        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setName(null);
        employeeDto.setBirthday("2000-01-01");
        employeeDto.setPhoneNumber("0936369999");
        employeeDto.setAddress("Tp.Đà NẴNG");
        employeeDto.setGender(0);
        employeeDto.setEmail("levana@gmail.com");
        employeeDto.setSalary(10.0);
        employeeDto.setImage("http/:firebase.levana.png");
        employeeDto.setIsDeleted(0);

        Position position = new Position();
        position.setId(1);
        employeeDto.setPosition(position);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/account/updateAccountEmployee/6")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    // test edit name = "",where id = 6
    @Test
    public void editEmployee_name_20() throws Exception {

        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setName(null);
        employeeDto.setBirthday("2000-01-01");
        employeeDto.setPhoneNumber("0936369999");
        employeeDto.setAddress("Tp.Đà NẴNG");
        employeeDto.setGender(0);
        employeeDto.setEmail("levana@gmail.com");
        employeeDto.setSalary(10.0);
        employeeDto.setImage("http/:firebase.levana.png");
        employeeDto.setIsDeleted(0);

        Position position = new Position();
        position.setId(1);
        employeeDto.setPosition(position);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/account/updateAccountEmployee/6")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    // test edit format birthday,where id = 6
    @Test
    public void editEmployee_birthday_21() throws Exception {

        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setName("Lê Văn A");
        employeeDto.setBirthday("20000101");
        employeeDto.setPhoneNumber("0936369999");
        employeeDto.setAddress("Tp.Đà NẴNG");
        employeeDto.setGender(0);
        employeeDto.setEmail("levana@gmail.com");
        employeeDto.setSalary(10.0);
        employeeDto.setImage("http/:firebase.levana.png");
        employeeDto.setIsDeleted(0);

        Position position = new Position();
        position.setId(1);
        employeeDto.setPosition(position);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/account/updateAccountEmployee/6")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    // test edit phone = null,where id = 6
    @Test
    public void editEmployee_phoneNumber_19() throws Exception {

        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setName("Lê Văn A");
        employeeDto.setBirthday("2000-01-01");
        employeeDto.setPhoneNumber(null);
        employeeDto.setAddress("Tp.Đà NẴNG");
        employeeDto.setGender(0);
        employeeDto.setEmail("levana@gmail.com");
        employeeDto.setSalary(10.0);
        employeeDto.setImage("http/:firebase.levana.png");
        employeeDto.setIsDeleted(0);

        Position position = new Position();
        position.setId(1);
        employeeDto.setPosition(position);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/account/updateAccountEmployee/6")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    // test edit phoneNumber = "",where id = 6
    @Test
    public void editEmployee_phoneNumber_20() throws Exception {

        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setName("Lê Văn A");
        employeeDto.setBirthday("2000-01-01");
        employeeDto.setPhoneNumber("");
        employeeDto.setAddress("Tp.Đà NẴNG");
        employeeDto.setGender(0);
        employeeDto.setEmail("levana@gmail.com");
        employeeDto.setSalary(10.0);
        employeeDto.setImage("http/:firebase.levana.png");
        employeeDto.setIsDeleted(0);

        Position position = new Position();
        position.setId(1);
        employeeDto.setPosition(position);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/account/updateAccountEmployee/6")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    // test edit address = null,where id = 6
    @Test
    public void editEmployee_address_19() throws Exception {

        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setName("Lê Văn A");
        employeeDto.setBirthday("2000-01-01");
        employeeDto.setPhoneNumber("0936369999");
        employeeDto.setAddress(null);
        employeeDto.setGender(0);
        employeeDto.setEmail("levana@gmail.com");
        employeeDto.setSalary(10.0);
        employeeDto.setImage("http/:firebase.levana.png");
        employeeDto.setIsDeleted(0);

        Position position = new Position();
        position.setId(1);
        employeeDto.setPosition(position);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/account/updateAccountEmployee/6")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    // test edit address = "",where id = 6
    @Test
    public void editEmployee_address_20() throws Exception {

        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setName("Lê Văn A");
        employeeDto.setBirthday("2000-01-01");
        employeeDto.setPhoneNumber("0936369999");
        employeeDto.setAddress("");
        employeeDto.setGender(0);
        employeeDto.setEmail("levana@gmail.com");
        employeeDto.setSalary(10.0);
        employeeDto.setImage("http/:firebase.levana.png");
        employeeDto.setIsDeleted(0);

        Position position = new Position();
        position.setId(1);
        employeeDto.setPosition(position);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/account/updateAccountEmployee/6")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    // test edit email = null,where id = 6
    @Test
    public void editEmployee_email_19() throws Exception {

        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setName("Lê Văn A");
        employeeDto.setBirthday("2000-01-01");
        employeeDto.setPhoneNumber("0936369999");
        employeeDto.setAddress("Tp.Đà Nẵng");
        employeeDto.setGender(0);
        employeeDto.setEmail(null);
        employeeDto.setSalary(10.0);
        employeeDto.setImage("http/:firebase.levana.png");
        employeeDto.setIsDeleted(0);

        Position position = new Position();
        position.setId(1);
        employeeDto.setPosition(position);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/account/updateAccountEmployee/6")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    // test edit email = "" ,where id = 6
    @Test
    public void editEmployee_email_20() throws Exception {

        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setName("Lê Văn A");
        employeeDto.setBirthday("2000-01-01");
        employeeDto.setPhoneNumber("0936369999");
        employeeDto.setAddress("Tp.Đà Nẵng");
        employeeDto.setGender(0);
        employeeDto.setEmail("");
        employeeDto.setSalary(10.0);
        employeeDto.setImage("http/:firebase.levana.png");
        employeeDto.setIsDeleted(0);

        Position position = new Position();
        position.setId(1);
        employeeDto.setPosition(position);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/account/updateAccountEmployee/6")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    // test edit format email where id = 6
    @Test
    public void editEmployee_email_21() throws Exception {

        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setName("Lê Văn A");
        employeeDto.setBirthday("2000-01-01");
        employeeDto.setPhoneNumber("0936369999");
        employeeDto.setAddress("Tp.Đà Nẵng");
        employeeDto.setGender(0);
        employeeDto.setEmail("levana");
        employeeDto.setSalary(10.0);
        employeeDto.setImage("http/:firebase.levana.png");
        employeeDto.setIsDeleted(0);

        Position position = new Position();
        position.setId(1);
        employeeDto.setPosition(position);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/account/updateAccountEmployee/6")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    // test edit salary = null where id = 6
    @Test
    public void editEmployee_salary_19() throws Exception {

        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setName("Lê Văn A");
        employeeDto.setBirthday("2000-01-01");
        employeeDto.setPhoneNumber("0936369999");
        employeeDto.setAddress("Tp.Đà Nẵng");
        employeeDto.setGender(0);
        employeeDto.setEmail("levana@gmail.com");
        employeeDto.setSalary(null);
        employeeDto.setImage("http/:firebase.levana.png");
        employeeDto.setIsDeleted(0);

        Position position = new Position();
        position.setId(1);
        employeeDto.setPosition(position);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/account/updateAccountEmployee/6")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    // test edit salary < 0 where id = 6
    @Test
    public void editEmployee_salary_22() throws Exception {

        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setName("Lê Văn A");
        employeeDto.setBirthday("2000-01-01");
        employeeDto.setPhoneNumber("0936369999");
        employeeDto.setAddress("Tp.Đà Nẵng");
        employeeDto.setGender(0);
        employeeDto.setEmail("levana@gmail.com");
        employeeDto.setSalary(-11.0);
        employeeDto.setImage("http/:firebase.levana.png");
        employeeDto.setIsDeleted(0);

        Position position = new Position();
        position.setId(1);
        employeeDto.setPosition(position);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/account/updateAccountEmployee/6")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    // test edit employee id = 6 success
    @Test
    public void editEmployee_24() throws Exception {

        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setName("Lê Văn A");
        employeeDto.setBirthday("2000-01-01");
        employeeDto.setPhoneNumber("0936369999");
        employeeDto.setAddress("Tp.Đà NẴNG");
        employeeDto.setGender(0);
        employeeDto.setEmail("levana@gmail.com");
        employeeDto.setSalary(10.0);
        employeeDto.setImage("http/:firebase.levana.png");
        employeeDto.setIsDeleted(0);

        Position position = new Position();
        position.setId(1);
        employeeDto.setPosition(position);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/account/updateAccountEmployee/6")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
