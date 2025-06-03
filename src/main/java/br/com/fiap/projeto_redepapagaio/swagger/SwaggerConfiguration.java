package br.com.fiap.projeto_redepapagaio.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.Components;

@Configuration
public class SwaggerConfiguration {

	@Bean
    OpenAPI configurarSwagger() {
        final String securitySchemeName = "bearerAuth";

        return new OpenAPI()
            .info(new Info()
                .title("RedePapagaio - Sistema de Apoio em Situações Extremas")
                .description("API da RedePapagaio - plataforma de ajuda humanitária em desastres naturais.")
                .summary("Cadastro de usuários, pedidos de ajuda, alertas, doações, reputações e integração com voluntários.")
                .version("v1.0.0")
                .license(new License()
                    .name("FIAP - Global Solution")
                    .url("www.fiap.com.br")))
            .addSecurityItem(new SecurityRequirement().addList(securitySchemeName))
            .components(new Components()
                .addSecuritySchemes(securitySchemeName,
                    new SecurityScheme()
                        .name(securitySchemeName)
                        .type(SecurityScheme.Type.HTTP)
                        .scheme("bearer")
                        .bearerFormat("JWT")));
    }
}
