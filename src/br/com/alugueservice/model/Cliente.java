package br.com.alugueservice.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity(name = "TBL_CLIENTE")
public class Cliente implements IPessoa
{

    /*
     * Variáveis de instância
     */

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @SequenceGenerator(name = "ID_CLIENTE", sequenceName = "ID_CLIENTE_SEQ", allocationSize = 1)
    @Id
    @Column(name = "ID_CLIENTE")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_CLIENTE")

    private int      idCliente;

    @Column(name = "NOME_CLIENTE", nullable = false)
    private String   nome;

    @Column(name = "SOBRENOME_CLIENTE", nullable = false)
    private String   sobrenome;

    @Column(name = "CPF_CLIENTE", nullable = false)
    private String   cpf;

    @Column(name = "DATA_NASCIMENTO", nullable = true)
    private long     dataNascimento;

    @Column(name = "EMAIL_CLIENTE", nullable = true)
    private String   email;

    @Column(name = "TELEFONE_CLIENTE")
    private String   telefone;

    @Column(name = "CELULAR_CLIENTE")
    private String   celular;

    @Embedded
    private Endereco endereco;

    @Column(name = "STATUS_CLIENTE", nullable = false)
    private int      status;

    @Column(name = "DATA_CRIACAO_CLIENTE", nullable = true)
    private long     dataCriacao;

    @Column(name = "ID_OPERADOR", nullable = false)
    private Integer  operadorCriador;

    /*
     * Função construtora
     */

    public Cliente()
    {

        endereco = new Endereco();
    }

    /*
     * Métodos de acesso
     */

    /**
     * Método get para idCliente
     *
     * @return idCliente
     */

    public int getIdCliente()
    {
        return idCliente;
    }

    /**
     * Método set para idCliente
     *
     * @param idCliente
     */
    public void setIdCliente(int idCliente)
    {
        this.idCliente = idCliente;
    }

    /**
     * Método get para nome
     *
     * @return nome
     */
    @Override

    public String getNome()
    {
        return nome;
    }

    /**
     * Método set para nome
     *
     * @param nome
     */
    @Override
    public void setNome(String nome)
    {
        this.nome = nome;
    }

    /**
     * Método get para sobrenome
     *
     * @return sobrenome
     */
    @Override

    public String getSobrenome()
    {
        return sobrenome;
    }

    /**
     * Método set para sobrenome
     *
     * @param sobrenome
     */
    @Override
    public void setSobrenome(String sobrenome)
    {
        this.sobrenome = sobrenome;
    }

    /**
     * Método get para telefone
     *
     * @return telefone
     */
    @Override

    public String getTelefone()
    {
        return telefone;
    }

    /**
     * Método set para telefone
     *
     * @param telefone
     */
    @Override
    public void setTelefone(String telefone)
    {
        this.telefone = telefone;
    }

    /**
     * Método get para celular
     *
     * @return celular
     */
    @Override

    public String getCelular()
    {
        return celular;
    }

    /**
     * Método set para celular
     *
     * @param celular
     */
    @Override
    public void setCelular(String celular)
    {
        this.celular = celular;
    }

    /**
     * Método get para cpf
     *
     * @return cpf
     */
    @Override

    public String getCpf()
    {
        return cpf;
    }

    /**
     * Método set para cpf
     *
     * @param cpf
     */
    @Override
    public void setCpf(String cpf)
    {
        this.cpf = cpf;
    }

    /**
     * Método get para endereco
     *
     * @return endereco
     */
    @Override

    public Endereco getEndereco()
    {
        return endereco;
    }

    /**
     * Método set para endereco
     *
     * @param endereco
     */
    @Override
    public void setEndereco(Endereco endereco)
    {
        this.endereco = endereco;
    }

    /**
     * Método get para status
     *
     * @return status
     */
    @Override

    public int getStatus()
    {
        return status;
    }

    /**
     * Métodoset para status
     *
     * @param status
     */
    @Override
    public void setStatus(int status)
    {
        this.status = status;
    }

    /**
     * Método get para quantidadeCupom
     *
     * @return quantidadeCupom
     */

    /**
     * @return the operadorCriador
     */
    public Integer getOperadorCriador()
    {
        return operadorCriador;
    }

    /**
     * @param pOperadorCriador
     *            the operadorCriador to set
     */
    public void setOperadorCriador(Integer pOperadorCriador)
    {
        operadorCriador = pOperadorCriador;
    }

    public long getDataNascimento()
    {
        return dataNascimento;
    }

    public void setDataNascimento(long pDataNascimento)
    {
        dataNascimento = pDataNascimento;
    }

    public long getDataCriacao()
    {
        return dataCriacao;
    }

    public void setDataCriacao(long pDataCriacao)
    {
        dataCriacao = pDataCriacao;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String pEmail)
    {
        email = pEmail;
    }

    @Override
    public String toString()
    {
        return "Cliente [idCliente=" + idCliente + ", nome=" + nome + ", sobrenome=" + sobrenome + ", telefone=" + telefone + ", celular=" + celular
                        + ", cpf=" + cpf + ", endereco=" + endereco + ", status=" + status + "]";
    }

}
