package com.broodcamp.order.business.api.client;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.broodcamp.order.business.api.domain.Product;

@Service
public class ProductServiceFallback implements ProductServiceProxy {

	@Override
	public List<Product> findAll() {
		return Collections.emptyList();
	}

	@Override
	public Product findById(Long id) {
		Product product = new Product();
		product.setName("NOT_FOUND");

		return product;
	}

}
