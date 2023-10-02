package com.api_senai.api.entities;

import lombok.Data;
import org.apache.http.client.methods.HttpGet;

@Data
public class Endereco {
    private String cep;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;

    public Endereco getEnderecoByCep(String cep){
        Endereco endereco = new Endereco();

        //Mandar o cep para o viaCep
        HttpGet request = new HttpGet("https://viacep.com.br/ws/"+ cep +"/json/");

        //Tratar a resposta do via cep

        //montar o meu Endereco endereco

        return endereco;
    }
}
