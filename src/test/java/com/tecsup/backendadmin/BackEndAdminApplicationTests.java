package com.tecsup.backendadmin;

import com.tecsup.backendadmin.Login.Usuario;
import com.tecsup.backendadmin.Repository.UsuarioRepository;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BackEndAdminApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void testObtenerProyectos() {

		ResponseEntity<String> response = restTemplate.getForEntity("/proyectos", String.class);

		assertThat(response.getStatusCodeValue()).isEqualTo(200);

		assertThat(response.getBody()).isNotEmpty();
	}

	@Test
	public void testObtenerCategorias() {
		ResponseEntity<String> response = restTemplate.getForEntity("/categorias", String.class);

		assertThat(response.getStatusCodeValue()).isEqualTo(200);

		assertThat(response.getBody()).isNotEmpty();
	}

	@Test
	public void testObtenerAños() {
		ResponseEntity<String> response = restTemplate.getForEntity("/ciclo", String.class);

		assertThat(response.getStatusCodeValue()).isEqualTo(200);

		assertThat(response.getBody()).isNotEmpty();
	}




}
