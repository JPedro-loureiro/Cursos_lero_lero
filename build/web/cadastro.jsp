<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html lang="pt-br">

  <head>
    <jsp:include page="head.jsp" />
  </head>

  <body>

    <!-- Navbar -->
    <jsp:include page="navbar.jsp" />

    <div class="container">
      <div class="row">
        <div class="col-md-5 mx-auto">

          <div class="myform form ">

            <div class="container pt-5">
              <div class="text-center pt-5">
                <h1 class="display-4 text-primary">Cadastre-se</h1>
              </div>
            </div>

            <form class="py-3" id="form-cadastro" method="POST" action="ServletCadastro">
              
                <div class="form-group">
                  <label for="Campo_cadastro">Nome completo</label>
                  <input type="text"  name="name" class="form-control" id="name" placeholder="(Obrigatório)">
                </div>

                <div class="form-group">
                  <label for="Campo_cadastro">CPF (somente números)</label>
                  <input type="text"  name="cpf" class="form-control cpf" id="cpf" placeholder="(Obrigatório)">
                </div>

                <div class="form-group">
                  <label for="Campo_cadastro">Endereço de email</label>
                  <input type="email" name="email"  class="form-control" id="email" placeholder="(Obrigatório)">
                </div>

                <div class="form-group">
                  <label for="Campo_cadastro">Senha (mínimo de 6 dígitos)</label>
                  <input type="password" name="password" id="password"  class="form-control password" placeholder="(Obrigatória)">
                </div>

                <div class="form-group">
                  <p class="text-center">Ao entrar, você aceita nossos termos de uso</p>
                </div>

                <div class="col-md-12 text-center mb-3">
                  <button type="submit" class=" btn btn-block btn-primary tx-tfm">Comece já</button>
                </div>

                <div class="col-md-12 ">
                  <div class="form-group">
                      <p class="text-center">Já tem uma conta? <a href="login.html" id="signin">Login</a></p>
                  </div>
                </div>

            </form>
          </div>
        </div>
      </div>
    </div>
    
    <!-- Rodapé -->
    <jsp:include page="rodape.jsp" />

    <script src="js/jquery-3.4.1.min.js"></script>
    <script src="js/popper.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/jquery-validation/dist/jquery.validate.min.js"></script>
    <script type="text/javascript" src="js/validate_traducao.js"></script>

    <script>
      $(document).ready(function() {
        $("#form-cadastro").validate({
          rules: {

            name: { required: true, minlength: 3, maxlength: 50 },

            cpf: { required: true, minlength: 11, maxlength:11, digits: true },

            email: { required: true, maxlength: 50 },

            password: { required: true, minlength: 6, maxlength: 255 }

          }, 
          messages: {

            name: {required: "Obrigatório", 
            minlength: "3 caracteres no mínimo", 
            maxlength: "50 caracteres no máximo"},

            cpf: {required: "Obrigatório",
            minlength: "O CPF deve ter 11 dígitos", 
            maxlength: "O CPF deve ter 11 dígitos"},

            email: {required: "Obrigatório", 
            maxlength: "50 caracteres no máximo"},

            password: {required: "Obrigatória", 
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