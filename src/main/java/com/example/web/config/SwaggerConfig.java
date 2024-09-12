package com.example.web.config;

import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;

//Esta clase se iba usar para documentasr los endpoints con swagger, pero al no tener una versión compatible se cambio por OpenApi
//Así que se aprovechara para hacer una interfaz personalizada
public class SwaggerConfig {

    //No logro utilizar este, así que el código funcional que en HolaSpringApplication
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
