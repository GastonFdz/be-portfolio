package com.gastonfernandez.services;

import java.util.Properties;

import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;
import org.springframework.mail.SimpleMailMessage;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SendMail {

	public void sendMail(String from, String to, String subject, String body) throws Exception {
		try {

			log.info("sendMail: levantando servicor SMTP...");

			JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
			mailSender.setHost("localhost");
			mailSender.setPort(25);

			mailSender.setUsername("root");
			mailSender.setPassword("G4st0n");

			Properties props = mailSender.getJavaMailProperties();
			props.put("mail.transport.protocol", "smtp");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.debug", "true");

			log.info("sendMail: Servidor SMTP levantado.");
			log.info("sendMail: Servidor SMTP: " + mailSender.getHost() + ":" + mailSender.getPort());
			log.info("sendMail: Usuario: " + mailSender.getUsername());
			log.info("sendMail: Contraseña: " + mailSender.getPassword());
			log.info("sendMail: Propiedades: " + props);
			log.info("sendMail: Enviando email...");

			SimpleMailMessage message = new SimpleMailMessage();
			message.setFrom(from);
			message.setTo(to);
			message.setSubject(subject);
			message.setText(body);

			mailSender.send(message);

			log.info("sendMail: Email enviado.");
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

}
