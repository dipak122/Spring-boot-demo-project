package com.example.journalAPP;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tools.jackson.databind.MapperFeature;
import tools.jackson.databind.ObjectMapper;

@SpringBootApplication
public class JournalApplication {

//	@Autowired
//	private ObjectMapper objectMapper;
//
//	@PostConstruct
//	public void testJackson() {
//		System.out.println(
//				objectMapper.isEnabled(
//						MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES
//				)
//		);
//	}
	public static void main(String[] args) {
		System.out.println("I am in main before Spring application");
		SpringApplication.run(JournalApplication.class, args);
		System.out.println("I am in main after Spring application");
	}

}
