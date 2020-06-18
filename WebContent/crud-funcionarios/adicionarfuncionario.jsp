<%@page import="br.com.petbittencourt.controller.ControllerFuncionario"%>
<%@page import="br.com.petbittencourt.beans.Funcionario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
  
<%  
 String nome = request.getParameter("nome");
 double salario = Double.parseDouble(request.getParameter("salario"));
 int id_cargo = Integer.parseInt(request.getParameter("idCargo"));
 
 System.out.println(id_cargo);	
 
 ControllerFuncionario cf = new ControllerFuncionario();
 Funcionario funcionario = new Funcionario(0,nome,salario,id_cargo);
 
 cf.insereFuncionario(funcionario);
 response.sendRedirect("http://localhost:8080/pet/crud-funcionarios/funcionarios.jsp");
%>  