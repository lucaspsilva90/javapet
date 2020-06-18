<%@page import="br.com.petbittencourt.controller.ControllerServico"%>
<%@page import="br.com.petbittencourt.beans.Servico"%>


<%
    int id = Integer.parseInt(request.getParameter("id"));
    String nome = request.getParameter("nome");
    double preco = Double.parseDouble(request.getParameter("preco"));
    int idFuncionario = Integer.parseInt(request.getParameter("idFuncionario"));

    Servico servico = new Servico(id,nome,preco,idFuncionario);
    ControllerServico cs = new ControllerServico();
    cs.alteraServico(servico);
    response.sendRedirect("http://localhost:8080/pet/crud-servicos/servicos.jsp");
%>