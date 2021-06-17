package com.cybertek;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

    }

    // to see Json format ad json viewer extension and navigate to  http://localhost:8080/v3/api-docs
    @Bean
    public OpenAPI customOpenApi(){

        return new OpenAPI()
                .info(new Info().title("Cinema Application")
                        .version("v1")
                        .description("Selling online cinema tickets"));
    }
}
