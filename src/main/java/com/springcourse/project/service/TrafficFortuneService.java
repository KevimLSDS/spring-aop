package com.springcourse.project.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

@Component
public class TrafficFortuneService {

	public String getFortune() {

		// SIMULATE A DELAY
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// RETURN A FORTUNE
		return "Expect heavy traffic this morning.";
	}

	public String getFortune(boolean tripWire) {

		if (tripWire) {
			throw new RuntimeException("Major accident! Highway is closed!");
		}

		return getFortune();
	}

}
