package com.etiya.searchservice.repository;

import com.etiya.searchservice.entities.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FilterRepository extends MongoRepository<Customer,String> {
}
