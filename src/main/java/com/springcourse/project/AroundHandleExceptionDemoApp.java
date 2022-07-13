package com.springcourse.project;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import com.springcourse.project.aop.DemoConfig;
import com.springcourse.project.service.TrafficFortuneService;

@Component
public class AroundHandleExceptionDemoApp implements CommandLineRunner {
	
	@Override
	public void run(String... args) throws Exception {
		main(args);
	}

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		TrafficFortuneService theFortuneService = context.getBean("trafficFortuneService",
				TrafficFortuneService.class);

		System.out.println("\nMain Program: AroundHandleExceptionDemoApp");

		System.out.println("Calling getFortune()");
		
		boolean tripWire = true;

		String data = theFortuneService.getFortune(tripWire);

		System.out.println("\nMy fortune is: " + data);

		System.out.println("Finished");

		context.close();
	}

}
