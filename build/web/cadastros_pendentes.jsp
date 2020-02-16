<%@page import="java.util.List"%>
<%@page import="model.Aluno"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html lang="pt-br">

    <head>
        <jsp:include page="head.jsp" />
    </head>

    <body>

        <!-- Navbar -->
        <jsp:include page="navbar_administrador.jsp" />

        <div class="container">
            <div class="text-center py-5">
                <h1 class="text-primary">Cadastros pendentes</h1>
            </div>
        
            <table class="table table-responsive-md table-hover ">
        
                <thead-light>
                    <tr>
                        <th scope="col">id</th>
                        <th scope="col">Nome</th>
                        <th scope="col">CPF</th>
                        <th scope="col">Email</th>

                    </tr>
                    </thead>
        
                    <tbody>
                        <!-- FAZER DIREITINHO!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! -->
                        <%  List<Aluno> aprovPendentes = (List<Aluno>) request.getAttribute("aprovPendentes");
                                for (Aluno i : aprovPendentes) { %>
                        <tr>
                            <th scope="row">
                                <%=i.getId()%>
                            </th>
        
                            <td><%=i.getCpf()%></td>
                            <td><%=i.getNome()%></td>
                            <td><%=i.getEmail()%></td>
                            <td><%=i.getCelular()%></td>
        
                            <td>

                                <a href="ServletAprovCadastrosPendentes?action=aprovar&id_aluno=<%=i.getId()%>">
                                    <button type="button" class="btn btn-primary">Aprovar</button>
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