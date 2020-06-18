<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../parts/head-crud.jsp"%>

<%@page import="br.com.petbittencourt.controller.ControllerFuncionario"%>
<%@page import="br.com.petbittencourt.beans.Funcionario"%>
<%@page import="java.util.List"%>


<%
	
	ControllerFuncionario cf = new ControllerFuncionario();
	List<Funcionario> funcionarios = cf.listaFuncionario();
%>
  <body>
    <%@include file="../parts/nav.jsp"%>

    <main>
    <div class="container">
      <h3 class="center">Lista de Funcionários</h3>
      <a href="./form-criar.jsp" class="waves-effect waves-light yellow lighten-5 black-text btn"><i class="material-icons left">add</i>Adicionar Funcionário</a>
      <table class="striped">
        <thead>
          <tr>
              <th>ID</th>
              <th>Nome</th>
              <th>Salário</th>
              <th>Cargo</th>
              <th>Editar</th>
              <th>Excluir</th>
          </tr>
        </thead>
		
		<% if (!(funcionarios.isEmpty())) { %>
        <tbody>
        	<% for (Funcionario funcionario: funcionarios) { %>
          <tr>
            <td><%=funcionario.getId()%></td>
            <td><%=funcionario.getNome()%></td>
            <td><%=funcionario.getSalario()%></td>
            <td><%=funcionario.getCargo().getNome()%></td>
            <td><a href="form-editar.jsp?<%="id=" + funcionario.getId() %>"  class="btn-floating btn-large waves-effect waves-light"><i class="material-icons">mode_edit</i></a></td>
            <td><a href="excluir.jsp?<%="id=" + funcionario.getId() %>" class="btn-floating btn-large waves-effect waves-light red"><i class="material-icons">delete</i></a></td>
            <% } %>
          </tr>
          	<% } %>

        </tbody>
    </table>
    </div>
    </main>
    
    <%@include file="../parts/footer-crud.jsp"%> 
    <script type="text/javascript" src="../public/js/materialize.min.js"></script>
  </body>
</html>