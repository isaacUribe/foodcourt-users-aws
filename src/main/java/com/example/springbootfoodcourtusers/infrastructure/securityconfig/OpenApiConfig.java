package com.example.springbootfoodcourtusers.infrastructure.securityconfig;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;

import io.swagger.v3.oas.annotations.info.Info;

import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                description = "OpenApi documentation for Spring Boot",
                title = "FoodCourt Users",
                version = "1.0,",
                termsOfService = "Terms of service"
        ),

        servers = {
                @Server(
                        description = "Local ENV",
                        url = "http://localhost:8080"
                )
        }
)
public class OpenApiConfig {
}
