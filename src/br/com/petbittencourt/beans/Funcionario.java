package br.com.petbittencourt.beans;

public class Funcionario {
	
	private int id;
	private String nome;
	private double salario;
	private int idCargo;
	private Cargo cargo;
	
	
	public Funcionario(int id, String nome, double salario, int idCargo) {
		
		this.id = id;
		this.nome = nome;
		this.salario = salario;
		this.idCargo = idCargo;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public double getSalario() {
		return salario;
	}
	
	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public int getIdCargo() {
		return idCargo;
	}

	public void setIdCargo(int idCargo) {
		this.idCargo = idCargo;
	}
	
	
	
	
	
	
	
}
