package br.com.rodrigo.App.Contatos.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
public class OpenApiConfig {

	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI()
				.components(
						new Components().addSecuritySchemes("bearerAuth", 
								new SecurityScheme().type(SecurityScheme.Type.HTTP)
									.scheme("bearer").bearerFormat("JWT")))
				.info(new Info()
						.title("App de contatos das pessoas")
						.description("Este aplicativo faz controle dos contatos das pessoas "
								+ "bem como o cadastro de seu respectivo estoque.")
						.contact(new Contact()
									.name("Rodrigo")
									.email("rsouzas@minsait.com")
									.url("http://localhost")
								)
						.version("Versão 0.0.1-SNAPSHOT")
				).addSecurityItem(new SecurityRequirement().addList("bearerAuth"));
	}	
}