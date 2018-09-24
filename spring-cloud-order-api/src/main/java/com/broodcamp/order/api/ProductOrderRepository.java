package com.broodcamp.order.api;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.broodcamp.order.api.domain.ProductOrder;

@Repository
public interface ProductOrderRepository extends CrudRepository<ProductOrder, Long> {

}
