package org.serratec.curso.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API - Cursos comunitários")
                        .version("1.0.0")
                        .description("Serratec - Trabalho individual - API REST para gerenciamento de cursos comunitários")
                        .contact(new Contact()
                                .name("Elionardo Silva dos Santos")
                                .email("elionars@gmail.com"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("https://github.com/elionardosantos/serratec-api-rest-trabalho-individual.git")))
                .addServersItem(new Server()
                        .url("http://localhost:8080")
                        .description("Servidor Local"));
    }
}