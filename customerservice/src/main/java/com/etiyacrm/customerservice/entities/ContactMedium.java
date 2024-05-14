package com.etiyacrm.customerservice.entities;

import com.etiyacrm.common.entities.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "contact_mediums")
@Where(clause = "deleted_date IS NULL")
public class ContactMedium extends BaseEntity {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;


    @Column(name = "mobile_phone")
    private String mobilePhone;

    @Column(name = "home_phone")
    private String homePhone;


    @Column(name="email")
    private String email;


    @Column(name = "fax")
    private String fax;

    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;


}
