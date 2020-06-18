package br.com.petbittencourt.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.petbittencourt.beans.Cargo;
import br.com.petbittencourt.util.ConexaoDB;

public class DaoCargo {
	
	private final Connection conexao;
	
	public DaoCargo() throws ClassNotFoundException, SQLException {
		this.conexao = new ConexaoDB().getConnection();
	}
	
	public Cargo busca(Cargo cargo) throws SQLException {
		
		String sql = "SELECT * FROM cargos WHERE id = ?";
    	
    	PreparedStatement statement = this.conexao.prepareStatement(sql);
    	
    	statement.setInt(1, cargo.getId());
    	
    	ResultSet resultado = statement.executeQuery();
    	
    	while(resultado.next()) {
    		cargo.setId(resultado.getInt(1));
    		cargo.setNome(resultado.getString(2));
    		cargo.setDescricao(resultado.getString(3));
    		
    	}
    	
    	statement.close();
    	conexao.close();
    	
    	return cargo;
	}

	public Cargo altera(Cargo cargo) throws SQLException {
		
		String sql = "UPDATE cargos SET nome = ?, descricao = ? WHERE id = ?";
    	
    	PreparedStatement statement = this.conexao.prepareStatement(sql);
    	
    	statement.setString(1, cargo.getNome());
    	statement.setString(2, cargo.getDescricao());
    	statement.setInt(3, cargo.getId());
    	
    	statement.execute();
    	statement.close();
    	conexao.close();
    	    	   	
    	return cargo;
	}

	public Cargo exclui(Cargo cargo) throws SQLException {
		
		String sql = "DELETE FROM cargos WHERE id = ?";
    	
    	PreparedStatement statement = this.conexao.prepareStatement(sql);
    	
    	statement.setInt(1, cargo.getId());
    	
    	statement.execute();
    	statement.close();
    	conexao.close();
    	  	
    	
    	return cargo;
	}

	public Cargo insere(Cargo cargo) throws SQLException {
    	String sql = "INSERT INTO cargos (nome,descricao) values (?, ?)";
    	
    	PreparedStatement statement = this.conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
    	
    	statement.setString(1,cargo.getNome());
    	statement.setString(2, cargo.getDescricao());
    	
    	statement.executeUpdate();
    	ResultSet resultado = statement.getGeneratedKeys();
    	
    	if(resultado.next()) {
    		int id = resultado.getInt(1);
    		cargo.setId(id);
    		
    	}
    	
    	statement.close();
    	conexao.close();
    	
    	return cargo ;
	}

	public List<Cargo> lista() throws SQLException{
		
		List<Cargo> cargos = new ArrayList<>();
    	
    	String sql = "SELECT * FROM cargos";
    	
    	PreparedStatement statement = this.conexao.prepareStatement(sql);
    	
    	    	
    	ResultSet resultado = statement.executeQuery();
    	
    	
    	while(resultado.next()) {
    		Cargo cargo = new Cargo (resultado.getInt(1), resultado.getString(2), resultado.getString(3));
    		cargos.add(cargo);
    	}
    	
    	resultado.close();
    	statement.close();
    	conexao.close();
    	
    	return cargos;
	}
	
}
