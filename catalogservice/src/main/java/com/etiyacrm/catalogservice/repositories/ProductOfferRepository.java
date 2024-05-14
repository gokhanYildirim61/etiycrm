package com.etiyacrm.catalogservice.repositories;

import com.etiyacrm.catalogservice.entities.ProductOffer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductOfferRepository extends JpaRepository<ProductOffer, String> {
}
