package br.com.petbittencourt.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.petbittencourt.beans.Pet;
import br.com.petbittencourt.db.DaoPet;

public class ControllerPet {

	public static DaoPet daoPet;
	public static ControllerCliente controllerCliente;
	
	
	public Pet buscaPorId(Pet pet) throws ClassNotFoundException, SQLException {
		
		daoPet = new DaoPet();		
		pet = daoPet.busca(pet);
		return pet;		
	}
	
	public Pet inserePet(Pet pet) throws ClassNotFoundException, SQLException {
		daoPet = new DaoPet();
		return daoPet.insere(pet);
	}
	
	public Pet alteraPet(Pet pet) throws SQLException, ClassNotFoundException {
		daoPet = new DaoPet();
		return daoPet.altera(pet);
	}
	
	public Pet excluiPet(Pet pet) throws ClassNotFoundException, SQLException {
		daoPet = new DaoPet();
		return daoPet.exclui(pet);
	}
	
	public List<Pet> listaPet() throws ClassNotFoundException, SQLException{
    	List<Pet> listaPets = new ArrayList<Pet>();
    	daoPet = new DaoPet();
    	listaPets = daoPet.lista();
    	return listaPets;
	}
}
