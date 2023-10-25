package com.api_senai.api.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
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

    @OneToOne
    @JoinColumn(name = "endereco", foreignKey = @ForeignKey(name = "endereco_fkey"))
    private Endereco endereco;
}
