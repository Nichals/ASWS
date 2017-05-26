package br.com.alugueservice.dao;

import java.util.List;

import br.com.alugueservice.model.Cliente;

public interface ClienteDAO
{

    // Método para criar um cliente na base de dados (INSERT)
    Cliente create(Cliente pCliente);

    // Método para recuperar um cliente da base de dados (SELECT)
    Cliente recovery(int pId);

    // Método para atualizar um cliente na base de dados (UPDATE)
    Cliente update(Cliente pCliente);

    // Método para desativar um cliente na base de dados (DELETE)
    boolean alterarStatus(Cliente pCliente);

    // Método para pesquisar por cpf todos os clientes da base de dados
    Cliente searchByCpf(String pCpf);

    // Método para pesquisar todos os clientes da base de dados
    List<Cliente> search();

    // Método para pesquisar por nome todos os clientes da base de dados
    List<Cliente> searchByNome(String pNome);

    // Método para pesquisar por email todos os clientes da base de dados
    List<Cliente> searchByEmail(String pEmail);

}
