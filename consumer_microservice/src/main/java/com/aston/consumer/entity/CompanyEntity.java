package com.aston.consumer.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Table(name = "company")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompanyEntity {
    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(name = "company_id")
    private UUID companyId;
    @Column(name = "company")
    private String company;
    @Column(name = "product_id", nullable = false)
    private UUID productId;
}
