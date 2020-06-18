<%@page import="br.com.petbittencourt.controller.ControllerCliente"%>
<%@page import="br.com.petbittencourt.beans.Cliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
  
<%  
 String nome = request.getParameter("nome");
 String email = request.getParameter("email");
 
 ControllerCliente cc = new ControllerCliente();
 Cliente cliente = new Cliente(0,nome,email);
 cc.insereCliente(cliente);
 response.sendRedirect("http://localhost:8080/pet/crud-cliente/clientes.jsp");
%>  