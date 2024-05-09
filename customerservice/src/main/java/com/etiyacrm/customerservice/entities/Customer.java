package com.etiyacrm.customerservice.entities;

import com.etiyacrm.customerservice.core.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Table(name = "customers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer extends BaseEntity {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    //@Column(name="email")
   // private String email;

    @OneToOne(mappedBy = "customer")
    private IndividualCustomer individualCustomer;



    //@OneToOne(mappedBy = "customer",cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    //private ContactMedium contactMedium;
}
