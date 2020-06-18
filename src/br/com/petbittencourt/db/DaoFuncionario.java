package br.com.petbittencourt.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.petbittencourt.beans.Cargo;
import br.com.petbittencourt.beans.Funcionario;
import br.com.petbittencourt.controller.ControllerCargo;
import br.com.petbittencourt.util.ConexaoDB;

public class DaoFuncionario {
	private final Connection conexao;
	
	public DaoFuncionario() throws ClassNotFoundException, SQLException {
		
		this.conexao = new ConexaoDB().getConnection();
	}
	
	public Funcionario busca(Funcionario funcionario) throws SQLException {
    	
		String sql = "SELECT * FROM funcionarios WHERE id = ?";
    	
    	PreparedStatement statement = this.conexao.prepareStatement(sql);
    	
    	statement.setInt(1, funcionario.getId());
    	
    	ResultSet resultado = statement.executeQuery();
    		    	
    	
    	while(resultado.next()) {
    		funcionario.setId(resultado.getInt(1));
    		funcionario.setNome(resultado.getString(2));
    		funcionario.setSalario(resultado.getDouble(3));
    		funcionario.setIdCargo(resultado.getInt(4));
    	}
    	
    	statement.close();
    	conexao.close();
    	
    	return funcionario;
 			
	}

	public Funcionario altera(Funcionario funcionario) throws SQLException {
		
		String sql = "UPDATE funcionarios SET nome = ?, salario = ?, id_cargo = ? WHERE id = ?";
		
    	
    	PreparedStatement statement = this.conexao.prepareStatement(sql);
    	
    	statement.setString(1, funcionario.getNome());
    	statement.setDouble(2, funcionario.getSalario());
    	statement.setInt(3, funcionario.getIdCargo());
    	statement.setInt(4, funcionario.getId());
    	
    	statement.execute();
    	statement.close();
    	conexao.close();
    	    	   	
    	return funcionario;
	}
	
	public Funcionario excluir(Funcionario funcionario) throws SQLException {
		
		String sql = "DELETE FROM funcionarios WHERE id = ?";
    	
    	PreparedStatement statement = this.conexao.prepareStatement(sql);
    	
    	statement.setInt(1, funcionario.getId());
    	
    	statement.execute();
    	statement.close();
    	conexao.close();
    	  	
    	
    	
		
		return funcionario;
	}

	public Funcionario insere(Funcionario funcionario) throws SQLException {
		
		String sql = "INSERT INTO funcionarios (nome,salario,id_cargo) values (?, ?, ?)";
    	
    	PreparedStatement statement = this.conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
    	
    	statement.setString(1,funcionario.getNome());
    	statement.setDouble(2, funcionario.getSalario());
    	statement.setInt(3, funcionario.getIdCargo());
    	
    	
    	statement.executeUpdate();
    	
    	ResultSet resultado = statement.getGeneratedKeys();
    	
    	if(resultado.next()) {
    		int id = resultado.getInt(1);
    		funcionario.setId(id);
    		
    	}
    	
    	statement.close();
    	conexao.close();
    	    	
		return funcionario;
	}

	public List<Funcionario> lista() throws SQLException, ClassNotFoundException{
		
		List<Funcionario> funcionarios = new ArrayList<>();
    	
    	String sql = "SELECT * FROM funcionarios";
    	
    	PreparedStatement statement = this.conexao.prepareStatement(sql);
    	
    	    	
    	ResultSet resultado = statement.executeQuery();
    	
    	
    	while(resultado.next()) {
    		Funcionario funcionario = new Funcionario (resultado.getInt(1), resultado.getString(2), resultado.getDouble(3), resultado.getInt(4));
    		
    		Cargo cargo = new Cargo(funcionario.getIdCargo(),"","");
    		ControllerCargo cca = new ControllerCargo();   		
    		funcionario.setCargo(cca.buscaCargoPorId(cargo));
    		
    		funcionarios.add(funcionario);
    	}
    	
    	resultado.close();
    	statement.close();
    	conexao.close();
		
		return funcionarios;
	}


}
