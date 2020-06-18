package br.com.petbittencourt.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.petbittencourt.beans.Cliente;
import br.com.petbittencourt.beans.Pet;
import br.com.petbittencourt.controller.ControllerCliente;
import br.com.petbittencourt.util.ConexaoDB;

public class DaoPet {
	
	private final Connection conexao;
	
	public DaoPet() throws ClassNotFoundException, SQLException {
		this.conexao = new ConexaoDB().getConnection();
	}
	
	
	public Pet busca(Pet pet) throws SQLException {
		
		String sql = "SELECT * FROM pets WHERE id = ?";
		
		PreparedStatement statement = this.conexao.prepareStatement(sql);
		
		statement.setInt(1, pet.getId());
    	
    	ResultSet resultado = statement.executeQuery();
		
    	while(resultado.next()) {
    		pet.setId(resultado.getInt(1));
    		pet.setNome(resultado.getString(2));
    		pet.setData_nascimento(resultado.getString(3));
    		pet.setIdCliente(resultado.getInt(4));
    	}
		
    	statement.close();
    	conexao.close();
		
    	return pet;
		
	}

	public Pet altera(Pet pet) throws SQLException {
		
    	String sql = "UPDATE pets SET nome = ?, data_nascimento = ?, id_cliente= ? WHERE id = ?";
    	
    	PreparedStatement statement = this.conexao.prepareStatement(sql);
    	
    	statement.setString(1, pet.getNome());
    	statement.setString(2, pet.getData_nascimento());
    	statement.setInt(3,  pet.getIdCliente());
    	statement.setInt(4, pet.getId());
    	
    	
    	statement.execute();
    	statement.close();
    	conexao.close();
    	    	   	
    	return pet;
	}
	
	public Pet exclui(Pet pet) throws SQLException {
		
		String sql = "DELETE FROM pets WHERE id = ?";
    	
    	PreparedStatement statement = this.conexao.prepareStatement(sql);
    	
    	statement.setInt(1, pet.getId());
    	
    	statement.execute();
    	statement.close();
    	conexao.close();
    	  	
    	
    	return pet;
	}
	
	public Pet insere(Pet pet) throws SQLException {
		
		String sql = "INSERT INTO pets (nome, data_nascimento, id_cliente) values (?, ? , ?)";
    	
    	PreparedStatement statement = this.conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
    	
    	statement.setString(1,pet.getNome());
    	statement.setString(2, pet.getData_nascimento());
    	statement.setInt(3,pet.getIdCliente());
    	
    	statement.executeUpdate();
    	ResultSet resultado = statement.getGeneratedKeys();
    	
    	if(resultado.next()) {
    		int id = resultado.getInt(1);
    		pet.setId(id);
    		
    	}
    	
    	statement.close();
    	conexao.close();
    	
    	return pet;
	}

	public List<Pet> lista() throws SQLException, ClassNotFoundException{
    	
		List<Pet> pets = new ArrayList<>();
    	
    	String sql = "SELECT * FROM pets";
    	
    	PreparedStatement statement = this.conexao.prepareStatement(sql);
  
    	    	
    	ResultSet resultado = statement.executeQuery();
    	
    	
    	
    	while(resultado.next()) {
    		Pet pet = new Pet (resultado.getInt(1), resultado.getString(2), resultado.getString(3), resultado.getInt(4));
    		Cliente cliente = new Cliente(pet.getIdCliente(),"","");
    		ControllerCliente cc = new ControllerCliente();   		
    		pet.setCliente(cc.buscaClientePorId(cliente));
    		pets.add(pet);
    	}
    	
    	resultado.close();
    	statement.close();
    	conexao.close();
    	
    	return pets;
    }

}
