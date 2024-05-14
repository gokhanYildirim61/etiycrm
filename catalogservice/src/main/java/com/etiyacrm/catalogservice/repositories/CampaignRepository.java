package com.etiyacrm.catalogservice.repositories;

import com.etiyacrm.catalogservice.entities.Campaign;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CampaignRepository extends JpaRepository<Campaign, String> {
}
