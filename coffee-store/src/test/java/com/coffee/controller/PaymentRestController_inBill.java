package com.coffee.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PaymentRestController_inBill {

    @Autowired
    private MockMvc mockMvc;


    /**
     * Create: Hoann
     * Create date: 17/08/2022
     * @throws Exception
     */
    @Test
    public void inBill_id_7() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/payment/in-bill"+ "?idTable=" + null ).header("authorization",
                "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJtYW5hZ2VyIiwiZXhwIjoxNjYxMzE2MTE1LCJpYXQiOjE2NjExMzYxMTV9.F1Vp9fGsVsitdbGum_PiZzh9a7tyjKwrmG5gr9dr32KvAOI7Vh54C6b1mCg3LxywlBivrFUfFj3rnjYoU5i_dg"))
                .andDo(print()).andExpect(status().is4xxClientError());
    }
    /**
     * Create: Hoann
     * Create date: 17/08/2022
     * @throws Exception
     */
    @Test
    public void inBill_id_8() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/payment/in-bill"+ "?idTable=" + ' ' ).header("authorization",
                "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJtYW5hZ2VyIiwiZXhwIjoxNjYxMzE2MTE1LCJpYXQiOjE2NjExMzYxMTV9.F1Vp9fGsVsitdbGum_PiZzh9a7tyjKwrmG5gr9dr32KvAOI7Vh54C6b1mCg3LxywlBivrFUfFj3rnjYoU5i_dg"))
                .andDo(print()).andExpect(status().is4xxClientError());
    }
    /**
     * Create: Hoann
     * Create date: 17/08/2022
     * @throws Exception
     */
    @Test
    public void inBill_id_9() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/payment/in-bill"+ "?idTable=" + 99).header("authorization",
                "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJtYW5hZ2VyIiwiZXhwIjoxNjYxMzE2MTE1LCJpYXQiOjE2NjExMzYxMTV9.F1Vp9fGsVsitdbGum_PiZzh9a7tyjKwrmG5gr9dr32KvAOI7Vh54C6b1mCg3LxywlBivrFUfFj3rnjYoU5i_dg"))
                .andDo(print()).andExpect(status().is4xxClientError());
    }
    /**
     * Create: Hoann
     * Create date: 17/08/2022
     * @throws Exception
     */
    @Test
    public void inBill_id_10() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/payment/in-bill"+ "?idTable=" + 1).header("authorization",
                "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJtYW5hZ2VyIiwiZXhwIjoxNjYxMzE2MTE1LCJpYXQiOjE2NjExMzYxMTV9.F1Vp9fGsVsitdbGum_PiZzh9a7tyjKwrmG5gr9dr32KvAOI7Vh54C6b1mCg3LxywlBivrFUfFj3rnjYoU5i_dg"))
                .andDo(print()).andExpect(status().is4xxClientError());
    }

    /**
     * Create: Hoann
     * Create date: 17/08/2022
     * @throws Exception
     */
    @Test
    public void inBill_id_11() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/payment/in-bill"+ "?idTable=" + 1).header("authorization",
                "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJtYW5hZ2VyIiwiZXhwIjoxNjYxMzE2MTE1LCJpYXQiOjE2NjExMzYxMTV9.F1Vp9fGsVsitdbGum_PiZzh9a7tyjKwrmG5gr9dr32KvAOI7Vh54C6b1mCg3LxywlBivrFUfFj3rnjYoU5i_dg"))
                .andDo(print()).andExpect(status().is2xxSuccessful());
    }
}
