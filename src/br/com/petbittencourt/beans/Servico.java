package br.com.petbittencourt.beans;

public class Servico {
		
	private int id;
	private String nome;
	private double preco;
	private int idFuncionario;
	private Funcionario funcionario;
	

	public Servico(int id, String nome, double preco, int idFuncionario) {
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.idFuncionario = idFuncionario;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public double getPreco() {
		return preco;
	}
	
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdFuncionario() {
		return idFuncionario;
	}

	public void setIdFuncionario(int idFuncionario) {
		this.idFuncionario = idFuncionario;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}



	
	
}
