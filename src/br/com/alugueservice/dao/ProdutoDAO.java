package br.com.alugueservice.dao;

import java.util.List;

import br.com.alugueservice.model.Produto;

public interface ProdutoDAO
{

    // Método para criar um produto na base de dados (INSERT)
    Produto create(Produto pProduto);

    // Método para recuperar um produto da base de dados (SELECT)
    Produto recovery(int pId);

    // Método para atualizar um produto na base de dados (UPDATE)
    Produto update(Produto pProduto);

    // Método para desativar um produto na base de dados (DELETE)
    boolean alterarStatus(Produto pProduto);

    // Método para pesquisar todos os produtos da base de dados
    List<Produto> search();

    // Método para pesquisar por nome todos os produtos da base de dados
    List<Produto> searchByNome(String pNome);

}
