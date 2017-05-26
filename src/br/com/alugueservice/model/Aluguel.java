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

@Entity(name = "TBL_ALUGUEL")
public class Aluguel
{

    /*
     * Variáveis de instância
     */
    @SequenceGenerator(name = "ID_ALUGUEL", sequenceName = "ID_ALUGUEL_SEQ", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_ALUGUEL")
    @Column(name = "ID_ALUGUEL")
    private int                 idAluguel;

    @OneToOne
    @JoinColumn(name = "ID_OPERADOR_CRIADOR", nullable = false)
    private Operador            operadorCriador;

    @OneToOne
    @JoinColumn(name = "ID_CLIENTE", nullable = false)
    private Cliente             cliente;

    @OneToOne
    @JoinColumn(name = "ID_CONFIGURACAO", nullable = false)
    private Configuracao        configuracao;

    @OneToOne
    @JoinColumn(name = "ID_CUPOM")
    private Cupom               cupom;

    @OneToOne
    @JoinColumn(name = "ID_PRE_ALUGUEL")
    private PreAluguel          preAluguel;

    @Column(name = "DATA_ALUGUEL", nullable = false)
    private long                dataAluguel;

    @Column(name = "DATA_PREVISTA", nullable = false)
    private long                dataPrevista;

    @Column(name = "DATA_ENTREGA")
    private long                dataEntrega;

    @Column(name = "STATUS_ALUGUEL", nullable = false)
    private Integer             statusAluguel;

    @Column(name = "QUANTIDADE_MULTA")
    private int                 quatidadeMulta;

    @Column(name = "VALOR_ALUGUEL")
    private float               valorAluguel;

    @Column(name = "VALOR_MULTA")
    private Float               valorMulta;

    @Column(name = "VALOR_TOTAL")
    private Float               valorTotal;

    @OneToOne
    @JoinColumn(name = "ID_OPERADOR_FINALIZADOR")
    private Operador            operadorFinalizador;

    @OneToMany(fetch=FetchType.EAGER)
    @JoinTable(name = "TBL_PRODUTOS_ALUGUEL", joinColumns = @JoinColumn(name = "ID_ALUGUEL"), inverseJoinColumns = @JoinColumn(name = "ID_PRODUTO"))
    private Collection<Produto> listaProdutos = new ArrayList<Produto>();

    /*
     * Função construtora
     */
    public Aluguel()
    {

    }

    /*
     * Métodos de acesso
     */

    /**
     * Método set para dataEntrega
     *
     * @param dataEntrega
     */
    public void setDataEntrega(long dataEntrega)
    {
        this.dataEntrega = dataEntrega;
    }

    /**
     * Método get para dataEntrega
     *
     * @return dataEntrega
     */

    public long getDataEntrega()
    {
        return dataEntrega;
    }

    /**
     * Método get para idAluguel
     *
     * @return idAluguel
     */

    public int getIdAluguel()
    {
        return idAluguel;
    }

    /**
     * Método set para idAluguel
     *
     * @param idAluguel
     */
    public void setIdAluguel(int idAluguel)
    {
        this.idAluguel = idAluguel;
    }

    /**
     * Método get para dataPrevista
     *
     * @return dataPrevista
     */

    public long getDataPrevista()
    {
        return dataPrevista;
    }

    /**
     * Método set para dataPrevista
     *
     * @param dataPrevista
     */
    public void setDataPrevista(long dataPrevista)
    {
        this.dataPrevista = dataPrevista;
    }

    /**
     * Método get para dataAluguel
     *
     * @return dataAluguel
     */

    public long getDataAluguel()
    {
        return dataAluguel;
    }

    /**
     * Método set para dataAluguel
     *
     * @param dataAluguel
     */
    public void setDataAluguel(long dataAluguel)
    {
        this.dataAluguel = dataAluguel;
    }

    /**
     * Método get para valorTotal
     *
     * @return valorTotal
     */

    public Float getValorTotal()
    {
        return valorTotal;
    }

    /**
     * Método set para valorTotal
     *
     * @param valorTotal
     */
    public void setValorTotal(Float valorTotal)
    {
        this.valorTotal = valorTotal;
    }

    /**
     * Método get para valorAluguel
     *
     * @return valorAluguel
     */

    public float getValorAluguel()
    {
        return valorAluguel;
    }

    /**
     * Método set para valorAluguel
     *
     * @param valorAluguel
     */
    public void setValorAluguel(float valorAluguel)
    {
        this.valorAluguel = valorAluguel;
    }

    /**
     * Método get para statusAluguel
     *
     * @return statusAluguel
     */

    public Integer getStatusAluguel()
    {
        return statusAluguel;
    }

    /**
     * Método set para statusAluguel
     *
     * @param statusAluguel
     */
    public void setStatusAluguel(Integer statusAluguel)
    {
        this.statusAluguel = statusAluguel;
    }

    /**
     * Método get para quatidadeMulta
     *
     * @return quatidadeMulta
     */

    public int getQuatidadeMulta()
    {
        return quatidadeMulta;
    }

    /**
     * Método set para quatidadeMulta
     *
     * @param quatidadeMulta
     */
    public void setQuatidadeMulta(int quatidadeMulta)
    {
        this.quatidadeMulta = quatidadeMulta;
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

    public Collection<Produto> getListaProdutos()
    {
        return listaProdutos;
    }

    public void setListaProdutos(Collection<Produto> pListaProdutos)
    {
        listaProdutos = pListaProdutos;
    }

    public Operador getOperadorCriador()
    {
        return operadorCriador;
    }

    public void setOperadorCriador(Operador pOperadorCriador)
    {
        operadorCriador = pOperadorCriador;
    }

    public Operador getOperadorFinalizador()
    {
        return operadorFinalizador;
    }

    public void setOperadorFinalizador(Operador pOperadorFinalizador)
    {
        operadorFinalizador = pOperadorFinalizador;
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
     * @return the cupom
     */

    public Cupom getCupom()
    {
        return cupom;
    }

    /**
     * @param pCupom
     *            the cupom to set
     */
    public void setCupom(Cupom pCupom)
    {
        cupom = pCupom;
    }

    /**
     * @return the preAluguel
     */

    public PreAluguel getPreAluguel()
    {
        return preAluguel;
    }

    /**
     * @param pPreAluguel
     *            the preAluguel to set
     */
    public void setPreAluguel(PreAluguel pPreAluguel)
    {
        preAluguel = pPreAluguel;
    }

}
