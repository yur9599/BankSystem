package com.example.bankSystem.repository;

import com.example.bankSystem.entities.Issuer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IssuerRepository extends JpaRepository<Issuer,Long> {
}
