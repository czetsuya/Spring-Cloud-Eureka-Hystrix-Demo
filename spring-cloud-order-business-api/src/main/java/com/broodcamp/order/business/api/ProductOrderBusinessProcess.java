package com.broodcamp.order.business.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.broodcamp.order.business.api.client.ProductOrderServiceProxy;
import com.broodcamp.order.business.api.client.ProductServiceProxy;
import com.broodcamp.order.business.api.domain.ProductOrder;

@Service
public class ProductOrderBusinessProcess {

	@Autowired
	private ProductServiceProxy productService;

	@Autowired
	private ProductOrderServiceProxy productOrderService;

	public List<ProductOrder> findProductOrders() {
		List<ProductOrder> orders = productOrderService.findAll();

		orders.stream().forEach(p -> p.setProductName(productService.findById(p.getProductId()).getName()));

		return orders;
	}

}
