package com.example.springbootfoodcourtusers.infrastructure.out.jpa.repository;

import com.example.springbootfoodcourtusers.infrastructure.out.jpa.entity.RolEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolRepository extends JpaRepository<RolEntity, Long> {
}
