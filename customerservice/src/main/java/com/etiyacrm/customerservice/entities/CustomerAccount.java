package com.etiyacrm.customerservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "customer_accounts")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Where(clause = "deleted_date IS NULL")
public class CustomerAccount {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.UUID)
    public String id;
}
