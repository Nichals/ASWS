package br.com.alugueservice.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import br.com.alugueservice.dao.AluguelDAO;
import br.com.alugueservice.model.Aluguel;
import br.com.alugueservice.model.Cliente;
import br.com.alugueservice.model.Operador;
import br.com.alugueservice.model.Produto;
import br.com.alugueservice.util.HibernateUtil;

public class AluguelHibernateDAO implements AluguelDAO
{

    // Método de criação de Cliente
    @SuppressWarnings("unchecked")
    @Override
    public Aluguel create(Aluguel pAluguel)
    {
        @SuppressWarnings("unused")
        List<Boolean> list = new ArrayList<Boolean>();
        try
        {
            // Obtendo a sessão hibernate
            SessionFactory tFactory = HibernateUtil.getSessionFactory();
            Session tSessao = tFactory.getCurrentSession();

            // salvando o objeto via hibernate
            tSessao.save(pAluguel);
            tSessao.flush();
            for (Produto pItem : pAluguel.getListaProdutos())
            {
                Query query = tSessao.createSQLQuery("CALL PRODUTOS_ALUGUEL_INICIAR(:idProduto, :idAluguel)")
                                .addEntity(Aluguel.class)
                                .setParameter("idProduto",pItem.getIdProduto() )
                                .setParameter("idAluguel", pAluguel.getIdAluguel());
                 list = query.list();
            }
            // retornando o objeto atualizado
            return pAluguel;

        }
        catch (HibernateException tExcept)
        {
            System.out.println("Erro no método de criação do Aluguel, " + tExcept);
        }
        return null;
    }

    @Override
    public Aluguel recovery(int pId)
    {
        try
        {
            // Obtendo a sessão hibernate
            SessionFactory tFactory = HibernateUtil.getSessionFactory();
            Session tSessao = tFactory.getCurrentSession();

            // Recuperando o objeto via hibernate
            Aluguel tAluguel = (Aluguel) tSessao.get(Aluguel.class, pId);

            // Retornando o objeto lido
            return tAluguel;
        }
        catch (HibernateException tExcept)
        {
            System.out.println("Erro no método de recuperação do Aluguel, " + tExcept);
        }
        return null;
    }


    @Override
    public Aluguel update(Aluguel pAluguel)
    {

        try
        {
            // Obtendo a sessão hibernate
            SessionFactory tFactory = HibernateUtil.getSessionFactory();
            Session tSessao = tFactory.getCurrentSession();

            // Ataulizando o objeto via hibernate
            tSessao.merge(pAluguel);
            tSessao.flush();



            // Retornando o objeto atualizado
            return pAluguel;
        }
        catch (HibernateException tExcept)
        {
            System.out.println("Erro no método de atualização do aluguel, " + tExcept);
        }
        return null;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Boolean finalizar(Aluguel pAluguel)
    {
        Boolean resultado = false;
        try
        {
            // Obtendo a sessão hibernate
            SessionFactory tFactory = HibernateUtil.getSessionFactory();
            Session tSessao = tFactory.getCurrentSession();

            // Chamando storage procedure via hibernate

            Query query = tSessao.createSQLQuery("CALL FINALIZAR_ALUGUEL(:idAluguel, :quantidadeMulta, :resultado)")
                            .addEntity(Aluguel.class)
                            .setParameter("idAluguel", pAluguel.getIdAluguel())
                            .setParameter("quantidadeMulta", pAluguel.getQuatidadeMulta())
                            .setParameter("resultado", resultado);

            @SuppressWarnings("unused")
            List<Boolean> list = query.list();

            for (Produto pItem : pAluguel.getListaProdutos())
            {
                Query query2 = tSessao.createSQLQuery("CALL PRODUTOS_ALUGUEL_FINALIZAR(:idProduto)")
                                .addEntity(Aluguel.class)
                                .setParameter("idProduto",pItem.getIdProduto());
                 list = query2.list();
            }

            // Retornando o objeto atualizado
            return resultado;
        }
        catch (HibernateException tExcept)
        {
            System.out.println("Erro no método de finalização do aluguel, " + tExcept);
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Aluguel> search()
    {
        // Criando a tLista de clientes vazia
        List<Aluguel> tLista = new ArrayList<>();

        try
        {
            // Obtendo a sessão hibernate
            SessionFactory tFactory = HibernateUtil.getSessionFactory();
            Session tSessao = tFactory.getCurrentSession();

            // Criando o objeto para pesquisa
            Query tQuery = tSessao.createQuery("FROM TBL_ALUGUEL");

            // Recuperando a lista via hibernate
            tLista = tQuery.list();

        }
        catch (HibernateException tExcept)
        {
            System.out.println("Erro no método de recuperação da lista de Alugueis, " + tExcept);
        }

        // Retornando a lista de alugueis
        return tLista;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Aluguel> searchByCliente(Cliente pCliente, int pStatus)
    {
        // Criando a tLista de aluguel vazia
        List<Aluguel> tLista = new ArrayList<>();

        try
        {
            // Obtendo a sessão hibernate
            SessionFactory tFactory = HibernateUtil.getSessionFactory();
            Session tSessao = tFactory.getCurrentSession();

            // Criando o critério para pesquisa
            Criteria tCriterio = tSessao.createCriteria(Aluguel.class)
                            .add(Restrictions.like("cliente", pCliente.getIdCliente()))
                            .add(Restrictions.like("status", pStatus));

            // Recuperando a lista via hibernate
            tLista = tCriterio.list();
        }
        catch (HibernateException tExcept)
        {
            System.out.println("Erro no método de recuperação da lista de Alugueis por cliente, " + tExcept);
        }

        // Retornando a lista de clientes
        return tLista;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Aluguel> searchByOperador(Operador pOperador, int pStatus)
    {
        // Criando a tLista de aluguel vazia
        List<Aluguel> tLista = new ArrayList<>();

        try
        {
            // Obtendo a sessão hibernate
            SessionFactory tFactory = HibernateUtil.getSessionFactory();
            Session tSessao = tFactory.getCurrentSession();

            // Criando o critério para pesquisa
            Criteria tCriterio = tSessao.createCriteria(Aluguel.class)
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
    public List<Aluguel> searchByStatus(int pStatus)
    {
        // Criando a tLista de aluguel vazia
        List<Aluguel> tLista = new ArrayList<>();

        try
        {
            // Obtendo a sessão hibernate
            SessionFactory tFactory = HibernateUtil.getSessionFactory();
            Session tSessao = tFactory.getCurrentSession();

            // Criando o critério para pesquisa
            Criteria tCriterio = tSessao.createCriteria(Aluguel.class)
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
