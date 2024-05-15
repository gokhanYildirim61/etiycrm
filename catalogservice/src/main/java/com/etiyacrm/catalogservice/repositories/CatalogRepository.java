package com.etiyacrm.catalogservice.repositories;

import com.etiyacrm.catalogservice.entities.Campaign;
import com.etiyacrm.catalogservice.entities.Catalog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatalogRepository extends JpaRepository<Catalog, String> {
    Page<Catalog> findAllByDeletedDateIsNull(Pageable pageable);
}
