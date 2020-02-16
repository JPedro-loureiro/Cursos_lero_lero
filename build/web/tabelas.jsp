<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html lang="pt-br">

<head>
  <jsp:include page="head.jsp" />
</head>

<body>

  <!-- Navbar -->
  <jsp:include page="navbar_administrador.jsp" />

    <div class="formularios py-5 my-5">

      <div class="container py-5 my-5">

        <div class="text-center py-5">
          <h1 class="text-primary">Formulários</h1>
        </div>

        <div class="row d-flex justify-content-center">
          <div class="btn-group btn-group-lg" role="group">
            <a type="button" class="btn btn-outline-primary px-4" href="inserir_administrador.jsp">Administrador</a>
            <a type="button" class="btn btn-outline-primary px-4" href="inserir_aluno.jsp">Aluno</a>
            <a type="button" class="btn btn-outline-primary px-4" href="inserir_curso.jsp">Cursos</a>
            <a type="button" class="btn btn-outline-primary px-4" href="inserir_instrutor.jsp">Instrutor</a>
            <a type="button" class="btn btn-outline-primary px-4" href="inserir_matricula.jsp">Matrícula</a>
            <a type="button" class="btn btn-outline-primary px-4" href="inserir_turma.jsp">Turma</a>
          </div>
        </div>
      </div>
    </div>

    <!-- Rodapé -->
    <jsp:include page="rodape.jsp" />

    <script src="js/jquery-3.4.1.min.js"></script>
    <script src="js/popper.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
  </body>
</html>