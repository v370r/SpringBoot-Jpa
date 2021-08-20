package com.webservices.restfulWebServices.helloWorld;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class hellow{
	@GetMapping(value="/hello")
	//@ResponseStatus(code = HttpStatus.OK, reason = "object created and saved")
	public String Hello() {
		return "Hello ";
	}
//	
//	
	@GetMapping(path = "/helloworld")
	public HelloWorldBean helloWorldPathVariable() { 
		return new HelloWorldBean("Hello world");
	}
	@GetMapping(path="/hello-world/path/{name}")
	public HelloWorldBean hellopath(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello world, %s",name));
	}
}
