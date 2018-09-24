package com.broodcamp.order.business.api.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.broodcamp.order.business.api.domain.ProductOrder;

@FeignClient(value = "ORDERSERVICE")
public interface ProductOrderServiceProxy {

	@RequestMapping(value = "/orders", method = RequestMethod.GET)
	List<ProductOrder> findAll();

}
