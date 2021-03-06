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
            <h1 class="text-primary">Inserir matrícula</h1>
          </div>
        </div>

        <form class="py-3 px-5" id="form-mat" method="POST" action="ServletInserirMatricula">

          <div class="form-group">
            <label for="Campo_cadastro">id da turma</label>
            <input type="text" name="turmas_id" class="form-control turmas_id" id="turmas_id" 
            placeholder="(Obrigatório)">
          </div>

          <div class="form-group">
            <label for="Campo_cadastro">id do aluno</label>
            <input type="text" name="alunos_id" class="form-control alunos_id" id="alunos_id" 
            placeholder="(Obrigatório)">
          </div>

          <div class="form-group">
            <label for="Campo_cadastro">Data da matrícula</label>
            <input type="date" class="form-control data_matricula" id="data_matricula" 
            name="data_matricula">
          </div>

          <div class="form-group">
            <label for="Campo_cadastro">Nota</label>
            <input type="text" name="nota" class="form-control nota" id="nota" 
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
        $("#form-mat").validate({
          rules: {

            turmas_id: { required: true, minlength: 1, maxlength: 10, number: true },

            alunos_id: { required: true, minlength: 1, maxlength: 11, number: true },

            nota: { maxlength: 11, digits: true }

          }, 
          messages: {

            turmas_id: { required: "Obrigatório", 
            minlength: "1 caractere no mínimo",
            maxlength: "10 caracteres no máximo"},

            alunos_id: { required: "Obrigatório",
            minlength: "1 caractere no mínimo",
            maxlength: "11 caracteres no máximo"},

            nota: {maxlength: "11 caracteres no máximo"}
          },

          submitHandler: function (form) {
            form.submit();
          }
        });
      });
    </script>
  </body>
</html>