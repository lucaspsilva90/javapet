<%@page import="br.com.petbittencourt.controller.ControllerCargo"%>
<%@page import="br.com.petbittencourt.beans.Cargo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
  
<%  
 String nome = request.getParameter("nome");
 String descricao = request.getParameter("descricao");
 
 ControllerCargo cca = new ControllerCargo();
 Cargo cargo = new Cargo(0,nome,descricao);
 cca.insereCargo(cargo);
 response.sendRedirect("http://localhost:8080/pet/crud-cargos/cargos.jsp");
%>  