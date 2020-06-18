<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../parts/head-crud.jsp"%>

  <body>
    <%@include file="../parts/nav.jsp"%>

    <main class="container">
      <div class="row form-cliente">
        <form class="col s12" method="POST" action="adicionarcargo.jsp">
          <div class="input-field col s6">
            <input type="text" name="nome" class="validate">
            <label class="active" for="">Nome</label>
          </div>
        <div class="row">
          <div class="input-field col s6">            
            <input name="descricao"  class="validate">
            <label class="active" for="">Descrição</label>
        </div>
        </div>

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