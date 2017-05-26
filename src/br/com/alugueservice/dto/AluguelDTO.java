package br.com.alugueservice.dto;

import java.util.List;

import br.com.alugueservice.model.Aluguel;

public class AluguelDTO extends BaseDTO<Aluguel>
{

    /* Construtores da classe */
    public AluguelDTO()
    {
        super();
    }

    public AluguelDTO(boolean pOk, String pMensagem)
    {
        super(pOk, pMensagem);
    }

    public AluguelDTO(boolean pOk, String pMensagem, Aluguel pAluguel)
    {
        super(pOk, pMensagem, pAluguel);
    }

    public AluguelDTO(boolean pOk, String pMensagem, List<Aluguel> pLista)
    {
        super(pOk, pMensagem, pLista);
    }

    /* Métodos de acesso */
    public Aluguel getAluguel()
    {
        return getObjeto();
    }

    public void setAluguel(Aluguel pAluguel)
    {
        setObjeto(pAluguel);
    }

}
