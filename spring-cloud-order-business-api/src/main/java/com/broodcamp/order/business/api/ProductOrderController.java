package com.broodcamp.order.business.api;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.broodcamp.order.business.api.client.ProductOrderServiceProxy;
import com.broodcamp.order.business.api.client.ProductServiceProxy;
import com.broodcamp.order.business.api.domain.Product;
import com.broodcamp.order.business.api.domain.ProductOrder;

@RestController
public class ProductOrderController {

//	@Autowired
//	private RestTemplate restTemplate;
//
//	@RequestMapping(value = "/orders", method = RequestMethod.GET)
//	public List<ProductOrder> findAllProductOrders() {
//		ResponseEntity<List<ProductOrder>> animeResponse;
//		try {
//			animeResponse = restTemplate.exchange(new URI("http://ORDERSERVICE/orders"), HttpMethod.GET, null,
//					new ParameterizedTypeReference<List<ProductOrder>>() {
//					});
//
//			return animeResponse.getBody();
//
//		} catch (RestClientException | URISyntaxException e) {
//			return null;
//		}
//	}

	private Logger log = LoggerFactory.getLogger(ProductOrderController.class);

	@Value("${server.port}")
	private String portNumber;

	@Autowired
	private ProductServiceProxy productService;

	@Autowired
	private ProductOrderServiceProxy productOrderService;

	@Autowired
	private ProductOrderBusinessProcess productOrderBusinessProcess;

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public List<Product> findAllProducts() {
		System.out.println("port=" + portNumber);
		return productService.findAll();
	}

	@RequestMapping(value = "/products/{id}", method = RequestMethod.GET)
	public Product findProduct(@PathVariable(value = "id") Long id) {
		System.out.println("port=" + portNumber);
		return productService.findById(id);
	}

	@RequestMapping(value = "/orders", method = RequestMethod.GET)
	public List<ProductOrder> findAllOrders() {
		System.out.println("port=" + portNumber);
		return productOrderService.findAll();
	}

	@RequestMapping(value = "/productOrders", method = RequestMethod.GET)
	public List<ProductOrder> findProductOrders() {
		System.out.println("port=" + portNumber);
		return productOrderBusinessProcess.findProductOrders();
	}

}
