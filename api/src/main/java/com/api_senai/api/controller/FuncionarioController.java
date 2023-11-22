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

import com.api_senai.api.entities.Funcionario;
import com.api_senai.api.service.FuncionarioService;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {
    
    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping
    public ResponseEntity<List<Funcionario>> getAllFuncionarios(){
        
        List<Funcionario> funcionarios = funcionarioService.getAllFuncionarios();

        if(!funcionarios.isEmpty()) {
            return new ResponseEntity<>(funcionarios, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(funcionarios, HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<Funcionario> getFuncionariosById(@PathVariable Long id){
        
        Funcionario funcionario = funcionarioService.getFuncionarioById(id);

        if (funcionario != null){
            return new ResponseEntity<>(funcionario, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(funcionario, HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping
    public ResponseEntity<Funcionario> saveFuncionario(@RequestBody Funcionario novoFuncionario){

        Funcionario funcionario = funcionarioService.saveFuncionario(novoFuncionario);
        return ResponseEntity.ok(funcionario);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Funcionario> updateFuncionario (@RequestBody Funcionario funcionarioAtualizado, @PathVariable Long id) {

        Funcionario funcionario = funcionarioService.getFuncionarioById(id);
        if (funcionario != null){
            Funcionario funcionarioNovo = funcionarioService.updateFuncionario(id, funcionarioAtualizado);
            return new ResponseEntity<>(funcionarioNovo, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(funcionario, HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Funcionario> deleteFuncionario(@PathVariable Long id){

        Funcionario funcionario = funcionarioService.getFuncionarioById(id);
        
        if (funcionario != null){
            funcionarioService.deleteFuncionario(id);
            return new ResponseEntity<>(funcionario, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(funcionario, HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Funcionario> logicalDeleteFuncionario(@PathVariable Long id){

        Funcionario funcionario = funcionarioService.getFuncionarioById(id);
        
        if (funcionario != null){
            funcionarioService.logicalDeleteFuncionario(id);
            return new ResponseEntity<>(funcionario, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(funcionario, HttpStatus.NOT_FOUND);
        }
    }
}
