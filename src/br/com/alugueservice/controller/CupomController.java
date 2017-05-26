package br.com.alugueservice.controller;

import java.util.List;

import br.com.alugueservice.dao.CupomDAO;
import br.com.alugueservice.dao.DAOFactoy;
import br.com.alugueservice.dto.CupomDTO;
import br.com.alugueservice.model.Cliente;
import br.com.alugueservice.model.Cupom;
import br.com.alugueservice.model.Operador;

public class CupomController
{
    // Método de cadastro de Cupom
    public static CupomDTO cadastrar(Cupom pCupom)
    {

        // Valida se objeto é nulo.
        if (pCupom == null)
        {
            return new CupomDTO(false, "Tentativa de cadastrar Cupom nulo.");
        }

        // Acesso a camada de persistencia
        CupomDAO cupomDAO = DAOFactoy.getCupomDAO();
        Cupom cupom = cupomDAO.create(pCupom);

        // Retornando o indicativo de falha ao salvar o objeto.
        if (cupom == null)
        {
            return new CupomDTO(false, "Erro ao gravar o Cupom.");
        }

        // Retornando o indicativo de sucesso com o objeto criado
        return new CupomDTO(true, "Cupom gravado com sucesso", cupom);

    }

    // Método de recuperação de Cupom
    public static CupomDTO recuperar(Integer pId)
    {

        // Acesso a camada de persistencia
        CupomDAO cupomDAO = DAOFactoy.getCupomDAO();
        Cupom cupom = cupomDAO.recovery(pId);

        // Retornando o indicativo de falha ao salvar o objeto.
        if (cupom == null)
        {
            return new CupomDTO(false, "Cupom não existe.");
        }

        // Retornando o indicativo de sucesso com o objeto criado
        return new CupomDTO(true, "Cupom recuperado com sucesso", cupom);

    }

    // Método de pesquisa total da base de dados
    public static CupomDTO pesquisar()
    {
        // Obtendo lista de Produtos
        CupomDAO cupomDAO = DAOFactoy.getCupomDAO();
        List<Cupom> listaCupom = cupomDAO.search();

        // Valida se lista está vazia
        if (listaCupom.isEmpty())
            return new CupomDTO(false, "Nenhum resultado encontrado.");

        // Retorna a lista
        return new CupomDTO(true, "Lista de cupons recuperada.", listaCupom);

    }

    // Método de pesquisa por cliente
    public static CupomDTO pesquisarPorCliente(Cliente pCliente)
    {
        // Valida se nome é nulo, caso seja, retorna base de Produtos completa.
        if (pCliente == null)
            return new CupomDTO(false, "Cliente informado não possui nenhuma informação.");

        // Obtendo lista de Produtos
        CupomDAO CupomDAO = DAOFactoy.getCupomDAO();
        List<Cupom> listaCupom = CupomDAO.searchByCliente(pCliente);

        // Valida se lista está vazia
        if (listaCupom.isEmpty())
            return new CupomDTO(false, "Nenhum cupom encontrado para o Cliente " + pCliente.getNome() +" "+pCliente.getSobrenome() + ".");

        // Retorna a lista
        return new CupomDTO(true, "Lista de cupons recuperada.", listaCupom);

    }

    // Método de pesquisa por operador
    public static CupomDTO pesquisarPorOperador(Operador pOperador)
    {
        // Valida se nome é nulo, caso seja, retorna base de Produtos completa.
        if (pOperador == null)
            return new CupomDTO(false, "Cliente informado não possui nenhuma informação.");

        // Obtendo lista de Produtos
        CupomDAO CupomDAO = DAOFactoy.getCupomDAO();
        List<Cupom> listaCupom = CupomDAO.searchByOperador(pOperador);

        // Valida se lista está vazia
        if (listaCupom.isEmpty())
            return new CupomDTO(false, "Nenhum cupom encontrado para o operador " + pOperador.getNome() +" "+pOperador.getSobrenome() + ".");

        // Retorna a lista
        return new CupomDTO(true, "Lista de cupons recuperada.", listaCupom);

    }

    // Método de utilização de cupom
    public static CupomDTO usarCupom(Cliente pCliente)
    {
        // Valida se nome é nulo, caso seja, retorna base de Produtos completa.
        if (pCliente == null)
            return new CupomDTO(false, "Cliente informado não possui nenhuma informação.");

        // Obtendo lista de Produtos
        CupomDAO CupomDAO = DAOFactoy.getCupomDAO();
        List<Cupom> listaCupom = CupomDAO.searchByClienteStatus(pCliente, 1);

        if(listaCupom.isEmpty())
            return new CupomDTO(false, "Cliente não possui nenhum cupom disponivel para uso.");
        Boolean resultado = CupomDAO.UsarCupom(pCliente);

        // Valida se foi utilizado o cupom
        if (!resultado)
            return new CupomDTO(false, "Falha ao utilizar o cupom");

        // Retorna a lista
        return new CupomDTO(true, "Cupom utilizado com sucesso.");

    }


}
