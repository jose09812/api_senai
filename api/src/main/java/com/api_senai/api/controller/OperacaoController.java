package com.api_senai.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api_senai.api.entities.Operacao;
import com.api_senai.api.service.OperacaoService;

@RestController
@RequestMapping("/operacoes")
public class OperacaoController {
    
    @Autowired
    private OperacaoService operacaoService;

    @GetMapping
    public ResponseEntity<List<Operacao>> getAllOperacaos(){
        
        List<Operacao> operacaos = operacaoService.getAllOperacaos();

        if(!operacaos.isEmpty()) {
            return new ResponseEntity<>(operacaos, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(operacaos, HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<Operacao> getOperacaosById(@PathVariable Long id){
        
        Operacao operacao = operacaoService.getOperacaoById(id);

        if (operacao != null){
            return new ResponseEntity<>(operacao, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(operacao, HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping
    public ResponseEntity<Operacao> saveOperacao(@RequestBody Operacao novoOperacao){

        Operacao operacao = operacaoService.saveOperacao(novoOperacao);
        return ResponseEntity.ok(operacao);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Operacao> updateOperacao (@RequestBody Operacao operacaoAtualizado, @PathVariable Long id) {

        Operacao operacao = operacaoService.getOperacaoById(id);
        if (operacao != null){
            Operacao operacaoNovo = operacaoService.updateOperacao(id, operacaoAtualizado);
            return new ResponseEntity<>(operacaoNovo, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(operacao, HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Operacao> deleteOperacao(@PathVariable Long id){

        Operacao operacao = operacaoService.getOperacaoById(id);
        
        if (operacao != null){
            operacaoService.deleteOperacao(id);
            return new ResponseEntity<>(operacao, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(operacao, HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Operacao> logicalDeleteOperacao(@PathVariable Long id){

        Operacao operacao = operacaoService.getOperacaoById(id);
        
        if (operacao != null){
            operacaoService.logicalDeleteOperacao(id);
            return new ResponseEntity<>(operacao, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(operacao, HttpStatus.NOT_FOUND);
        }
    }
}
