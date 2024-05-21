package com.etiyacrm.catalogservice.entities;

import com.etiyacrm.common.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Where(clause = "deleted_date IS NULL")
@Table(name = "catalogs")
public class Catalog extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "catalog")
    private List<CatalogProductOffer> catalogProductOffer;


//    @OneToMany(mappedBy = "catalog")
//    private List<Product> products;
}
