package com.coffee.controller;

<<<<<<< HEAD
<<<<<<< HEAD
import com.coffee.dto.EmployeeDTO;
=======
import com.coffee.dto.employe.EmployeeDTOCreate;
import com.coffee.model.account.AppUser;
>>>>>>> 81ebf118ad076574228d96c866a50213048fad1c
=======
import com.coffee.dto.employe.EmployeeDTOCreate;
import com.coffee.model.account.AppUser;
>>>>>>> 0dd84c9fdad5a52defe92a1d8eb8da514746caf3
import com.coffee.model.employee.Position;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

<<<<<<< HEAD
<<<<<<< HEAD
=======
import java.sql.Date;

>>>>>>> 81ebf118ad076574228d96c866a50213048fad1c
=======
import java.sql.Date;

>>>>>>> 0dd84c9fdad5a52defe92a1d8eb8da514746caf3
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeRestController_editEmployee {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

<<<<<<< HEAD
<<<<<<< HEAD
// test edit name = null,where id = 1
    @Test
    public void editEmployee_name_13() throws Exception {

        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setName(null);
        employeeDTO.getBirthday("2000-01-01");
        employeeDTO.getPhoneNumber("0936369999");
        employeeDTO.setAddress("Tp.Đà NẴNG");
        employeeDTO.setGender(0);
        employeeDTO.setEmail("levana@gmail.com");
        employeeDTO.setSalary(10.0);
        employeeDTO.setImage("http/:firebase.levana.png");
        employeeDTO.getIsDeleted(0);
=======
=======
>>>>>>> 0dd84c9fdad5a52defe92a1d8eb8da514746caf3
    /**
     * Create by TaiLV
     * create date:10/08/2022
     * method : editEmployee()
     * test userName = null
     */
    @Test
    public void editEmployee_userName_13() throws Exception {

        EmployeeDTOCreate employeeDTO = new EmployeeDTOCreate();

        AppUser appUser = new AppUser();
        appUser.setUserName(null);

        employeeDTO.setName("Lê Văn A");
        employeeDTO.setBirthday(Date.valueOf("2000-01-01"));
        employeeDTO.setPhoneNumber("0936369999");
        employeeDTO.setAddress("Tp.Đà NẴNG");
        employeeDTO.setGender(0);
        employeeDTO.setEmail("levana@gmail.com");
        employeeDTO.setSalary(1000000.0);
        employeeDTO.setImage("http/:firebase.levana.png");
        employeeDTO.setIsDeleted(0);

        Position position = new Position();
        position.setId(1);
        employeeDTO.setPosition(position);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/rest/employee/edit")
                        .content(this.objectMapper.writeValueAsString(employeeDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by TaiLV
     * create date:10/08/2022
     * method : editEmployee()
     * test userName = ""
     */
    @Test
    public void editEmployee_userName_14() throws Exception {

        EmployeeDTOCreate employeeDTO = new EmployeeDTOCreate();

        AppUser appUser = new AppUser();
        appUser.setUserName("");

        employeeDTO.setName("Lê Văn A");
        employeeDTO.setBirthday(Date.valueOf("2000-01-01"));
        employeeDTO.setPhoneNumber("0936369999");
        employeeDTO.setAddress("Tp.Đà NẴNG");
        employeeDTO.setGender(0);
        employeeDTO.setEmail("levana@gmail.com");
        employeeDTO.setSalary(1000000.0);
        employeeDTO.setImage("http/:firebase.levana.png");
        employeeDTO.setIsDeleted(0);

        Position position = new Position();
        position.setId(1);
        employeeDTO.setPosition(position);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/rest/employee/edit")
                        .content(this.objectMapper.writeValueAsString(employeeDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by TaiLV
     * create date:10/08/2022
     * method : saveEmployee()
     * test userName: first input = number
     */
    @Test
    public void editEmployee_userName_15() throws Exception {

        EmployeeDTOCreate employeeDTO = new EmployeeDTOCreate();

        AppUser appUser = new AppUser();
        appUser.setUserName("1user123");

        employeeDTO.setName("Lê Văn A");
        employeeDTO.setBirthday(Date.valueOf("2000-01-01"));
        employeeDTO.setPhoneNumber("0936369999");
        employeeDTO.setAddress("Tp.Đà NẴNG");
        employeeDTO.setGender(0);
        employeeDTO.setEmail("levana@gmail.com");
        employeeDTO.setSalary(1000000.0);
        employeeDTO.setImage("http/:firebase.levana.png");
        employeeDTO.setIsDeleted(0);

        Position position = new Position();
        position.setId(1);
        employeeDTO.setPosition(position);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/rest/employee/edit")
                        .content(this.objectMapper.writeValueAsString(employeeDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by TaiLV
     * create date:10/08/2022
     * method : editEmployee()
     * test userName < 6 char
     */
    @Test
    public void editEmployee_userName_16() throws Exception {

        EmployeeDTOCreate employeeDTO = new EmployeeDTOCreate();

        AppUser appUser = new AppUser();
        appUser.setUserName("user1");

        employeeDTO.setName("Lê Văn A");
        employeeDTO.setBirthday(Date.valueOf("2000-01-01"));
        employeeDTO.setPhoneNumber("0936369999");
        employeeDTO.setAddress("Tp.Đà NẴNG");
        employeeDTO.setGender(0);
        employeeDTO.setEmail("levana@gmail.com");
        employeeDTO.setSalary(1000000.0);
        employeeDTO.setImage("http/:firebase.levana.png");
        employeeDTO.setIsDeleted(0);

        Position position = new Position();
        position.setId(1);
        employeeDTO.setPosition(position);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/rest/employee/edit")
                        .content(this.objectMapper.writeValueAsString(employeeDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by TaiLV
     * create date:10/08/2022
     * method : editEmployee()
     * test userName >20 char
     */
    @Test
    public void editEmployee_userName_16_1() throws Exception {

        EmployeeDTOCreate employeeDTO = new EmployeeDTOCreate();

        AppUser appUser = new AppUser();
        appUser.setUserName("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa " +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa " +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");

        employeeDTO.setName("Lê Văn A");
        employeeDTO.setBirthday(Date.valueOf("2000-01-01"));
        employeeDTO.setPhoneNumber("0936369999");
        employeeDTO.setAddress("Tp.Đà NẴNG");
        employeeDTO.setGender(0);
        employeeDTO.setEmail("levana@gmail.com");
        employeeDTO.setSalary(1000000.0);
        employeeDTO.setImage("http/:firebase.levana.png");
        employeeDTO.setIsDeleted(0);

        Position position = new Position();
        position.setId(1);
        employeeDTO.setPosition(position);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/rest/employee/edit")
                        .content(this.objectMapper.writeValueAsString(employeeDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by TaiLV
     * create date:10/08/2022
     * method : editEmployee()
     * test name = null
     */
    @Test
    public void editEmployee_name_13() throws Exception {

        EmployeeDTOCreate employeeDTO = new EmployeeDTOCreate();

        AppUser appUser = new AppUser();
        appUser.setUserName("user123");

        employeeDTO.setName(null);
        employeeDTO.setBirthday(Date.valueOf("2000-01-01"));
        employeeDTO.setPhoneNumber("0936369999");
        employeeDTO.setAddress("Tp.Đà NẴNG");
        employeeDTO.setGender(0);
        employeeDTO.setEmail("levana@gmail.com");
        employeeDTO.setSalary(1000000.0);
        employeeDTO.setImage("http/:firebase.levana.png");
        employeeDTO.setIsDeleted(0);
<<<<<<< HEAD
>>>>>>> 81ebf118ad076574228d96c866a50213048fad1c
=======
>>>>>>> 0dd84c9fdad5a52defe92a1d8eb8da514746caf3

        Position position = new Position();
        position.setId(1);
        employeeDTO.setPosition(position);

        this.mockMvc
                .perform(MockMvcRequestBuilders
<<<<<<< HEAD
<<<<<<< HEAD
                        .patch("/rest/employee/edit/1")
=======
                        .patch("/rest/employee/edit")
>>>>>>> 81ebf118ad076574228d96c866a50213048fad1c
=======
                        .patch("/rest/employee/edit")
>>>>>>> 0dd84c9fdad5a52defe92a1d8eb8da514746caf3
                        .content(this.objectMapper.writeValueAsString(employeeDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
<<<<<<< HEAD
<<<<<<< HEAD
// test edit name = "",where id = 1
    @Test
    public void editEmployee_name_14() throws Exception {

        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setName("");
        employeeDTO.getBirthday("2000-01-01");
        employeeDTO.getPhoneNumber("0936369999");
        employeeDTO.setAddress("Tp.Đà NẴNG");
        employeeDTO.setGender(0);
        employeeDTO.setEmail("levana@gmail.com");
        employeeDTO.setSalary(10.0);
        employeeDTO.setImage("http/:firebase.levana.png");
        employeeDTO.getIsDeleted(0);
=======
=======
>>>>>>> 0dd84c9fdad5a52defe92a1d8eb8da514746caf3

    /**
     * Create by TaiLV
     * create date:10/08/2022
     * method : editEmployee()
     * test name = ""
     */
    @Test
    public void editEmployee_name_14() throws Exception {

        EmployeeDTOCreate employeeDTO = new EmployeeDTOCreate();
        AppUser appUser = new AppUser();
        appUser.setUserName("user123");
        employeeDTO.setName("");
        employeeDTO.setBirthday(Date.valueOf("2000-01-01"));
        employeeDTO.setPhoneNumber("0936369999");
        employeeDTO.setAddress("Tp.Đà NẴNG");
        employeeDTO.setGender(0);
        employeeDTO.setEmail("levana@gmail.com");
        employeeDTO.setSalary(1000000.0);
        employeeDTO.setImage("http/:firebase.levana.png");
        employeeDTO.setIsDeleted(0);
<<<<<<< HEAD
>>>>>>> 81ebf118ad076574228d96c866a50213048fad1c
=======
>>>>>>> 0dd84c9fdad5a52defe92a1d8eb8da514746caf3

        Position position = new Position();
        position.setId(1);
        employeeDTO.setPosition(position);

        this.mockMvc
                .perform(MockMvcRequestBuilders
<<<<<<< HEAD
<<<<<<< HEAD
                        .patch("/rest/employee/edit/1")
=======
                        .patch("/rest/employee/edit")
>>>>>>> 81ebf118ad076574228d96c866a50213048fad1c
=======
                        .patch("/rest/employee/edit")
>>>>>>> 0dd84c9fdad5a52defe92a1d8eb8da514746caf3
                        .content(this.objectMapper.writeValueAsString(employeeDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

<<<<<<< HEAD
<<<<<<< HEAD
    // test edit format birthday,where id = 1
    @Test
    public void editEmployee_birthday_15() throws Exception {

        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setName("Lê Văn A");
        employeeDTO.getBirthday("20000101");
        employeeDTO.getPhoneNumber("0936369999");
        employeeDTO.setAddress("Tp.Đà NẴNG");
        employeeDTO.setGender(0);
        employeeDTO.setEmail("levana@gmail.com");
        employeeDTO.setSalary(10.0);
        employeeDTO.setImage("http/:firebase.levana.png");
        employeeDTO.getIsDeleted(0);
=======
=======
>>>>>>> 0dd84c9fdad5a52defe92a1d8eb8da514746caf3
    /**
     * Create by TaiLV
     * create date:10/08/2022
     * method : editEmployee()
     * test format birthday
     */
    @Test
    public void editEmployee_birthday_15() throws Exception {

        EmployeeDTOCreate employeeDTO = new EmployeeDTOCreate();

        AppUser appUser = new AppUser();
        appUser.setUserName("user123");

        employeeDTO.setName("Lê Văn A");
        employeeDTO.setBirthday(Date.valueOf("20000101"));
        employeeDTO.setPhoneNumber("0936369999");
        employeeDTO.setAddress("Tp.Đà NẴNG");
        employeeDTO.setGender(0);
        employeeDTO.setEmail("levana@gmail.com");
        employeeDTO.setSalary(1000000.0);
        employeeDTO.setImage("http/:firebase.levana.png");
        employeeDTO.setIsDeleted(0);

        Position position = new Position();
        position.setId(1);
        employeeDTO.setPosition(position);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/rest/employee/edit")
                        .content(this.objectMapper.writeValueAsString(employeeDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by TaiLV
     * create date:10/08/2022
     * method : editEmployee()
     * test birthday = null
     */
    @Test
    public void editEmployee_birthday_13() throws Exception {

        EmployeeDTOCreate employeeDTO = new EmployeeDTOCreate();

        AppUser appUser = new AppUser();
        appUser.setUserName("user123");

        employeeDTO.setName("fate12345");
        employeeDTO.setBirthday(null);
        employeeDTO.setPhoneNumber("0936369999");
        employeeDTO.setAddress("Tp.Đà NẴNG");
        employeeDTO.setGender(0);
        employeeDTO.setEmail("levana@gmail.com");
        employeeDTO.setSalary(1000000.0);
        employeeDTO.setImage("http/:firebase.levana.png");
        employeeDTO.setIsDeleted(0);
<<<<<<< HEAD
>>>>>>> 81ebf118ad076574228d96c866a50213048fad1c
=======
>>>>>>> 0dd84c9fdad5a52defe92a1d8eb8da514746caf3

        Position position = new Position();
        position.setId(1);
        employeeDTO.setPosition(position);

        this.mockMvc
                .perform(MockMvcRequestBuilders
<<<<<<< HEAD
<<<<<<< HEAD
                        .patch("/rest/employee/edit/1")
=======
                        .patch("/rest/employee/edit")
>>>>>>> 81ebf118ad076574228d96c866a50213048fad1c
=======
                        .patch("/rest/employee/edit")
>>>>>>> 0dd84c9fdad5a52defe92a1d8eb8da514746caf3
                        .content(this.objectMapper.writeValueAsString(employeeDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

<<<<<<< HEAD
<<<<<<< HEAD
    // test edit phone = null,where id = 1
    @Test
    public void editEmployee_phoneNumber_13() throws Exception {

        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setName("Lê Văn A");
        employeeDTO.getBirthday("2000-01-01");
        employeeDTO.getPhoneNumber(null);
        employeeDTO.setAddress("Tp.Đà NẴNG");
        employeeDTO.setGender(0);
        employeeDTO.setEmail("levana@gmail.com");
        employeeDTO.setSalary(10.0);
        employeeDTO.setImage("http/:firebase.levana.png");
        employeeDTO.getIsDeleted(0);
=======
=======
>>>>>>> 0dd84c9fdad5a52defe92a1d8eb8da514746caf3
    /**
     * Create by TaiLV
     * create date:10/08/2022
     * method : editEmployee()
     * test birthday = ""
     */
    @Test
    public void editEmployee_birthday_14() throws Exception {

        EmployeeDTOCreate employeeDTO = new EmployeeDTOCreate();
        AppUser appUser = new AppUser();
        appUser.setUserName("user123");
        employeeDTO.setName("fate1234");
        employeeDTO.setBirthday(Date.valueOf(""));
        employeeDTO.setPhoneNumber("0936369999");
        employeeDTO.setAddress("Tp.Đà NẴNG");
        employeeDTO.setGender(0);
        employeeDTO.setEmail("levana@gmail.com");
        employeeDTO.setSalary(1000000.0);
        employeeDTO.setImage("http/:firebase.levana.png");
        employeeDTO.setIsDeleted(0);

        Position position = new Position();
        position.setId(1);
        employeeDTO.setPosition(position);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/rest/employee/edit")
                        .content(this.objectMapper.writeValueAsString(employeeDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     * Create by TaiLV
     * create date:10/08/2022
     * method : editEmployee()
     * test phoneNumber = null
     */
    @Test
    public void editEmployee_phoneNumber_13() throws Exception {

        EmployeeDTOCreate employeeDTO = new EmployeeDTOCreate();

        AppUser appUser = new AppUser();
        appUser.setUserName("user123");

        employeeDTO.setName("Lê Văn A");
        employeeDTO.setBirthday(Date.valueOf("2000-01-01"));
        employeeDTO.setPhoneNumber(null);
        employeeDTO.setAddress("Tp.Đà NẴNG");
        employeeDTO.setGender(0);
        employeeDTO.setEmail("levana@gmail.com");
        employeeDTO.setSalary(1000000.0);
        employeeDTO.setImage("http/:firebase.levana.png");
        employeeDTO.setIsDeleted(0);
<<<<<<< HEAD
>>>>>>> 81ebf118ad076574228d96c866a50213048fad1c
=======
>>>>>>> 0dd84c9fdad5a52defe92a1d8eb8da514746caf3

        Position position = new Position();
        position.setId(1);
        employeeDTO.setPosition(position);

        this.mockMvc
                .perform(MockMvcRequestBuilders
<<<<<<< HEAD
<<<<<<< HEAD
                        .patch("/rest/employee/edit/1")
=======
                        .patch("/rest/employee/edit")
>>>>>>> 81ebf118ad076574228d96c866a50213048fad1c
=======
                        .patch("/rest/employee/edit")
>>>>>>> 0dd84c9fdad5a52defe92a1d8eb8da514746caf3
                        .content(this.objectMapper.writeValueAsString(employeeDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

<<<<<<< HEAD
<<<<<<< HEAD
    // test edit phoneNumber = "",where id = 1
    @Test
    public void editEmployee_phoneNumber_14() throws Exception {

        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setName("Lê Văn A");
        employeeDTO.getBirthday("2000-01-01");
        employeeDTO.getPhoneNumber("");
        employeeDTO.setAddress("Tp.Đà NẴNG");
        employeeDTO.setGender(0);
        employeeDTO.setEmail("levana@gmail.com");
        employeeDTO.setSalary(10.0);
        employeeDTO.setImage("http/:firebase.levana.png");
        employeeDTO.getIsDeleted(0);
=======
=======
>>>>>>> 0dd84c9fdad5a52defe92a1d8eb8da514746caf3
    /**
     * Create by TaiLV
     * create date:10/08/2022
     * method : editEmployee()
     * test phoneNumber = ""
     */
    @Test
    public void editEmployee_phoneNumber_14() throws Exception {

        EmployeeDTOCreate employeeDTO = new EmployeeDTOCreate();

        AppUser appUser = new AppUser();
        appUser.setUserName("user123");

        employeeDTO.setName("Lê Văn A");
        employeeDTO.setBirthday(Date.valueOf("2000-01-01"));
        employeeDTO.setPhoneNumber("");
        employeeDTO.setAddress("Tp.Đà NẴNG");
        employeeDTO.setGender(0);
        employeeDTO.setEmail("levana@gmail.com");
        employeeDTO.setSalary(1000000.0);
        employeeDTO.setImage("http/:firebase.levana.png");
        employeeDTO.setIsDeleted(0);
<<<<<<< HEAD
>>>>>>> 81ebf118ad076574228d96c866a50213048fad1c
=======
>>>>>>> 0dd84c9fdad5a52defe92a1d8eb8da514746caf3

        Position position = new Position();
        position.setId(1);
        employeeDTO.setPosition(position);

        this.mockMvc
                .perform(MockMvcRequestBuilders
<<<<<<< HEAD
<<<<<<< HEAD
                        .patch("/rest/employee/edit/1")
=======
                        .patch("/rest/employee/edit")
>>>>>>> 81ebf118ad076574228d96c866a50213048fad1c
=======
                        .patch("/rest/employee/edit")
>>>>>>> 0dd84c9fdad5a52defe92a1d8eb8da514746caf3
                        .content(this.objectMapper.writeValueAsString(employeeDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

<<<<<<< HEAD
<<<<<<< HEAD
    // test edit address = null,where id = 1
    @Test
    public void editEmployee_address_13() throws Exception {

        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setName("Lê Văn A");
        employeeDTO.getBirthday("2000-01-01");
        employeeDTO.getPhoneNumber("0936369999");
        employeeDTO.setAddress(null);
        employeeDTO.setGender(0);
        employeeDTO.setEmail("levana@gmail.com");
        employeeDTO.setSalary(10.0);
        employeeDTO.setImage("http/:firebase.levana.png");
        employeeDTO.getIsDeleted(0);
=======
=======
>>>>>>> 0dd84c9fdad5a52defe92a1d8eb8da514746caf3

    /**
     * Create by TaiLV
     * create date:10/08/2022
     * method : editEmployee()
     * test format phoneNumber
     */
    @Test
    public void editEmployee_phoneNumber_15() throws Exception {

        EmployeeDTOCreate employeeDTO = new EmployeeDTOCreate();

        AppUser appUser = new AppUser();
        appUser.setUserName("user123");

        employeeDTO.setName("Lê Văn A");
        employeeDTO.setBirthday(Date.valueOf("2000-01-01"));
        employeeDTO.setPhoneNumber("00000000000000000");
        employeeDTO.setAddress("Tp.Đà NẴNG");
        employeeDTO.setGender(0);
        employeeDTO.setEmail("levana@gmail.com");
        employeeDTO.setSalary(1000000.0);
        employeeDTO.setImage("http/:firebase.levana.png");
        employeeDTO.setIsDeleted(0);

        Position position = new Position();
        position.setId(1);
        employeeDTO.setPosition(position);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/rest/employee/edit")
                        .content(this.objectMapper.writeValueAsString(employeeDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Create by TaiLV
     * create date:10/08/2022
     * method : editEmployee()
     * test address = null
     */
    @Test
    public void editEmployee_address_13() throws Exception {

        EmployeeDTOCreate employeeDTO = new EmployeeDTOCreate();

        AppUser appUser = new AppUser();
        appUser.setUserName("user123");
        employeeDTO.setName("Lê Văn A");
        employeeDTO.setBirthday(Date.valueOf("2000-01-01"));
        employeeDTO.setPhoneNumber("0936369999");
        employeeDTO.setAddress(null);
        employeeDTO.setGender(0);
        employeeDTO.setEmail("levana@gmail.com");
        employeeDTO.setSalary(1000000.0);
        employeeDTO.setImage("http/:firebase.levana.png");
        employeeDTO.setIsDeleted(0);
<<<<<<< HEAD
>>>>>>> 81ebf118ad076574228d96c866a50213048fad1c
=======
>>>>>>> 0dd84c9fdad5a52defe92a1d8eb8da514746caf3

        Position position = new Position();
        position.setId(1);
        employeeDTO.setPosition(position);

        this.mockMvc
                .perform(MockMvcRequestBuilders
<<<<<<< HEAD
<<<<<<< HEAD
                        .patch("/rest/employee/edit/1")
=======
                        .patch("/rest/employee/edit")
>>>>>>> 81ebf118ad076574228d96c866a50213048fad1c
=======
                        .patch("/rest/employee/edit")
>>>>>>> 0dd84c9fdad5a52defe92a1d8eb8da514746caf3
                        .content(this.objectMapper.writeValueAsString(employeeDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

<<<<<<< HEAD
<<<<<<< HEAD

    // test edit address = "",where id = 1
    @Test
    public void editEmployee_address_14() throws Exception {

        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setName("Lê Văn A");
        employeeDTO.getBirthday("2000-01-01");
        employeeDTO.getPhoneNumber("0936369999");
        employeeDTO.setAddress("");
        employeeDTO.setGender(0);
        employeeDTO.setEmail("levana@gmail.com");
        employeeDTO.setSalary(10.0);
        employeeDTO.setImage("http/:firebase.levana.png");
        employeeDTO.getIsDeleted(0);
=======
=======
>>>>>>> 0dd84c9fdad5a52defe92a1d8eb8da514746caf3
    /**
     * Create by TaiLV
     * create date:10/08/2022
     * method : editEmployee()
     * test address = ""
     */
    @Test
    public void editEmployee_address_14() throws Exception {

        EmployeeDTOCreate employeeDTO = new EmployeeDTOCreate();

        AppUser appUser = new AppUser();
        appUser.setUserName("user123");
        employeeDTO.setName("Lê Văn A");
        employeeDTO.setBirthday(Date.valueOf("2000-01-01"));
        employeeDTO.setPhoneNumber("0936369999");
        employeeDTO.setAddress("");
        employeeDTO.setGender(0);
        employeeDTO.setEmail("levana@gmail.com");
        employeeDTO.setSalary(1000000.0);
        employeeDTO.setImage("http/:firebase.levana.png");
        employeeDTO.setIsDeleted(0);
<<<<<<< HEAD
>>>>>>> 81ebf118ad076574228d96c866a50213048fad1c
=======
>>>>>>> 0dd84c9fdad5a52defe92a1d8eb8da514746caf3

        Position position = new Position();
        position.setId(1);
        employeeDTO.setPosition(position);

        this.mockMvc
                .perform(MockMvcRequestBuilders
<<<<<<< HEAD
<<<<<<< HEAD
                        .patch("/rest/employee/edit/1")
=======
                        .patch("/rest/employee/edit")
>>>>>>> 81ebf118ad076574228d96c866a50213048fad1c
=======
                        .patch("/rest/employee/edit")
>>>>>>> 0dd84c9fdad5a52defe92a1d8eb8da514746caf3
                        .content(this.objectMapper.writeValueAsString(employeeDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

<<<<<<< HEAD
<<<<<<< HEAD
    // test edit email = null,where id = 1
    @Test
    public void editEmployee_email_13() throws Exception {

        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setName("Lê Văn A");
        employeeDTO.getBirthday("2000-01-01");
        employeeDTO.getPhoneNumber("0936369999");
        employeeDTO.setAddress("Tp.Đà Nẵng");
        employeeDTO.setGender(0);
        employeeDTO.setEmail(null);
        employeeDTO.setSalary(10.0);
        employeeDTO.setImage("http/:firebase.levana.png");
        employeeDTO.getIsDeleted(0);
=======
=======
>>>>>>> 0dd84c9fdad5a52defe92a1d8eb8da514746caf3
    /**
     * Create by TaiLV
     * create date:10/08/2022
     * method : editEmployee()
     * test address = !@$#%^&*()
     */
    @Test
    public void editEmployee_address_15() throws Exception {

        EmployeeDTOCreate employeeDTO = new EmployeeDTOCreate();

        AppUser appUser = new AppUser();
        appUser.setUserName("user123");
        employeeDTO.setName("Lê Văn A");
        employeeDTO.setBirthday(Date.valueOf("2000-01-01"));
        employeeDTO.setPhoneNumber("0936369999");
        employeeDTO.setAddress("!@#$%^&*()");
        employeeDTO.setGender(0);
        employeeDTO.setEmail("levana@gmail.com");
        employeeDTO.setSalary(1000000.0);
        employeeDTO.setImage("http/:firebase.levana.png");
        employeeDTO.setIsDeleted(0);

        Position position = new Position();
        position.setId(1);
        employeeDTO.setPosition(position);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/rest/employee/edit")
                        .content(this.objectMapper.writeValueAsString(employeeDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Create by TaiLV
     * create date:10/08/2022
     * method : editEmployee()
     * test email = null
     */
    @Test
    public void editEmployee_email_13() throws Exception {

        EmployeeDTOCreate employeeDTO = new EmployeeDTOCreate();

        AppUser appUser = new AppUser();
        appUser.setUserName("user123");
        employeeDTO.setName("Lê Văn A");
        employeeDTO.setBirthday(Date.valueOf("2000-01-01"));
        employeeDTO.setPhoneNumber("0936369999");
        employeeDTO.setAddress("Tp.Đà Nẵng");
        employeeDTO.setGender(0);
        employeeDTO.setEmail(null);
        employeeDTO.setSalary(1000000.0);
        employeeDTO.setImage("http/:firebase.levana.png");
        employeeDTO.setIsDeleted(0);
<<<<<<< HEAD
>>>>>>> 81ebf118ad076574228d96c866a50213048fad1c
=======
>>>>>>> 0dd84c9fdad5a52defe92a1d8eb8da514746caf3

        Position position = new Position();
        position.setId(1);
        employeeDTO.setPosition(position);

        this.mockMvc
                .perform(MockMvcRequestBuilders
<<<<<<< HEAD
<<<<<<< HEAD
                        .patch("/rest/employee/edit/1")
=======
                        .patch("/rest/employee/edit")
>>>>>>> 81ebf118ad076574228d96c866a50213048fad1c
=======
                        .patch("/rest/employee/edit")
>>>>>>> 0dd84c9fdad5a52defe92a1d8eb8da514746caf3
                        .content(this.objectMapper.writeValueAsString(employeeDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

<<<<<<< HEAD
<<<<<<< HEAD
    // test edit email = "" ,where id = 1
    @Test
    public void editEmployee_email_14() throws Exception {

        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setName("Lê Văn A");
        employeeDTO.getBirthday("2000-01-01");
        employeeDTO.getPhoneNumber("0936369999");
        employeeDTO.setAddress("Tp.Đà Nẵng");
        employeeDTO.setGender(0);
        employeeDTO.setEmail("");
        employeeDTO.setSalary(10.0);
        employeeDTO.setImage("http/:firebase.levana.png");
        employeeDTO.getIsDeleted(0);
=======
=======
>>>>>>> 0dd84c9fdad5a52defe92a1d8eb8da514746caf3
    /**
     * Create by TaiLV
     * create date:10/08/2022
     * method : saveEmployee()
     * test email = ""
     */
    @Test
    public void editEmployee_email_14() throws Exception {

        EmployeeDTOCreate employeeDTO = new EmployeeDTOCreate();

        AppUser appUser = new AppUser();
        appUser.setUserName("user123");

        employeeDTO.setName("Lê Văn A");
        employeeDTO.setBirthday(Date.valueOf("2000-01-01"));
        employeeDTO.setPhoneNumber("0936369999");
        employeeDTO.setAddress("Tp.Đà Nẵng");
        employeeDTO.setGender(0);
        employeeDTO.setEmail("");
        employeeDTO.setSalary(1000000.0);
        employeeDTO.setImage("http/:firebase.levana.png");
        employeeDTO.setIsDeleted(0);
<<<<<<< HEAD
>>>>>>> 81ebf118ad076574228d96c866a50213048fad1c
=======
>>>>>>> 0dd84c9fdad5a52defe92a1d8eb8da514746caf3

        Position position = new Position();
        position.setId(1);
        employeeDTO.setPosition(position);

        this.mockMvc
                .perform(MockMvcRequestBuilders
<<<<<<< HEAD
<<<<<<< HEAD
                        .patch("/rest/employee/edit/1")
=======
                        .patch("/rest/employee/edit")
>>>>>>> 81ebf118ad076574228d96c866a50213048fad1c
=======
                        .patch("/rest/employee/edit")
>>>>>>> 0dd84c9fdad5a52defe92a1d8eb8da514746caf3
                        .content(this.objectMapper.writeValueAsString(employeeDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

<<<<<<< HEAD
<<<<<<< HEAD
    // test edit format email where id = 1
    @Test
    public void editEmployee_email_15() throws Exception {

        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setName("Lê Văn A");
        employeeDTO.getBirthday("2000-01-01");
        employeeDTO.getPhoneNumber("0936369999");
        employeeDTO.setAddress("Tp.Đà Nẵng");
        employeeDTO.setGender(0);
        employeeDTO.setEmail("levana");
        employeeDTO.setSalary(10.0);
        employeeDTO.setImage("http/:firebase.levana.png");
        employeeDTO.getIsDeleted(0);
=======
=======
>>>>>>> 0dd84c9fdad5a52defe92a1d8eb8da514746caf3
    /**
     * Create by TaiLV
     * create date:10/08/2022
     * method : saveEmployee()
     * test format email
     */
    @Test
    public void editEmployee_email_15() throws Exception {

        EmployeeDTOCreate employeeDTO = new EmployeeDTOCreate();

        AppUser appUser = new AppUser();
        appUser.setUserName("user123");

        employeeDTO.setName("Lê Văn A");
        employeeDTO.setBirthday(Date.valueOf("2000-01-01"));
        employeeDTO.setPhoneNumber("0936369999");
        employeeDTO.setAddress("Tp.Đà Nẵng");
        employeeDTO.setGender(0);
        employeeDTO.setEmail("levana");
        employeeDTO.setSalary(1000000.0);
        employeeDTO.setImage("http/:firebase.levana.png");
        employeeDTO.setIsDeleted(0);
<<<<<<< HEAD
>>>>>>> 81ebf118ad076574228d96c866a50213048fad1c
=======
>>>>>>> 0dd84c9fdad5a52defe92a1d8eb8da514746caf3

        Position position = new Position();
        position.setId(1);
        employeeDTO.setPosition(position);

        this.mockMvc
                .perform(MockMvcRequestBuilders
<<<<<<< HEAD
<<<<<<< HEAD
                        .patch("/rest/employee/edit/1")
=======
                        .patch("/rest/employee/edit")
>>>>>>> 81ebf118ad076574228d96c866a50213048fad1c
=======
                        .patch("/rest/employee/edit")
>>>>>>> 0dd84c9fdad5a52defe92a1d8eb8da514746caf3
                        .content(this.objectMapper.writeValueAsString(employeeDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

<<<<<<< HEAD
<<<<<<< HEAD
    // test edit salary = null where id = 1
    @Test
    public void editEmployee_salary_13() throws Exception {

        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setName("Lê Văn A");
        employeeDTO.getBirthday("2000-01-01");
        employeeDTO.getPhoneNumber("0936369999");
=======
=======
>>>>>>> 0dd84c9fdad5a52defe92a1d8eb8da514746caf3
    /**
     * Create by TaiLV
     * create date:10/08/2022
     * method : editEmployee()
     * test salary = null
     */
    @Test
    public void editEmployee_salary_13() throws Exception {

        EmployeeDTOCreate employeeDTO = new EmployeeDTOCreate();

        AppUser appUser = new AppUser();
        appUser.setUserName("user123");

        employeeDTO.setName("Lê Văn A");
        employeeDTO.setBirthday(Date.valueOf("2000-01-01"));
        employeeDTO.setPhoneNumber("0936369999");
<<<<<<< HEAD
>>>>>>> 81ebf118ad076574228d96c866a50213048fad1c
=======
>>>>>>> 0dd84c9fdad5a52defe92a1d8eb8da514746caf3
        employeeDTO.setAddress("Tp.Đà Nẵng");
        employeeDTO.setGender(0);
        employeeDTO.setEmail("levana@gmail.com");
        employeeDTO.setSalary(null);
        employeeDTO.setImage("http/:firebase.levana.png");
<<<<<<< HEAD
<<<<<<< HEAD
        employeeDTO.getIsDeleted(0);
=======
        employeeDTO.setIsDeleted(0);
>>>>>>> 81ebf118ad076574228d96c866a50213048fad1c
=======
        employeeDTO.setIsDeleted(0);
>>>>>>> 0dd84c9fdad5a52defe92a1d8eb8da514746caf3

        Position position = new Position();
        position.setId(1);
        employeeDTO.setPosition(position);

        this.mockMvc
                .perform(MockMvcRequestBuilders
<<<<<<< HEAD
<<<<<<< HEAD
                        .patch("/rest/employee/edit/1")
=======
                        .patch("/rest/employee/edit")
>>>>>>> 81ebf118ad076574228d96c866a50213048fad1c
=======
                        .patch("/rest/employee/edit")
>>>>>>> 0dd84c9fdad5a52defe92a1d8eb8da514746caf3
                        .content(this.objectMapper.writeValueAsString(employeeDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

<<<<<<< HEAD
<<<<<<< HEAD
// test edit salary < 0 where id = 1
    @Test
    public void editEmployee_salary_15() throws Exception {

        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setName("Lê Văn A");
        employeeDTO.getBirthday("2000-01-01");
        employeeDTO.getPhoneNumber("0936369999");
=======
=======
>>>>>>> 0dd84c9fdad5a52defe92a1d8eb8da514746caf3
    /**
     * Create by TaiLV
     * create date:10/08/2022
     * method : editEmployee()
     * test salary < 0
     */
    @Test
    public void editEmployee_salary_15() throws Exception {

        EmployeeDTOCreate employeeDTO = new EmployeeDTOCreate();

        AppUser appUser = new AppUser();
        appUser.setUserName("user123");

        employeeDTO.setName("Lê Văn A");
        employeeDTO.setBirthday(Date.valueOf("2000-01-01"));
        employeeDTO.setPhoneNumber("0936369999");
<<<<<<< HEAD
>>>>>>> 81ebf118ad076574228d96c866a50213048fad1c
=======
>>>>>>> 0dd84c9fdad5a52defe92a1d8eb8da514746caf3
        employeeDTO.setAddress("Tp.Đà Nẵng");
        employeeDTO.setGender(0);
        employeeDTO.setEmail("levana@gmail.com");
        employeeDTO.setSalary(-11.0);
        employeeDTO.setImage("http/:firebase.levana.png");
<<<<<<< HEAD
<<<<<<< HEAD
        employeeDTO.getIsDeleted(0);
=======
        employeeDTO.setIsDeleted(0);
>>>>>>> 81ebf118ad076574228d96c866a50213048fad1c
=======
        employeeDTO.setIsDeleted(0);
>>>>>>> 0dd84c9fdad5a52defe92a1d8eb8da514746caf3

        Position position = new Position();
        position.setId(1);
        employeeDTO.setPosition(position);

        this.mockMvc
                .perform(MockMvcRequestBuilders
<<<<<<< HEAD
<<<<<<< HEAD
                        .post("/employee/edit/1")
=======
                        .patch("/rest/employee/edit")
>>>>>>> 81ebf118ad076574228d96c866a50213048fad1c
=======
                        .patch("/rest/employee/edit")
>>>>>>> 0dd84c9fdad5a52defe92a1d8eb8da514746caf3
                        .content(this.objectMapper.writeValueAsString(employeeDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

<<<<<<< HEAD
<<<<<<< HEAD
    // test edit employee id = 1 success
    @Test
    public void editEmployee_18() throws Exception {

        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setName("Lê Văn A");
        employeeDTO.getBirthday("2000-01-01");
        employeeDTO.getPhoneNumber("0936369999");
        employeeDTO.setAddress("Tp.Đà NẴNG");
        employeeDTO.setGender(0);
        employeeDTO.setEmail("levana@gmail.com");
        employeeDTO.setSalary(10.0);
        employeeDTO.setImage("http/:firebase.levana.png");
        employeeDTO.getIsDeleted(0);
=======
=======
>>>>>>> 0dd84c9fdad5a52defe92a1d8eb8da514746caf3
    /**
     * Create by TaiLV
     * create date:10/08/2022
     * method : editEmployee()
     * test employee create success
     */
    @Test
    public void editEmployee_18() throws Exception {

        EmployeeDTOCreate employeeDTO = new EmployeeDTOCreate();

        AppUser appUser = new AppUser();
        appUser.setUserName("user1231212");

        employeeDTO.setName("Lê Văn A");
        employeeDTO.setBirthday(Date.valueOf("2000-01-01"));
        employeeDTO.setPhoneNumber("0936369999");
        employeeDTO.setAddress("Tp.Đà NẴNG");
        employeeDTO.setGender(0);
        employeeDTO.setEmail("levana@gmail.com");
        employeeDTO.setSalary(1000000.0);
        employeeDTO.setImage("http/:firebase.levana.png");
        employeeDTO.setIsDeleted(0);
<<<<<<< HEAD
>>>>>>> 81ebf118ad076574228d96c866a50213048fad1c
=======
>>>>>>> 0dd84c9fdad5a52defe92a1d8eb8da514746caf3

        Position position = new Position();
        position.setId(1);
        employeeDTO.setPosition(position);

        this.mockMvc
                .perform(MockMvcRequestBuilders
<<<<<<< HEAD
<<<<<<< HEAD
                        .post("/employee/edit/1")
=======
                        .patch("/rest/employee/edit")
>>>>>>> 81ebf118ad076574228d96c866a50213048fad1c
=======
                        .patch("/rest/employee/edit")
>>>>>>> 0dd84c9fdad5a52defe92a1d8eb8da514746caf3
                        .content(this.objectMapper.writeValueAsString(employeeDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
