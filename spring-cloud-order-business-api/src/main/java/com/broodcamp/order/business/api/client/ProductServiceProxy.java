package com.broodcamp.order.business.api.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.broodcamp.order.business.api.domain.Product;

@FeignClient(value = "PRODUCTSERVICE", fallback = ProductServiceFallback.class)
public interface ProductServiceProxy {

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	List<Product> findAll();

	@RequestMapping(value = "/products/{id}", method = RequestMethod.GET)
	Product findById(@PathVariable(value = "id", required = true) Long id);

}
