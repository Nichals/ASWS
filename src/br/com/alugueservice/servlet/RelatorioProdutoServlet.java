package br.com.alugueservice.servlet;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alugueservice.controller.ProdutoController;
import br.com.alugueservice.dto.ProdutoDTO;
import br.com.alugueservice.model.Produto;
import br.com.alugueservice.util.HibernateUtil;
import br.edu.opet.biblioteca.jasper.JasperFactory;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 * Servlet implementation class RelatorioProdutoServlet
 */
@WebServlet("/RelatorioProdutoServlet")
public class RelatorioProdutoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RelatorioProdutoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
        {
            JasperReport jasperReport = JasperFactory.getRelacaoProdutos();

            OutputStream tSaida = response.getOutputStream();

            //response.setHeader("Content-Disposition", "inline, filename=RelatorioProdutos.pdf");
            response.setContentType("application/pdf");


            // Par√¢metros para o relat√≥rio
            Map<String, Object> parameters = new HashMap<String, Object>();
            parameters.put("FACULDADE", "Faculdades OPET");

            // Obtendo a lista de Produtos
            HibernateUtil.iniciarSessao();
            ProdutoDTO tDto = ProdutoController.pesquisar();
            if (tDto.isOk())
            {
                List<Produto> tLista = tDto.getLista();

                // DataSource
                JRDataSource dataSource = new JRBeanCollectionDataSource(tLista);

                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,
                                parameters, dataSource);

                // Gerando o relat√≥rio para envio
                JasperExportManager.exportReportToPdfStream(jasperPrint,tSaida);

                System.out.println("Done!");

                tSaida.close();
            }
        }
        catch (JRException tExcept)
        {
            throw new ServletException("Problemas na geraÁ„o do relatÛrio dos produtos", tExcept);
        }

        //response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
