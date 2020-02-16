<%@page import="model.Instrutor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!-- FAZER DIREITINHO!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! -->
<%@page import="model.Aluno"%>

<%@page import="java.util.List"%>

<html lang="pt-br">

    <head>
        <jsp:include page="head.jsp" />
    </head>

    <body>

        <!-- Navbar -->
        <jsp:include page="navbar_administrador.jsp" />

        <div class="container">
            <div class="text-center py-5">
                <h1 class="text-primary">Instrutores</h1>
            </div>

            <table class="table table-responsive-md table-hover ">

                <thead-light>
                    <tr>
                        <th scope="col">id</th>
                        <th scope="col">Nome</th>
                        <th scope="col">Email</th>
                        <th scope="col">Valor/hora</th>
                        <th scope="col">Login</th>
                    </tr>
                </thead>

                    <tbody>
                        <!-- FAZER DIREITINHO!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! -->
                        <!-- <% List<Instrutor> instrutores = (List<Instrutor>) request.getAttribute("listInstrutores");
                            for (Instrutor i : instrutores) { %>
                        <tr>
                            <th scope="row">
                                <%=i.getId()%>
                            </th>

                            <td><%=i.getNome()%></td>
                            <td><%=i.getEmail()%></td>
                            <td><%=i.getValor_hora()%></td>
                            <td><%=i.getLogin()%></td>

                            <td>
                                <a href="">
                                    <button type="button" class="btn btn-primary">Editar</button>
                                </a>

                                <a href="ServletVerInstrutores?action=apagar&id=<%=i.getId()%>">
                                    <button type="button" class="btn btn-danger">Apagar</button>
                                </a>
                        
                                <a href="inserir_instrutor.jsp">
                                    <button type="button" class="btn btn-primary">Inserir</button>
                                </a>
                            </td>
                        </tr>
                    <%}%> -->
                </tbody>
            </table>
        </div>

        <!-- Rodapé -->
        <jsp:include page="rodape.jsp" />
    </body>

</html>