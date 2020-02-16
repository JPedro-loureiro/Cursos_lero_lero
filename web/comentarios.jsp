<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html lang="pt-br">

  <head>
    <jsp:include page="template/head.jsp" />
  </head>

  <body>

    <!-- Navbar -->
    <jsp:include page="template/navbar.jsp" />

    <section class="cursos py-5">

      <div class="container">

        <div class="text-center py-5">
          <h1 class="display-4 text-primary">O que nossos alunos dizem</h1>
        </div>
      
        <!--Aluno 1-->
        <div class="card mb-5 mx-auto shadow-sm" style="max-width: 600px;">
          <div class="row no-gutters">
            <div class="col-md-4">
              <img src="imagens/aluno_1.jpg" class="card-img">
            </div>
            <div class="col-md-8">
              <div class="card-body">
                <h5 class="card-title">Ayira Indra</h5>
                <p class="card-text">Curso incrível! Hoje já me sinto confortável para me comunicar 
                em português.</p>
                <p class="card-text"><small class="text-muted">Atualizado há 3 semanas</small></p>
              </div>
            </div>
          </div>
        </div>

        <!--CJ-->
        <div  class="card mb-5 mx-auto shadow-sm" style="max-width: 600px;">
          <div class="row no-gutters">
            <div class="col-md-4">
              <img src="imagens/cj.jpg" class="card-img">
            </div>
            <div class="col-md-8">
              <div class="card-body">
                <h5 class="card-title">CJ</h5>
                <p class="card-text">Curso muito bom. Me ajudou muito no desenrolo com os mano.</p>
                <p class="card-text"><small class="text-muted">Atualizado há 15 dias</small></p>
              </div>
            </div>
          </div>
        </div>

      </div>

    </section>
    
    <!-- Rodapé -->
    <jsp:include page="template/rodape.jsp" />

    <script src="js/jquery-3.4.1.min.js"></script>
    <script src="js/popper.min.js"></script>
    <script src="js/bootstrap.min.js"></script>

  </body>
</html>