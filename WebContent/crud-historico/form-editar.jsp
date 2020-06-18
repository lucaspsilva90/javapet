<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../parts/head-crud.jsp"%>
<%@page import="br.com.petbittencourt.controller.ControllerHistoricoServico"%>
<%@page import="br.com.petbittencourt.beans.HistoricoServico"%>
<%@page import="br.com.petbittencourt.controller.ControllerPet"%>
<%@page import="br.com.petbittencourt.beans.Pet"%>
<%@page import="br.com.petbittencourt.controller.ControllerServico"%>
<%@page import="br.com.petbittencourt.beans.Servico"%>
<%@page import="java.util.List"%>


<% 
	int id = Integer.parseInt(request.getParameter("id"));
	HistoricoServico historico = new HistoricoServico(id,0,0,"");
	ControllerHistoricoServico chs = new ControllerHistoricoServico();
	historico = chs.buscaPorId(historico);
	ControllerPet cp = new ControllerPet();
	List<Pet> pets = cp.listaPet();
	ControllerServico cs = new ControllerServico();
	List<Servico> servicos = cs.listaServico();
%>



  <body>
    <%@include file="../parts/nav.jsp"%>

    <main class="container">
      <div class="row form-cliente">
      <h3>Alterar Historico de Serviços</h3>
        <form class="col s12" method="POST" action="editar.jsp">
          <div class="row">
	       	    <label for="idPet" class="active" id="pet">Escolha o Pet</label>
	        	<select name="idPet" id="idPet">
	        		<% for (Pet pet: pets) { %>
	        			<option value="<%=pet.getId()%>" <%= pet.getId() == historico.getIdPet() ? "selected" : "" %>><%=pet.getNome()%></option>
	        		<% } %>
        		</select>     	
        	</div>
        <div class="row">
	       	    <label for="idServico" class="active" id="servico">Escolha o Serviço</label>
	        	<select name="idServico" id="idPet">
	        		<% for (Servico servico: servicos) { %>
	        			<option value="<%=servico.getId()%>" <%= servico.getId() == historico.getIdServico() ? "selected" : "" %>><%=servico.getNome()%></option>
	        		<% } %>
        		</select>     	
        </div>
        <div class="row">
          <div class="input-field col s6">            
            <input name="data" type="hidden" class="validate">
            <!--  <label class="active" for="">Data do Servico</label> -->
          </div>
        </div>
        <div class="row">
          <div class="input-field col s6">            
            <input  id="obs" name="obs" type="text" class="validate" value="<%=historico.getObs()%>">
            <label class="active" for="obs">Observações</label>
          </div>
        </div>
        <input type="hidden" name="id" value="<%=historico.getId()%>">

        <button class="btn waves-effect yellow lighten-5 black-text waves-light" type="submit" name="action">Submeter
          <i class="material-icons right">send</i>
        </button>
        </form>
      </div>
    </main>
    
    <%@include file="../parts/footer-crud.jsp"%> 
    <script type="text/javascript" src="../public/js/materialize.min.js"></script>
    <script type="text/javascript" src="form-criar.js"></script>
  </body>
</html>