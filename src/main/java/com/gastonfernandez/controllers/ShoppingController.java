package com.gastonfernandez.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gastonfernandez.models.Shopping;
import com.gastonfernandez.services.ShoppingService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/shoppings")
@Slf4j
public class ShoppingController {

	@Autowired
	private ShoppingService shoppingService;


	@PostMapping("/get-shoppings")
	public ResponseEntity<ArrayList<Shopping>> getShoppings() throws Exception {
		try {
			return ResponseEntity.ok(shoppingService.getShoppings());
		} catch (Exception e) {
			throw e;
		}
	}
	
	@PostMapping("/set-shoppings")
	public ResponseEntity<ArrayList<Shopping>> setShoppings(@RequestBody ArrayList<Shopping> elements) throws Exception {
		try {
        	log.info("setShoppings-Controller --> Start");
            shoppingService.setShoppings(elements);
			return ResponseEntity.status(HttpStatus.CREATED).body(elements);
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
