package br.com.alugueservice.dto;

import java.util.List;

import br.com.alugueservice.model.PreAluguel;

public class PreAluguelDTO extends BaseDTO<PreAluguel>
{

    /* Construtores da classe */
    public PreAluguelDTO()
    {
        super();
    }

    public PreAluguelDTO(boolean pOk, String pMensagem)
    {
        super(pOk, pMensagem);
    }

    public PreAluguelDTO(boolean pOk, String pMensagem, PreAluguel pPreAluguel)
    {
        super(pOk, pMensagem, pPreAluguel);
    }

    public PreAluguelDTO(boolean pOk, String pMensagem, List<PreAluguel> pLista)
    {
        super(pOk, pMensagem, pLista);
    }

    /* Métodos de acesso */
    public PreAluguel getPreAluguel()
    {
        return getObjeto();
    }

    public void setPreAluguel(PreAluguel pPreAluguel)
    {
        setObjeto(pPreAluguel);
    }


}
