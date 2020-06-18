<%@page import="br.com.petbittencourt.controller.ControllerCliente"%>
<%@page import="br.com.petbittencourt.beans.Cliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    int id = Integer.parseInt(request.getParameter("id"));
    Cliente cliente = new Cliente(id,"","");
    ControllerCliente cc = new ControllerCliente();
    cc.excluiCliente(cliente);
    
    response.sendRedirect("http://localhost:8080/pet/crud-cliente/clientes.jsp");
%>