package br.com.petbittencourt.beans;

public class Cargo {
	
	private int id;
	private String nome;
	private String descricao;
	
		
	public Cargo(int id, String nome, String descricao) {
		
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
		
	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}
	
	
}
