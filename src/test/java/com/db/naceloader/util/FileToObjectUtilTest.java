package com.db.naceloader.util;

import com.db.naceloader.model.Nace;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
class FileToObjectUtilTest {

    @Test
    void testFileToObject() {
        byte[] content = null;
        try {
            content = Files.readAllBytes(Paths.get(".\\src\\main\\resources\\NACE_2rec.csv"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        MultipartFile file = new MockMultipartFile("NACE_2rec.csv", "NACE_2rec.csv", "text/plain", content);

        final ArrayList<Nace> naceList = FileToObjectUtil.fileToNaceList(file);
        assertNotNull(naceList);
        assertEquals(2, naceList.size());
    }

}