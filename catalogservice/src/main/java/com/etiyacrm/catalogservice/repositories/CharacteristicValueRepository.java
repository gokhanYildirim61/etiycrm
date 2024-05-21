package com.etiyacrm.catalogservice.repositories;

import com.etiyacrm.catalogservice.entities.CharacteristicValue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacteristicValueRepository extends JpaRepository<CharacteristicValue,String> {
}
