package com.etiyacrm.customerservice.entities;

import com.etiyacrm.customerservice.core.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "contact_mediums")
public class ContactMedium extends BaseEntity {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;


    @Column(name = "mobile_Phone")
    private String mobilePhone;

    @Column(name = "home_Phone")
    private String homePhone;

    @Column(name="email")
    private String email;

    @Column(name = "fax")
    private String fax;

    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;


}
