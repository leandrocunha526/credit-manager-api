package com.api.creditomanager.config;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Crédito Manager API")
                        .version("1.0.0")
                        .description("API REST para gerenciamento de créditos com Kafka e PostgreSQL"));
    }
}
