package tn.esprit.pi.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;


@Configuration
public class SwaggerConfig {
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
		.select() //anehi classe li bch yekhdem aleha
		.apis(RequestHandlerSelectors.basePackage("tn.esprit.pi"))//filtrer selon le controller
		.paths(PathSelectors.any())//filtrer selon url any yekhdem les url lkol
		.build();
		}
	
	private ApiInfo apiInfo () {
		return new ApiInfoBuilder()
		.title("Swagger Configuration for consommi tounsi")
		.description("\"Spring Boot Swagger configuration\"")
		.version("1.1.0").build();
		}
	
	
	
		}
	




