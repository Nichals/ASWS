package br.com.alugueservice.dao;

import java.util.List;

import br.com.alugueservice.model.Aluguel;
import br.com.alugueservice.model.Cliente;
import br.com.alugueservice.model.Operador;

public interface AluguelDAO
{

    // Método para criar um aluguel na base de dados (INSERT)
    Aluguel create(Aluguel pAluguel);

    // Método para recuperar um aluguel da base de dados (SELECT)
    Aluguel recovery(int pId);

    //Método para finalizar o aluguel
    Boolean finalizar(Aluguel pAluguel);

    //Método para atualizar um aluguel
    Aluguel update(Aluguel pAluguel);

    // Método para pesquisar todos os alugueis da base de dados
    List<Aluguel> search();

    // Método para pesquisar todos os alugueis de um cliente de acordo
    // com o status informado
    List<Aluguel> searchByCliente(Cliente pCliente, int pStatus);

    // Método para pesquisar por operador todos os os alugueis que um operador criou
    // de acordo com o status informado
    List<Aluguel> searchByOperador(Operador pOperador, int pStatus);

    // Método para pesquisar por status todos os os alugueis
    List<Aluguel> searchByStatus(int pStatus);
}
