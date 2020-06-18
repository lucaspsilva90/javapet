package br.com.petbittencourt.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.petbittencourt.beans.Cargo;
import br.com.petbittencourt.db.DaoCargo;

public class ControllerCargo {

	public static DaoCargo daoCargo;
	
	public Cargo buscaCargoPorId(Cargo cargo) throws ClassNotFoundException, SQLException {
		daoCargo = new DaoCargo();
		return daoCargo.busca(cargo);
	}
	
	public Cargo insereCargo(Cargo cargo) throws ClassNotFoundException, SQLException {
		daoCargo = new DaoCargo();
		return daoCargo.insere(cargo);
	}
	
	public Cargo alteraCargo(Cargo cargo) throws ClassNotFoundException, SQLException {
		daoCargo = new DaoCargo();
		return daoCargo.altera(cargo);
	}
	
	public Cargo excluiCargo(Cargo cargo) throws ClassNotFoundException, SQLException {
		daoCargo = new DaoCargo();
		return daoCargo.exclui(cargo);
	}
	
	public List<Cargo> listaCargo() throws ClassNotFoundException, SQLException {
		List<Cargo> listaCargos = new ArrayList<Cargo>();
		daoCargo = new DaoCargo();
		listaCargos = daoCargo.lista();
		
		return listaCargos;
		
		
	}
}
