package com.db.naceloader;

import com.db.naceloader.model.Nace;
import com.db.naceloader.model.ResponseUserMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.*;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	void getNaceDetails() {
		final ResponseEntity<Nace> responseEntity = restTemplate.getForEntity("/nace/398481", Nace.class);
		assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(responseEntity.getBody().getOrderId()).isEqualTo(398481);
		assertThat(responseEntity.getBody().getLevel()).isEqualTo(1);
		assertThat(responseEntity.getBody().getCode()).isEqualTo("A");
	}

	@Test
	void putNaceDetails_LoadsCsvFileInDb() {

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.MULTIPART_FORM_DATA);

		MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
		body.add("file", new FileSystemResource(".\\src\\main\\resources\\NACE_REV2_20220610_081339.csv"));

		HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);
		final ResponseEntity<ResponseUserMessage> response = restTemplate.postForEntity("/uploadCsv", requestEntity, ResponseUserMessage.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody().getMessage()).isEqualTo("File Uploaded Successfully");


	}


}
