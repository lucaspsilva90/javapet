<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.com.petbittencourt.controller.ControllerPet"%>
<%@page import="br.com.petbittencourt.controller.ControllerCliente"%>
<%@page import="br.com.petbittencourt.beans.Cliente"%>
<%@page import="br.com.petbittencourt.beans.Pet"%>
<%@page import="java.util.List"%>
<%@include file="../parts/head-crud.jsp"%>

<%
	ControllerPet cp = new ControllerPet();
	ControllerCliente cc = new ControllerCliente();
	List<Pet> pets = cp.listaPet();
%>
  <body>
    <%@include file="../parts/nav.jsp"%>

    <main>
    <div class="container">
      <h3 class="center">Lista de Pets</h3>
      <a href="./form-criar.jsp" class="waves-effect waves-light yellow lighten-5 black-text btn"><i class="material-icons left">add</i>Adicionar Pet</a>
      <table class="striped">
        <thead>
          <tr>
              <th>ID</th>
              <th>Nome</th>
              <th>Data Nascimento</th>
              <th>Nome Proprietário</th>
              <th>Editar</th>
              <th>Excluir</th>
          </tr>
        </thead>
		
		<% if (!(pets.isEmpty())) { %>
        <tbody>
        	<% for (Pet pet: pets) { %>
          <tr>
            <td><%=pet.getId()%></td>
            <td><%=pet.getNome()%></td>
            <td><%=pet.getData_nascimento()%></td>
            <td><%=pet.getCliente().getNome()%></td>
            <td><a href="form-editar.jsp?<%="id=" + pet.getId() %>"  class="btn-floating btn-large waves-effect waves-light"><i class="material-icons">mode_edit</i></a></td>
            <td><a href="excluir.jsp?<%="id=" + pet.getId() %>" class="btn-floating btn-large waves-effect waves-light red"><i class="material-icons">delete</i></a></td>
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