package br.com.alugueservice.biblioteca.jasper;

import java.io.IOException;
import java.io.InputStream;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;

public class JasperFactory
{
    private static JasperReport sRelacaoProdutos;

    public static JasperReport getRelacaoProdutos() throws JRException
    {
        if (sRelacaoProdutos == null)
        {
            try
            {
                // Abrindo o arquivo JRXML
                InputStream tArqEntrada = JasperFactory.class.getResourceAsStream("Relatorio_etiquetas.jrxml");

                // Compilando o arquivo JRXML
                sRelacaoProdutos = JasperCompileManager.compileReport(tArqEntrada);

                // Fechando o arquivo JRXML
                tArqEntrada.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }

        // Retornando o relatório compilado
        return sRelacaoProdutos;
    }
}
