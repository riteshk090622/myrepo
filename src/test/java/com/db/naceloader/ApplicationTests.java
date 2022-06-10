package com.db.naceloader;

import com.db.naceloader.model.Nace;
import com.db.naceloader.model.ResponseUserMessage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import static org.assertj.core.api.Assertions.assertThat;

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
		assertThat(responseEntity.getBody().getParent()).isNullOrEmpty();
		assertThat(responseEntity.getBody().getDescription()).isEqualTo("AGRICULTURE, FORESTRY AND FISHING");
		assertThat(responseEntity.getBody().getIncludes()).isEqualTo("This section includes the exploitation of vegetal and animal natural resources, comprising the activities of growing of crops, raising and breeding of animals, harvesting of timber and other plants, animals or animal products from a farm or their natural habitats.");
		assertThat(responseEntity.getBody().getAlsoIncludes()).isNullOrEmpty();
		assertThat(responseEntity.getBody().getRulings()).isNullOrEmpty();
		assertThat(responseEntity.getBody().getExcludes()).isNullOrEmpty();
		assertThat(responseEntity.getBody().getReference()).isEqualTo("A");
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
