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
public class AccountEmployeeRestController_getInfoAccountEmployee {
    @Autowired
    private MockMvc mockMvc;
    /**
     * @param "id" = "null"
     * @status 4xx
     * @return Trả về nội dung lỗi FieldError ở REST
     * @creator ThongNV
     * Date 10/08/2022
     */
    @Test
    public void  getInfoAccountEmployee_id_1() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/api/account/accountEmployee/null")).andDo(print()).andExpect(status().is4xxClientError());
    }
    /**
     * @param "id" = "rỗng"
     * @status 4xx
     * @return Trả về nội dung lỗi FieldError ở REST
     * @creator ThongNV
     * Date 10/08/2022
     */
    @Test
    public void getInfoAccountEmployee_id_2() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/api/account/accountEmployee/")
        ).andDo(print()).andExpect(status().is4xxClientError());
    }
    /**
     * @param "id" = không tồn tại trong DB
     * @status 4xx
     * @return Trả về nội dung lỗi FieldError ở REST
     * @creator ThongNV
     * Date 10/08/2022
     */
    @Test
    public void getInfoAccountEmployee_id_3() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/api/account/accountEmployee/33")
        ).andDo(print()).andExpect(status().is4xxClientError());

    }
    /**
     * @param "id" = "Tồn tại trong DB
     * @status 2xx
     * @return"Dữ liệu là JSON, chứa đầy đủ các thuộc tính ở object, đảm bảo 2 yếu tố: Số lượng thuộc tính + Dữ liệu thuộc tính."
     * @creator ThongNV
     * Date 10/08/2022
     */
    @Test
    public void getInfoAccountEmployee_id_4() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/api/account/accountEmployee/6"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("userName").value("admin"))
                .andExpect(jsonPath("nameEmployee").value("thông"))
                .andExpect(jsonPath("address").value("Quảng Nam"))
                .andExpect(jsonPath("gender").value(1))
                .andExpect(jsonPath("phoneNumber").value("092398989"))
                .andExpect(jsonPath("birthDay").value("1990-09-09"))
                .andExpect(jsonPath("salary").value("1500000.0"))
                .andExpect(jsonPath("positionName").value("quản lí"));
    }
}
