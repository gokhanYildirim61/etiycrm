package com.etiya.searchservice.services.rules;

import com.etiya.searchservice.entities.Customer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.Normalizer;

@Service
@AllArgsConstructor
public class FilterBusinessRules {

    public void normalizeCustomerNames(Customer customer) {
        customer.setFirstName(normalize(customer.getFirstName()));
        customer.setMiddleName(normalize(customer.getMiddleName()));
        customer.setLastName(normalize(customer.getLastName()));
    }

    public String normalize(String name) {
        if (name == null) return null;
        return Normalizer.normalize(name, Normalizer.Form.NFD)
                .replaceAll("[^\\p{ASCII}]", "").toLowerCase();
    }

    public String capitalize(String name) {
        if (name == null || name.isEmpty()) return name;
        return name.substring(0, 1).toUpperCase() + name.substring(1);
    }
}
