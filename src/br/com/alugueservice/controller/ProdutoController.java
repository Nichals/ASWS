package br.com.alugueservice.controller;

import java.util.List;

import br.com.alugueservice.dao.DAOFactoy;
import br.com.alugueservice.dao.ProdutoDAO;
import br.com.alugueservice.dto.ProdutoDTO;
import br.com.alugueservice.model.Produto;

public class ProdutoController
{
    // Método de cadastro de Produto
    public static ProdutoDTO cadastrar(Produto pProduto)
    {
        Produto produto = null;
        // Valida se objeto é nulo.
        if (pProduto == null)
        {
            return new ProdutoDTO(false, "Tentativa de cadastrar produto nulo.");
        }

        // Acesso a camada de persistencia
        ProdutoDAO produtoDTO = DAOFactoy.getProdutoDAO();
        produto = produtoDTO.create(pProduto);

        // Retornando o indicativo de falha ao salvar o objeto.
        if (produto == null)
        {
            return new ProdutoDTO(false, "Erro ao gravar o Produto.");
        }

        // Retornando o indicativo de sucesso com o objeto criado
        return new ProdutoDTO(true, "Produto gravado com sucesso", produto);

    }

    // Método de atualização de Produto
    public static ProdutoDTO atualizar(Produto pProduto)
    {
        // Valida se objeto é nulo.
        if (pProduto == null)
            return new ProdutoDTO(false, "Tentativa de cadastrar Produto nulo.");

        // Acesso a camada de persistencia
        ProdutoDAO ProdutoDAO = DAOFactoy.getProdutoDAO();
        Produto Produto = ProdutoDAO.update(pProduto);

        // Retornando o indicativo de falha ao salvar o objeto.
        if (Produto == null)
            return new ProdutoDTO(false, "Erro ao atualizar Produto.");

        // Retornando o indicativo de sucesso com o objeto criado
        return new ProdutoDTO(true, "Produto atualizado com sucesso.", Produto);
    }

    // Método de recuperação de Produto
    public static ProdutoDTO recuperar(Integer pId)
    {
        // Recuperando objeto do banco
        ProdutoDAO ProdutoDAO = DAOFactoy.getProdutoDAO();
        Produto Produto = ProdutoDAO.recovery(pId);

        // Valida se Produto foi recuperado com sucesso;
        if (Produto == null)
            return new ProdutoDTO(false, "Produto não existe.");

        return new ProdutoDTO(true, "Produto recuperado com sucesso.", Produto);
    }

    // Método de pesquisa total da base de dados
    public static ProdutoDTO pesquisar()
    {
        // Obtendo lista de Produtos
        ProdutoDAO ProdutoDAO = DAOFactoy.getProdutoDAO();
        List<Produto> listaProduto = ProdutoDAO.search();

        // Valida se lista está vazia
        if (listaProduto.isEmpty())
            return new ProdutoDTO(false, "Nenhum resultado encontrado.");

        // Retorna a lista
        return new ProdutoDTO(true, "Lista de Produtos recuperada.", listaProduto);

    }

    // Método de pesquisa por nome
    public static ProdutoDTO pesquisarPorNome(String pNome)
    {
        // Valida se nome é nulo, caso seja, retorna base de Produtos completa.
        if (pNome == null)
            return pesquisar();

        // Obtendo lista de Produtos
        ProdutoDAO ProdutoDAO = DAOFactoy.getProdutoDAO();
        List<Produto> listaProduto = ProdutoDAO.searchByNome(pNome);

        // Valida se lista está vazia
        if (listaProduto.isEmpty())
            return new ProdutoDTO(false, "Nenhum resultado encontrado com o nome " + pNome + ".");

        // Retorna a lista
        return new ProdutoDTO(true, "Lista de Produtos recuperada.", listaProduto);

    }

    // Método de alteração de status
    public static ProdutoDTO alterarStatus(Produto pProduto)
    {

        // Valida se Produto informado é nulo
        if (pProduto == null)
            return new ProdutoDTO(false, "Produto infomado é nulo.");
        // Acessa camada de persistência
        ProdutoDAO ProdutoDAO = DAOFactoy.getProdutoDAO();
        // Valida se alteração foi efetuada
        if (ProdutoDAO.alterarStatus(pProduto))
        {
            return new ProdutoDTO(true, "Produto infomado teve seu status alterado.");
        }

        return new ProdutoDTO(false, "Não foi possivel alterar status do Produto.");
    }

}
