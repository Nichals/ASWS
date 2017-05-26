package br.com.alugueservice.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import br.com.alugueservice.dao.OperadorDAO;
import br.com.alugueservice.model.Operador;
import br.com.alugueservice.util.HibernateUtil;

public class OperadorHibernateDAO implements OperadorDAO
{

    @Override
    public Operador create(Operador pOperador)
    {
        try
        {
            // Obtendo a sessão hibernate
            SessionFactory tFactory = HibernateUtil.getSessionFactory();
            Session tSessao = tFactory.getCurrentSession();

            // salvando o objeto via hibernate
            tSessao.save(pOperador);
            tSessao.flush();

            // retornando o objeto atualizado
            return pOperador;
        }
        catch (HibernateException tExcept)
        {
            System.out.println("Erro no método de criação do Operador, " + tExcept);
        }

        return null;
    }

    @Override
    public Operador recovery(int pId)
    {
        try
        {
            // Obtendo a sessão hibernate
            SessionFactory tFactory = HibernateUtil.getSessionFactory();
            Session tSessao = tFactory.getCurrentSession();

            // Recuperando o objeto via hibernate
            Operador tOperador = (Operador) tSessao.get(Operador.class, pId);

            // Retornando o objeto lido
            return tOperador;
        }
        catch (HibernateException tExcept)
        {
            System.out.println("Erro no método de recuperação do Operador, " + tExcept);
        }
        return null;
    }

    @Override
    public Operador update(Operador pOperador)
    {
        try
        {
            // Obtendo a sessão hibernate
            SessionFactory tFactory = HibernateUtil.getSessionFactory();
            Session tSessao = tFactory.getCurrentSession();

            // Ataulizando o objeto via hibernate
            tSessao.merge(pOperador);
            tSessao.flush();

            // Retornando o objeto atualizado
            return pOperador;
        }
        catch (HibernateException tExcept)
        {
            System.out.println("Erro no método de atualização do Operador, " + tExcept);
        }
        return null;
    }

    @Override
    public Operador autenticar(Operador pOperador)
    {
        try
        {
            // Buscando operador informado via login
            List<Operador> operadorBanco = searchByLogin(pOperador.getLogin());
            if (operadorBanco.isEmpty())
                return null;
            // Valida se infomação do banco é igual a informada
            if (operadorBanco.get(0).getLogin().equals(pOperador.getLogin()) && operadorBanco.get(0).getSenha().equals(pOperador.getSenha()))
            {
                return operadorBanco.get(0);
            }
        }
        catch (Exception tExcept)
        {
            System.out.println("Erro no método de autenticação do Operador, " + tExcept);
        }
        return null;
    }

    @Override
    public boolean alterarStatus(Operador pOperador)
    {
        try
        {
            // Obtendo a sessão hibernate
            SessionFactory tFactory = HibernateUtil.getSessionFactory();
            Session tSessao = tFactory.getCurrentSession();

            // Identificando o status e modificando no Objeto
            if (pOperador.getStatus() == 0)
            {
                pOperador.setStatus(1);
            }
            else
            {
                pOperador.setStatus(0);
            }

            // Ataulizando o objeto via hibernate
            tSessao.merge(pOperador);
            tSessao.flush();

            // Retornando indicativo de sucesso
            return true;
        }
        catch (HibernateException tExcept)
        {
            System.out.println("Erro no método de atualização do Operador, " + tExcept);
        }

        return false;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Operador> search()
    {
        // Criando a tLista de Operadors vazia
        List<Operador> tLista = new ArrayList<>();

        try
        {
            // Obtendo a sessão hibernate
            SessionFactory tFactory = HibernateUtil.getSessionFactory();
            Session tSessao = tFactory.getCurrentSession();

            // Criando o objeto para pesquisa
            Query tQuery = tSessao.createQuery("FROM TBL_OPERADOR");

            // Recuperando a lista via hibernate
            tLista = tQuery.list();

        }
        catch (HibernateException tExcept)
        {
            System.out.println("Erro no método de recuperação da lista de Operador, " + tExcept);
        }

        // Retornando a lista de Operadores
        return tLista;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Operador> searchByNome(String pNome)
    {
        // Acertando o critério de pesquisa
        String tNomePesquisa = "%" + pNome + "%";

        // Criando a tLista de Cliente vazia
        List<Operador> tLista = new ArrayList<>();

        try
        {
            // Obtendo a sessão hibernate
            SessionFactory tFactory = HibernateUtil.getSessionFactory();
            Session tSessao = tFactory.getCurrentSession();

            // Criando o critério para pesquisa
            Criteria tCriterio = tSessao.createCriteria(Operador.class)
                            .add(Restrictions.like("nome", tNomePesquisa).ignoreCase());

            // Recuperando a lista via hibernate
            tLista = tCriterio.list();
        }
        catch (HibernateException tExcept)
        {
            System.out.println("Erro no método de recuperação da lista de operador na busca por nome, " + tExcept);
        }

        // Retornando a lista de alunos
        return tLista;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Operador> searchByLogin(String pLogin)
    {
        try
        {
            // Obtendo a sessão hibernate
            SessionFactory tFactory = HibernateUtil.getSessionFactory();
            Session tSessao = tFactory.getCurrentSession();

            // Criando o critério para pesquisa
            Criteria tCriterio = tSessao.createCriteria(Operador.class)
                            .add(Restrictions.eq("login", pLogin).ignoreCase());

            // Recuperando o objeto via hibernate
            List<Operador> tOperador = tCriterio.list();

            // Retornando o objeto lido
            return tOperador;
        }
        catch (HibernateException tExcept)
        {
            System.out.println("Erro no método de recuperação do  operador na busca por login, " + tExcept);
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Operador> searchByCpf(String pCpf)
    {
        // Criando objeto cliente vazio
        List<Operador> tOperador = new ArrayList<Operador>();

        try
        {
            // Obtendo a sessão hibernate
            SessionFactory tFactory = HibernateUtil.getSessionFactory();
            Session tSessao = tFactory.getCurrentSession();

            // Criando o critério para pesquisa
            Criteria tCriterio = tSessao.createCriteria(Operador.class)
                            .add(Restrictions.eq("cpf", pCpf));

            tOperador = tCriterio.list();

        }
        catch (HibernateException tExcept)
        {
            System.out.println("Erro no método de recuperação da lista de operador na busca por cpf, " + tExcept);

        }

        // Retornando o operador
        return tOperador;
    }

}
