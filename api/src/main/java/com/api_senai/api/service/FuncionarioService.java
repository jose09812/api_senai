package com.api_senai.api.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api_senai.api.entities.Funcionario;
import com.api_senai.api.repository.FuncionarioRepository;

@Service
public class FuncionarioService {
    
    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public List<Funcionario> getAllFuncionarios(){
        List<Funcionario> funcionarios = funcionarioRepository.findAll();

        return funcionarios;
    }
    public Funcionario getFuncionarioById(Long id){

        Funcionario funcionario = funcionarioRepository.findById(id).orElse(null);

        return funcionario;
    }
    public Funcionario saveFuncionario(Funcionario novoFuncionario){

        Funcionario funcionario = funcionarioRepository.save(novoFuncionario);
        return funcionario;
    }
    public Funcionario updateFuncionario(Long id, Funcionario funcionarioAtualizado){
        
        Funcionario funcionarioExistente = getFuncionarioById(id);
        funcionarioExistente.setAllAtributos(funcionarioAtualizado);
        saveFuncionario(funcionarioExistente);
        
        return funcionarioExistente;
    }
    public Funcionario deleteFuncionario(Long id){

        funcionarioRepository.deleteById(id);
        Funcionario funcionarioDeletado = getFuncionarioById(id);

        return funcionarioDeletado;
    }
    public Funcionario logicalDeleteFuncionario(Long id){
        Funcionario funcionarioExistente = getFuncionarioById(id);
        funcionarioExistente.setAtivo(false);
        saveFuncionario(funcionarioExistente);

        return funcionarioExistente;
    }
}
