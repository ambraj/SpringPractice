package com.luv2code.springdemo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {
	
	private Random random = new Random();
	
	public String[] data = {
		"Beware of the wolf!",
		"The journey is the award!",
		"It's gonna rain today!"
	};

	@Override
	public String getFortune() {
		return data[random.nextInt(data.length)];
	}
	
}
