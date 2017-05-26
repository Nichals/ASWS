package br.com.alugueservice.dao;

import br.com.alugueservice.dao.hibernate.AluguelHibernateDAO;
import br.com.alugueservice.dao.hibernate.ClienteHibernateDAO;
import br.com.alugueservice.dao.hibernate.ConfiguracaoHibernateDAO;
import br.com.alugueservice.dao.hibernate.CupomHibernateDAO;
import br.com.alugueservice.dao.hibernate.OperadorHibernateDAO;
import br.com.alugueservice.dao.hibernate.PreAluguelHibernateDAO;
import br.com.alugueservice.dao.hibernate.ProdutoHibernateDAO;

public class DAOFactoy
{
    public static ClienteDAO getClienteDAO()
    {
        return new ClienteHibernateDAO();
    }

    public static OperadorDAO getOperadorDAO()
    {
        return new OperadorHibernateDAO();
    }

    public static ProdutoDAO getProdutoDAO()
    {
        return new ProdutoHibernateDAO();
    }
    public static CupomDAO getCupomDAO()
    {
        return new CupomHibernateDAO();
    }

    public static ConfiguracaoDAO getConfiguracaoDAO()
    {
        return new ConfiguracaoHibernateDAO();
    }

    public static AluguelDAO getAluguelDAO()
    {
        return new AluguelHibernateDAO();
    }
    public static PreAluguelDAO getPreAluguelDAO()
    {
        return new PreAluguelHibernateDAO();
    }
}
