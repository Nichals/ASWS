package br.com.alugueservice.dto;

import java.util.List;

import br.com.alugueservice.model.Configuracao;

public class ConfiguracaoDTO extends BaseDTO<Configuracao>
{

    /* Construtores da classe */
    public ConfiguracaoDTO()
    {
        super();
    }

    public ConfiguracaoDTO(boolean pOk, String pMensagem)
    {
        super(pOk, pMensagem);
    }

    public ConfiguracaoDTO(boolean pOk, String pMensagem, Configuracao pConfiguracao)
    {
        super(pOk, pMensagem, pConfiguracao);
    }

    public ConfiguracaoDTO(boolean pOk, String pMensagem, List<Configuracao> pLista)
    {
        super(pOk, pMensagem, pLista);
    }

    /* Métodos de acesso */
    public Configuracao getConfiguracao()
    {
        return getObjeto();
    }

    public void setConfiguracao(Configuracao pConfiguracao)
    {
        setObjeto(pConfiguracao);
    }

}
