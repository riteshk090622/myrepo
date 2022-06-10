package com.db.naceloader.controller;

import com.db.naceloader.controller.NaceController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(NaceController.class)
public class NaceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getNaceDetails() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/nace/398481"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("orderId").value(398481))
                .andExpect(jsonPath("level").value(1))
                .andExpect(jsonPath("code").value("A"));
    }
}
