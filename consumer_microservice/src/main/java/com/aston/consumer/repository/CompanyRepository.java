package com.aston.consumer.repository;

import com.aston.consumer.entity.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface CompanyRepository extends JpaRepository<CompanyEntity, UUID> {
}
