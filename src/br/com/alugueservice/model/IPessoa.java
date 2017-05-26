package br.com.alugueservice.model;

public abstract interface IPessoa {

	public void setNome(String Nome);

	public String getNome();

	public void setSobrenome(String Sobrenome);

	public String getSobrenome();

	public void setTelefone(String Telefone);

	public String getTelefone();

	public void setCelular(String Celular);

	public String getCelular();

	public void setCpf(String Cpf);

	public String getCpf();

	public void setEndereco(Endereco Endereco);

	public Endereco getEndereco();

	void setStatus(int status);

	int getStatus();

}
