package br.com.petbittencourt.beans;


public class Pet {
	
	private int id;
	private String nome;
	private String data_nascimento;
	private int idCliente;
	private Cliente cliente;
	
	
	public Pet(int id, String nome, String data_nascimento, int idCliente) {
		
		this.id = id;
		this.nome = nome;
		this.data_nascimento = data_nascimento;
		this.idCliente = idCliente;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getId() {
		return id;
	}
	
	public String getData_nascimento() {
		return data_nascimento;
	}
	public void setData_nascimento(String data_nascimento) {
		this.data_nascimento = data_nascimento;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	
	
}
