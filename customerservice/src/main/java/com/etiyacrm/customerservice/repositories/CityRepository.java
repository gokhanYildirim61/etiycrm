package com.etiyacrm.customerservice.repositories;

import com.etiyacrm.customerservice.entities.City;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CityRepository extends JpaRepository<City, String> {
    Optional<City> findByNameIgnoreCase(String name);

    Page<City> findAllByDeletedDateIsNull(Pageable pageable);
}
