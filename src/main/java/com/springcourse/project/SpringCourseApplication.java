package com.springcourse.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class SpringCourseApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCourseApplication.class, args);
		
	}

}
