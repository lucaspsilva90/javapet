<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../parts/head-crud.jsp"%>

<%@page import="br.com.petbittencourt.controller.ControllerCargo"%>
<%@page import="br.com.petbittencourt.beans.Cargo"%>
<%@page import="java.util.List"%>


<%
	
	ControllerCargo cca = new ControllerCargo();
	List<Cargo> cargos = cca.listaCargo();
%>
  <body>
    <%@include file="../parts/nav.jsp"%>

    <main>
    <div class="container">
      <h3 class="center">Lista de Cargos</h3>
      <a href="./form-criar.jsp" class="waves-effect waves-light yellow lighten-5 black-text btn"><i class="material-icons left">add</i>Adicionar Cargo</a>
      <table class="striped">
        <thead>
          <tr>
              <th>ID</th>
              <th>Nome</th>
              <th>Descrição</th>
              <th>Editar</th>
              <th>Excluir</th>
          </tr>
        </thead>
		
		<% if (!(cargos.isEmpty())) { %>
        <tbody>
        	<% for (Cargo cargo: cargos) { %>
          <tr>
            <td><%=cargo.getId()%></td>
            <td><%=cargo.getNome()%></td>
            <td><%=cargo.getDescricao()%></td>
            <td><a href="form-editar.jsp?<%="id=" + cargo.getId()%>"  class="btn-floating btn-large waves-effect waves-light"><i class="material-icons">mode_edit</i></a></td>
            <td><a href="excluir.jsp?<%="id=" + cargo.getId() %>" class="btn-floating btn-large waves-effect waves-light red"><i class="material-icons">delete</i></a></td>
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