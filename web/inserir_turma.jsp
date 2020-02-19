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
            <h1 class="text-primary">Inserir turma</h1>
          </div>
        </div>

        <form class="py-3 px-5" id="form-turma" method="POST" action="ServletInserirTurma">

          <div class="form-group">
            <label for="Campo_cadastro">id do instrutor</label>
            <input type="text" name="instrutores_id" class="form-control instrutores_id" 
            id="instrutores_id" placeholder="(Obrigatório)">
          </div>

          <div class="form-group">
            <label for="Campo_cadastro">id do curso</label>
            <input type="text" name="cursos_id" class="form-control cursos_id" 
            id="cursos_id" placeholder="(Obrigatório)">
          </div>

          <div class="form-group">
            <label for="Campo_cadastro">Data de início</label>
            <input type="date" class="form-control data_inicio" id="data_inicio" name="data_inicio">
          </div>

          <div class="form-group">
            <label for="Campo_cadastro">Data de fim</label>
            <input type="date" class="form-control data_final" id="data_final" name="data_final">
          </div>

          <div class="form-group">
            <label for="Campo_cadastro">Carga horária</label>
            <input type="text" name="carga_horaria" class="form-control carga_horaria" id="carga_horaria"
            placeholder="(Opcional)">
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
        $("#form-turma").validate({
          rules: {

            instrutores_id: { required: true, minlength: 1, maxlength: 10, number: true },

            cursos_id: { required: true, minlength: 1, maxlength: 11, number: true },

            carga_horaria: { digits: true, maxlength: 5 }

          }, messages: {

            instrutores_id: {
            required: "Obrigatório",
            minlength: "1 caractere no mínimo",
            maxlength: "10 caracteres no máximo"},

            cursos_id: {
            required: "Obrigatório",
            minlength: "1 caractere no mínimo",
            maxlength: "11 caracteres no máximo"},

            carga_horaria: { maxlength: "5 caracteres no máximo" }
          },

          submitHandler: function (form) {
            form.submit();
          }
        });
      });
    </script>
  </body>
</html>