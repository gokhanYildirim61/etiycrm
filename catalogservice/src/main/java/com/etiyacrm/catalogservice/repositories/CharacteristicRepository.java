package com.etiyacrm.catalogservice.repositories;

import com.etiyacrm.catalogservice.entities.Characteristic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacteristicRepository extends JpaRepository<Characteristic,String> {
}
