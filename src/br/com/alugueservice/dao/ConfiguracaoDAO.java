package br.com.alugueservice.dao;

import java.util.List;

import br.com.alugueservice.model.Configuracao;

public interface ConfiguracaoDAO
{

    // Método para criar um configuração na base de dados (INSERT)
    Configuracao create(Configuracao pConfiguracao);

    // Método para recuperar um configuração da base de dados (SELECT)
    Configuracao recovery(int pId);

    // Método para pesquisar todos os configurações da base de dados
    List<Configuracao> search();

    // Método para pesquisar a ultima configuração da base de dados
    Configuracao searchLast();
}
