<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../parts/head-crud.jsp"%>

<%@page import="br.com.petbittencourt.controller.ControllerHistoricoServico"%>
<%@page import="br.com.petbittencourt.beans.HistoricoServico"%>
<%@page import="java.util.List"%>


<%
	
	ControllerHistoricoServico chs = new ControllerHistoricoServico();
	List<HistoricoServico> historicos= chs.listaHistoricoServico();
%>
  <body>
    <%@include file="../parts/nav.jsp"%>

    <main>
    <div class="container">
      <h3 class="center">Histórico de Serviços</h3>
      <a href="./form-criar.jsp" class="waves-effect waves-light yellow lighten-5 black-text btn"><i class="material-icons left">add</i>Adicionar Histórico</a>
      <table class="striped">
        <thead>
          <tr>
              <th>ID</th>
              <th>Pet</th>
              <th>Servico</th>
              <th>Preço</th>
              <th>Proprietário</th>
              <th>Realizado por</th>
              <th>Observação</th>
              <th>Editar</th>
              <th>Excluir</th>
          </tr>
        </thead>
		
		<% if (!(historicos.isEmpty())) { %>
        <tbody>
        	<% for (HistoricoServico historico: historicos) { %>
          <tr>
            <td><%=historico.getId()%></td>
            <td><%=historico.getPet().getNome()%></td>
            <td><%=historico.getServico().getNome()%></td>
            <td><%=historico.getServico().getPreco() %></td>
            <td><%=historico.getPet().getCliente().getNome() %></td>
            <td><%=historico.getServico().getFuncionario().getNome()%></td>
            <td><%=historico.getObs()%></td>
            <td><a href="form-editar.jsp?<%="id=" + historico.getId() %>"  class="btn-floating btn-large waves-effect waves-light"><i class="material-icons">mode_edit</i></a></td>
            <td><a href="excluir.jsp?<%="id=" + historico.getId() %>" class="btn-floating btn-large waves-effect waves-light red"><i class="material-icons">delete</i></a></td>
            <% } %>
          </tr>
          	<% } %>

        </tbody>
    </table>
    </div>
    </main>
    
    <%@include file="../parts/footer.jsp"%> 
    <script type="text/javascript" src="../js/materialize.min.js"></script>
  </body>
</html>