package br.com.alugueservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity(name = "TBL_CONFIGURACAO")
public class Configuracao {

	/*
	 * Variáveis de instância
	 */
    @Id
    @SequenceGenerator(name = "ID_CONFIGURACAO", sequenceName = "ID_CONF_SEQ", allocationSize = 1)
    @Column(name="ID_CONFIGURACAO")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="ID_CONFIGURACAO" )
	private Integer idConfiguracao;

    @Column(name="MULTA_VALOR")
	private Float multa;

    @Column(name="CUPOM_VALOR")
	private Float cupom;

    @Column(name="CONTRATO")
	private String contrato;

	/*
	 * Função construtora
	 */

	public Configuracao() {

	}

	/*
	 * Métodos de acesso
	 */

	/**
	 * Método get para idConf
	 *
	 * @return idConf
	 */

	public Integer getIdConfiguracao() {
		return idConfiguracao;
	}

	/**
	 * Método set para idConf
	 *
	 * @param idConf
	 */
	public void setIdConfiguracao(Integer idConfiguracao) {
		this.idConfiguracao = idConfiguracao;
	}

	/**
	 * Método get para multa
	 *
	 * @return multa
	 */

	public Float getMulta() {
		return multa;
	}

	/**
	 * Método set para multa
	 *
	 * @param multa
	 */
	public void setMulta(Float multa) {
		this.multa = multa;
	}

	/**
	 * Método get para cupom
	 *
	 * @return cupom
	 */

	public Float getCupom() {
		return cupom;
	}

	/**
	 * Método set para cupom
	 *
	 * @param cupom
	 */
	public void setCupom(Float cupom) {
		this.cupom = cupom;
	}

    /**
     * @return the contrato
     */

    public String getContrato()
    {
        return contrato;
    }

    /**
     * @param pContrato the contrato to set
     */
    public void setContrato(String pContrato)
    {
        contrato = pContrato;
    }

}
