package com.gastonfernandez.services;

import org.springframework.stereotype.Service;

import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.model.*;

import com.amazonaws.services.simpleemail.model.Message;
import com.amazonaws.services.simpleemail.model.Body;
import com.amazonaws.services.simpleemail.model.Content;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SendMailService {

    private final Environment env;

    @Autowired
    private AmazonSimpleEmailService sesClient;

    private String mailTo;

    public SendMailService(Environment env) {
		this.env = env;
        this.mailTo = env.resolvePlaceholders("gaston.fernandez@yahoo.com");
    }

    public void sendMail(String from, String to, String subject, String body) throws Exception {}

	public void sendMail(String from, String subject, String body) throws Exception {
		try {
			log.info("sendMail: Enviando email...");

            Message message = new Message()
                    .withSubject(new Content().withData(subject))
                    .withBody(new Body()
                            .withHtml(new Content().withData(body)));

            sesClient.sendEmail(new SendEmailRequest()
                    .withSource(from)
                    .withDestination(new Destination()
                            .withToAddresses(mailTo))
                    .withMessage(message));

			log.info("sendMail: Email enviado.");
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

}
