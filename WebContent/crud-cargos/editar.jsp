<%@page import="br.com.petbittencourt.controller.ControllerCargo"%>
<%@page import="br.com.petbittencourt.beans.Cargo"%>


<%
    int id = Integer.parseInt(request.getParameter("id"));
    String nome = request.getParameter("nome");
    String descricao = request.getParameter("descricao");

    Cargo cargo = new Cargo(id,nome,descricao);
    ControllerCargo cca = new ControllerCargo();
    cca.alteraCargo(cargo);
    
    response.sendRedirect("http://localhost:8080/pet/crud-cargos/cargos.jsp");
%>