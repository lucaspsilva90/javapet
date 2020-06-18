package br.com.petbittencourt.db;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import br.com.petbittencourt.beans.Cliente;
import br.com.petbittencourt.util.ConexaoDB;
import java.sql.Statement;


public class DaoCliente {
	
	private final Connection conexao;
	
	public DaoCliente() throws SQLException, ClassNotFoundException {
		
		this.conexao = new ConexaoDB().getConnection();
		
	}
	
	//busca por id
    public Cliente busca(Cliente cliente) throws SQLException{
    	
    	String sql = "SELECT * FROM cliente WHERE id = ?";
    	
    	PreparedStatement statement = this.conexao.prepareStatement(sql);
    	
    	statement.setInt(1, cliente.getId());
    	
    	ResultSet resultado = statement.executeQuery();
    	
    	   	    	   	
    	while(resultado.next()) {
    		cliente.setId(resultado.getInt(1));
    		cliente.setNome(resultado.getString(2));
    		cliente.setEmail(resultado.getString(3));
    		
    	}
    	
    	statement.close();
    	conexao.close();
    	
    	return cliente;
    }
    
    //update por id
    
    public Cliente altera(Cliente cliente) throws SQLException {
    	
    	String sql = "UPDATE cliente SET nome = ?, email = ? WHERE id = ?";
    	
    	PreparedStatement statement = this.conexao.prepareStatement(sql);
    	
    	statement.setString(1, cliente.getNome());
    	statement.setString(2, cliente.getEmail());
    	statement.setInt(3, cliente.getId());
    	
    	statement.execute();
    	statement.close();
    	conexao.close();
    	    	   	
    	return cliente;
    	
    	
    }
    
    public Cliente exclui(Cliente cliente) throws SQLException {
		
    	String sql = "DELETE FROM cliente WHERE id = ?";
    	
    	PreparedStatement statement = this.conexao.prepareStatement(sql);
    	
    	statement.setInt(1, cliente.getId());
    	
    	statement.execute();
    	statement.close();
    	conexao.close();
    	  	
    	
    	return cliente;
    	
    }
    
    public Cliente insere(Cliente cliente) throws SQLException {
    	
    	String sql = "INSERT INTO cliente (nome,email) values (?, ?)";
    	
    	PreparedStatement statement = this.conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
    	
    	statement.setString(1,cliente.getNome());
    	statement.setString(2, cliente.getEmail());
    	
    	statement.executeUpdate();
    	ResultSet resultado = statement.getGeneratedKeys();
    	
    	
    	
    	if(resultado.next()) {
    		int id = resultado.getInt(1);
    		cliente.setId(id);
    		
    	}
    	
    	statement.close();
    	conexao.close();
    	
    	return cliente;
    	
    	
    }
    
    public List<Cliente> lista() throws SQLException {
    	
    	List<Cliente> clientes = new ArrayList<>();
    	
    	String sql = "SELECT * FROM cliente";
    	
    	PreparedStatement statement = this.conexao.prepareStatement(sql);
    	
    	   	
    	ResultSet resultado = statement.executeQuery();
    	
    	
    	while(resultado.next()) {
    		Cliente cliente = new Cliente (resultado.getInt(1), resultado.getString(2), resultado.getString(3));
    		clientes.add(cliente);
    	}
    	
    	resultado.close();
    	statement.close();
    	conexao.close();
    	
    	return clientes;
    }
    
}
