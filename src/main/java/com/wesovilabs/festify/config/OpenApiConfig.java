package com.wesovilabs.festify.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(title = "API de Festify", version = "v1", description = "Servicios de gestión de festivales"),
        servers = { @Server(url = "/") }
)
// Botón “Authorize” tipo Bearer en Swagger UI
/**
@SecurityScheme(
        name = "bearerAuth",
        type = SecuritySchemeType.HTTP,
        scheme = "bearer",
        bearerFormat = "JWT",
        in = SecuritySchemeIn.HEADER
)
**/
public class OpenApiConfig {}