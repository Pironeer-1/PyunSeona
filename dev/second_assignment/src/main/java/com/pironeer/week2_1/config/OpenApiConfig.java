package com.pironeer.week2_1.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(
                title = "Pironeer Second_assignment",
                description = "Second_assignment",
                version = "v1",
                contact = @Contact(
                        name = "편선아",
                        email = "vustjsdk1@naver.com"
                )
        )
)
@Configuration
public class OpenApiConfig {
}
