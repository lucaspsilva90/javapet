package br.com.petbittencourt.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.petbittencourt.beans.Funcionario;
import br.com.petbittencourt.beans.Servico;
import br.com.petbittencourt.db.DaoServico;

public class ControllerServico {

	public static DaoServico daoServico;
	public static ControllerFuncionario controllerFuncionario;
	
	
	public Servico buscaPorId(Servico servico) throws ClassNotFoundException, SQLException {
		daoServico = new DaoServico();
		servico = daoServico.busca(servico);
		
		Funcionario funcionario = new Funcionario(servico.getIdFuncionario(),"",0,0);
		servico.setFuncionario(funcionario);
		
		return servico;
	}
	
	public Servico insereServico(Servico servico) throws ClassNotFoundException, SQLException {
		daoServico = new DaoServico();
		return daoServico.insere(servico);
	}
	
	public Servico alteraServico(Servico servico) throws ClassNotFoundException, SQLException {
		daoServico = new DaoServico();
		return daoServico.altera(servico);
	}
	
	public Servico excluiServico(Servico servico) throws ClassNotFoundException, SQLException {
		daoServico = new DaoServico();
		return daoServico.exclui(servico);
	}
	
	public List<Servico> listaServico() throws ClassNotFoundException, SQLException {
		List<Servico> listaServicos = new ArrayList<Servico>();
		daoServico = new DaoServico();
	
		listaServicos = daoServico.lista();
		return listaServicos;
		
	}
	
}
