<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html lang="pt-br">

  <head>
    <jsp:include page="template/head.jsp" />
  </head>

  <body>

    <!-- Navbar -->
    <jsp:include page="template/navbar_administrador.jsp" />

    <div class="container-fluid py-5">

      <div class="myform form">

        <div class="container pt-5">
          <div class="text-center pt-5">
            <h1 class="text-primary">Novo administrador</h1>
          </div>
        </div>

        <form class="py-3" id="form-administrador" method="POST" action="ServletInserirAdmin">

            <div class="form-group">
              <label for="Campo_cadastro">Nome</label>
              <input type="text"  name="nome" class="form-control nome" id="nome" 
              placeholder="(Obrigatório)">
            </div>

            <div class="form-group">
              <label for="Campo_cadastro">Login</label>
              <input type="text"  name="login" class="form-control login"
              id="login" placeholder="(Obrigatório)">
            </div>

            <div class="form-group">
              <label for="Campo_cadastro">Senha</label>
              <input type="password" name="password" id="password"  
              class="form-control password" placeholder="(Obrigatória)">
            </div>

            <div class="col-md-12 text-center mb-3">
              <button type="submit" class=" btn btn-primary tx-tfm">Inserir no sistema</button>
            </div>
        </form>
      </div>
    </div>
    
    <!-- Rodapé -->
    <jsp:include page="template/rodape.jsp" />

    <script src="js/jquery-3.4.1.min.js"></script>
    <script src="js/popper.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/jquery-validation/dist/jquery.validate.min.js"></script>
    <script type="text/javascript" src="js/validate_traducao.js"></script>

    <script>
      $(document).ready(function() {
        $("#form-administrador").validate({
          rules: {

            nome: { required: true, minlength: 3, maxlength: 50 },

            login: { required: true, minlength: 3, maxlength: 20 },

            password: { required: true, minlength: 6, maxlength: 255 }

          },
          messages: {

            nome: {required: "Obrigatório",
            minlength: "3 caracteres no mínimo",
            maxlength: "50 caracteres no máximo"},

            login: {required: "Obrigatório",
            minlength: "3 caracteres no mínimo",
            maxlength: "20 caracteres no máximo"},

            password: { required: "Obrigatória", 
            minlength: "6 caracteres no mínimo", 
            maxlength: "255 caracteres no máximo"},
          },

          submitHandler: function(form) {
            form.submit();
          }
        });
      });
    </script>
  </body>
</html>