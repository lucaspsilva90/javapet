<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="./parts/head.jsp"%> 

  <body>
    <main class="grey lighten-5">
    <%@include file="./parts/nav.jsp"%>  
    <div class="container">
    
        <div class="center-align">
            <h1>Gerenciamento Pet-Shop</h1>
        </div>

        <div class="row center-align">

            <div class="col s4">
                <img src="./public/img/icone-pessoa.png" alt="">
                <a href="./crud-cliente/clientes.jsp"><h3>Clientes</h3></a>
            </div>
            <div class="col s4">
                <img src="./public/img/icone-pets.png" alt="">
                <a href="./crud-pets/pets.jsp"><h3>Pets</h3></a>
            </div>
            <div class="col s4">
                <img src="./public/img/servicos-pet.png" alt="">
                <a href="./crud-servicos/servicos.jsp"><h3>Serviços</h3></a>
            </div>
            
          </div>

          <div class="row center-align" >
            <div class="col s4">
              <img src="./public/img/icone-cargo.png" alt="">
              <a href="./crud-cargos/cargos.jsp"><h3>Cargos</h3></a>
            </div>
            <div class="col s4">
              <img src="./public/img/icone-funcionario.png" alt="">
              <a href="./crud-funcionarios/funcionarios.jsp"><h3>Funcionários</h3></a>
            </div>
            <div class="col s4">
              <img src="./public/img/icone-historico.png" alt="">
              <a href="./crud-historico/historico.jsp"><h3>Histórico de Serviços</h3></a>
            </div>
          </div>

    </div>
    </main>
    <%@include file="./parts/footer.jsp"%>
    <script type="text/javascript" src="../js/materialize.min.js"></script>
  </body>

</html>