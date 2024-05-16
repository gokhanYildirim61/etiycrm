package com.etiyacrm.customerservice.entities;


import com.etiyacrm.common.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "billing_accounts")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Where(clause = "deleted_date IS NULL")
public class BillingAccount extends BaseEntity {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name="status")
    private boolean status;

    @Column(name="number")
    private String number;

    @Column(name="name")
    private String name;

    @Column(name="description")
    private String description;

    @Column(name="type")
    private String type;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;
}
