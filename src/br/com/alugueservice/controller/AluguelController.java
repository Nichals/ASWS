package br.com.alugueservice.controller;

import java.util.List;

import br.com.alugueservice.dao.AluguelDAO;
import br.com.alugueservice.dao.DAOFactoy;
import br.com.alugueservice.dto.AluguelDTO;
import br.com.alugueservice.model.Aluguel;
import br.com.alugueservice.model.Cliente;
import br.com.alugueservice.model.Operador;

public class AluguelController
{
    // Método de cadastro de Aluguel
    public static AluguelDTO cadastrar(Aluguel pAluguel)
    {

        // Valida se objeto é nulo.
        if (pAluguel == null)
        {
            return new AluguelDTO(false, "Tentativa de cadastrar Aluguel nulo.");
        }

        // Acesso a camada de persistencia
        AluguelDAO aluguelDAO = DAOFactoy.getAluguelDAO();
        Aluguel aluguel = aluguelDAO.create(pAluguel);

        // Retornando o indicativo de falha ao salvar o objeto.
        if (aluguel == null)
        {
            return new AluguelDTO(false, "Erro ao gravar o Aluguel.");
        }

        // Retornando o indicativo de sucesso com o objeto criado
        return new AluguelDTO(true, "Aluguel gravado com sucesso", aluguel);

    }

    //Método de finalização de Aluguel
    public static AluguelDTO finalizar(Aluguel pAluguel) {
        // valida se o objeto possui informação
        if (pAluguel == null)
            return new AluguelDTO(false, "Tentativa de finalizar Aluguel nulo.");
     // Acesso a camada de persistencia
        AluguelDAO AluguelDAO = DAOFactoy.getAluguelDAO();
        Boolean resultado = AluguelDAO.finalizar(pAluguel);

     // Retornando o indicativo de falha ao salvar o objeto.
        if (resultado == false)
        {
            return new AluguelDTO(false, "Aluguel não foi finalizado.");
        }

        // Retornando o indicativo de sucesso com o objeto criado
        return new AluguelDTO(true, "Aluguel finalizado com sucesso");

    }
    // Método de recuperação de Aluguel
    public static AluguelDTO recuperar(Integer pId)
    {

        // Acesso a camada de persistencia
        AluguelDAO AluguelDAO = DAOFactoy.getAluguelDAO();
        Aluguel aluguel = AluguelDAO.recovery(pId);

        // Retornando o indicativo de falha ao salvar o objeto.
        if (aluguel == null)
        {
            return new AluguelDTO(false, "Aluguel não existe.");
        }

        // Retornando o indicativo de sucesso com o objeto criado
        return new AluguelDTO(true, "Aluguel recuperado com sucesso", aluguel);

    }

    // Método de pesquisa total da base de dados
    public static AluguelDTO pesquisar()
    {
        // Obtendo lista de Produtos
        AluguelDAO AluguelDAO = DAOFactoy.getAluguelDAO();
        List<Aluguel> listaAluguel = AluguelDAO.search();

        // Valida se lista está vazia
        if (listaAluguel.isEmpty())
            return new AluguelDTO(false, "Nenhum resultado encontrado.");

        // Retorna a lista
        return new AluguelDTO(true, "Lista de Produtos recuperada.", listaAluguel);

    }

    // Método de atualização de Aluguel
    public static AluguelDTO atualizar(Aluguel pAluguel)
    {
        // Valida se objeto é nulo.
        if (pAluguel == null)
            return new AluguelDTO(false, "Tentativa de cadastrar Aluguel nulo.");

        // Acesso a camada de persistencia
        AluguelDAO aluguelDAO = DAOFactoy.getAluguelDAO();
        Aluguel aluguel = aluguelDAO.update(pAluguel);

        // Retornando o indicativo de falha ao salvar o objeto.
        if (aluguel == null)
            return new AluguelDTO(false, "Erro ao atualizar o aluguel.");

        // Retornando o indicativo de sucesso com o objeto criado
        return new AluguelDTO(true, "Aluguel atualizado com sucesso.", aluguel);
    }

    // Método de pesquisa por operador
    public static AluguelDTO pesquisarPorOperador(Operador pOperador, Integer pStatus)
    {
        // Valida se nome é nulo
        if (pOperador == null)
            return new AluguelDTO(false, "Operador não possui nenhuma informação.");

        // Obtendo lista de Produtos
        AluguelDAO AluguelDAO = DAOFactoy.getAluguelDAO();
        List<Aluguel> listaAluguel = AluguelDAO.searchByOperador(pOperador, pStatus);

        // Valida se lista está vazia
        if (listaAluguel.isEmpty())
            return new AluguelDTO(false, "Nenhum Aluguel encontrado para o Operador " + pOperador.getNome() + " " + pOperador.getSobrenome() + ".");

        // Retorna a lista
        return new AluguelDTO(true, "Lista de Alugueis recuperada.", listaAluguel);

    }

    // Método de pesquisa por cliente
    public static AluguelDTO pesquisarPorCliente(Cliente pCliente, Integer pStatus)
    {
        // Valida se nome é nulo
        if (pCliente == null)
            return new AluguelDTO(false, "Cliente informado não possui nenhuma informação.");

        // Obtendo lista de Produtos
        AluguelDAO aluguelDAO = DAOFactoy.getAluguelDAO();
        List<Aluguel> listaAluguel = aluguelDAO.searchByCliente(pCliente, pStatus);

        // Valida se lista está vazia
        if (listaAluguel.isEmpty())
            return new AluguelDTO(false, "Nenhum cupom encontrado para o Cliente " + pCliente.getNome() + " " + pCliente.getSobrenome() + ".");

        // Retorna a lista
        return new AluguelDTO(true, "Lista de Produtos recuperada.", listaAluguel);

    }

    // Método de pesquisa por status
    public static AluguelDTO pesquisarPorStatus(Integer pStatus)
    {
        // Obtendo lista de Alugueis
        AluguelDAO aluguelDAO = DAOFactoy.getAluguelDAO();
        List<Aluguel> listaAluguel = aluguelDAO.searchByStatus(pStatus);

        // Valida se lista está vazia
        if (listaAluguel.isEmpty())
            return new AluguelDTO(false, "Nenhum aluguel encontrado para o status informado.");

        // Retorna a lista
        return new AluguelDTO(true, "Lista de alugueis recuperada.", listaAluguel);

    }
}
