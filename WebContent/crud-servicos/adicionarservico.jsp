<%@page import="br.com.petbittencourt.controller.ControllerServico"%>
<%@page import="br.com.petbittencourt.beans.Servico"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
  
<%  
 String nome = request.getParameter("nome");
 double preco = Double.parseDouble(request.getParameter("preco"));
 int idFuncionario = Integer.parseInt(request.getParameter("idFuncionario"));
 
 ControllerServico cs = new ControllerServico();
 Servico servico = new Servico(0,nome,preco,idFuncionario);
 cs.insereServico(servico);
 response.sendRedirect("http://localhost:8080/pet/crud-servicos/servicos.jsp");
%>  