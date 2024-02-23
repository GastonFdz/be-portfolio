package com.gastonfernandez.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gastonfernandez.models.Product;
import com.gastonfernandez.repositories.ProductRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductService {

	@Autowired
	private final ProductRepository productRepository;

	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	public void setProduct(Product product) throws Exception {
		try {
			log.info("setBusiness-Services --> Start");
			log.info("setBusiness-Services -->Datos de shopping a actualizar: ");
			log.info(product.toString());
			this.productRepository.save(product);
			log.info("setBusiness-Services -->Datos actualizados");
		} catch (Exception e) {
			log.error(e.toString());
			throw e;
		}
	}

	public Product getProduct(long productId) {
		try {
			return productRepository.findById(productId).orElse(null);
		} catch (Exception e) {
			log.error(e.toString());
			throw e;
		}
	}

	public Object getProduct(String productDescription) {
		try {
			List<Product> products = productRepository.findByDescription(productDescription);

			if (products.isEmpty()) {
				return null;
			} else if (products.size() == 1) {
				return products.get(0);
			}
			return products;
		} catch (Exception e) {
			log.error(e.toString());
			throw e;
		}
	}

	private Product getProductByList(Object products) {	
		Product response = new Product();
		if (products instanceof Product) 
			response = (Product) products;
		else if (products instanceof List) {
			List<Product> productsAux = (List<Product>) products;
			return productsAux.get(0);
		}
		return response;		
	}

	public Product checkProduct(String productDescription) throws Exception {
		try {
			Object products = this.getProduct(productDescription);
			Product product = new Product();
			if (products == null) {
				log.info("checkProduct-Service --> el producto " + productDescription + " no existe");
				log.info("checkProduct-Service --> creando producto...");
				product = new Product();
				product.setProduct(productDescription);
				this.setProduct(product);
				product = getProductByList(this.getProduct(productDescription));
				log.info("checkProduct-Service --> el producto " + productDescription + " fue creado");
			} else if (products instanceof Product) {
				log.info("checkProduct-Service --> el producto " + product.toString() + " existe");
			} else if (products instanceof List) {
				log.error("Los metodos de pago asociados a " + productDescription + " son mas de uno: (se toma el primero)");
				log.error(products.toString());
				product = getProductByList(products);
			}
			return product;
		} catch (Exception e) {
			log.error(e.toString());
			throw e;
		}
	}
}
