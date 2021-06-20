package com.cybertek.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenApi(){

        SecurityScheme securitySchemeItem = new SecurityScheme();  //create instance

        //set
        securitySchemeItem.setType(SecurityScheme.Type.HTTP);
        securitySchemeItem.setScheme("bearer");         //Bearer Authentication
        securitySchemeItem.setBearerFormat("JWT");          //set token format
        securitySchemeItem.setIn(SecurityScheme.In.HEADER); //set place for  our token
        securitySchemeItem.setName("Authorization");

        //info object
        io.swagger.v3.oas.models.info.Info infoVersion = new io.swagger.v3.oas.models.info.Info().title("Cybertek API").version("snapshot");

        //security part : provide access to read and write
        SecurityRequirement securityItem = new SecurityRequirement().addList("bearer-jwt", Arrays.asList("read","write"));

        return new OpenAPI()
                .components(new Components()
                .addSecuritySchemes("bearer-jwt",securitySchemeItem))
                .info(infoVersion)
                .addSecurityItem(securityItem);
    }

}
/*
to test it go to chrome
navigate to
http://localhost:8080/swagger-ui.html

POST Authenticate
see the token is created

try read
denied
create token
authorize
try read
success
 */