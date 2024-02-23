package com.gastonfernandez.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gastonfernandez.models.Shopping;
import com.gastonfernandez.repositories.ShoppingRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ShoppingService {
	@Autowired
	private final ShoppingRepository shoppingRepository;
	
	@Autowired
	private BusinessService businessService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private PaymentMethodService paymentMethodService;

	@Autowired
	private AccountService accountService;

	public ShoppingService(ShoppingRepository shoppingRepository) {
		this.shoppingRepository = shoppingRepository;
	}

	public void setShoppings(ArrayList<Shopping> shoppings) throws Exception {
		try {
			log.info("saveShopping-Services --> Start");
			log.info("-->Datos de shopping a actualizar: ");
			log.info(shoppings.toString());
			for (Shopping shopping : shoppings) {
				shopping.setBusiness(businessService.checkBusiness(shopping.getBusiness().getBusiness()));
				shopping.setProduct(productService.checkProduct(shopping.getProduct().getProduct()));
				shopping.setPaymentMethod(paymentMethodService.checkPaymentMethod(shopping.getPaymentMethod().getPaymentMethod()));
				shopping.setAccount(accountService.checkAccount(shopping.getAccount().getAccount()));
				this.setShopping(shopping);
			}
			this.shoppingRepository.saveAllAndFlush(shoppings);
			log.info("-->Datos actualizados");
		} catch (Exception e) {
			log.error(e.toString());
			throw e;
		}
	}

	public void setShopping(Shopping shopping) throws Exception {
		try {
			log.info("saveShopping-Services --> Start");
			log.info("-->Datos de shopping a actualizar: ");
			log.info(shopping.toString());
			this.shoppingRepository.save(shopping);
			log.info("-->Datos actualizados");
		} catch (Exception e) {
			log.error(e.toString());
			throw e;
		}
	}

	public ArrayList<Shopping> getShoppings() throws Exception {
		ArrayList<Shopping> shoppings = null;
		try {
			log.info("getShoppings-Services --> Start");
			shoppings = (ArrayList<Shopping>) this.shoppingRepository.findAll();
			log.info("-->Datos de shopping obtenidos: ");
			log.info(shoppings.toString());
		} catch (Exception e) {
			log.error(e.toString());
			throw e;
		}
		return shoppings;
	}

}
