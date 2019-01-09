package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@MapperScan("com.example.studyweb.mapper")
public class StudywebApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder applicationBuilder){
		 applicationBuilder.sources(StudywebApplication.class);
		 return super.configure(applicationBuilder);
	}

	public static void main(String[] args) {
		SpringApplication.run(StudywebApplication.class, args);
	}
}
