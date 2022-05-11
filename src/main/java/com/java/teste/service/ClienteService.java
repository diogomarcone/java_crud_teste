package com.java.teste.service;

import com.java.teste.model.Cliente;

import java.util.List;

public interface ClienteService {

    public Cliente saveCliente(Cliente cliente);

    public List<Cliente> getAll();

    public String delete(Long id);

    public Cliente update(Cliente cliente);

}
