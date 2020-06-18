<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../parts/head-crud.jsp"%>
<%@page import="br.com.petbittencourt.controller.ControllerPet"%>
<%@page import="br.com.petbittencourt.beans.Pet"%>
<%@page import="br.com.petbittencourt.beans.Cliente"%>
<%@page import="br.com.petbittencourt.controller.ControllerCliente"%>
<%@page import="java.util.List"%>


<% 
	int id = Integer.parseInt(request.getParameter("id"));
	Pet pet  = new Pet(id,"","",0);
	ControllerPet cp = new ControllerPet();
	pet = cp.buscaPorId(pet);
	ControllerCliente cc = new ControllerCliente();
	List<Cliente> clientes = cc.listaCliente();
%>

  <body>
    <%@include file="../parts/nav.jsp"%>

    <main class="container">
      <div class="row form-pet">
        <form class="col s12" method="POST" action="editar.jsp">
          <div class="input-field col s6">
            <input type="text" name="nome" class="validate" value="<%=pet.getNome()%>">
            <label class="active" for="">Nome</label>
          </div>
        <div class="row">
          <div class="input-field col s6">            
            <input name="dataNascimento" type="date" class="validate" value="<%=pet.getData_nascimento()%>">
            <label class="active" for="">Data de Nascimento</label>
          </div>
        </div>
         <div class="row">
       	    <label for="clienteId" class="active" id="cliente">Escolha o Proprietário</label>
        	<select name="clienteId" id="clienteId">
        		<% for (Cliente cliente: clientes) { %>
        			<option value="<%=cliente.getId()%>" <%= cliente.getId() == pet.getIdCliente() ? "selected" : "" %>><%=cliente.getNome()%></option>
        		<% } %>
        	</select>     	
        </div>
		<input type="hidden" name="id" value="<%=pet.getId()%>">
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