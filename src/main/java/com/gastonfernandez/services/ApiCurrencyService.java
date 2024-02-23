package com.gastonfernandez.services;

import com.gastonfernandez.beans.Casa;
import com.gastonfernandez.beans.SecundaryHome;
import com.gastonfernandez.collections.ApiCurrencyCollection;
import com.gastonfernandez.exceptions.CurrencyServiceException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@Component
@Service
@Slf4j
public class ApiCurrencyService {

	@Autowired
	private final RestTemplate restTemplate;

	public ApiCurrencyService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public List<Object> getDolarValues() throws Exception {
		List casas = null;
		try {
			String url = "https://www.dolarsi.com/api/api.php?type=dolar";
			log.info("getDolarValues-Services --> Start");
			log.info("Obteniendo valores del Dolar del servidor principal: " + url);
			String responseJson = restTemplate.getForObject(url, String.class);
			log.info("Datos obtenidos: ");
			log.info(responseJson);
			log.info("Serializando resultados...");
			ObjectMapper objectMapper = new ObjectMapper();
			ArrayList<Map<String, Object>> casasJson = objectMapper.readValue(responseJson,
					new TypeReference<ArrayList<Map<String, Object>>>() {
					});

			casas = mapearCasas(casasJson);
		} catch (Exception e) {
			try {
				log.error("Fallo el intento de otencion del service primario " + e.toString()
						+ " ovteniendo del service secundario...");
				casas = this.getDolarValuesServerSecondary();
			} catch (Exception e2) {
				log.error("Fallo el intento de otencion del service secundario + " + e2.toString());
				e2.getStackTrace();
				log.debug("");
				// throw new CurrencyServiceException(e, e2);
				throw e2;
			}
		}
		log.info("");
		return casas;
	}

	private List<SecundaryHome> getDolarValuesServerSecondary() throws Exception {
		List<SecundaryHome> casas = null;
		try {
			String url = "https://dolarapi.com/v1/dolares";
			log.info("getDolarValuesServerSecondary-Services --> Start");
			log.info("Obteniendo valores del Dolar del servidor secundario: " + url);
			String responseJson = restTemplate.getForObject(url, String.class);
			log.info("Datos obtenidos: ");
			log.info(responseJson);
			log.info("Serializando resultados...");
			ObjectMapper objectMapper = new ObjectMapper();

			List<Map<String, Object>> casasJson = (List<Map<String, Object>>) objectMapper.readValue(responseJson,
					new TypeReference<ArrayList<Map<String, Object>>>() {
					});
			log.info("casasJson: " + casasJson);
			casas = mapearCasasSecundaryService(casasJson);
		} catch (Exception e) {
			e.getStackTrace();
			log.error(e.toString());
			throw e;
		}
		log.info("");
		return casas;
	}

	private List<SecundaryHome> mapearCasasSecundaryService(List<Map<String, Object>> casasJson) throws Exception {
		ArrayList<SecundaryHome> casas;
		try {
			casas = new ArrayList<SecundaryHome>();
			ModelMapper modelMapper = new ModelMapper();
			for (Map<String, Object> casaJson : casasJson) {
				SecundaryHome cot = modelMapper.map(casaJson, SecundaryHome.class);
				casas.add(cot);
			}
			return casas;
		} catch (Exception e) {
			e.getStackTrace();
			log.error(e.toString());
			throw e;
		}
	}

	private List<Casa> mapearCasas(List<Map<String, Object>> casasJson) throws Exception {
		ArrayList<Casa> casas;
		try {
			casas = new ArrayList<Casa>();
			ModelMapper modelMapper = new ModelMapper();
			for (Map<String, Object> casaJson : casasJson) {
				Casa casa = modelMapper.map(casaJson, Casa.class);
				casas.add(casa);
			}
			return casas;
		} catch (Exception e) {
			e.getStackTrace();
			log.error(e.toString());
			throw e;
		}
	}
}
