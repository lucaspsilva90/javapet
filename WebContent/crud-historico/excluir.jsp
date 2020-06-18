<%@page import="br.com.petbittencourt.controller.ControllerHistoricoServico"%>
<%@page import="br.com.petbittencourt.beans.HistoricoServico"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    int id = Integer.parseInt(request.getParameter("id"));
    HistoricoServico historico = new HistoricoServico(id,0,0,"");
    ControllerHistoricoServico chs = new ControllerHistoricoServico();
    chs.excluiHistoricoServico(historico);
    
    response.sendRedirect("http://localhost:8080/pet/crud-historico/historico.jsp");
%>