package com.luv2code.webservice.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@GetMapping("/hello-world")
	private String helloWorld() {
		return "Hello World";
	}

	@GetMapping("/hello-world-bean")
	private HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("hello-world-bean");
	}

	@GetMapping("/hello-world-bean/path-variable/{name}")
	private HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello World, %s", name));
	}

}
