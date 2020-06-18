<%@page import="br.com.petbittencourt.controller.ControllerFuncionario"%>
<%@page import="br.com.petbittencourt.beans.Funcionario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    int id = Integer.parseInt(request.getParameter("id"));
    Funcionario funcionario = new Funcionario(id,"",0,0);
    ControllerFuncionario cf = new ControllerFuncionario();
    cf.excluiFuncionario(funcionario);
    
    response.sendRedirect("http://localhost:8080/pet/crud-funcionarios/funcionarios.jsp");
%>