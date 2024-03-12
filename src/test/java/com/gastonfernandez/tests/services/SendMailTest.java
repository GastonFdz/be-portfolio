package com.gastonfernandez.tests.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.gastonfernandez.services.SendMailService;

public class SendMailTest {
	@Mock
	private SendMailService mockServicio;

	/*
	@InjectMocks private MiServicioImpl servicio;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	*/

	@Test
	void sendMailTest() {

	}
}