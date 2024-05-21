package com.etiyacrm.catalogservice.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;

import com.etiyacrm.common.entities.BaseEntity;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Where(clause = "deleted_date IS NULL")
@Table(name = "characteristic")
public class Characteristic extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "characteristic")
    private List<CharacteristicValue> characteristicValues;
}
