package com.practica.devops;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Profile;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication

public class PracticaDevOpsApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(PracticaDevOpsApplication.class, args);
	}

}
