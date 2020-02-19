<%@page import="model.Instrutor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Aluno"%>
<%@page import="java.util.List"%>

<html lang="pt-br">

    <head>
        <jsp:include page="head.jsp" />
    </head>

    <body>

        <div class="text-center py-3">
            <h3 class="text-primary"> </h3>
        </div>
        
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
                        <% List<Instrutor> instrutores = (List<Instrutor>) request.getAttribute("listInstrutores");
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
                                <a href="ServletVerInstrutor?action=editar&id=<%=i.getId()%>">
                                    <button type="button" class="btn btn-primary">Editar</button>
                                </a>

                                <a href="ServletVerInstrutor?action=apagar&id=<%=i.getId()%>">
                                    <button type="button" class="btn btn-danger">Apagar</button>
                                </a>
                        
                            </td>
                        </tr>
                    <%}%>
                </tbody>
            </table>
        </div>

        <!-- Rodapé -->
        <jsp:include page="rodape.jsp" />
    </body>

</html>