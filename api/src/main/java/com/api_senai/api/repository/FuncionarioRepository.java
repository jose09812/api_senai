package com.api_senai.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api_senai.api.entities.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{
    
}
