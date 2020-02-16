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
        <jsp:include page="navbar_administrador.jsp" />

        <div class="container">
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
                        <!-- FAZER DIREITINHO!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! -->
                        <!-- <% List<Aluno> alunos = (List<Aluno>) request.getAttribute("alunos");
                                        for (Aluno i : alunos) { %>
                            <tr>
                                <th scope="row">
                                    <%=i.getId()%>
                                </th>

                                <td><%=NOME DO INSTRUTOR()%></td>
                                <td><%=NOME DO CURSO()%></td>
                                <td><%=i.getData_inicio()%></td>
                                <td><%=i.getData_fim()%></td>
                                <td><%=i.getCarga_horaria()%></td>

                                <td>
                                    <a href="AÇÃO OU LINK">
                                        <button type="button" class="btn btn-primary">Matricule-se</button>
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