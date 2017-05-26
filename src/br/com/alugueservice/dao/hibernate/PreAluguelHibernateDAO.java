package br.com.alugueservice.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import br.com.alugueservice.dao.PreAluguelDAO;
import br.com.alugueservice.model.Cliente;
import br.com.alugueservice.model.Operador;
import br.com.alugueservice.model.PreAluguel;
import br.com.alugueservice.util.HibernateUtil;

public class PreAluguelHibernateDAO implements PreAluguelDAO
{

    @Override
    public PreAluguel create(PreAluguel pPreAluguel)
    {
        try
        {
            // Obtendo a sessão hibernate
            SessionFactory tFactory = HibernateUtil.getSessionFactory();
            Session tSessao = tFactory.getCurrentSession();

            // salvando o objeto via hibernate
            tSessao.save(pPreAluguel);
            tSessao.flush();

            // retornando o objeto atualizado
            return pPreAluguel;

        }
        catch (HibernateException tExcept)
        {
            System.out.println("Erro no método de criação do Pré-Aluguel, " + tExcept);
        }
        return null;
    }

    @Override
    public PreAluguel recovery(int pId)
    {
        try
        {
            // Obtendo a sessão hibernate
            SessionFactory tFactory = HibernateUtil.getSessionFactory();
            Session tSessao = tFactory.getCurrentSession();

            // Recuperando o objeto via hibernate
            PreAluguel tAluguel = (PreAluguel) tSessao.get(PreAluguel.class, pId);

            // Retornando o objeto lido
            return tAluguel;
        }
        catch (HibernateException tExcept)
        {
            System.out.println("Erro no método de recuperação do Pré-Aluguel, " + tExcept);
        }
        return null;
    }

    @Override
    public PreAluguel update(PreAluguel pPreAluguel)
    {
        try
        {
            // Obtendo a sessão hibernate
            SessionFactory tFactory = HibernateUtil.getSessionFactory();
            Session tSessao = tFactory.getCurrentSession();

            // Ataulizando o objeto via hibernate
            tSessao.merge(pPreAluguel);
            tSessao.flush();

            // Retornando o objeto atualizado
            return pPreAluguel;
        }
        catch (HibernateException tExcept)
        {
            System.out.println("Erro no método de atualização do aluguel, " + tExcept);
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<PreAluguel> search()
    {
        // Criando a tLista vazia
        List<PreAluguel> tLista = new ArrayList<>();

        try
        {
            // Obtendo a sessão hibernate
            SessionFactory tFactory = HibernateUtil.getSessionFactory();
            Session tSessao = tFactory.getCurrentSession();

            // Criando o objeto para pesquisa
            Query tQuery = tSessao.createQuery("FROM TBL_PRE_ALUGUEL");

            // Recuperando a lista via hibernate
            tLista = tQuery.list();

        }
        catch (HibernateException tExcept)
        {
            System.out.println("Erro no método de recuperação da lista de Pré-alugueis, " + tExcept);
        }

        // Retornando a lista
        return tLista;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<PreAluguel> searchByCliente(Cliente pCliente, int pStatus)
    {
     // Criando a tLista vazia
        List<PreAluguel> tLista = new ArrayList<>();

        try
        {
            // Obtendo a sessão hibernate
            SessionFactory tFactory = HibernateUtil.getSessionFactory();
            Session tSessao = tFactory.getCurrentSession();

            // Criando o critério para pesquisa
            Criteria tCriterio = tSessao.createCriteria(PreAluguel.class)
                            .add(Restrictions.like("cliente", pCliente.getIdCliente()))
                            .add(Restrictions.like("status", pStatus));

            // Recuperando a lista via hibernate
            tLista = tCriterio.list();
        }
        catch (HibernateException tExcept)
        {
            System.out.println("Erro no método de recuperação da lista de Pre-Alugueis por cliente, " + tExcept);
        }

        // Retornando a lista de clientes
        return tLista;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<PreAluguel> searchByOperador(Operador pOperador, int pStatus)
    {
     // Criando a tLista de aluguel vazia
        List<PreAluguel> tLista = new ArrayList<>();

        try
        {
            // Obtendo a sessão hibernate
            SessionFactory tFactory = HibernateUtil.getSessionFactory();
            Session tSessao = tFactory.getCurrentSession();

            // Criando o critério para pesquisa
            Criteria tCriterio = tSessao.createCriteria(PreAluguel.class)
                            .add(Restrictions.like("cliente", pOperador.getIdOperador()))
                            .add(Restrictions.like("status", pStatus));

            // Recuperando a lista via hibernate
            tLista = tCriterio.list();
        }
        catch (HibernateException tExcept)
        {
            System.out.println("Erro no método de recuperação da lista de Clientes, " + tExcept);
        }

        // Retornando a lista de clientes
        return tLista;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<PreAluguel> searchByStatus(int pStatus)
    {
     // Criando a tLista de aluguel vazia
        List<PreAluguel> tLista = new ArrayList<>();

        try
        {
            // Obtendo a sessão hibernate
            SessionFactory tFactory = HibernateUtil.getSessionFactory();
            Session tSessao = tFactory.getCurrentSession();

            // Criando o critério para pesquisa
            Criteria tCriterio = tSessao.createCriteria(PreAluguel.class)
                            .add(Restrictions.like("status", pStatus));

            // Recuperando a lista via hibernate
            tLista = tCriterio.list();
        }
        catch (HibernateException tExcept)
        {
            System.out.println("Erro no método de recuperação da lista de Clientes, " + tExcept);
        }

        // Retornando a lista de clientes
        return tLista;
    }

}
