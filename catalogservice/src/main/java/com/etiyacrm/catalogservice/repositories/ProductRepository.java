package com.etiyacrm.catalogservice.repositories;

import com.etiyacrm.catalogservice.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,String> {
}
