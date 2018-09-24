package com.broodcamp.order.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.broodcamp.order.api.domain.ProductOrder;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/orders")
@Api(value = "orders", tags = ("orders"))
public class ProductOrderController {

	@Autowired
	private ProductOrderRepository orderRepository;

	@RequestMapping(method = RequestMethod.GET)
	@ApiOperation(value = "Return orders", nickname = "getOrders")
	public List<ProductOrder> findAll() {
		return (List<ProductOrder>) orderRepository.findAll();
	}

}
