package br.com.petbittencourt.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.petbittencourt.beans.HistoricoServico;
import br.com.petbittencourt.db.DaoHistoricoServico;

public class ControllerHistoricoServico {
	
	public static DaoHistoricoServico daoHistoricoServico;
	public static ControllerServico controllerServico;
	public static ControllerPet controllerPet;
	
	public HistoricoServico buscaPorId(HistoricoServico historico) throws ClassNotFoundException, SQLException {
		daoHistoricoServico = new DaoHistoricoServico();		
		historico = daoHistoricoServico.busca(historico);		
		return historico;
	}
	
	public HistoricoServico insereHistorico(HistoricoServico historico) throws ClassNotFoundException, SQLException {
		daoHistoricoServico = new DaoHistoricoServico();
		return daoHistoricoServico.insere(historico);
	}
	
	public HistoricoServico alteraHistoricoServico(HistoricoServico historico) throws ClassNotFoundException, SQLException {
		daoHistoricoServico = new DaoHistoricoServico();
		return daoHistoricoServico.altera(historico);
	}
	
	public HistoricoServico excluiHistoricoServico(HistoricoServico historico) throws ClassNotFoundException, SQLException {
		daoHistoricoServico = new DaoHistoricoServico();
		return daoHistoricoServico.exclui(historico);
	}
	
	public List<HistoricoServico> listaHistoricoServico() throws ClassNotFoundException, SQLException{
		List<HistoricoServico> listaHistoricoServicos = new ArrayList<HistoricoServico>();
		daoHistoricoServico = new DaoHistoricoServico();
		listaHistoricoServicos = daoHistoricoServico.lista();		
		return listaHistoricoServicos;
		
	}
	
}
