package com.etiyacrm.catalogservice.repositories;

import com.etiyacrm.catalogservice.entities.CatalogProductOffer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatalogProductOfferRepository extends JpaRepository<CatalogProductOffer,String> {
    CatalogProductOffer findByProductOfferId (String productOfferId);
}
