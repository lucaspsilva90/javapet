<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../parts/head-crud.jsp"%>
<%@page import="br.com.petbittencourt.controller.ControllerCliente"%>
<%@page import="br.com.petbittencourt.beans.Cliente"%>

<% 
	int id = Integer.parseInt(request.getParameter("id"));
	Cliente cliente = new Cliente(id,"","");
	ControllerCliente cc = new ControllerCliente();
	cliente = cc.buscaClientePorId(cliente);
%>

  <body>
    <%@include file="../parts/nav.jsp"%>

    <main class="container">
    <h3>Alterar Cliente</h3>
      <div class="row form-cliente">
        <form class="col s12" method="POST" action="editar.jsp">
          <div class="input-field col s6">
            <input type="text" name="nome" class="validate" value="<%=cliente.getNome()%>">
            <label class="active" for="">Nome</label>
          </div>
        <div class="row">
          <div class="input-field col s6">            
            <input name="email" type="email" class="validate" value="<%=cliente.getEmail()%>">
            <label class="active" for="">E-mail</label>
        </div>
        </div>
        <input type="hidden" name="id" value="<%=cliente.getId()%>">

        <button class="btn waves-effect yellow lighten-5 black-text waves-light" type="submit" name="action">Submeter
          <i class="material-icons right">send</i>
        </button>
        </form>
      </div>
    </main>
    
    <%@include file="../parts/footer-crud.jsp"%> 
    <script type="text/javascript" src="../js/materialize.min.js"></script>
  </body>
</html>