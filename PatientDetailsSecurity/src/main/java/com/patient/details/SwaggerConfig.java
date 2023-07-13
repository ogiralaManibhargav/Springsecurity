package com.patient.details;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;


@Configuration
//@EnableSwagger2
public class SwaggerConfig {
	
	  @Bean
	    public OpenAPI usersMicroserviceOpenAPI() {
	        return new OpenAPI()
	                .info(new Info().title("Your API Title")
	                                 .description("Your API Description")
	                                 .version("1.0"));
	  }

	/*   @Bean
	    public Docket api() {
	        return new Docket(DocumentationType.SWAGGER_12)
	                .select()
	                .apis(RequestHandlerSelectors.basePackage("com.patient.details.controller")) 
	                .paths(PathSelectors.any())
	                .build()
	                .securitySchemes(Arrays.asList(apiKey()))
	                .securityContexts(Arrays.asList(securityContext()))
	                .apiInfo(apiInfo())
	                .pathMapping("/")
	                .useDefaultResponseMessages(false)
	                .directModelSubstitute(LocalDate.class, String.class)
	                .genericModelSubstitutes(ResponseEntity.class);
	    }
	    
	    private ApiInfo apiInfo() {
	        return new ApiInfoBuilder()
	                .title("Your API Documentation")
	                .description("Description of your API")
	                .version("1.0.0")
	                .build();
	    }
	    
	    private ApiKey apiKey() {
	        return new ApiKey("JWT", "Authorization", "header");
	    }

	    private SecurityContext securityContext() {
	        return SecurityContext.builder().securityReferences(defaultAuth()).build();
	    }
	    private List<SecurityReference> defaultAuth() {
	        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
	        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
	        authorizationScopes[0] = authorizationScope;
	        return Arrays.asList(new SecurityReference("JWT", authorizationScopes));
	    }*/
}
