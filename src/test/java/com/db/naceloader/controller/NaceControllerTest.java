package com.db.naceloader.controller;

import com.db.naceloader.controller.NaceController;
import com.db.naceloader.model.Nace;
import com.db.naceloader.service.NaceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(NaceController.class)
public class NaceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    NaceService naceService;

    @Test
    void getNaceDetails() throws Exception {
        given(naceService.getNaceDetails(anyInt())).willReturn(new Nace(398481, 1, "A"));
        mockMvc.perform(MockMvcRequestBuilders.get("/nace/398481"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("orderId").value(398481))
                .andExpect(jsonPath("level").value(1))
                .andExpect(jsonPath("code").value("A"));
    }
}
