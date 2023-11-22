package com.api_senai.api.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api_senai.api.entities.Conta;
import com.api_senai.api.repository.ContaRepository;

@Service
public class ContaService {
    
    @Autowired
    private ContaRepository contaRepository;

    public List<Conta> getAllContas(){
        List<Conta> contas = contaRepository.findAll();

        return contas;
    }
    public Conta getContaById(Long id){

        Conta conta = contaRepository.findById(id).orElse(null);

        return conta;
    }
    public Conta saveConta(Conta novoConta){

        Conta conta = contaRepository.save(novoConta);
        return conta;
    }
    public Conta updateConta(Long id, Conta contaAtualizado){
        
        Conta contaExistente = getContaById(id);
        contaExistente.setAllAtributos(contaAtualizado);
        saveConta(contaExistente);
        
        return contaExistente;
    }
    public Conta deleteConta(Long id){

        contaRepository.deleteById(id);
        Conta contaDeletado = getContaById(id);

        return contaDeletado;
    }
    public Conta logicalDeleteConta(Long id){
        Conta contaExistente = getContaById(id);
        saveConta(contaExistente);
        return contaExistente;
    }
}