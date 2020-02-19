<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html lang="pt-br">

  <head>
    <jsp:include page="head.jsp" />

    <style>
      .login-or {
        position: relative;
        color: #aaa;
        margin-top: 10px;
        margin-bottom: 10px;
        padding-top: 10px;
        padding-bottom: 10px;
      }
    
      .span-or {
        display: block;
        position: absolute;
        left: 50%;
        top: -2px;
        margin-left: -25px;
        background-color: #fff;
        width: 50px;
        text-align: center;
      }
    
      .hr-or {
        height: 1px;
        margin-top: 0px !important;
        margin-bottom: 0px !important;
      }
    </style>
  </head>

  <body>

    <!-- Navbar -->
    <jsp:include page="navbar.jsp" />

    <div class="container">
      <div class="row">
        <div class="col-md-5 mx-auto">
          <div id="first">

            <div class="myform form">

              <div class="container pt-5">
                <div class="text-center pt-5">
                  <h1 class="display-4 text-primary">Login</h1>
                </div>
              </div>

              <form method="POST" id="form-login" action="ServletLogin">

                <div class="form-group">
                  <label for="Campo_login">Login</label>
                  <input type="text" name="login"  class="form-control" id="login">
                </div>

                <div class="form-group">
                  <label for="Campo_login">Senha</label>
                  <input type="password" name="password" id="password"  class="form-control">
                </div>

                <div class="form-group">
                  <label for="Campo_login">Tipo de usuário</label>
                  <select id="dropdown_tipo_usuario" name="dropdown_tipo_usuario" class="form-control">
                    <option value="">Entrar como</option>
                    <option value="adm">Administrador</option>
                    <option value="aluno">Aluno</option>
                    <option value="inst">Instrutor</option>
                  </select>
                </div>

                <div class="col-md-12 ">
                  <div class="login-or">
                    <hr class="hr-or">
                    <span class="span-or"></span>
                  </div>
                </div>

                <div class="text-center pb-3">
                  <button type="submit" class=" btn btn-block btn-primary tx-tfm">Login</button>
                </div>

                <div class="form-group">
                  <p class="text-center">Não tem uma conta? <a href="cadastro.jsp" id="signup">
                      Cadastre-se</a></p>
                </div>

              </form>
            </div>
          </div>
        </div>
      </div>
    </div>   
       
    <!-- Rodapé -->
    <jsp:include page="rodape.jsp" />

    <script>
      $(document).ready(function() {
        $("#form-login").validate({
          rules: {
        
            login: { required: true},

            password: { required: true, minlength: 6, maxlength: 255 },

            dropdown_tipo_usuario: { required: true }

          },
          messages: {

            login: {required: "Obrigatório"},

            password: {required: "Obrigatória", 
            minlength: "6 caracteres no mínimo", 
            maxlength: "255 caracteres no máximo"}, 

            dropdown_tipo_usuario: { required: "Escolha um tipo" }

          },

          submitHandler: function(form) {
            form.submit();
          }
        });
      });
    </script>
  </body>
</html>