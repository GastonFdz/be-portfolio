package com.gastonfernandez.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gastonfernandez.models.Contact;
import com.gastonfernandez.repositories.ContactRpository;

import lombok.extern.slf4j.Slf4j;

import java.util.Date;

@Service
@Slf4j
public class ContactService {
	@Autowired
	private final ContactRpository contactRepository;

	public ContactService(ContactRpository contactRepository) {
		this.contactRepository = contactRepository;
	}
	
	public void setContact(Contact contact) throws Exception {
		try {
			log.info("setContact-Services --> Start");
			log.info("setContact-Services -->Contacto a actualizar: ");
			log.info(contact.toString());
			this.contactRepository.save(contact);
			contact.setDateContact(new Date());
			log.info("setContact-Services -->Contacto actualizados");			
		} catch (Exception e) {
			log.error(e.toString());
			throw e;
		}
	}
}
