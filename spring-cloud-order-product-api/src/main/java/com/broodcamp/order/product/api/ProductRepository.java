package com.broodcamp.order.product.api;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.broodcamp.order.product.api.domain.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

}
