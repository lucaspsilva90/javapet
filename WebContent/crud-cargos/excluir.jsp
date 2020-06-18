<%@page import="br.com.petbittencourt.controller.ControllerCargo"%>
<%@page import="br.com.petbittencourt.beans.Cargo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    int id = Integer.parseInt(request.getParameter("id"));
    Cargo cargo = new Cargo(id,"","");
    ControllerCargo cca = new ControllerCargo();
    cca.excluiCargo(cargo);
    
    response.sendRedirect("http://localhost:8080/pet/crud-cargos/cargos.jsp");
%>