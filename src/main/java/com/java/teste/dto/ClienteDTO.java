package com.java.teste.dto;

import com.java.teste.model.Cliente;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO {

    private String nome;

    private LocalDate dataCadastro;

    public static ClienteDTO dtoForClient(Cliente cliente){
        return new ClienteDTO(cliente.getNome(), cliente.getDataCadastro());
    }
}
