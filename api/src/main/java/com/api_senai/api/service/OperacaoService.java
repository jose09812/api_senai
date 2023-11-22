package com.api_senai.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api_senai.api.entities.Operacao;
import com.api_senai.api.repository.OperacaoRepository;

@Service
public class OperacaoService {
    
    @Autowired
    private OperacaoRepository operacaoRepository;

    public List<Operacao> getAllOperacaos(){
        List<Operacao> operacaos = operacaoRepository.findAll();

        return operacaos;
    }
    public Operacao getOperacaoById(Long id){

        Operacao operacao = operacaoRepository.findById(id).orElse(null);

        return operacao;
    }
    public Operacao saveOperacao(Operacao novoOperacao){

        Operacao operacao = operacaoRepository.save(novoOperacao);
        return operacao;
    }
    public Operacao updateOperacao(Long id, Operacao operacaoAtualizado){
        
        Operacao operacaoExistente = getOperacaoById(id);
        operacaoExistente.setAllAtributos(operacaoAtualizado);
        saveOperacao(operacaoExistente);
        
        return operacaoExistente;
    }
    public Operacao deleteOperacao(Long id){

        operacaoRepository.deleteById(id);
        Operacao operacaoDeletado = getOperacaoById(id);

        return operacaoDeletado;
    }
    public Operacao logicalDeleteOperacao(Long id){
        Operacao operacaoExistente = getOperacaoById(id);
        saveOperacao(operacaoExistente);

        return operacaoExistente;
    }
}
