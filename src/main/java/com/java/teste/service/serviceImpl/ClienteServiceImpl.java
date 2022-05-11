package com.java.teste.service.serviceImpl;

import com.java.teste.dto.ClienteDTO;
import com.java.teste.model.Cliente;
import com.java.teste.repository.ClienteRepository;
import com.java.teste.service.ClienteService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository repository;

    public ClienteServiceImpl(ClienteRepository repository){
        this.repository = repository;
    }

    public Cliente saveCliente(Cliente cliente){
        return repository.save(cliente);
    }

    public List<Cliente> getAll(){
        return repository.findAll();
    }

    public String delete(Long id){
       repository.deleteById(id);
       return "Cliente com id: "+id+" deletado!";
    }

    public Cliente update(Cliente cliente){
        Cliente existingCliente = repository.findById(cliente.getId()).orElse(null);
        existingCliente.setNome((cliente.getNome()));
        existingCliente.setSobrenome((cliente.getSobrenome()));
        return repository.save(existingCliente);
    }


}
