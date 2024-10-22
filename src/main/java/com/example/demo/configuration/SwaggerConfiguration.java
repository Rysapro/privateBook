package com.example.demo.configuration;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("SPRING BOOT + REST")
                        .description("Singers Management REST API")
                        .contact(new Contact()
                                .name("Aisha")
                                .url("https://www.youtube.com/watch?v=xFYS8NisDz4&list=PLbZYvuv94zTXT12XZnSlDfXm5lTx2nMRR&index=8")
                                .email("asdf@gmail.com")));
    }
}