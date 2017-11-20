package com.example.Sleuthdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.apache.log4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;
import org.springframework.context.annotation.Bean; 

@SpringBootApplication
@RestController
public class SleuthDemoApplication {

	private static final Logger LOG = Logger.getLogger(SleuthDemoApplication.class.getName());

	@Autowired
	private RestTemplate restTemplate;

	public static void main(String[] args) {
		SpringApplication.run(SleuthDemoApplication.class, args);
	}

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	@RequestMapping("/")
	public String home() {
		LOG.log(Level.INFO, "you called home");
		return "Hello World!";
	}

	@RequestMapping("/callhome")
	public String callHome() {
		LOG.log(Level.INFO, "calling home");
    		return
restTemplate.getForObject("http://localhost:8080", String.class);
	}

}
