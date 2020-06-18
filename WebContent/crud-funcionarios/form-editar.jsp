<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../parts/head-crud.jsp"%>
<%@page import="br.com.petbittencourt.controller.ControllerFuncionario"%>
<%@page import="br.com.petbittencourt.beans.Funcionario"%>
<%@page import="br.com.petbittencourt.controller.ControllerCargo"%>
<%@page import="br.com.petbittencourt.beans.Cargo"%>
<%@page import="java.util.List"%>

<% 
	int id = Integer.parseInt(request.getParameter("id"));
	Funcionario funcionario = new Funcionario(id,"",0,0);
	ControllerFuncionario cf = new ControllerFuncionario();
	funcionario = cf.buscaPorId(funcionario);
	ControllerCargo cc = new ControllerCargo();
	List<Cargo> cargos = cc.listaCargo();
%>

  <body>
    <%@include file="../parts/nav.jsp"%>

    <main class="container">
      <div class="row form-cliente">
        <form class="col s12" method="POST" action="editar.jsp">
          <div class="input-field col s6">
            <input type="text" name="nome" class="validate" value="<%=funcionario.getNome()%>">
            <label class="active" for="">Nome</label>
          </div>
        <div class="row">
          <div class="input-field col s6">            
            <input name="salario" type="number" min="1" step="any" class="validate" value="<%=funcionario.getSalario()%>">
            <label class="active" for="">Salário</label>
        </div>
        </div>
        <div class="row">
       	    <label for="idCargo" class="active" id="cargo">Escolha um Cargo</label>
        	<select name="idCargo" id="idCargo">
        		<% for (Cargo cargo: cargos) { %>
        			<option value="<%=cargo.getId()%>" <%= cargo.getId() == funcionario.getIdCargo() ? "selected" : ""%>><%=cargo.getNome()%></option>
        		<% } %>
        	</select>
        	
        </div>
        <input type="hidden" name="id" value="<%=funcionario.getId()%>">

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