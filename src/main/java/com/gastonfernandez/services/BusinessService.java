package com.gastonfernandez.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gastonfernandez.models.Business;
import com.gastonfernandez.repositories.BusinessRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BusinessService {

	@Autowired
	private final BusinessRepository businessRepository;

	public BusinessService(BusinessRepository businessRepository) {
		this.businessRepository = businessRepository;
	}

	public void setBusiness(Business business) throws Exception {
		try {
			log.info("setBusiness-Services --> Start");
			log.info("setBusiness-Services -->Datos de business a actualizar: ");
			log.info(business.toString());
			this.businessRepository.save(business);
			log.info("setBusiness-Services -->Datos actualizados");
		} catch (Exception e) {
			log.error(e.toString());
			throw e;
		}
	}

	public Business getBusiness(long businessId) {
		try {
			return businessRepository.findById(businessId).orElse(null);
		} catch (Exception e) {
			log.error(e.toString());
			throw e;
		}
	}

	public Object getBusiness(String businessDescription) {
		try {
			List<Business> business = businessRepository.findByDescription(businessDescription);
			if (business.isEmpty()) {
				return null;
			} else if (business.size() == 1) {
				return business.get(0);
			}
			return business;
		} catch (Exception e) {
			log.error(e.toString());
			throw e;
		}
	}

	private Business getBusinessByList(Object businesses) {		
		Business response = new Business();
		if (businesses instanceof Business) 
			response = (Business) businesses;
		else if (businesses instanceof List) {
			List<Business> businessesAux = (List<Business>) businesses;
			response = businessesAux.get(0);
		}
		return response;		
	}

	public Business checkBusiness(String businessDescription) throws Exception {
		try {
			Object businesses = this.getBusiness(businessDescription);
			Business business = new Business();
			if (businesses == null) {
				log.info("checkBusiness-Service --> el comercio " + businessDescription + " no existe");
				log.info("checkBusiness-Service --> creando comercio...");
				business.setBusiness(businessDescription);
				this.setBusiness(business);
				business = getBusinessByList(this.getBusiness(businessDescription));
				log.info("checkBusiness-Service --> el comercio " + businessDescription + " fue creado");
			} else if (businesses instanceof Business) {
				business = (Business) businesses;
				log.info("checkBusiness-Service --> el comercio " + businessDescription.toString() + " existe");
			} else if (businesses instanceof List) {
				log.error("Los comercios asociadas a " + businessDescription + " son mas de uno: (se toma el primero)");
				log.error(businesses.toString());
				business = getBusinessByList(businesses);
			}
			return business;
		} catch (Exception e) {
			log.error(e.toString());
			throw e;
		}
	}

}
