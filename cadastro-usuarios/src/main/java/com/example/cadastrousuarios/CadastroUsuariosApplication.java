package com.example.cadastrousuarios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.example.cadastrousuarios")
public class CadastroUsuariosApplication {

	public static void main(String[] args) {
		SpringApplication.run(CadastroUsuariosApplication.class, args);
	}

}
