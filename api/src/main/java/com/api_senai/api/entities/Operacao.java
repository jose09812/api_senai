package com.api_senai.api.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="operacoes")
public class Operacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tipo; //Saque, depósito e transferência
    private double valor;
    private LocalDateTime data; //data.now()

    @ManyToOne
    @JoinColumn
    private Conta origem;

    @ManyToOne
    @JoinColumn
    private Conta destino;

    public void setAllAtributos (Operacao novaOperacao) {
        this.setData(novaOperacao.getData());
        this.setDestino(novaOperacao.getDestino());
        this.setOrigem(novaOperacao.getOrigem());
        this.setTipo(novaOperacao.getTipo());
        this.setValor(novaOperacao.getValor());
    }
}
