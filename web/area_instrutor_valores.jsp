<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Aluno"%>

<%@page import="java.util.List"%>

<html lang="pt-br">

    <head>
        <jsp:include page="head.jsp" />
    </head>

    <body>

        <!-- Navbar -->
        <jsp:include page="navbar.jsp" />

        <div class="container pt-5">
            <div class="text-center py-5">
                <h1 class="text-primary">Valores</h1>
            </div>

        <div class="container">
            <div class="text-center py-5">
                <h3 class="text-primary">Valor total: <%=request.getAttribute("valor")%></h1>
            </div>
        </div>

        <!-- Rodapé -->
        <jsp:include page="rodape.jsp" />
    </body>

</html>