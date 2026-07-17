package mx.edu.itvo.biblioteca.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;

import org.springframework.context.annotation.Configuration;

/**
 * Configuración de OpenAPI para la documentación
 * del Sistema Integral de Biblioteca.
 *
 * Integra Swagger UI con autenticación JWT.
 *
 * @author Conce
 * @version 1.0
 * @since 1.0
 */
@Configuration
@OpenAPIDefinition(

        info = @Info(

                title = "Sistema Integral de Biblioteca API",

                version = "1.0",

                description = """
                        API REST para la gestión integral
                        de bibliotecas.

                        Características:

                        • Spring Boot

                        • Spring Security

                        • JWT

                        • CRUD REST

                        • XML

                        • JSON

                        • CSV

                        • Swagger/OpenAPI
                        """,

                contact = @Contact(

                        name = "ITVO",

                        email = "admin@biblioteca.local"),

                license = @License(

                        name = "Uso Académico")),

        security = @SecurityRequirement(
                name = "Bearer Authentication"))

@SecurityScheme(

        name = "Bearer Authentication",

        description = """
                Introduzca únicamente el token JWT.

                Ejemplo:

                eyJhbGciOiJIUzI1NiJ9...
                """,

        scheme = "bearer",

        bearerFormat = "JWT",

        type = SecuritySchemeType.HTTP,

        in = SecuritySchemeIn.HEADER)

public class OpenApiConfig {

}