<%-- 
    Document   : instrutores
    Created on : 11/02/2020, 20:13:33
    Author     : Joao_
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="stylesheet" href="css/bootstrap.min.css">

    <style>

      /* Carrossel */
      @media (min-width: 768px) {
        .carousel-inner .active,
        .carousel-inner .active + .carousel-item,
        .carousel-inner .active + .carousel-item + .carousel-item {
          display: block;
        }

        .carousel-inner .carousel-item.active:not(.carousel-item-right):not(.carousel-item-left),
        .carousel-inner .carousel-item.active:not(.carousel-item-right):not(.carousel-item-left) + 
        .carousel-item,
        .carousel-inner .carousel-item.active:not(.carousel-item-right):not(.carousel-item-left) + 
        .carousel-item + .carousel-item {
          transition: none;
        }

        .carousel-inner .carousel-item-next,
        .carousel-inner .carousel-item-prev {
          position: relative;
          transform: translate3d(0, 0, 0);
        }

        .carousel-inner .active.carousel-item + .carousel-item + .carousel-item + .carousel-item {
          position: absolute;
          top: 0;
          right: -33.3333%;
          z-index: -1;
          display: block;
          visibility: visible;
        }

        .active.carousel-item-left + .carousel-item-next.carousel-item-left,
        .carousel-item-next.carousel-item-left + .carousel-item,
        .carousel-item-next.carousel-item-left + .carousel-item + .carousel-item,
        .carousel-item-next.carousel-item-left + .carousel-item + .carousel-item + .carousel-item {
          position: relative;
          transform: translate3d(-100%, 0, 0);
          visibility: visible;
        }

        .carousel-inner .carousel-item-prev.carousel-item-right {
          position: absolute;
          top: 0;
          left: 0;
          z-index: -1;
          display: block;
          visibility: visible;
        }

        .active.carousel-item-right + .carousel-item-prev.carousel-item-right,
        .carousel-item-prev.carousel-item-right + .carousel-item,
        .carousel-item-prev.carousel-item-right + .carousel-item + .carousel-item,
        .carousel-item-prev.carousel-item-right + .carousel-item + .carousel-item + .carousel-item {
          position: relative;
          transform: translate3d(100%, 0, 0);
          visibility: visible;
          display: block;
          visibility: visible;
        }
      }
    </style>

    <title>Instrutores - Cursos Lero Lero</title>

  </head>

  <body>
    <header>
      <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">

        <a class="navbar-brand h4" href="index.jsp">Cursos Lero Lero</a>
        
        <div class="collapse navbar-collapse" id="navbarCollapse">
          <ul class="navbar-nav mr-auto">

            <li class="nav-item active">
              <a class="nav-link" href="sobre_nos.html">Sobre nós </a>
            </li>

            <li class="nav-item active">
              <a class="nav-link" href="instrutores.jsp">Instrutores</a>
            </li>

            <li class="nav-item active">
              <a class="nav-link" href="comentarios.html">Comentários </a>
            </li>

            <li class="nav-item disabled">
              <a class="nav-link" href="tabelas.html">Tabelas </a>
            </li>
          </ul>
          
          <a class="btn btn-primary" href="cadastro.html" role="button">Cadastre-se</a>
          <a class="nav-link" href="login.html">Login <span class="sr-only">(current)</span></a>

        </div>
      </nav>
    </header>

    <div class="container py-5">

      <div class="text-center pt-5">
        <h1 class="display-4 text-primary">Os instrutores</h1>
      </div>

      <!-- Carrossel -->
      <div id="myCarousel" class="carousel slide" data-ride="carousel">
        <div class="carousel-inner row w-100 mx-auto ">
          <div class="carousel-item col-md-4 active py-5">
            <div class="card">
              <img class="card-img-top img-fluid" src="imagens/kratos.jpg">
              <div class="card-body bg-secondary">
                <h4 class="card-title text-white">Kratos</h4>
                <p class="card-text text-white">Humblebrag squid lyft, 
                godard waistcoat intelligentsia knausgaard jianbing.</p>
              </div>
            </div>
          </div>

          <div class="carousel-item col-md-4 py-5">
            <div class="card">
              <img class="card-img-top img-fluid" src="imagens/mario.jpg">
              <div class="card-body bg-secondary">
                <h4 class="card-title text-white">Mario</h4>
                <p class="card-text text-white">Humblebrag squid lyft, 
                godard waistcoat intelligentsia knausgaard jianbing.</p>
              </div>
            </div>
          </div>

          <div class="carousel-item col-md-4 py-5">
            <div class="card">
              <img class="card-img-top img-fluid" src="imagens/geralt_de_rivia.jpg">
              <div class="card-body bg-secondary">
                <h4 class="card-title text-white">Geralt de Rivia</h4>
                <p class="card-text text-white">Humblebrag squid lyft, 
                godard waistcoat intelligentsia knausgaard jianbing.</p>
              </div>
            </div>
          </div>

          <div class="carousel-item col-md-4 py-5">
            <div class="card">
              <img class="card-img-top img-fluid" src="imagens/allejo.jpg">
              <div class="card-body bg-secondary">
                <h4 class="card-title text-white">Allejo</h4>
                <p class="card-text text-white">Humblebrag squid lyft, 
                godard waistcoat intelligentsia knausgaard jianbing.</p>
              </div>
            </div>
          </div>

          <div class="carousel-item col-md-4 py-5">
            <div class="card">
              <img class="card-img-top img-fluid" src="imagens/link.jpg">
              <div class="card-body bg-secondary">
                <h4 class="card-title text-white">Link</h4>
                <p class="card-text text-white">Humblebrag squid lyft, 
                godard waistcoat intelligentsia knausgaard jianbing.</p>
              </div>
            </div>
          </div>

          <div class="carousel-item col-md-4 py-5">
            <div class="card">
              <img class="card-img-top img-fluid" src="imagens/ganso.jpg">
              <div class="card-body bg-secondary">
                <h4 class="card-title text-white">Ganso</h4>
                <p class="card-text text-white">Humblebrag squid lyft, 
                godard waistcoat intelligentsia knausgaard jianbing.</p>
              </div>
            </div>
          </div>

        </div>

        <a class="carousel-control-prev" href="#myCarousel" role="button" data-slide="prev">
          <span class="carousel-control-prev-icon" aria-hidden="true"></span>
          <span class="sr-only">Previous</span>
        </a>

        <a class="carousel-control-next" href="#myCarousel" role="button" data-slide="next">
          <span class="carousel-control-next-icon" aria-hidden="true"></span>
          <span class="sr-only">Next</span>
        </a>
      </div>
    </div>
    
    <!-- Rodapé -->
    <footer class="navbar navbar-fixed-bottom bg-secondary text-white">
      <div class="footer-copyright mx-auto py-3">2020 Caíque e João Pedro
      </div>
    </footer>

    <script src="js/jquery-3.4.1.min.js"></script>
    <script src="js/popper.min.js"></script>
    <script src="js/bootstrap.min.js"></script>

    <script>

      //Carrossel
      $(document).ready(function() {
        $("#myCarousel").on("slide.bs.carousel", function(e) {
          var $e = $(e.relatedTarget);
          var idx = $e.index();
          var itemsPerSlide = 3;
          var totalItems = $(".carousel-item").length;

          if (idx >= totalItems - (itemsPerSlide - 1)) {
            var it = itemsPerSlide - (totalItems - idx);
            for (var i = 0; i < it; i++) {

              if (e.direction == "left") {
                $(".carousel-item")
                  .eq(i)
                  .appendTo(".carousel-inner");
              } else {
                $(".carousel-item")
                  .eq(0)
                  .appendTo($(this).find(".carousel-inner"));
              }
            }
          }
        });
      });
    </script>
  </body>
</html>
