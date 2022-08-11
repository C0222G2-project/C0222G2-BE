package com.coffee.controller;

import com.coffee.dto.employe.EmployeeDTOEdit;
import com.coffee.model.employee.Position;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.sql.Date;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeRestController_editEmployee {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;


    /**
     * Create by TaiLV
     * create date:10/08/2022
     * method : editEmployee()
     * param : id = 1
     * test name = null
     */
    @Test
    public void editEmployee_name_13() throws Exception {

        EmployeeDTOEdit employeeDTO = new EmployeeDTOEdit();

        employeeDTO.setName(null);
        employeeDTO.setBirthday(Date.valueOf("2000-01-01"));
        employeeDTO.setPhoneNumber("0936369999");
        employeeDTO.setAddress("Tp.Đà NẴNG");
        employeeDTO.setGender(0);
        employeeDTO.setEmail("levana@gmail.com");
        employeeDTO.setSalary(10.0);
        employeeDTO.setImage("http/:firebase.levana.png");
        employeeDTO.setIsDeleted(0);

        Position position = new Position();
        position.setId(1);
        employeeDTO.setPosition(position);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/rest/employee/edit/1")
                        .content(this.objectMapper.writeValueAsString(employeeDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by TaiLV
     * create date:10/08/2022
     * method : editEmployee()
     * param : id = 1
     * test name = ""
     */
    @Test
    public void editEmployee_name_14() throws Exception {

        EmployeeDTOEdit employeeDTO = new EmployeeDTOEdit();

        employeeDTO.setName("");
        employeeDTO.setBirthday(Date.valueOf("2000-01-01"));
        employeeDTO.setPhoneNumber("0936369999");
        employeeDTO.setAddress("Tp.Đà NẴNG");
        employeeDTO.setGender(0);
        employeeDTO.setEmail("levana@gmail.com");
        employeeDTO.setSalary(10.0);
        employeeDTO.setImage("http/:firebase.levana.png");
        employeeDTO.setIsDeleted(0);

        Position position = new Position();
        position.setId(1);
        employeeDTO.setPosition(position);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/rest/employee/edit/1")
                        .content(this.objectMapper.writeValueAsString(employeeDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by TaiLV
     * create date:10/08/2022
     * method : editEmployee()
     * param : id = 1
     * test format birthday
     */
    @Test
    public void editEmployee_birthday_15() throws Exception {

        EmployeeDTOEdit employeeDTO = new EmployeeDTOEdit();

        employeeDTO.setName("Lê Văn A");
        employeeDTO.setBirthday(Date.valueOf("2000-01-01"));
        employeeDTO.setPhoneNumber("0936369999");
        employeeDTO.setAddress("Tp.Đà NẴNG");
        employeeDTO.setGender(0);
        employeeDTO.setEmail("levana@gmail.com");
        employeeDTO.setSalary(10.0);
        employeeDTO.setImage("http/:firebase.levana.png");
        employeeDTO.setIsDeleted(0);

        Position position = new Position();
        position.setId(1);
        employeeDTO.setPosition(position);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/rest/employee/edit/1")
                        .content(this.objectMapper.writeValueAsString(employeeDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by TaiLV
     * create date:10/08/2022
     * method : editEmployee()
     * param : id = 1
     * test phoneNumber = null
     */
    @Test
    public void editEmployee_phoneNumber_13() throws Exception {

        EmployeeDTOEdit employeeDTO = new EmployeeDTOEdit();

        employeeDTO.setName("Lê Văn A");
        employeeDTO.setBirthday(Date.valueOf("2000-01-01"));
        employeeDTO.setPhoneNumber(null);
        employeeDTO.setAddress("Tp.Đà NẴNG");
        employeeDTO.setGender(0);
        employeeDTO.setEmail("levana@gmail.com");
        employeeDTO.setSalary(10.0);
        employeeDTO.setImage("http/:firebase.levana.png");
        employeeDTO.setIsDeleted(0);

        Position position = new Position();
        position.setId(1);
        employeeDTO.setPosition(position);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/rest/employee/edit/1")
                        .content(this.objectMapper.writeValueAsString(employeeDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by TaiLV
     * create date:10/08/2022
     * method : editEmployee()
     * param : id = 1
     * test phoneNumber = ""
     */
    @Test
    public void editEmployee_phoneNumber_14() throws Exception {

        EmployeeDTOEdit employeeDTO = new EmployeeDTOEdit();


        employeeDTO.setName("Lê Văn A");
        employeeDTO.setBirthday(Date.valueOf("2000-01-01"));
        employeeDTO.setPhoneNumber("");
        employeeDTO.setAddress("Tp.Đà NẴNG");
        employeeDTO.setGender(0);
        employeeDTO.setEmail("levana@gmail.com");
        employeeDTO.setSalary(10.0);
        employeeDTO.setImage("http/:firebase.levana.png");
        employeeDTO.setIsDeleted(0);

        Position position = new Position();
        position.setId(1);
        employeeDTO.setPosition(position);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/rest/employee/edit/1")
                        .content(this.objectMapper.writeValueAsString(employeeDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by TaiLV
     * create date:10/08/2022
     * method : editEmployee()
     * param : id = 1
     * test address = null
     */
    @Test
    public void editEmployee_address_13() throws Exception {

        EmployeeDTOEdit employeeDTO = new EmployeeDTOEdit();

        employeeDTO.setName("Lê Văn A");
        employeeDTO.setBirthday(Date.valueOf("2000-01-01"));
        employeeDTO.setPhoneNumber("0936369999");
        employeeDTO.setAddress(null);
        employeeDTO.setGender(0);
        employeeDTO.setEmail("levana@gmail.com");
        employeeDTO.setSalary(10.0);
        employeeDTO.setImage("http/:firebase.levana.png");
        employeeDTO.setIsDeleted(0);

        Position position = new Position();
        position.setId(1);
        employeeDTO.setPosition(position);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/rest/employee/edit/1")
                        .content(this.objectMapper.writeValueAsString(employeeDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by TaiLV
     * create date:10/08/2022
     * method : editEmployee()
     * param : id = 1
     * test address = ""
     */
    @Test
    public void editEmployee_address_14() throws Exception {

        EmployeeDTOEdit employeeDTO = new EmployeeDTOEdit();

        employeeDTO.setName("Lê Văn A");
        employeeDTO.setBirthday(Date.valueOf("2000-01-01"));
        employeeDTO.setPhoneNumber("0936369999");
        employeeDTO.setAddress("");
        employeeDTO.setGender(0);
        employeeDTO.setEmail("levana@gmail.com");
        employeeDTO.setSalary(10.0);
        employeeDTO.setImage("http/:firebase.levana.png");
        employeeDTO.setIsDeleted(0);

        Position position = new Position();
        position.setId(1);
        employeeDTO.setPosition(position);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/rest/employee/edit/1")
                        .content(this.objectMapper.writeValueAsString(employeeDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by TaiLV
     * create date:10/08/2022
     * method : editEmployee()
     * param : id = 1
     * test email = null
     */
    @Test
    public void editEmployee_email_13() throws Exception {

        EmployeeDTOEdit employeeDTO = new EmployeeDTOEdit();

        employeeDTO.setName("Lê Văn A");
        employeeDTO.setBirthday(Date.valueOf("2000-01-01"));
        employeeDTO.setPhoneNumber("0936369999");
        employeeDTO.setAddress("Tp.Đà Nẵng");
        employeeDTO.setGender(0);
        employeeDTO.setEmail(null);
        employeeDTO.setSalary(10.0);
        employeeDTO.setImage("http/:firebase.levana.png");
        employeeDTO.setIsDeleted(0);

        Position position = new Position();
        position.setId(1);
        employeeDTO.setPosition(position);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/rest/employee/edit/1")
                        .content(this.objectMapper.writeValueAsString(employeeDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by TaiLV
     * create date:10/08/2022
     * method : editEmployee()
     * param : id = 1
     * test name = ""
     */
    @Test
    public void editEmployee_email_14() throws Exception {

        EmployeeDTOEdit employeeDTO = new EmployeeDTOEdit();

        employeeDTO.setName("Lê Văn A");
        employeeDTO.setBirthday(Date.valueOf("2000-01-01"));
        employeeDTO.setPhoneNumber("0936369999");
        employeeDTO.setAddress("Tp.Đà Nẵng");
        employeeDTO.setGender(0);
        employeeDTO.setEmail("");
        employeeDTO.setSalary(10.0);
        employeeDTO.setImage("http/:firebase.levana.png");
        employeeDTO.setIsDeleted(0);

        Position position = new Position();
        position.setId(1);
        employeeDTO.setPosition(position);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/rest/employee/edit/1")
                        .content(this.objectMapper.writeValueAsString(employeeDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by TaiLV
     * create date:10/08/2022
     * method : editEmployee()
     * param : id = 1
     * test format email
     */
    @Test
    public void editEmployee_email_15() throws Exception {

        EmployeeDTOEdit employeeDTO = new EmployeeDTOEdit();

        employeeDTO.setName("Lê Văn A");
        employeeDTO.setBirthday(Date.valueOf("2000-01-01"));
        employeeDTO.setPhoneNumber("0936369999");
        employeeDTO.setAddress("Tp.Đà Nẵng");
        employeeDTO.setGender(0);
        employeeDTO.setEmail("levana");
        employeeDTO.setSalary(10.0);
        employeeDTO.setImage("http/:firebase.levana.png");
        employeeDTO.setIsDeleted(0);

        Position position = new Position();
        position.setId(1);
        employeeDTO.setPosition(position);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/rest/employee/edit/1")
                        .content(this.objectMapper.writeValueAsString(employeeDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by TaiLV
     * create date:10/08/2022
     * method : editEmployee()
     * param : id = 1
     * test salary = null
     */
    @Test
    public void editEmployee_salary_13() throws Exception {

        EmployeeDTOEdit employeeDTO = new EmployeeDTOEdit();

        employeeDTO.setName("Lê Văn A");
        employeeDTO.setBirthday(Date.valueOf("2000-01-01"));
        employeeDTO.setPhoneNumber("0936369999");
        employeeDTO.setAddress("Tp.Đà Nẵng");
        employeeDTO.setGender(0);
        employeeDTO.setEmail("levana@gmail.com");
        employeeDTO.setSalary(null);
        employeeDTO.setImage("http/:firebase.levana.png");
        employeeDTO.setIsDeleted(0);

        Position position = new Position();
        position.setId(1);
        employeeDTO.setPosition(position);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/rest/employee/edit/1")
                        .content(this.objectMapper.writeValueAsString(employeeDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by TaiLV
     * create date:10/08/2022
     * method : editEmployee()
     * param : id = 1
     * test salary < 0
     */
    @Test
    public void editEmployee_salary_15() throws Exception {

        EmployeeDTOEdit employeeDTO = new EmployeeDTOEdit();

        employeeDTO.setName("Lê Văn A");
        employeeDTO.setBirthday(Date.valueOf("2000-01-01"));
        employeeDTO.setPhoneNumber("0936369999");
        employeeDTO.setAddress("Tp.Đà Nẵng");
        employeeDTO.setGender(0);
        employeeDTO.setEmail("levana@gmail.com");
        employeeDTO.setSalary(-11.0);
        employeeDTO.setImage("http/:firebase.levana.png");
        employeeDTO.setIsDeleted(0);

        Position position = new Position();
        position.setId(1);
        employeeDTO.setPosition(position);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/rest/employee/edit/1")
                        .content(this.objectMapper.writeValueAsString(employeeDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by TaiLV
     * create date:10/08/2022
     * method : editEmployee()
     * param : id = 1
     * test employee edit success
     */
    @Test
    public void editEmployee_18() throws Exception {

        EmployeeDTOEdit employeeDTO = new EmployeeDTOEdit();

        employeeDTO.setName("Lê Văn A");
        employeeDTO.setBirthday(Date.valueOf("2000-01-01"));
        employeeDTO.setPhoneNumber("0936369999");
        employeeDTO.setAddress("Tp.Đà NẴNG");
        employeeDTO.setGender(0);
        employeeDTO.setEmail("levana@gmail.com");
        employeeDTO.setSalary(10.0);
        employeeDTO.setImage("http/:firebase.levana.png");
        employeeDTO.setIsDeleted(0);

        Position position = new Position();
        position.setId(1);
        employeeDTO.setPosition(position);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/rest/employee/edit/1")
                        .content(this.objectMapper.writeValueAsString(employeeDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
