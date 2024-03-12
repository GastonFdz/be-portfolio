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

import com.gastonfernandez.models.Contact;
import com.gastonfernandez.models.Shopping;
import com.gastonfernandez.services.ContactService;
import com.gastonfernandez.services.SendMailService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/contact")
@Slf4j
public class ContactController {

	@Autowired
	private final SendMailService sendMailService;

	@Autowired
	private final ContactService contactService;

	public ContactController(SendMailService sendMailService, ContactService contactService) {
		this.sendMailService = sendMailService;
		this.contactService = contactService;
	}

	@PostMapping("/send-contact")
	public ResponseEntity<Contact> sendMail(@RequestBody Contact contact) throws Exception {
		try {
			this.contactService.setContact(contact);
			String body = "<p>Nombre: " + contact.getName() + " " + contact.getLastname() +
					"</p><p>Email: " + contact.getEmail() +
					"</p><p>Telefono: " + contact.getPhone() +
					"</p><p>Mensaje: " + contact.getMessage() + "</p>";
			log.info("sendMail-Controller --> Se enviara el email: " + body);
			sendMailService.sendMail(contact.getEmail(), contact.getSubject(), body);
			return ResponseEntity.status(HttpStatus.CREATED).body(contact);
		} catch (Exception e) {
			log.error(e.toString());
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
