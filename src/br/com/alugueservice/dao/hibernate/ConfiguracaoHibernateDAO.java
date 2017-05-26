package br.com.alugueservice.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import br.com.alugueservice.dao.ConfiguracaoDAO;
import br.com.alugueservice.model.Configuracao;
import br.com.alugueservice.util.HibernateUtil;

public class ConfiguracaoHibernateDAO implements ConfiguracaoDAO
{

    @Override
    public Configuracao create(Configuracao pConfiguracao)
    {
        try
        {
            // Obtendo a sessão hibernate
            SessionFactory tFactory = HibernateUtil.getSessionFactory();
            Session tSessao = tFactory.getCurrentSession();

            // salvando o objeto via hibernate
            tSessao.save(pConfiguracao);
            tSessao.flush();

            // retornando o objeto atualizado
            return pConfiguracao;
        }
        catch (HibernateException tExcept)
        {
            System.out.println("Erro no método de criação da Configuração, " + tExcept);
        }

        return null;
    }

    @Override
    public Configuracao recovery(int pId)
    {
        try
        {
            // Obtendo a sessão hibernate
            SessionFactory tFactory = HibernateUtil.getSessionFactory();
            Session tSessao = tFactory.getCurrentSession();

            // Recuperando o objeto via hibernate
            Configuracao tConfiguracao = (Configuracao) tSessao.get(Configuracao.class, pId);

            // Retornando o objeto lido
            return tConfiguracao;
        }
        catch (HibernateException tExcept)
        {
            System.out.println("Erro no método de recuperação da Configuração, " + tExcept);
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Configuracao> search()
    {
        // Criando a tLista de configurações vazia
        List<Configuracao> tLista = new ArrayList<>();

        try
        {
            // Obtendo a sessão hibernate
            SessionFactory tFactory = HibernateUtil.getSessionFactory();
            Session tSessao = tFactory.getCurrentSession();

            // Criando o objeto para pesquisa
            Query tQuery = tSessao.createQuery("FROM TBL_CONFIGURACAO");

            // Recuperando a lista via hibernate
            tLista = tQuery.list();

        }
        catch (HibernateException tExcept)
        {
            System.out.println("Erro no método de recuperação da lista de Configuração, " + tExcept);
        }

        // Retornando a lista de clientes
        return tLista;
    }

    @Override
    public Configuracao searchLast()
    {
        // Criando a tLista de configurações vazia
        List<Configuracao> tLista = new ArrayList<>();

        // Recuperando a lista via hibernate
        tLista = search();

        // Validando se a lista não está vazia
        if (!tLista.isEmpty())
        {
            // Recupera o ultimo valor da lista
            Configuracao tConfiguracao = tLista.get(tLista.size() - 1);
            return tConfiguracao;
        }

        return null;
    }

}
