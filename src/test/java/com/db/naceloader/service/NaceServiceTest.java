package com.db.naceloader.service;

import com.db.naceloader.model.Nace;
import com.db.naceloader.model.NaceBuilder;
import com.db.naceloader.repository.NaceRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyCollection;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class NaceServiceTest {

    @Mock
    private NaceRepository naceRepository;

    private NaceService naceService;

    @BeforeEach
    void setUp() {
        naceService = new NaceService(naceRepository);
    }

    @Test
    void getNaceDetails() {
        given(naceRepository.findByOrderId(anyInt())).willReturn(new NaceBuilder().setOrderId(398481).setLevel(1).setCode("A").createNace());
        final Nace nace = naceService.getNaceDetails(398481);
        assertEquals(398481, nace.getOrderId());
        assertEquals(1, nace.getLevel());
        assertEquals("A", nace.getCode());
    }

    @Test
    void putNaceDetails() {
        given(naceRepository.saveAll(anyCollection())).willReturn(new ArrayList<Nace>());

        byte[] content = null;
        try {
            content = Files.readAllBytes(Paths.get(".\\src\\main\\resources\\NACE_REV2_20220610_081339.csv"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        MultipartFile file = new MockMultipartFile("NACE_REV2_20220610_081339.csv","NACE_REV2_20220610_081339.csv",
                "text/plain",content);


        final String message = naceService.putNaceDetails(file);
        assertNotNull(message);
        assertEquals("File Uploaded Successfully", message);
    }
}