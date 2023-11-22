package com.api_senai.api.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="contas")
public class Conta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private int numero;
    private double saldo;
    // Funcionario gerente;

    @OneToOne
    @JoinColumn(name = "cliente", foreignKey = @ForeignKey(name = "cliente_fkey"))
    private Cliente cliente;

    @OneToMany(mappedBy="origem")
    private List<Operacao> operacoesOrigem;

    @OneToMany(mappedBy="destino")
    private List<Operacao> operacoesDestino;

    public void setAllAtributos (Conta novaConta) {
        this.setNumero(novaConta.getNumero());
        this.setOperacoesDestino(novaConta.getOperacoesDestino());
        this.setOperacoesOrigem(novaConta.getOperacoesOrigem());
        this.setSaldo(novaConta.getSaldo());
    }
}
