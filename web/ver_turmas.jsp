<%@page import="model.Turma"%>
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
                <h1 class="text-primary">Turmas</h1>
            </div>

            <table class="table table-responsive-md table-hover ">

                <thead-light>
                    <tr>
                        <th scope="col">id</th>
                        <th scope="col">id do instrutor</th>
                        <th scope="col">id do curso</th>
                        <th scope="col">Início</th>
                        <th scope="col">Fim</th>
                        <th scope="col">Carga horária</th>
                    </tr>
                    </thead>

                    <tbody>
                        <!-- FAZER DIREITINHO!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! -->
                        <!-- <% List<Turma> turmas = (List<Turma>) request.getAttribute("listTurmas");
                                    for (Turma i : turmas) { %>
                        <tr>
                            <th scope="row">
                                <%=i.getId()%>
                            </th>

                            <td><%=i.getInstrutor_id()%></td>
                            <td><%=i.getCurso_id()%></td>
                            <td><%=i.getData_inicio()%></td>
                            <td><%=i.getData_fim()%></td>
                            <td><%=i.getCarga_horaria()%></td>

                            <td>
                                <a href="">
                                    <button type="button" class="btn btn-primary">Editar</button>
                                </a>

                                <a href="ServletVerTurma?action=apagar&id_turma=<%=i.getId()%>">
                                    <button type="button" class="btn btn-danger">Apagar</button>
                                </a>
                        
                                <a href="inserir_turma.jsp">
                                    <button type="button" class="btn btn-danger">Inserir</button>
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