package br.com.alugueservice.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class Filtro implements Filter
{
    public Filtro()
    {
    }

    @Override
    public void destroy()
    {
    }

    @Override
    public void doFilter(ServletRequest pRequest, ServletResponse pResponse, FilterChain pSequencia) throws IOException, ServletException
    {
        try
        {
            HibernateUtil.iniciarSessao();

            HttpServletRequest tRequest = (HttpServletRequest) pRequest;
            System.out.println("Servlet Ativado : " + tRequest.getRequestURI());

            pSequencia.doFilter(pRequest, pResponse);

            HibernateUtil.confirmarSessao();
        }
        catch (Exception tExcept)
        {
            HibernateUtil.cancelarSessao();
            tExcept.printStackTrace();
            throw new ServletException(tExcept);
        }
    }

    @Override
    public void init(FilterConfig fConfig) throws ServletException
    {
    }
}
