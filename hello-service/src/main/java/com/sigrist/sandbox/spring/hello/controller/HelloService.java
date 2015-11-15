package com.sigrist.sandbox.spring.hello.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloService {

	@RequestMapping("/{name}")
    private String hello(@PathVariable("name") String name) {
		System.out.println("Hello "+name);
		return "Hello "+name;
	}
    
}
