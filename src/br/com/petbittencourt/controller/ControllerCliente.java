package br.com.petbittencourt.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.petbittencourt.beans.Cliente;
import br.com.petbittencourt.db.DaoCliente;

public class ControllerCliente {
	
	public static DaoCliente daoCliente;
	
	public Cliente buscaClientePorId(Cliente cliente) throws SQLException, ClassNotFoundException {
		daoCliente = new DaoCliente();
		return daoCliente.busca(cliente);
	}
		
    public Cliente insereCliente (Cliente cliente) throws SQLException, ClassNotFoundException {
        daoCliente = new DaoCliente();
        return daoCliente.insere(cliente);
    }
    
    public Cliente alteraCliente(Cliente cliente) throws ClassNotFoundException, SQLException {
    	daoCliente = new DaoCliente();
    	return daoCliente.altera(cliente);
    }
    
    public Cliente excluiCliente(Cliente cliente) throws ClassNotFoundException, SQLException {
    	daoCliente = new DaoCliente();
    	return daoCliente.exclui(cliente);
    }
    
    public List<Cliente> listaCliente() throws ClassNotFoundException, SQLException {
    	
    	List<Cliente> listaClientes = new ArrayList<Cliente>();
    	daoCliente = new DaoCliente();
    	listaClientes = daoCliente.lista();
    	
    	return listaClientes;
    }
    
}
