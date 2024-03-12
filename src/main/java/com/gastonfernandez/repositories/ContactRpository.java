package com.gastonfernandez.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gastonfernandez.models.Contact;

@Repository
public interface ContactRpository extends JpaRepository<Contact, Long>  {

}
