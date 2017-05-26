package br.com.alugueservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
@Entity(name = "TBL_PRODUTO")

public class Produto {

	/*
	 * Variáveis de instância
	 */

    @SequenceGenerator(name = "ID_PRODUTO_SEQUENCIA", sequenceName = "ID_PRODUTO_SEQ",allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="ID_PRODUTO_SEQUENCIA" )
    @Column(name="ID_PRODUTO")

	private Integer idProduto;

    @Column(name="NOME_PRODUTO", nullable = false)
	private String nome;

    @Column(name="VALOR_PRODUTO", nullable = false)
    private Float valor;

    @Column(name="TAMANHO_PRODUTO", nullable = false)
    private String tamanho;

    @Column(name="GENERO_PRODUTO", nullable = false)
    private String genero;

    @Column(name="DESCRICAO_PRODUTO")
	private String descricao;

   @Column(name="STATUS_PRODUTO", nullable = false)
	private Integer status;

   @Column(name="QUANTIDADE_ALUGUEL_PRODUTO")
   private Integer quantidadeAluguel;

   @Column(name="DIRETORIO_IMAGEM_PRODUTO")
   private String diretorioImagem;

   @Column(name="DATA_CRIACAO_PRODUTO", nullable = false)
   private long dataCriacao;


   @Column(name = "ID_OPERADOR", nullable = false)
   private Integer operadorCriador;

	/*
	 * Função construtora
	 */

	public Produto() {

	}

	/*
	 * Métodos de acesso
	 */

	/**
	 * Método get para idProduto
	 *
	 * @return idProduto
	 */
	public Integer getIdProduto() {
		return idProduto;
	}

	/**
	 * Método set para idProduto
	 *
	 * @param idProduto
	 */
	public void setIdProduto(Integer idProduto) {
		this.idProduto = idProduto;
	}

	/**
	 * Método get para nome
	 *
	 * @return nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Método set para nome
	 *
	 * @param nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Método get para descricao
	 *
	 * @return descricao
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * Método set para descricao
	 *
	 * @param descricao
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	/**
	 * Método get para valor
	 *
	 * @return valor
	 */
	public Float getValor() {
		return valor;
	}

	/**
	 * Método set para valor
	 *
	 * @param valor
	 */
	public void setValor(Float valor) {
		this.valor = valor;
	}

	/**
	 * Método get para status
	 *
	 * @return status
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * Método set para status
	 *
	 * @param status
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * Método get para tamanho
	 *
	 * @return tamanho
	 */
	public String getTamanho() {
		return tamanho;
	}

	/**
	 * Método set para tamanho
	 *
	 * @param tamanho
	 */
	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}

	/**
	 * Método get para genero
	 *
	 * @return genero
	 */
	public String getGenero() {
		return genero;
	}

	/**
	 * Método set para genero
	 *
	 * @param genero
	 */
	public void setGenero(String genero) {
		this.genero = genero;
	}

	/**
     * Método get para genero
     *
     * @return genero
     */
    public long getDataCriacao() {
        return dataCriacao;
    }

    /**
     * Método set para genero
     *
     * @param genero
     */
    public void setDataCriacao(long dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    /**
     * @return the quantidadeAluguel
     */
    public Integer getQuantidadeAluguel()
    {
        return quantidadeAluguel;
    }

    /**
     * @param pQuantidadeAluguel the quantidadeAluguel to set
     */
    public void setQuantidadeAluguel(Integer pQuantidadeAluguel)
    {
        quantidadeAluguel = pQuantidadeAluguel;
    }

    /**
     * @return the diretorioImagem
     */
    public String getDiretorioImagem()
    {
        return diretorioImagem;
    }

    /**
     * @param pDiretorioImagem the diretorioImagem to set
     */
    public void setDiretorioImagem(String pDiretorioImagem)
    {
        diretorioImagem = pDiretorioImagem;
    }

    /**
     * @return the operadorCriador
     */
    public Integer getOperadorCriador()
    {
        return operadorCriador;
    }

    /**
     * @param pOperadorCriador the operadorCriador to set
     */
    public void setOperadorCriador(Integer pOperadorCriador)
    {
        operadorCriador = pOperadorCriador;
    }


}
