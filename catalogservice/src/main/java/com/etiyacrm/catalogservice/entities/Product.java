package com.etiyacrm.catalogservice.entities;

import com.etiyacrm.common.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "product")
    private List<ProductOffer> productOffers;



//    @Id
//    @GeneratedValue(strategy = GenerationType.UUID)
//    private String id;
//
//    @Column(name = "name")
//    private String name;
//
//    @Column(name = "description")
//    private String description;
//
//    //@ManyToOne(cascade = CascadeType.MERGE)
//    @ManyToOne()
//    @JoinColumn(name = "product_offer_id")
//    private ProductOffer productOffer;
//
//    //@ManyToOne(cascade = CascadeType.MERGE)
//    @ManyToOne()
//    @JoinColumn(name = "catalog_id")
//    private Catalog catalog;
//
//    //@ManyToOne(cascade = CascadeType.MERGE)
//    @ManyToOne()
//    @JoinColumn(name = "campaign_id")
//    private Campaign campaign;
}
