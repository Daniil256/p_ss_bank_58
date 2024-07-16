package com.bank.transfer.entity;

import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.Instant;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
@Entity
@Table(name = "audit", schema = "transfer")
public class Audit {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "audit_id_gen")
    @SequenceGenerator(name = "audit_id_gen", sequenceName = "audit_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "entity_type", nullable = false, length = 40)
    private String entityType;

    @Column(name = "operation_type", nullable = false)
    private String operationType;

    @Column(name = "created_by", nullable = false)
    private String createdBy;

    @Column(name = "modified_by")
    private String modifiedBy;

    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    @Column(name = "modified_at")
    private Instant modifiedAt;

    @Column(name = "new_entity_json")
    @Type(type = "org.hibernate.type.TextType")
    private String newEntityJson;

    @Column(name = "entity_json", nullable = false)
    @Type(type = "org.hibernate.type.TextType")
    private String entityJson;

    @Override
    public String toString() {
        return "Audit{" +
                "id=" + id +
                ", entityType='" + entityType + '\'' +
                ", operationType='" + operationType + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", modifiedBy='" + modifiedBy + '\'' +
                ", createdAt=" + createdAt +
                ", modifiedAt=" + modifiedAt +
                ", newEntityJson='" + newEntityJson + '\'' +
                ", entityJson='" + entityJson + '\'' +
                '}';
    }
}