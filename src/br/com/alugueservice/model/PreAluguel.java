/**
 *
 */
package br.com.alugueservice.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity(name = "TBL_PRE_ALUGUEL")
/**
 * @author Vinicius Washington Nichals Filho
 *
 */
public class PreAluguel
{

    /*
     * Variáveis de instância
     */
    @SequenceGenerator(name = "ID_PRE_ALUGUEL", sequenceName = "ID_PRE_ALUGUEL_SEQ", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_PRE_ALUGUEL")
    @Column(name = "ID_PRE_ALUGUEL")
    private int                 idPreAluguel;


    @Column(name = "ID_OPERADOR_CRIADOR")
    private int            operadorCriador;

    @OneToOne
    @JoinColumn(name = "ID_CLIENTE", nullable = false)
    private Cliente             cliente;

    @OneToOne
    @JoinColumn(name = "ID_CONFIGURACAO", nullable = false)
    private Configuracao        configuracao;

    @Column(name = "DATA_PREVISTA", nullable = false)
    private long                dataPrevista;

    @Column(name = "STATUS_PRE_ALUGUEL", nullable = false)
    private int                 statusPreAluguel;

    @Column(name = "VALOR_ALUGUEL", nullable = false)
    private float               valorAluguel;

    @OneToMany(fetch=FetchType.EAGER)
    @JoinTable(name = "TBL_PRODUTOS_PRE_ALUGUEL", joinColumns = @JoinColumn(name = "ID_PRE_ALUGUEL"), inverseJoinColumns = @JoinColumn(name = "ID_PRODUTO"))
    private Collection<Produto> listaProdutos = new ArrayList<Produto>();

    /*
     * Função construtora
     */
    public PreAluguel()
    {

    }

    /*
     * Métodos de acesso
     */
    /**
     * @return the idPreAluguel
     */

    public int getIdPreAluguel()
    {
        return idPreAluguel;
    }

    /**
     * @param pIdPreAluguel
     *            the idPreAluguel to set
     */
    public void setIdPreAluguel(int pIdPreAluguel)
    {
        idPreAluguel = pIdPreAluguel;
    }

    /**
     * @return the cliente
     */
    public Cliente getCliente()
    {
        return cliente;
    }

    /**
     * @param pCliente
     *            the cliente to set
     */
    public void setCliente(Cliente pCliente)
    {
        cliente = pCliente;
    }

    /**
     * @return the configuracao
     */

    public Configuracao getConfiguracao()
    {
        return configuracao;
    }

    /**
     * @param pConfiguracao
     *            the configuracao to set
     */
    public void setConfiguracao(Configuracao pConfiguracao)
    {
        configuracao = pConfiguracao;
    }

    /**
     * @return the dataPrevista
     */

    public long getDataPrevista()
    {
        return dataPrevista;
    }

    /**
     * @param pDataPrevista
     *            the dataPrevista to set
     */
    public void setDataPrevista(long pDataPrevista)
    {
        dataPrevista = pDataPrevista;
    }

    /**
     * @return the statusPreAluguel
     */
    @Column(name = "STATUS_PRE_ALUGUEL")
    public int getStatusPreAluguel()
    {
        return statusPreAluguel;
    }

    /**
     * @param pStatusPreAluguel
     *            the statusPreAluguel to set
     */
    public void setStatusPreAluguel(int pStatusPreAluguel)
    {
        statusPreAluguel = pStatusPreAluguel;
    }

    /**
     * @return the valorAluguel
     */
    @Column(name = "VALOR_ALUGUEL")
    public float getValorAluguel()
    {
        return valorAluguel;
    }

    /**
     * @param pValorAluguel
     *            the valorAluguel to set
     */
    public void setValorAluguel(float pValorAluguel)
    {
        valorAluguel = pValorAluguel;
    }

    /**
     * @return the listaProdutos
     */
    public Collection<Produto> getListaProdutos()
    {
        return listaProdutos;
    }

    /**
     * @param pListaProdutos
     *            the listaProdutos to set
     */
    public void setListaProdutos(Collection<Produto> pListaProdutos)
    {
        listaProdutos = pListaProdutos;
    }

    /**
     * @return the operadorCriador
     */
    public int getOperadorCriador()
    {
        return operadorCriador;
    }

    /**
     * @param pOperadorCriador
     *            the operadorCriador to set
     */
    public void setOperadorCriador(int pOperadorCriador)
    {
        operadorCriador = pOperadorCriador;
    }

}
