package com.db.naceloader.controller;

import com.db.naceloader.model.Nace;
import com.db.naceloader.service.NaceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(NaceController.class)
public class NaceControllerTest {

    @MockBean
    NaceService naceService;
    @Autowired
    private MockMvc mockMvc;

    @Test
    void getNaceDetails() throws Exception {
        given(naceService.getNaceDetails(anyInt())).willReturn(new Nace(398481, 1, "A"));
        mockMvc.perform(MockMvcRequestBuilders.get("/nace/398481"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("orderId").value(398481))
                .andExpect(jsonPath("level").value(1))
                .andExpect(jsonPath("code").value("A"));
    }

    @Test
    void putNaceDetails() throws Exception {
        given(naceService.putNaceDetails(any())).willReturn("File Uploaded Successfully");
//        final byte[] content = Files.readAllBytes(Paths.get(".\\src\\main\\resources\\NACE_REV2_20220610_081339.csv"));

        byte[] content = null;
        try {
            content = Files.readAllBytes(Paths.get(".\\src\\main\\resources\\NACE_REV2_20220610_081339.csv"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        MockMultipartFile file = new MockMultipartFile("file", "NACE_REV2_20220610_081339.csv",
                "text/plain", content);


        mockMvc.perform(MockMvcRequestBuilders.multipart("/uploadCsv")
                        .file(file)
                        .contentType(MediaType.MULTIPART_FORM_DATA)
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("message").value("File Uploaded Successfully"));
    }
}
