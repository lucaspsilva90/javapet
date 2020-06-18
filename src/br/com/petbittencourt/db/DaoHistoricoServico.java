package br.com.petbittencourt.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.petbittencourt.beans.Cargo;
import br.com.petbittencourt.beans.Cliente;
import br.com.petbittencourt.beans.Funcionario;
import br.com.petbittencourt.beans.HistoricoServico;
import br.com.petbittencourt.beans.Pet;
import br.com.petbittencourt.beans.Servico;
import br.com.petbittencourt.controller.ControllerCargo;
import br.com.petbittencourt.controller.ControllerCliente;
import br.com.petbittencourt.controller.ControllerFuncionario;
import br.com.petbittencourt.controller.ControllerPet;
import br.com.petbittencourt.controller.ControllerServico;
import br.com.petbittencourt.util.ConexaoDB;

public class DaoHistoricoServico {

	private final Connection conexao;
	
	public DaoHistoricoServico() throws ClassNotFoundException, SQLException {
		this.conexao = new ConexaoDB().getConnection();
	}
	
	public HistoricoServico busca(HistoricoServico historico) throws SQLException {
		
		String sql = "SELECT * FROM historico_servicos WHERE id = ?";
    	
    	PreparedStatement statement = this.conexao.prepareStatement(sql);
    
    	statement.setInt(1, historico.getId());
    	
    	ResultSet resultado = statement.executeQuery();
    	
    	   	   	    	   	
    	while(resultado.next()) {
    		
    		historico.setId(resultado.getInt(1));
    		historico.setIdPet(resultado.getInt(2));
    		historico.setIdServico(resultado.getInt(3));
    		historico.setData_servico(resultado.getString(4));
    		historico.setObs(resultado.getString(5));
    		   		
    	}
    	
    	statement.close();
    	conexao.close();
    	
    	return historico;
	}
	
	
	public HistoricoServico altera(HistoricoServico historico) throws SQLException {
		
    	String sql = "UPDATE historico_servicos SET id_pet = ? ,id_servico = ?, obs = ? WHERE id = ?";
    	
    	PreparedStatement statement = this.conexao.prepareStatement(sql);
    	
    	statement.setInt(1, historico.getIdPet());
    	statement.setInt(2, historico.getIdServico());
    	statement.setString(3, historico.getObs());
    	statement.setInt(4, historico.getId());
    	
    	statement.execute();
    	statement.close();
    	conexao.close();
   	
		return historico;
		

	}
	
	public HistoricoServico exclui(HistoricoServico historico) throws SQLException {
		
    	String sql = "DELETE FROM historico_servicos WHERE id = ?";
    	
    	PreparedStatement statement = this.conexao.prepareStatement(sql);
    	
    	statement.setInt(1, historico.getId());
    	
    	statement.execute();
    	statement.close();
    	conexao.close();
    	  	
    	
    	return historico;
	}
	
	
	public HistoricoServico insere(HistoricoServico historico) throws SQLException {
		
    	String sql = "INSERT INTO historico_servicos (id_pet, id_servico, data_servico, obs) VALUES (?, ?, NOW(), ?);";
    	
    	PreparedStatement statement = this.conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
    	
    	
    	statement.setInt(1, historico.getIdPet());
    	statement.setInt(2, historico.getIdServico());
    	statement.setString(3, historico.getObs());
    	
    	
    	statement.executeUpdate();
    	ResultSet resultado = statement.getGeneratedKeys();
    	
    	
    	
    	if(resultado.next()) {
    		int id = resultado.getInt(1);
    		historico.setId(id);
    		
    	}
    	
    	statement.close();
    	conexao.close();
    	
    	return historico;
    	
	}
	
	
	public List<HistoricoServico> lista() throws SQLException, ClassNotFoundException{
		
		List<HistoricoServico> historicos = new ArrayList<>();
    	
    	String sql = "SELECT * FROM historico_servicos";
    	
    	PreparedStatement statement = this.conexao.prepareStatement(sql);
    	
    	   	
    	ResultSet resultado = statement.executeQuery();
    	
    	
    	while(resultado.next()) {
    		HistoricoServico historico = new HistoricoServico (resultado.getInt(1), resultado.getInt(2), resultado.getInt(3), resultado.getString(5));
    		
    		//instanciando controllers
    		ControllerPet cp = new ControllerPet();
    		ControllerCliente cc = new ControllerCliente();
    		ControllerServico cs = new ControllerServico();
    		ControllerFuncionario cf = new ControllerFuncionario();
    		ControllerCargo cca = new ControllerCargo();
    		
    		//criando pet e seu respectivo cliente
    		Pet pet = new Pet(historico.getIdPet(),"","",0);
    		historico.setPet(cp.buscaPorId(pet));
    		Cliente cliente = new Cliente(historico.getPet().getIdCliente(),"","");
    		historico.getPet().setCliente(cc.buscaClientePorId(cliente));

    		//criando servico e seu respectivo funcionario
    		Servico servico = new Servico(historico.getIdServico(),"",0,0);
    		historico.setServico(cs.buscaPorId(servico));
    		Funcionario funcionario = new Funcionario(historico.getServico().getIdFuncionario(),"",0,0);
    		historico.getServico().setFuncionario(cf.buscaPorId(funcionario));
    	    Cargo cargo = new Cargo(historico.getServico().getFuncionario().getIdCargo(),"","");
    	    historico.getServico().getFuncionario().setCargo(cca.buscaCargoPorId(cargo));
    	    
    		
    		historicos.add(historico);
    	}
    	
    	resultado.close();
    	statement.close();
    	conexao.close();
    	
    	return historicos;
		
	}
}
