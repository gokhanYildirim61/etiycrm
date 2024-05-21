package com.etiyacrm.basketservice.repositories;

import com.etiyacrm.basketservice.entities.BasketItem;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BasketItemRepository extends MongoRepository<BasketItem,String> {

}
