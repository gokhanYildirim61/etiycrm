package com.etiyacrm.catalogservice.repositories;

import com.etiyacrm.catalogservice.entities.Catalog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatalogRepository extends JpaRepository<Catalog, String> {
}
