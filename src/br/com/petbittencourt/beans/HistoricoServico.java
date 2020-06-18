package br.com.petbittencourt.beans;

public class HistoricoServico {
	
	private int id;
	private int idPet;
	private int idServico;
	private String data_servico;
	private String obs;
	private Pet pet;
	private Servico servico;

	public HistoricoServico(int id, int idPet, int idServico, String obs) {
		this.id = id;
		this.idPet = idPet;
		this.idServico = idServico;
		this.obs = obs;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getData_servico() {
		return data_servico;
	}
	
	public void setData_servico(String data_servico) {
		this.data_servico = data_servico;
	}
	
	public String getObs() {
		return obs;
	}
	
	public void setObs(String obs) {
		this.obs = obs;
	}


	public Pet getPet() {
		return pet;
	}


	public void setPet(Pet pet) {
		this.pet = pet;
	}


	public Servico getServico() {
		return servico;
	}


	public void setServico(Servico servico) {
		this.servico = servico;
	}


	public int getIdPet() {
		return idPet;
	}


	public void setIdPet(int idPet) {
		this.idPet = idPet;
	}


	public int getIdServico() {
		return idServico;
	}


	public void setIdServico(int idServico) {
		this.idServico = idServico;
	}


	
	
	
	
}
