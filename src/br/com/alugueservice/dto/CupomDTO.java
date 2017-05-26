package br.com.alugueservice.dto;

import java.util.List;

import br.com.alugueservice.model.Cupom;

public class CupomDTO extends BaseDTO<Cupom>
{

    /* Construtores da classe */
    public CupomDTO()
    {
        super();
    }

    public CupomDTO(boolean pOk, String pMensagem)
    {
        super(pOk, pMensagem);
    }

    public CupomDTO(boolean pOk, String pMensagem, Cupom pCupom)
    {
        super(pOk, pMensagem, pCupom);
    }

    public CupomDTO(boolean pOk, String pMensagem, List<Cupom> pLista)
    {
        super(pOk, pMensagem, pLista);
    }

    /* Métodos de acesso */
    public Cupom getCupom()
    {
        return getObjeto();
    }

    public void setCupom(Cupom pCupom)
    {
        setObjeto(pCupom);
    }

}
