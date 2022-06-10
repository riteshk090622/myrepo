package com.db.naceloader.util;

import com.db.naceloader.model.Nace;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

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
        assertEquals(398481, naceList.get(0).getOrderId());
        assertEquals(1, naceList.get(0).getLevel());
        assertEquals("A", naceList.get(0).getCode());
        assertTrue("".equals(naceList.get(0).getParent()));
        assertEquals("AGRICULTURE, FORESTRY AND FISHING", naceList.get(0).getDescription());
        assertEquals("This section includes the exploitation of vegetal and animal natural resources, comprising the activities of growing of crops, raising and breeding of animals, harvesting of timber and other plants, animals or animal products from a farm or their natural habitats.", naceList.get(0).getIncludes());
        assertTrue("".equals(naceList.get(0).getAlsoIncludes()));
        assertTrue("".equals(naceList.get(0).getRulings()));
        assertTrue("".equals(naceList.get(0).getExcludes()));
        assertTrue("A".equals(naceList.get(0).getReference()));

    }

}