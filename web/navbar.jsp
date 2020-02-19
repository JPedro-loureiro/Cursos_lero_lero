<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<header>
    <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">

        <a class="navbar-brand h4" href="index.jsp">Cursos Lero Lero</a>

        
            <ul class="navbar-nav mr-auto">

                <li class="nav-item active">
                    <a class="nav-link" href="sobre_nos.jsp">Sobre nós </a>
                </li>

                <li class="nav-item active">
                    <a class="nav-link" href="instrutores.jsp">Instrutores</a>
                </li>

                <li class="nav-item active">
                    <a class="nav-link" href="comentarios.jsp">Comentários </a>
                </li>
            
                <%if("adm".equals(request.getSession().getAttribute("tipoUsuario"))){ %>
                    <li class="nav-item">
                    <a class="nav-link" href="painel_controle.jsp">Painel de controle </a>
                    </li>
                <%}%>
            </ul>
            
            <a class="btn btn-primary" href="cadastro.jsp" role="button">Cadastre-se</a>
            <a class="nav-link" href="login.jsp">Login <span class="sr-only">(current)</span></a>
            
    </nav>
</header>