package com.sigrist.sandbox.spring.hello.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/hi")
public class HelloClient {

	@Autowired
	@LoadBalanced
	private RestTemplate restTemplate;

	
	@RequestMapping("/sigrist")
	public String helloSigrist() {
		return this.hello("Sigrist");
	}
	
	public String hello(String name) {
		ParameterizedTypeReference<String> ptr = new ParameterizedTypeReference<String>() {
		};

		String reservations = restTemplate
				.exchange("http://hello-service/hello/"+name, HttpMethod.GET, null, ptr).getBody();

		return reservations;
	}
}
