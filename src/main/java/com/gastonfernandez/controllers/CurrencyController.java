package com.gastonfernandez.controllers;

import org.springframework.web.bind.annotation.RestController;
import com.gastonfernandez.beans.Casa;
import com.gastonfernandez.services.ApiCurrencyService;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/currencies")
@Slf4j
public class CurrencyController {

	@Autowired
	private final ApiCurrencyService apiCurrencyService;
	
	public CurrencyController(ApiCurrencyService apiCurrencyService) {
		this.apiCurrencyService = apiCurrencyService;
	}

	@PostMapping("/get-dolar-values")
	public  ResponseEntity<List> getDolarValues() throws Exception {
		try {
		log.info("getDolarValues-Controller --> Start");
		List response = apiCurrencyService.getDolarValues();
		return ResponseEntity.status(HttpStatus.OK).body(response);
		} catch (Exception e) {	
			throw e;
		}
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleException(Exception exception) {
		log.error(exception.toString());
		exception.printStackTrace();
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception.toString());
	}

}
