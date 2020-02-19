<%@page import="model.TurmasDisponiveis"%>
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
                <h1 class="text-primary">Turmas disponíveis</h1>
            </div>

            <table class="table table-responsive-md table-hover ">

                <thead-light>
                    <tr>
                        <th scope="col">id</th>
                        <th scope="col">Instrutor</th>
                        <th scope="col">Curso</th>
                        <th scope="col">Início</th>
                        <th scope="col">Fim</th>
                        <th scope="col">Carga horária</th>
                    </tr>
                    </thead>

                    <tbody>
                        
                        <% List<TurmasDisponiveis> turmas = (List<TurmasDisponiveis>) request.getAttribute("turmas_disponiveis");
                                        for (TurmasDisponiveis i : turmas) { %>
                            <tr>
                                <th scope="row">
                                    <%=i.getId_turma()%>
                                </th>

                                <td><%=i.getNome_instrutor()%></td>
                                <td><%=i.getNome_curso()%></td>
                                <td><%=i.getData_inicio()%></td>
                                <td><%=i.getData_fim()%></td>
                                <td><%=i.getCarga_horaria()%></td>

                                <td>
                                    <a href="ServletTurmasDisponiveis?action=matricular&turma=<%=i.getId_turma()%>">
                                        <button type="button" class="btn btn-primary">Matricule-se</button>
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