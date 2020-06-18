package br.com.petbittencourt.teste;

import java.sql.SQLException;
import java.util.List;

import br.com.petbittencourt.beans.Cliente;
import br.com.petbittencourt.controller.ControllerCliente;

public class ClienteTeste {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		ControllerCliente controleCliente = new ControllerCliente();
		Cliente cliente = new Cliente(0, "Jabiraca", "jablinks@asdasaasd");
		
		controleCliente.insereCliente(cliente);
		
		List<Cliente> lista = controleCliente.listaCliente();
		
		System.out.println(lista);
		
			

	}
		
	
}

