<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html lang="pt-br">

  <head>
    <jsp:include page="head.jsp" />
  </head>

  <body>

    <!-- Navbar -->
    <jsp:include page="navbar.jsp" />

    <div class="container-fluid py-5">
    
      <div class="myform form">
    
        <div class="container pt-5">
          <div class="text-center pt-5">
            <h1 class="text-primary">Inserir curso</h1>
          </div>
        </div>

        <form class="py-3 px-5" id="form-curso" method="POST" action="ServletInserirCurso">

          <div class="form-group">
            <label for="Campo_cadastro">Nome do curso</label>
            <input type="text"  name="nome" class="form-control nome" id="nome" 
            placeholder="(Obrigatório)">
          </div>

          <div class="form-group">
            <label for="Campo_cadastro">Requisito</label>
            <input type="text"  name="requisito" class="form-control requisito"
            id="requisito" placeholder="(Opcional)">
          </div>

          <div class="form-group">
            <label for="Campo_cadastro">Ementa</label>
            <input name="ementa" id="ementa"  class="form-control ementa" placeholder="(Opcional)">
          </div>

          <div class="form-group">
            <label for="Campo_cadastro">Carga horária</label>
            <input  type="text" name="carga_horaria"  class="form-control carga_horaria"
            id="carga_horaria" placeholder="(Opcional)">
          </div>

          <div class="form-group">
            <label for="Campo_cadastro">Preço</label>
            <input type="text" name="preco" id="preco"  
            class="form-control preco" placeholder="(Opcional)">
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
      $(document).ready(function() {
        $("#form-curso").validate({
          rules: {

            nome: { required: true, minlength: 3, maxlength: 50 },

            requisito: { maxlength: 255 },

            ementa: { maxlength: 255 },

            carga_horaria: { digits: true, maxlength: 5 },

            preco: { number: true }

          },
          messages: {

            nome: {required: "Obrigatório",
            minlength: "3 caracteres no mínimo",
            maxlength: "50 caracteres no máximo"},

            requisito: {maxlength: "255 caracteres no máximo"},

            ementa: {maxlength: "255 caracteres no máximo"},

            carga_horaria: {maxlength: "5 caracteres no máximo"}
          },

          submitHandler: function(form) {
              form.submit();
          }
        });
      });
    </script>
  </body>
</html>