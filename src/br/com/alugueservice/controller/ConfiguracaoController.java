package br.com.alugueservice.controller;

import java.util.List;

import br.com.alugueservice.dao.ConfiguracaoDAO;
import br.com.alugueservice.dao.DAOFactoy;
import br.com.alugueservice.dto.ConfiguracaoDTO;
import br.com.alugueservice.model.Configuracao;

public class ConfiguracaoController
{

    // Método de cadastro de Configuração
    public static ConfiguracaoDTO cadastrar(Configuracao pConfiguracao)
    {

        // Valida se objeto é nulo.
        if (pConfiguracao == null)
        {
            return new ConfiguracaoDTO(false, "Tentativa de cadastrar Cupom nulo.");
        }
        // Acesso a camada de persistencia
        ConfiguracaoDAO configuracaoDAO = DAOFactoy.getConfiguracaoDAO();
        Configuracao cupom = configuracaoDAO.create(pConfiguracao);

        // Retornando o indicativo de falha ao salvar o objeto.
        if (cupom == null)
        {
            return new ConfiguracaoDTO(false, "Erro ao gravar a Configuração.");
        }

        // Retornando o indicativo de sucesso com o objeto criado
        return new ConfiguracaoDTO(true, "Configuração gravado com sucesso", cupom);

    }

    // Método de recuperação de Cupom
    public static ConfiguracaoDTO recuperar(Integer pId)
    {

        // Acesso a camada de persistencia
        ConfiguracaoDAO configuracaoDAO = DAOFactoy.getConfiguracaoDAO();
        Configuracao configuracao = configuracaoDAO.recovery(pId);

        // Retornando o indicativo de falha ao salvar o objeto.
        if (configuracao == null)
        {
            return new ConfiguracaoDTO(false, "Configuração não existe.");
        }

        // Retornando o indicativo de sucesso com o objeto criado
        return new ConfiguracaoDTO(true, "Configuração recuperada com sucesso", configuracao);

    }

    // Método de pesquisa total da base de dados
    public static ConfiguracaoDTO pesquisar()
    {
        // Obtendo lista de Produtos
        ConfiguracaoDAO ConfiguracaoDAO = DAOFactoy.getConfiguracaoDAO();
        List<Configuracao> listaConfiguracao = ConfiguracaoDAO.search();

        // Valida se lista está vazia
        if (listaConfiguracao.isEmpty())
            return new ConfiguracaoDTO(false, "Nenhum resultado encontrado.");

        // Retorna a lista
        return new ConfiguracaoDTO(true, "Lista de Produtos recuperada.", listaConfiguracao);

    }

    // Método de pesquisa total da base de dados
    public static ConfiguracaoDTO pesquisarUltimo()
    {
        // Obtendo lista de Produtos
        ConfiguracaoDAO ConfiguracaoDAO = DAOFactoy.getConfiguracaoDAO();
        Configuracao configuracao = ConfiguracaoDAO.searchLast();

        // Valida se lista está vazia
        if (configuracao == null)
            return new ConfiguracaoDTO(false, "Nenhum resultado encontrado.");

        // Retorna a lista
        return new ConfiguracaoDTO(true, "Lista de Produtos recuperada.", configuracao);

    }

}
