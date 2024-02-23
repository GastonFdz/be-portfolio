package com.gastonfernandez.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gastonfernandez.models.PaymentMethod;
import com.gastonfernandez.repositories.PaymentMethodRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PaymentMethodService {

	@Autowired
	private final PaymentMethodRepository paymentMethodRepository;

	public PaymentMethodService(PaymentMethodRepository paymentMethodRepository) {
		this.paymentMethodRepository = paymentMethodRepository;
	}

	public void setPaymentMethod(PaymentMethod paymentMethod) throws Exception {
		try {
			log.info("setPaymentMethod-Services --> Start");
			log.info("setPaymentMethod-Services -->Datos de paymentMethod a actualizar: ");
			log.info(paymentMethod.toString());
			this.paymentMethodRepository.save(paymentMethod);
			log.info("setPaymentMethod-Services -->Datos actualizados");
		} catch (Exception e) {
			log.error(e.toString());
			throw e;
		}
	}

	public PaymentMethod getPaymentMethod(long paymentMethodId) {
		try {
			return paymentMethodRepository.findById(paymentMethodId).orElse(null);
		} catch (Exception e) {
			log.error(e.toString());
			throw e;
		}
	}

	public Object getPaymentMethod(String paymentMethodDescription) {
		try {
			List<PaymentMethod> paymentMethods = paymentMethodRepository.findByDescription(paymentMethodDescription);

			if (paymentMethods.isEmpty()) {
				return null;
			} else if (paymentMethods.size() == 1) {
				return paymentMethods.get(0);
			}
			return paymentMethods;
		} catch (Exception e) {
			log.error(e.toString());
			throw e;
		}
	}

	private PaymentMethod getPaymentMethodByList(Object paymentMethods) {
		PaymentMethod response = new PaymentMethod();
		if (paymentMethods instanceof PaymentMethod) 
			response = (PaymentMethod) paymentMethods;
		else if (paymentMethods instanceof List) {
			List<PaymentMethod> paymentMethodsAux = (List<PaymentMethod>) paymentMethods;
			response = paymentMethodsAux.get(0);
		}
		return response;
	}

	public PaymentMethod checkPaymentMethod(String paymentMethodDescription) throws Exception {
		try {
			Object paymentMethods = this.getPaymentMethod(paymentMethodDescription);
			PaymentMethod paymentMethod = new PaymentMethod();
			if (paymentMethods == null) {
				log.info("checkPaymentMethod-Service --> el metodo de pago " + paymentMethodDescription + " no existe");
				log.info("checkPaymentMethod-Service --> creando metodo de pago...");
				paymentMethod.setPaymentMethod(paymentMethodDescription);
				this.setPaymentMethod(paymentMethod);
				paymentMethod = getPaymentMethodByList(this.getPaymentMethod(paymentMethodDescription));
				log.info(
						"checkPaymentMethod-Service --> el metodo de pago " + paymentMethodDescription + " fue creado");
			} else if (paymentMethods instanceof PaymentMethod) {
				paymentMethod = (PaymentMethod) paymentMethods;
				log.info("checkPaymentMethod-Service --> el metodo de pago " + paymentMethod.toString() + " existe");
			} else if (paymentMethods instanceof List) {
				log.error("Los metodos de pago asociados a " + paymentMethodDescription
						+ " son mas de uno: (se toma el primero)");
				log.error(paymentMethods.toString());
				paymentMethod = getPaymentMethodByList(paymentMethods);
			}
			return paymentMethod;
		} catch (Exception e) {
			log.error(e.toString());
			throw e;
		}
	}

}
