<%@page import="br.com.petbittencourt.controller.ControllerCliente"%>
<%@page import="br.com.petbittencourt.beans.Cliente"%>


<%
    int id = Integer.parseInt(request.getParameter("id"));
    String nome = request.getParameter("nome");
    String email = request.getParameter("email");

    Cliente cliente = new Cliente(id,nome,email);
    ControllerCliente cc = new ControllerCliente();
    cc.alteraCliente(cliente);
    
    response.sendRedirect("http://localhost:8080/pet/crud-cliente/clientes.jsp");
%>