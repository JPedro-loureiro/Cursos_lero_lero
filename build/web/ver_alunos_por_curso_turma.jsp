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
                <h1 class="text-primary">Alunos por curso/turma</h1>
            </div>

            <!-- FAZER DIREITINHO!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! -->
            <form class="py-3" id="form-alunos-curso" method="POST" action="">
            
                <div class="form-group">
                    <label for="Campo_cadastro">id da turma</label>
                    <input type="text" name="instrutores_id" class="form-control instrutores_id" id="instrutores_id"
                        placeholder="(Obrigatório)">
                </div>
            
                <div class="col-md-12 text-center mb-3">
                    <button type="submit" class=" btn btn-primary tx-tfm">Pesquisar</button>
                </div>
            </form>

            <table class="table table-responsive-md table-hover ">

                <thead-light>
                    <tr>
                        <th scope="col">id do aluno</th>
                        <th scope="col">Nome do aluno</th>
                        <th scope="col">Nome do curso</th>
                        <th scope="col">nota</th>
                    </tr>
                    </thead>

                    <tbody>
                        <!-- FAZER DIREITINHO!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! -->
                        <!-- <% List<Aluno> alunos = (List<Aluno>) request.getAttribute("alunos");
                                for (Aluno i : alunos) { %>
                        <tr>
                            <th scope="row">
                                <td><%=i.getAluno_id()%></td>
                            </th>

                            <td><%=i.getTurma_id()%></td>
                            <td><%=i.getAluno_id()%></td>
                            <td><%=i.getData_matricula()%></td>
                            <td><%=i.getNota()%></td>

                        </tr>
                    <%}%> -->
                </tbody>
            </table>
        </div>

        <!-- Rodapé -->
        <jsp:include page="rodape.jsp" />
    </body>

</html>