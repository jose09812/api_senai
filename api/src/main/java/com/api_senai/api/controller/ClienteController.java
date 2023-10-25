package com.api_senai.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api_senai.api.entities.Cliente;
import com.api_senai.api.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    
    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<Cliente>> getAllClientes(){
        
        List<Cliente> clientes = clienteService.getAllClientes();

        return ResponseEntity.ok(clientes);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getClientesById(@PathVariable Long id){
        
        Cliente cliente = clienteService.getClienteById(id);

        return ResponseEntity.ok(cliente);
    }
    @PostMapping
    public ResponseEntity<Cliente> saveCliente(@RequestBody Cliente novoCliente){

        Cliente cliente = clienteService.saveCliente(novoCliente);
        return ResponseEntity.ok(cliente);
    }
    @PutMapping
    @RequestMapping("/{id}")
    public ResponseEntity<Cliente> updateCliente (@RequestBody Cliente cliente) {

        Cliente cliente = clienteService.updateCliente();
        return ResponseEntity.ok(cliente);
    }

    // @GetMapping("/{id}")
    // getClienteById(){

    // }
    // @PostMapping
    // saveCliente(Cliente cliente){

    // }
    // @PutMapping("/{id}")
    // updateCliente(@RequestBody Cliente clienteUpdated){

    // }
    // @DeleteMapping("/{id}")
    // deleteCliente(Long id){

    // }
}
