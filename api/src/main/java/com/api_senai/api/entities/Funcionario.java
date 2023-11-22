package com.api_senai.api.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
@Table(name = "funcionarios", 
       uniqueConstraints = {
           @UniqueConstraint(name = "email_ukey", columnNames = "email"),
           @UniqueConstraint(name = "cpf_ukey", columnNames = "cpf"),
           @UniqueConstraint(name = "telefone_ukey", columnNames = "telefone")
       })
public class Funcionario extends Pessoa{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ctps;
    private String login;
    private String senha;
    private boolean ativo;

    public void setAllAtributos (Funcionario novoFuncionario) {
        this.setNome(novoFuncionario.getNome());
        this.setCpf(novoFuncionario.getCpf());
        this.setDataNascimento(novoFuncionario.getDataNascimento());
        this.setTelefone(novoFuncionario.getTelefone());
        this.setEmail(novoFuncionario.getEmail());
    }
}
