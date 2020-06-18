package br.com.petbittencourt.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.petbittencourt.beans.Funcionario;
import br.com.petbittencourt.beans.Servico;
import br.com.petbittencourt.controller.ControllerFuncionario;
import br.com.petbittencourt.util.ConexaoDB;

public class DaoServico {
	
	private final Connection conexao;
	
	public DaoServico() throws ClassNotFoundException, SQLException {
		this.conexao = new ConexaoDB().getConnection();
	}
	
	public Servico busca(Servico servico) throws SQLException {
		
		String sql = "SELECT * FROM servicos WHERE id = ?";
    	
    	PreparedStatement statement = this.conexao.prepareStatement(sql);
    	
    	statement.setInt(1, servico.getId());
    	
    	ResultSet resultado = statement.executeQuery();
    	
    	while(resultado.next()) {
    		
    		servico.setId(resultado.getInt(1));
    		servico.setNome(resultado.getString(2));
    		servico.setPreco(resultado.getDouble(3));
    		servico.setIdFuncionario(resultado.getInt(4));
    	}
    	
    	statement.close();
    	conexao.close();
    	
    			
		return servico;
	}
	
	public Servico altera(Servico servico) throws SQLException {
		
		String sql = "UPDATE servicos SET nome = ?, preco = ?, realizado_por = ? WHERE id = ?";
    	
    	PreparedStatement statement = this.conexao.prepareStatement(sql);
    	
    	statement.setString(1, servico.getNome());
    	statement.setDouble(2, servico.getPreco());
    	statement.setInt(3, servico.getIdFuncionario());
    	statement.setInt(4, servico.getId());
    	
    	statement.execute();
    	statement.close();
    	conexao.close();
    	    	   	
    	return servico;
	}
	
	public Servico exclui(Servico servico) throws SQLException {
		
		String sql = "DELETE FROM servicos WHERE id = ?";
    	
    	PreparedStatement statement = this.conexao.prepareStatement(sql);
    	
    	statement.setInt(1, servico.getId());
    	
    	statement.execute();
    	statement.close();
    	conexao.close();
    	  	
    	
    	return servico;
	}

	public Servico insere(Servico servico) throws SQLException {
		
		String sql = "INSERT INTO servicos (nome,preco, realizado_por) values (?, ?, ?)";
    	
    	PreparedStatement statement = this.conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
    	
    	statement.setString(1, servico.getNome());
    	statement.setDouble(2, servico.getPreco());
    	statement.setInt(3, servico.getIdFuncionario());
    	
    	statement.executeUpdate();
    	ResultSet resultado = statement.getGeneratedKeys();
    	
    	if(resultado.next()) {
    		int id = resultado.getInt(1);
    		servico.setId(id);
    		
    	}
    	
    	statement.close();
    	conexao.close();
    	
    	return servico;
	}

	public List<Servico> lista() throws SQLException, ClassNotFoundException{
		
		List<Servico> servicos = new ArrayList<>();
				   	
    	String sql = "SELECT * FROM servicos";
    	
    	PreparedStatement statement = this.conexao.prepareStatement(sql);
    	    	   	
    	ResultSet resultado = statement.executeQuery();
    	
    	
    	while(resultado.next()) {
    		Servico servico = new Servico (resultado.getInt(1), resultado.getString(2), resultado.getDouble(3), resultado.getInt(4));
    		    		
    		Funcionario funcionario = new Funcionario(servico.getIdFuncionario(),"",0,0);
    		ControllerFuncionario cf = new ControllerFuncionario();   		
    		servico.setFuncionario(cf.buscaPorId(funcionario));
    		
    		servicos.add(servico);
    	}
    	
    	resultado.close();
    	statement.close();
    	conexao.close();
    	
    	return servicos;
    	
		
		
	}
}
