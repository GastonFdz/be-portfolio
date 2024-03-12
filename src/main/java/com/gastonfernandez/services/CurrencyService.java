package com.gastonfernandez.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gastonfernandez.models.Currency;
import com.gastonfernandez.repositories.CurrencyRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CurrencyService {

	@Autowired
	private final CurrencyRepository currencyRepository;
	
	public CurrencyService(CurrencyRepository currencyRepository) {
		this.currencyRepository = currencyRepository;
	}

	public void setCurrency(Currency currency) {
		try {
			log.info("setCurrency-Services --> Start");
			log.info("setCurrency-Services --> Datos de divisa a actualizar: ");
			log.info(currency.toString());
			this.currencyRepository.save(currency);
			log.info("setCurrency-Services --> Datos de divisa actualizada");
		} catch (Exception e) {
			log.error(e.toString());
			throw e;
		}
	}
}
