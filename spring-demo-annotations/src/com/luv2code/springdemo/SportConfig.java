package com.luv2code.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

	@Bean
	public SadFortuneService sadFortuneService() {
		return new SadFortuneService();
	}

	@Bean
	public SwimCoach swimCoach() {
		return new SwimCoach(sadFortuneService());
	}

}
