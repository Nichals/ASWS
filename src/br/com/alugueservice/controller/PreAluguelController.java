package br.com.alugueservice.controller;

import java.util.List;

import br.com.alugueservice.dao.DAOFactoy;
import br.com.alugueservice.dao.PreAluguelDAO;
import br.com.alugueservice.dto.PreAluguelDTO;
import br.com.alugueservice.model.Cliente;
import br.com.alugueservice.model.Operador;
import br.com.alugueservice.model.PreAluguel;

public class PreAluguelController
{

    // Método de cadastro de PreAluguel
    public static PreAluguelDTO cadastrar(PreAluguel pPreAluguel)
    {

        // Valida se objeto é nulo.
        if (pPreAluguel == null)
        {
            return new PreAluguelDTO(false, "Tentativa de cadastrar Pré-aluguel nulo.");
        }

        // Acesso a camada de persistencia
        PreAluguelDAO aluguelDAO = DAOFactoy.getPreAluguelDAO();
        PreAluguel aluguel = aluguelDAO.create(pPreAluguel);

        // Retornando o indicativo de falha ao salvar o objeto.
        if (aluguel == null)
        {
            return new PreAluguelDTO(false, "Erro ao gravar o Pré-aluguel.");
        }

        // Retornando o indicativo de sucesso com o objeto criado
        return new PreAluguelDTO(true, "Pré-aluguel gravado com sucesso", aluguel);

    }

    // Método de recuperação de PreAluguel
    public static PreAluguelDTO recuperar(Integer pId)
    {

        // Acesso a camada de persistencia
        PreAluguelDAO PreAluguelDAO = DAOFactoy.getPreAluguelDAO();
        PreAluguel aluguel = PreAluguelDAO.recovery(pId);

        // Retornando o indicativo de falha ao salvar o objeto.
        if (aluguel == null)
        {
            return new PreAluguelDTO(false, "Pré-aluguel não existe.");
        }

        // Retornando o indicativo de sucesso com o objeto criado
        return new PreAluguelDTO(true, "Pré-aluguel recuperado com sucesso", aluguel);

    }

    // Método de pesquisa total da base de dados
    public static PreAluguelDTO pesquisar()
    {
        // Obtendo lista de Pré - Aluguel
        PreAluguelDAO PreAluguelDAO = DAOFactoy.getPreAluguelDAO();
        List<PreAluguel> listaPreAluguel = PreAluguelDAO.search();

        // Valida se lista está vazia
        if (listaPreAluguel.isEmpty())
            return new PreAluguelDTO(false, "Nenhum resultado encontrado.");

        // Retorna a lista
        return new PreAluguelDTO(true, "Lista de Pré-aluguel recuperada.", listaPreAluguel);

    }

    // Método de atualização de PreAluguel
    public static PreAluguelDTO atualizar(PreAluguel pPreAluguel)
    {
        // Valida se objeto é nulo.
        if (pPreAluguel == null)
            return new PreAluguelDTO(false, "Tentativa de cadastrar Pre-aluguel nulo.");

        // Acesso a camada de persistencia
        PreAluguelDAO aluguelDAO = DAOFactoy.getPreAluguelDAO();
        PreAluguel aluguel = aluguelDAO.update(pPreAluguel);

        // Retornando o indicativo de falha ao salvar o objeto.
        if (aluguel == null)
            return new PreAluguelDTO(false, "Erro ao atualizar o pré-aluguel.");

        // Retornando o indicativo de sucesso com o objeto criado
        return new PreAluguelDTO(true, "PreAluguel atualizado com sucesso.", aluguel);
    }

    // Método de pesquisa por operador
    public static PreAluguelDTO pesquisarPorOperador(Operador pOperador, Integer pStatus)
    {
        // Valida se nome é nulo
        if (pOperador == null)
            return new PreAluguelDTO(false, "Operador não possui nenhuma informação.");

        // Obtendo lista de Pré - Aluguel
        PreAluguelDAO PreAluguelDAO = DAOFactoy.getPreAluguelDAO();
        List<PreAluguel> listaPreAluguel = PreAluguelDAO.searchByOperador(pOperador, pStatus);

        // Valida se lista está vazia
        if (listaPreAluguel.isEmpty())
            return new PreAluguelDTO(false, "Nenhum Pré-aluguel encontrado para o Operador " + pOperador.getNome() + " " + pOperador.getSobrenome() + ".");

        // Retorna a lista
        return new PreAluguelDTO(true, "Lista de Alugueis recuperada.", listaPreAluguel);

    }

    // Método de pesquisa por cliente
    public static PreAluguelDTO pesquisarPorCliente(Cliente pCliente, Integer pStatus)
    {
        // Valida se nome é nulo
        if (pCliente == null)
            return new PreAluguelDTO(false, "Cliente informado não possui nenhuma informação.");

        // Obtendo lista de Pré - Aluguel
        PreAluguelDAO aluguelDAO = DAOFactoy.getPreAluguelDAO();
        List<PreAluguel> listaPreAluguel = aluguelDAO.searchByCliente(pCliente, pStatus);

        // Valida se lista está vazia
        if (listaPreAluguel.isEmpty())
            return new PreAluguelDTO(false, "Nenhum cupom encontrado para o Cliente " + pCliente.getNome() + " " + pCliente.getSobrenome() + ".");

        // Retorna a lista
        return new PreAluguelDTO(true, "Lista de Pré - Aluguel recuperada.", listaPreAluguel);

    }

    // Método de pesquisa por status
    public static PreAluguelDTO pesquisarPorStatus(Integer pStatus)
    {
        // Obtendo lista de Alugueis
        PreAluguelDAO aluguelDAO = DAOFactoy.getPreAluguelDAO();
        List<PreAluguel> listaPreAluguel = aluguelDAO.searchByStatus(pStatus);

        // Valida se lista está vazia
        if (listaPreAluguel.isEmpty())
            return new PreAluguelDTO(false, "Nenhum aluguel encontrado para o status informado.");

        // Retorna a lista
        return new PreAluguelDTO(true, "Lista de pré - aluguel recuperada.", listaPreAluguel);

    }
}

