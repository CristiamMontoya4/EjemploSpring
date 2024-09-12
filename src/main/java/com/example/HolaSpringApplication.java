package com.example;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HolaSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(HolaSpringApplication.class, args);
	}

	// Información para la documentación de la Api :)
	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI()
				.info(new Info()
						.title("Api de SpringBoot - Tienda")
						.version("1.0")
						.description("Esta api maneja información de una tienda, esta fue hecha como ejercicio del curso de Spring de Platzi")
						.termsOfService("http://swagger.io/terms/")
						.license(new io.swagger.v3.oas.models.info.License().name("Apache 2.0").url("http://springdoc.org")));
	}

}
