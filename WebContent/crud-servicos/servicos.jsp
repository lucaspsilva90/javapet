<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../parts/head-crud.jsp"%>

<%@page import="br.com.petbittencourt.controller.ControllerServico"%>
<%@page import="br.com.petbittencourt.beans.Servico"%>
<%@page import="java.util.List"%>


<%
	
	ControllerServico cs = new ControllerServico();
	List<Servico> servicos = cs.listaServico();
%>
  <body>
    <%@include file="../parts/nav.jsp"%>

    <main>
    <div class="container">
      <h3 class="center">Lista de Serviços</h3>
      <a href="./form-criar.jsp" class="waves-effect waves-light yellow lighten-5 black-text btn"><i class="material-icons left">add</i>Adicionar Serviço</a>
      <table class="striped">
        <thead>
          <tr>
              <th>ID</th>
              <th>Nome</th>
              <th>Preço</th>
              <th>Profissional</th>
              <th>Editar</th>
              <th>Excluir</th>
          </tr>
        </thead>
		
		<% if (!(servicos.isEmpty())) { %>
        <tbody>
        	<% for (Servico servico: servicos) { %>
          <tr>
            <td><%=servico.getId()%></td>
            <td><%=servico.getNome()%></td>
            <td><%=servico.getPreco()%></td>
            <td><%=servico.getFuncionario().getNome()%></td>
            <td><a href="form-editar.jsp?<%="id=" + servico.getId() %>"  class="btn-floating btn-large waves-effect waves-light"><i class="material-icons">mode_edit</i></a></td>
            <td><a href="excluir.jsp?<%="id=" + servico.getId() %>" class="btn-floating btn-large waves-effect waves-light red"><i class="material-icons">delete</i></a></td>
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