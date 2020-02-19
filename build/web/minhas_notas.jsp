<%@page import="model.AlunoNotaTurma"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="model.Turma"%>
<%@page import="model.Instrutor"%>
<%@page import="model.Curso"%>

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
                <h1 class="text-primary">Notas</h1>
            </div>

            <table class="table table-responsive-md table-hover ">

                <thead-light>
                    <tr>
                        <th scope="col">Curso</th>
                        <th scope="col">Turma</th>
                        <th scope="col">Nota</th>
                    </tr>
                    </thead>

                    <tbody>
                        <!-- FAZER DIREITINHO!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! -->
                        <% List<AlunoNotaTurma> notas = (List<AlunoNotaTurma>) request.getAttribute("notas");
                                        for (AlunoNotaTurma i : notas) { %>
                            <tr>
                                <th scope="row">
                                    <%=i.getNome_aluno()%>
                                </th>

                                <td><%=i.getNome_curso()%></td>
                                <td><%=i.getId_turma()%></td>
                                <td><%=i.getNota()%></td>

                                
                            </tr>
                        <%}%>
                    </tbody>
            </table>
        </div>

        <!-- Rodapé -->
        <jsp:include page="rodape.jsp" />
    </body>

</html>