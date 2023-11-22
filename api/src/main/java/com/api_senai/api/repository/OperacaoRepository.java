package com.api_senai.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api_senai.api.entities.Operacao;

public interface OperacaoRepository extends JpaRepository<Operacao, Long>{
    
}
