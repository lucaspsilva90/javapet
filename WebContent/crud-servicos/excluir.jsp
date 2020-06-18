<%@page import="br.com.petbittencourt.controller.ControllerServico"%>
<%@page import="br.com.petbittencourt.beans.Servico"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    int id = Integer.parseInt(request.getParameter("id"));
    Servico servico = new Servico(id,"",0,0);
    ControllerServico cs = new ControllerServico();
    cs.excluiServico(servico);
    
    response.sendRedirect("http://localhost:8080/pet/crud-servicos/servicos.jsp");
%>