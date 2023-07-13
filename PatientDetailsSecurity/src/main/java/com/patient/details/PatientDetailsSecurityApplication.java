package com.patient.details;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;


@SpringBootApplication
@EnableWebMvc
@OpenAPIDefinition(info = @Info(title = "Patient API", version = "2.0", description = "Patient Information"))
@SecurityScheme(name = "Test", scheme = "bearer", type = SecuritySchemeType.HTTP, in = SecuritySchemeIn.HEADER)
public class PatientDetailsSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(PatientDetailsSecurityApplication.class, args);
	}

}
