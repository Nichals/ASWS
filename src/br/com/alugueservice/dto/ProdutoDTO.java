package br.com.alugueservice.dto;

import java.util.List;

import br.com.alugueservice.model.Produto;

public class ProdutoDTO extends BaseDTO<Produto>
{

    /* Construtores da classe */
    public ProdutoDTO()
    {
        super();
    }

    public ProdutoDTO(boolean pOk, String pMensagem)
    {
        super(pOk, pMensagem);
    }

    public ProdutoDTO(boolean pOk, String pMensagem, Produto pProduto)
    {
        super(pOk, pMensagem, pProduto);
    }

    public ProdutoDTO(boolean pOk, String pMensagem, List<Produto> pLista)
    {
        super(pOk, pMensagem, pLista);
    }

    /* Métodos de acesso */
    public Produto getProduto()
    {
        return getObjeto();
    }

    public void setProduto(Produto pProduto)
    {
        setObjeto(pProduto);
    }

}
