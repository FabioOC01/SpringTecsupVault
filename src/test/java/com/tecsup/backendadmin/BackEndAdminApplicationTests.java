package com.tecsup.backendadmin;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BackEndAdminApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void testObtenerProyectos() {

		ResponseEntity<String> response = restTemplate.getForEntity("/api/proyectos", String.class);

		assertThat(response.getStatusCodeValue()).isEqualTo(200);

		assertThat(response.getBody()).isNotEmpty();
	}

	@Test
	public void testObtenerCategorias() {
		ResponseEntity<String> response = restTemplate.getForEntity("/api/categorias", String.class);

		assertThat(response.getStatusCodeValue()).isEqualTo(200);

		assertThat(response.getBody()).isNotEmpty();
	}

	@Test
	public void testObtenerAños() {
		ResponseEntity<String> response = restTemplate.getForEntity("/api/ciclo", String.class);

		assertThat(response.getStatusCodeValue()).isEqualTo(200);

		assertThat(response.getBody()).isNotEmpty();
	}

}
