package com.bcf.church.configs;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    final String securitySchemeName = "bearerAuth";

    @Bean
    public OpenAPI apiInfo(){
        return new OpenAPI()
                .addSecurityItem(new SecurityRequirement().addList(securitySchemeName))
                .components(
                        new Components()
                                .addSecuritySchemes(securitySchemeName,
                                        new SecurityScheme()
                                                .name(securitySchemeName)
                                                .type(SecurityScheme.Type.HTTP)
                                                .scheme("bearer")
                                                .bearerFormat("JWT")
                                )
                )
                .info(new Info()
                    .title("Micro Service")
                    .description("APIs for Test Console service")
                    .version("3.0")
                    .license(new License().name("Dev Team").url("https://github.com"))
                    .contact(new Contact().name("Kim Oraya").url("www.kimguides.net").email("kimbriel_oraya@yahoo.com"))
                );
    }
}
