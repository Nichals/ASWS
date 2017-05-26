package br.com.alugueservice.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Endereco
{

    /*
     * Variáveis de instância
     */
    @Column(name = "RUA", nullable = false)
    private String rua;

    @Column(name = "NUMERO", nullable = false)
    private String numero;

    @Column(name = "CIDADE", nullable = false)
    private String cidade;

    @Column(name = "CEP", nullable = false)
    private String cep;

    @Column(name = "BAIRRO", nullable = false)
    private String bairro;

    /*
     * Métodos de acesso
     */

    /**
     * Método get para rua
     *
     * @return rua
     */
    public String getRua()
    {
        return rua;
    }

    /**
     * Método set para rua
     *
     * @param rua
     */
    public void setRua(String rua)
    {
        this.rua = rua;
    }

    /**
     * Método get para numero
     *
     * @return numero
     */
    public String getNumero()
    {
        return numero;
    }

    /**
     * Método set para numero
     *
     * @param numero
     */
    public void setNumero(String numero)
    {
        this.numero = numero;
    }

    /**
     * Método get para cidade
     *
     * @return cidade
     */
    public String getCidade()
    {
        return cidade;
    }

    /**
     * Método set para cidade
     *
     * @param cidade
     */
    public void setCidade(String cidade)
    {
        this.cidade = cidade;
    }

    /**
     * Método get para cep
     *
     * @return cep
     */
    public String getCep()
    {
        return cep;
    }

    /**
     * Método set para cep
     *
     * @param cep
     */
    public void setCep(String cep)
    {
        this.cep = cep;
    }

    /**
     * Método get para bairro
     *
     * @return bairro
     */
    public String getBairro()
    {
        return bairro;
    }

    /**
     * Método set para bairro
     *
     * @param bairro
     */
    public void setBairro(String bairro)
    {
        this.bairro = bairro;
    }

}
