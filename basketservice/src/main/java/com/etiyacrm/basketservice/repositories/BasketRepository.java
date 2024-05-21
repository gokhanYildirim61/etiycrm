package com.etiyacrm.basketservice.repositories;

import com.etiyacrm.basketservice.entities.Basket;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BasketRepository extends MongoRepository<Basket,String> {
}
