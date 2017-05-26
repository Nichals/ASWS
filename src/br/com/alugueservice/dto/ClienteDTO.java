package br.com.alugueservice.dto;

import java.util.List;

import br.com.alugueservice.model.Cliente;


public class ClienteDTO extends BaseDTO<Cliente>
{
    /* Construtores da classe */
    public ClienteDTO()
    {
        super();
    }

    public ClienteDTO(boolean pOk, String pMensagem)
    {
        super(pOk, pMensagem);
    }

    public ClienteDTO(boolean pOk, String pMensagem, Cliente pCliente)
    {
        super(pOk, pMensagem, pCliente);
    }

    public ClienteDTO(boolean pOk, String pMensagem, List<Cliente> pLista)
    {
        super(pOk, pMensagem, pLista);
    }

    /* Métodos de acesso */
    public Cliente getCliente()
    {
        return getObjeto();
    }

    public void setCliente(Cliente pCliente)
    {
        setObjeto(pCliente);
    }
}
