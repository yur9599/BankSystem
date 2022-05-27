package com.example.bankSystem.repository;

import com.example.bankSystem.entities.CardHolder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardHolderRepository extends JpaRepository<CardHolder,Long> {
}
