package com.etiyacrm.customerservice.entities;

import com.etiyacrm.customerservice.core.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class ContactMedium extends BaseEntity {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    @JoinColumn(name = "individual_customer_id")
    private IndividualCustomer individualCustomer;

    @Column(name = "mobile_Phone")
    private String mobilePhone;

    @Column(name = "home_Phone")
    private String homePhone;

    @Column(name="email")
    private String email;

    @Column(name = "fax")
    private String fax;

}