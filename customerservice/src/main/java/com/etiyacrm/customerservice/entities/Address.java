package com.etiyacrm.customerservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "addresses")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "description")
    private String description;

    @Column(name = "street")
    private String street;


    @Column(name = "house_number")
    private String houseNumber;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;
    //burada da hata gelebilir
    @ManyToOne
    @JoinColumn(name = "individual_customer_id")
    private IndividualCustomer individualCustomer;


    // @ManyToOne
    //@JoinColumn(name = "customer_id")
    //private Customer customer;
}
