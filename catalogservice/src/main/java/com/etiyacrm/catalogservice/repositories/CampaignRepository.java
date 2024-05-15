package com.etiyacrm.catalogservice.repositories;

import com.etiyacrm.catalogservice.entities.Campaign;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CampaignRepository extends JpaRepository<Campaign, String> {
    Page<Campaign> findAllByDeletedDateIsNull(Pageable pageable);
}
