package com.java.teste.controller;
import com.java.teste.dto.ClienteDTO;
import com.java.teste.model.Cliente;
import com.java.teste.service.serviceImpl.ClienteServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/")
    public class ClienteController {

    private final ClienteServiceImpl service;

    public ClienteController(ClienteServiceImpl service){
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ClienteDTO> save(@RequestBody Cliente cliente){
        service.saveCliente(cliente);
        return new ResponseEntity<>(ClienteDTO.dtoForClient(cliente), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Cliente> getAll() {
        return service.getAll();
    }

    @DeleteMapping("{id}")
    public String deleteCliente(@PathVariable Long id){
        return service.delete(id);
    }

    @PutMapping
    public ResponseEntity<ClienteDTO> updateCliente(@RequestBody Cliente cliente){
        cliente = service.update(cliente);
        return new ResponseEntity<>(ClienteDTO.dtoForClient(cliente), HttpStatus.OK);
    }
}
