package br.com.alugueservice.dao;

import java.util.List;

import br.com.alugueservice.model.Cliente;
import br.com.alugueservice.model.Operador;
import br.com.alugueservice.model.PreAluguel;

public interface PreAluguelDAO
{
    // Método para criar um pré-aluguel na base de dados (INSERT)
    PreAluguel create(PreAluguel pPreAluguel);

    // Método para recuperar um pré-aluguel da base de dados (SELECT)
    PreAluguel recovery(int pId);

    // Método para finalizar um pré-aluguel da base de dados
    PreAluguel update(PreAluguel pPreAluguel);

    // Método para pesquisar todos os pré-alugueis da base de dados
    List<PreAluguel> search();

    // Método para pesquisar todos os pré-alugueis de um cliente de acordo
    // com o status informado
    List<PreAluguel> searchByCliente(Cliente pCliente, int pStatus);

    // Método para pesquisar por operador todos os os pré-alugueis que um operador criou
    // de acordo com o status informado
    List<PreAluguel> searchByOperador(Operador pOperador, int pStatus);

    // Método para pesquisar por status todos os os pré-alugueis
    List<PreAluguel> searchByStatus(int pStatus);
}
