package com.broodcamp.order.product.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.broodcamp.order.product.api.domain.Product;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/products")
@Api(value = "products", tags = ("products"))
public class ProductController {

	@Autowired
	private ProductRepository productRepository;

	@RequestMapping(method = RequestMethod.GET)
	@ApiOperation(value = "Return products", nickname = "getProducts")
	public List<Product> findAll() {
		return (List<Product>) productRepository.findAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ApiOperation(value = "Find a product", nickname = "getProduct")
	public Product findById(@PathVariable(value = "id") Long id) {
		return productRepository.findById(id).get();
	}

}
