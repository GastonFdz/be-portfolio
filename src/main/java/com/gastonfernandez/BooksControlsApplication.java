package com.gastonfernandez;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
@ComponentScan("com.gastonfernandez.tests")
public class BooksControlsApplication {

	public static void main(String[] args) {
		SpringApplication.run(BooksControlsApplication.class, args);
		log.info("Application-> Start");
	}

}
