package br.com.alugueservice.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity(name = "TBL_OPERADOR")
public class Operador implements IPessoa
{

    /*
     * Variáveis de instância
     */



    @SequenceGenerator(name = "ID_OPERADOR_SEQUENCIA", sequenceName = "ID_OPERADOR_SEQ", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_OPERADOR_SEQUENCIA")
    @Column(name = "ID_OPERADOR")
    private int      idOperador;

    @Column(name = "NOME_OPERADOR", nullable = false)
    private String   nome;

    @Column(name = "SOBRENOME_OPERADOR", nullable = false)
    private String   sobrenome;

    @Column(name = "CPF_OPERADOR", nullable = false)
    private String   cpf;

    @Column(name = "DATA_NASCIMENTO_OPERADOR", nullable = false)
    private long     dataNascimento;

    @Column(name = "EMAIL_OPERADOR", nullable = false)
    private String   email;

    @Column(name = "TELEFONE_OPERADOR")
    private String   telefone;

    @Column(name = "CELULAR_OPERADOR")
    private String   celular;

    @Embedded
    private Endereco endereco;

    @Column(name = "STATUS_OPERADOR", nullable = false)
    private int      status;

    @Column(name = "LOGIN_OPERADOR", nullable = false)
    private String   login;

    @Column(name = "SENHA_OPERADOR", nullable = false)
    private String   senha;

    @Column(name = "NIVEL_OPERADOR", nullable = false)
    private int      nivel;

    @Column(name = "DATA_CRIACAO_OPERADOR", nullable = false)
    private long     dataCriacao;


    @Column(name = "ID_OPERADOR_CRIADOR")
    private Integer operadorCriador;

    /*
     * Função construtora
     */

    public Operador()
    {

    }

    /*
     * Métodos de acesso
     */

    /**
     * Método get para idOperador
     *
     * @return idOperador
     */

    public int getIdOperador()
    {
        return idOperador;
    }

    /**
     * Método set para idOperador
     *
     * @param idOperador
     */
    public void setIdOperador(int idOperador)
    {
        this.idOperador = idOperador;
    }

    /**
     * Método get para senha
     *
     * @return senha
     */

    public String getSenha()
    {
        return senha;
    }

    /**
     * Método set para senha
     *
     * @param senha
     */
    public void setSenha(String senha)
    {
        this.senha = senha;
    }

    /**
     * Método get para nivel
     *
     * @return nivel
     */

    public int getNivel()
    {
        return nivel;
    }

    /**
     * Método set para nivel
     *
     * @param nivel
     */
    public void setNivel(int nivel)
    {
        this.nivel = nivel;
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
     * Método set para status
     *
     * @param status
     */
    @Override
    public void setStatus(int status)
    {
        this.status = status;
    }

    /**
     * @return the dataNascimento
     */
    public long getDataNascimento()
    {
        return dataNascimento;
    }

    /**
     * @param pDataNascimento the dataNascimento to set
     */
    public void setDataNascimento(long pDataNascimento)
    {
        dataNascimento = pDataNascimento;
    }

    /**
     * @return the email
     */
    public String getEmail()
    {
        return email;
    }

    /**
     * @param pEmail the email to set
     */
    public void setEmail(String pEmail)
    {
        email = pEmail;
    }

    /**
     * @return the login
     */
    public String getLogin()
    {
        return login;
    }

    /**
     * @param pLogin the login to set
     */
    public void setLogin(String pLogin)
    {
        login = pLogin;
    }

    /**
     * @return the dataCriacao
     */
    public long getDataCriacao()
    {
        return dataCriacao;
    }

    /**
     * @param pDataCriacao the dataCriacao to set
     */
    public void setDataCriacao(long pDataCriacao)
    {
        dataCriacao = pDataCriacao;
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
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + idOperador;
        return result;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Operador other = (Operador) obj;
        if (idOperador != other.idOperador)
            return false;
        return true;
    }

}
