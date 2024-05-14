package com.etiyacrm.customerservice.entities;

import com.etiyacrm.customerservice.core.entities.BaseEntity;
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


    @Column(name = "mobile_Phone")
    private String mobilePhone;

    @Column(name = "home_Phone")
    private String homePhone;

    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$", message = "Invalid email address")
    @Column(name="email")
    private String email;

    @Pattern(regexp = "^\\+90[-\\s]?\\(?(\\d{3})\\)?[-\\s]?(\\d{3})[-\\s]?(\\d{4})$", message = "Invalid Turkish fax number")
    @Column(name = "fax")
    private String fax;

    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;


}
