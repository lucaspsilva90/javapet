<%@page import="br.com.petbittencourt.controller.ControllerHistoricoServico"%>
<%@page import="br.com.petbittencourt.beans.HistoricoServico"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
  
<%  
 int idPet = Integer.parseInt(request.getParameter("idPet"));
 int idServico = Integer.parseInt(request.getParameter("idServico"));
 String obs = request.getParameter("obs");
 
 System.out.println(idPet);
 System.out.println(idServico);
 
 ControllerHistoricoServico chs = new ControllerHistoricoServico();
 HistoricoServico historico = new HistoricoServico(0,idPet,idServico,obs);

 chs.insereHistorico(historico);
 response.sendRedirect("http://localhost:8080/pet/crud-historico/historico.jsp");
%>  