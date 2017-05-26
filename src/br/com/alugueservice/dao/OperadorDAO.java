package br.com.alugueservice.dao;

import java.util.List;

import br.com.alugueservice.model.Operador;

public interface OperadorDAO
{

    // Método para criar um operador na base de dados (INSERT)
    Operador create(Operador pOperador);

    // Método para recuperar um operador da base de dados (SELECT)
    Operador recovery(int pId);

    // Método para atualizar um operador na base de dados (UPDATE)
    Operador update(Operador pOperador);

    // Método para autenticação de operador
    Operador autenticar(Operador pOperador);

    // Método para desativar um cliente na base de dados (DELETE)
    boolean alterarStatus(Operador pOperador);

    // Método para pesquisar todos os clientes da base de dados
    List<Operador> search();

    // Método para pesquisar por nome todos os clientes da base de dados
    List<Operador> searchByNome(String pNome);

    // Método para pesquisar por email todos os clientes da base de dados
    List<Operador> searchByLogin(String pLogin);

    // Método para pesquisar por cpf um clientes da base de dados
    List<Operador> searchByCpf(String pCpf);

}
