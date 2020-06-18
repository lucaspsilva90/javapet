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

    <main class="container">
      <div class="row form-cliente">
        <form class="col s12" method="POST" action="adicionarservico.jsp">
          <div class="input-field col s6">
            <input type="text" name="nome" class="validate">
            <label class="active" for="">Nome</label>
          </div>
        <div class="row">
          <div class="input-field col s6">            
            <input name="preco" type="number" min="1" step="any" class="validate">
            <label class="active" for="">Preço</label>
        </div>
       	</div>
       	<div class="row">
       	    <label for="idFuncionario" class="active" id="funcionario">Escolha o Proprietário</label>
        	<select name="idFuncionario" id="idFuncionario">
        		<% for (Funcionario funcionario: funcionarios) { %>
        			<option value="<%=funcionario.getId()%>"><%=funcionario.getNome()%></option>
        		<% } %>
        	</select>     	
        </div>

        <button class="btn waves-effect yellow lighten-5 black-text waves-light" type="submit" name="action">Submeter
          <i class="material-icons right">send</i>
        </button>
        </form>
      </div>
    </main>
    
    <%@include file="../parts/footer-crud.jsp"%> 
    <script type="text/javascript" src="../public/js/materialize.js"></script>
    <script type="text/javascript" src="form-criar.js"></script>
  </body>
</html>