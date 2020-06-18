<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../parts/head-crud.jsp"%>
<%@page import="br.com.petbittencourt.controller.ControllerCargo"%>
<%@page import="br.com.petbittencourt.beans.Cargo"%>

<% 
	int id = Integer.parseInt(request.getParameter("id"));
	Cargo cargo = new Cargo(id,"","");
	ControllerCargo cca = new ControllerCargo();
	cargo = cca.buscaCargoPorId(cargo);
%>

  <body>
    <%@include file="../parts/nav.jsp"%>

    <main class="container">
      <h2>Alterar Cargo</h2>
      <div class="row form-cliente">
        <form class="col s12" method="POST" action="editar.jsp">
          <div class="input-field col s6">
            <input type="text" name="nome" class="validate" value="<%=cargo.getNome()%>">
            <label class="active" for="">Nome</label>
          </div>
        <div class="row">
          <div class="input-field col s6">            
            <input name="descricao" type="text" class="validate" value="<%=cargo.getDescricao()%>">
            <label class="active" for="">Descrição</label>
        </div>
        </div>
        <input type="hidden" name="id" value="<%=cargo.getId()%>">

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