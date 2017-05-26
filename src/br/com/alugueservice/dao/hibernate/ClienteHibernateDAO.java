package br.com.alugueservice.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import br.com.alugueservice.dao.ClienteDAO;
import br.com.alugueservice.model.Cliente;
import br.com.alugueservice.util.HibernateUtil;

public class ClienteHibernateDAO implements ClienteDAO
{

    // Método de criação de Cliente
    @Override
    public Cliente create(Cliente pCliente)
    {
        try
        {
            // Obtendo a sessão hibernate
            SessionFactory tFactory = HibernateUtil.getSessionFactory();
            Session tSessao = tFactory.getCurrentSession();

            // salvando o objeto via hibernate
            tSessao.save(pCliente);
            tSessao.flush();
            // retornando o objeto atualizado
            return pCliente;
        }
        catch (HibernateException tExcept)
        {
            System.out.println("Erro no método de criação do Cliente, " + tExcept);
        }

        return null;
    }

    // Método de recuperação de Cliente
    @Override
    public Cliente recovery(int pId)
    {
        try
        {
            // Obtendo a sessão hibernate
            SessionFactory tFactory = HibernateUtil.getSessionFactory();
            Session tSessao = tFactory.getCurrentSession();

            // Recuperando o objeto via hibernate
            Cliente tCliente = (Cliente) tSessao.get(Cliente.class, pId);

            // Retornando o objeto lido
            return tCliente;
        }
        catch (HibernateException tExcept)
        {
            System.out.println("Erro no método de recuperação do Cliente, " + tExcept);
        }
        return null;
    }

    @Override
    public Cliente update(Cliente pCliente)
    {
        try
        {
            // Obtendo a sessão hibernate
            SessionFactory tFactory = HibernateUtil.getSessionFactory();
            Session tSessao = tFactory.getCurrentSession();

            // Ataulizando o objeto via hibernate
            tSessao.merge(pCliente);
            tSessao.flush();

            // Retornando o objeto atualizado
            return pCliente;
        }
        catch (HibernateException tExcept)
        {
            System.out.println("Erro no método de atualização do Cliente, " + tExcept);
        }
        return null;
    }

    @Override
    public boolean alterarStatus(Cliente pCliente)
    {
        try
        {
            // Obtendo a sessão hibernate
            SessionFactory tFactory = HibernateUtil.getSessionFactory();
            Session tSessao = tFactory.getCurrentSession();

            // Identificando o status e modificando no Objeto
            if (pCliente.getStatus() == 0)
            {
                pCliente.setStatus(1);
            }
            else
            {
                pCliente.setStatus(0);
            }

            // Ataulizando o objeto via hibernate
            tSessao.merge(pCliente);
            tSessao.flush();

            // Retornando indicativo de sucesso
            return true;
        }
        catch (HibernateException tExcept)
        {
            System.out.println("Erro no método de atualização do Cliente, " + tExcept);
        }

        return false;
    }

    @Override
    public Cliente searchByCpf(String pCpf)
    {
        // Criando objeto cliente vazio
        Cliente tCliente = new Cliente();

        try
        {
            // Obtendo a sessão hibernate
            SessionFactory tFactory = HibernateUtil.getSessionFactory();
            Session tSessao = tFactory.getCurrentSession();

            // Criando o critério para pesquisa
            Criteria tCriterio = tSessao.createCriteria(Cliente.class)
                            .add(Restrictions.eq("cpf", pCpf));

            // Recuperando a lista via hibernate
            tCliente = (Cliente) tCriterio.uniqueResult();
        }
        catch (HibernateException tExcept)
        {
            System.out.println("Erro no método de recuperação da lista de Clientes, " + tExcept);

        }

        // Retornando a lista de clientes
        return tCliente;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Cliente> search()
    {
        // Criando a tLista de clientes vazia
        List<Cliente> tLista = new ArrayList<>();

        try
        {
            // Obtendo a sessão hibernate
            SessionFactory tFactory = HibernateUtil.getSessionFactory();
            Session tSessao = tFactory.getCurrentSession();

            // Criando o objeto para pesquisa
            Query tQuery = tSessao.createQuery("FROM TBL_CLIENTE");

            // Recuperando a lista via hibernate
            tLista = tQuery.list();

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
    public List<Cliente> searchByNome(String pNome)
    {
        // Acertando o critério de pesquisa
        String tNomePesquisa = "%" + pNome + "%";

        // Criando a tLista de Cliente vazia
        List<Cliente> tLista = new ArrayList<>();

        try
        {
            // Obtendo a sessão hibernate
            SessionFactory tFactory = HibernateUtil.getSessionFactory();
            Session tSessao = tFactory.getCurrentSession();

            // Criando o critério para pesquisa
            Criteria tCriterio = tSessao.createCriteria(Cliente.class)
                            .add(Restrictions.like("nome", tNomePesquisa).ignoreCase());

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
    public List<Cliente> searchByEmail(String pEmail)
    {
        // Acertando o critério de pesquisa
        String tEmailPesquisa = "%" + pEmail + "%";

        // Criando a tLista de clientes vazia
        List<Cliente> tLista = new ArrayList<>();

        try
        {
            // Obtendo a sessão hibernate
            SessionFactory tFactory = HibernateUtil.getSessionFactory();
            Session tSessao = tFactory.getCurrentSession();

            // Criando o critério para pesquisa
            Criteria tCriterio = tSessao.createCriteria(Cliente.class)
                            .add(Restrictions.like("email", tEmailPesquisa).ignoreCase());

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
