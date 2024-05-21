package com.etiyacrm.catalogservice.entities;
import com.etiyacrm.common.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Where(clause = "deleted_date IS NULL")
@Table(name = "characteristic_value")
public class CharacteristicValue extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private String id;

    @Column(name = "value")
    private String value;

    @Column(name = "is_active")
    private boolean isActive;

    @ManyToOne()
    @JoinColumn(name = "characteristic_id")
    private Characteristic characteristic;
}
