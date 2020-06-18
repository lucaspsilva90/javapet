package br.com.petbittencourt.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.petbittencourt.beans.Funcionario;
import br.com.petbittencourt.db.DaoFuncionario;

public class ControllerFuncionario {
	
	public static DaoFuncionario daoFuncionario;
	public static ControllerCargo controllerCargo;
	
	public Funcionario buscaPorId(Funcionario funcionario) throws ClassNotFoundException, SQLException {
		
		daoFuncionario = new DaoFuncionario();		
		funcionario = daoFuncionario.busca(funcionario);			
		return funcionario;
	}
	
	public Funcionario alteraFuncionario (Funcionario funcionario) throws ClassNotFoundException, SQLException {
		daoFuncionario = new DaoFuncionario();
		return daoFuncionario.altera(funcionario);
	}
	
	public Funcionario excluiFuncionario(Funcionario funcionario) throws SQLException, ClassNotFoundException {
		daoFuncionario = new DaoFuncionario();
		return daoFuncionario.excluir(funcionario);
	}
	
	public Funcionario insereFuncionario(Funcionario funcionario) throws ClassNotFoundException, SQLException {
		daoFuncionario = new DaoFuncionario();
		return daoFuncionario.insere(funcionario);
	}
	
	public List<Funcionario> listaFuncionario() throws ClassNotFoundException, SQLException {
		List<Funcionario> listaFuncionarios = new ArrayList<Funcionario>();
		daoFuncionario = new DaoFuncionario();
	
		listaFuncionarios = daoFuncionario.lista();
		return listaFuncionarios;
	}
}
