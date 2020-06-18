<%@page import="br.com.petbittencourt.controller.ControllerFuncionario"%>
<%@page import="br.com.petbittencourt.beans.Funcionario"%>


<%
    int id = Integer.parseInt(request.getParameter("id"));
    String nome = request.getParameter("nome");
    double salario = Double.parseDouble(request.getParameter("salario"));
    int idCargo = Integer.parseInt(request.getParameter("idCargo"));

    Funcionario funcionario = new Funcionario(id,nome,salario,idCargo);
    ControllerFuncionario cf = new ControllerFuncionario();
    cf.alteraFuncionario(funcionario);
    
    response.sendRedirect("http://localhost:8080/pet/crud-funcionarios/funcionarios.jsp");
%>