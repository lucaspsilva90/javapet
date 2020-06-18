<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../parts/head-crud.jsp"%>

<%@page import="br.com.petbittencourt.controller.ControllerCliente"%>
<%@page import="br.com.petbittencourt.beans.Cliente"%>
<%@page import="java.util.List"%>


<%
	
	ControllerCliente cc = new ControllerCliente();
	List<Cliente> clientes = cc.listaCliente();
%>
  <body>
    <%@include file="../parts/nav.jsp"%>

    <main>
    <div class="container">
      <h3 class="center">Lista de Clientes</h3>
      <a href="./form-criar.jsp" class="waves-effect waves-light yellow lighten-5 black-text btn"><i class="material-icons left">add</i>Adicionar Cliente</a>
      <table class="striped">
        <thead>
          <tr>
              <th>ID</th>
              <th>Nome</th>
              <th>E-mail</th>
              <th>Editar</th>
              <th>Excluir</th>
          </tr>
        </thead>
		
		<% if (!(clientes.isEmpty())) { %>
        <tbody>
        	<% for (Cliente cliente: clientes) { %>
          <tr>
            <td><%=cliente.getId()%></td>
            <td><%=cliente.getNome()%></td>
            <td><%=cliente.getEmail()%></td>
            <td><a href="form-editar.jsp?<%="id=" + cliente.getId() %>"  class="btn-floating btn-large waves-effect waves-light"><i class="material-icons">mode_edit</i></a></td>
            <td><a href="excluir.jsp?<%="id=" + cliente.getId()%>" class="btn-floating btn-large waves-effect waves-light red"><i class="material-icons">delete</i></a></td>
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