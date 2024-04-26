package com.TaskDemo.Task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//import io.swagger.annotations.Api;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

@SpringBootApplication
@EnableConfigurationProperties
@EnableWebMvc
@EntityScan(basePackages = {"com.TaskDemo.Entity"})
@ComponentScan(basePackages = {"com.TaskDemo.Repository","com.TaskDemo.controller","com.TaskDemo.service","com.TaskDemo.serviceImpl"})
public class TaskApplication implements WebMvcConfigurer{

	public static void main(String[] args) {
		SpringApplication.run(TaskApplication.class, args);
	}
	 @Override
	    public void addCorsMappings(CorsRegistry registry) {
	        registry.addMapping("/**")
	                .allowedOrigins("http://localhost:3000") 
	                .allowedMethods("GET", "POST", "PUT", "DELETE")
	                .allowedHeaders("*");
	        }
	 
//	 @Bean
//	 public Docket api() {
//		 return new Docket(DocumentationType.SWAGGER_2).select()
//				 .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
//				 .paths(PathSelectors.any())
//				 .build().pathMapping("/");
//	 }
//	
}
