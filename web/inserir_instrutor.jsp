<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html lang="pt-br">

  <head>
    <jsp:include page="head.jsp" />
  </head>

  <body>

    <!-- Navbar -->
    <jsp:include page="navbar_administrador.jsp" />

    <div class="container-fluid py-5">
    
      <div class="myform form">
    
        <div class="container pt-5">
          <div class="text-center pt-5">
            <h1 class="text-primary">Inserir instrutor</h1>
          </div>
        </div>

        <form class="py-3" id="form-instrutor" method="POST" action="ServletInserirInstrutor">

          <div class="form-group">
            <label for="Campo_cadastro">Nome</label>
            <input type="text" name="nome" class="form-control nome" id="nome" 
            placeholder="(Obrigatório)">
          </div>

          <div class="form-group">
            <label for="Campo_cadastro">Email</label>
            <input type="email" name="email" class="form-control email" id="email" 
            placeholder="(Obrigatório)">
          </div>

          <div class="form-group">
            <label for="valor_hora">Valor/hora</label>
            <input type="text" class="form-control valor_hora" id="valor_hora" 
            name="valor_hora" placeholder="(Opcional)">
          </div>

          <div class="form-group">
            <label for="Campo_cadastro">Login</label>
            <input type="text" name="login" class="form-control login" id="login" 
            placeholder="(Obrigatório)">
          </div>

          <div class="form-group">
            <label for="Campo_cadastro">Senha</label>
            <input type="password" name="password" id="password" class="form-control password"
            placeholder="(Obrigatória)">
          </div>

          <div class="form-group">
            <label for="Campo_cadastro">Experiência</label>
            <input type="text" name="experiencia" class="form-control experiencia" id=" 
            experiencia" placeholder="(Opcional)">
          </div>

          <div class="col-md-12 text-center mb-3">
            <button type="submit" class=" btn btn-primary tx-tfm">Inserir no sistema</button>
          </div>
        </form>
      </div>
    </div>

    <!-- Rodapé -->
    <jsp:include page="rodape.jsp" />

    <script>
      $(document).ready(function () {
        $('#form-instrutor').validate({
          rules: {

            nome: { required: true, minlength: 3, maxlength: 50 },

            email: { required: true },

            valor_hora: { number: true },

            login: { required: true, minlength: 3, maxlength: 20 },

            password: { required: true, minlength: 6, maxlength: 255 },

            experiencia: { minlength: 3, maxlength: 255 },

          }, 
          messages: {

            nome: { required: "Obrigatório",
            minlength: "3 caracteres no mínimo",
            maxlength: "50 caracteres no máximo"},

            email: {required: "Obrigatório"},

            login: {required: "Obrigatório",
            minlength: "3 caracteres no mínimo",
            maxlength: "20 caracteres no máximo"},

            password: {required: "Obrigatória",
            minlength: "Mínimo de 6 caracteres",
            maxlength: "Máximo de 255 caracteres"},

            experiencia: {minlength: "Deve ter 3 caracteres",
            maxlength: "Deve ter 255 caracteres"},

          },

          submitHandler: function (form) {
            form.submit();
          }
        });
      });
    </script>
  </body>
</html>