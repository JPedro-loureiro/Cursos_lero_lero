<%@page import="model.Curso"%>
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
                <h1 class="text-primary">Cursos</h1>
            </div>

            <table class="table table-responsive-md table-hover ">

                <thead-light>
                    <tr>
                        <th scope="col">id</th>
                        <th scope="col">Nome do Curso</th>
                        <th scope="col">Requisito</th>
                        <th scope="col">Ementa</th>
                        <th scope="col">Carga horária</th>
                        <th scope="col">Preço</th>
                    </tr>
                    </thead>

                    <tbody>
                        <!-- FAZER DIREITINHO!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! -->
                        <!-- <% List<Curso> cursos = (List<Curso>) request.getAttribute("listCursos");
                            for (Curso i : cursos) { %>
                        <tr>
                            <th scope="row">
                                <%=i.getId()%>
                            </th>

                            <td><%=i.getNome()%></td>
                            <td><%=i.getRequisito()%></td>
                            <td><%=i.getEmenta()%></td>
                            <td><%=i.getCarga_horaria()%></td>
                            <td><%=i.getPreco()%></td>

                            <td>
                                <a href="">
                                    <button type="button" class="btn btn-primary">Editar</button>
                                </a>

                                <a href="ServletVerCurso?action=apagar&id_curso=<%=i.getId()%>">
                                    <button type="button" class="btn btn-danger">Apagar</button>
                                </a>
                        
                                <a href="inserir_curso.jsp">
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