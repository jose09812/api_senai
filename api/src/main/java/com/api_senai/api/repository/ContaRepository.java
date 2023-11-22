package com.api_senai.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api_senai.api.entities.Conta;

public interface ContaRepository extends JpaRepository<Conta, Long>{
    
}
