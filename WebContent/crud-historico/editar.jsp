<%@page import="br.com.petbittencourt.controller.ControllerHistoricoServico"%>
<%@page import="br.com.petbittencourt.beans.HistoricoServico"%>


<%
    int id = Integer.parseInt(request.getParameter("id"));
	int idPet = Integer.parseInt(request.getParameter("idPet"));
	int idServico = Integer.parseInt(request.getParameter("idServico"));
    String observacoes = request.getParameter("obs");

    HistoricoServico historico = new HistoricoServico(id,idPet,idServico,observacoes);
    ControllerHistoricoServico chs = new ControllerHistoricoServico();
    chs.alteraHistoricoServico(historico);
    response.sendRedirect("http://localhost:8080/pet/crud-historico/historico.jsp");
%>