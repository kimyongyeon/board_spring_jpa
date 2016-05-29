package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class BoardSpringJpaStudyApplication extends SpringBootServletInitializer {

	/**
	 * SpringBootServletInitializer를 상속받고 아래 메소드를 선언해야 static 폴더 위치를 찾아 간다.
	 * @param application
	 * @return
     */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(BoardSpringJpaStudyApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(BoardSpringJpaStudyApplication.class, args);
	}
}
