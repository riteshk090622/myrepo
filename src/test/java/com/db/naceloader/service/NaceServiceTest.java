package com.db.naceloader.service;

import com.db.naceloader.model.Nace;
import com.db.naceloader.repository.NaceRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
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
        given(naceRepository.findByOrderId(anyInt())).willReturn(new Nace(398481,1,"A"));
        final Nace nace = naceService.getNaceDetails(398481);
        assertEquals(398481, nace.getOrderId());
        assertEquals(1, nace.getLevel());
        assertEquals("A", nace.getCode());
    }
}