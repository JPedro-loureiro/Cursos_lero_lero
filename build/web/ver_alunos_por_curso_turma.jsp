<%@page import="model.AlunoCursoTurma"%>
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

        <div class="text-center py-3">
            <h3 class="text-primary"> </h3>
        </div>
        
        <div class="text-center py-5">
            <h1 class="text-primary">Alunos por curso/turma</h1>
        </div>

        <!-- FAZER DIREITINHO!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! -->
        <form class="py-3 px-5" id="form-alunos-curso" method="POST" action="ServletAlunoPorCurso">

            <div class="form-group">
                <label for="Campo_cadastro">id da turma</label>
                <input type="text" name="turma_id" class="form-control turma_id" id="turma_id"
                    placeholder="(Obrigatório)">
            </div>

            <div class="col-md-12 text-center mb-3">
                <button type="submit" class=" btn btn-primary tx-tfm">Pesquisar</button>
            </div>
        </form>
        <%if(request.getAttribute("alunos") != null){ %>
        <%=request.getAttribute("curso")%>
        <%=request.getAttribute("turma")%>

        <table class="table table-responsive-md table-hover ">

            <thead-light>
                <tr>
                    <th scope="col">id do aluno</th>
                    <th scope="col">Nome do aluno</th>
                    <th scope="col">Nome do curso</th>
                    <th scope="col">nota</th>
                </tr>
                </thead>


                    <% List<AlunoCursoTurma> alunos = (List<AlunoCursoTurma>) request.getAttribute("alunos");
                            for (AlunoCursoTurma i : alunos) { %>
                    <tr>
                        <th scope="row">
                            <td><%=i.getNome_aluno()%></td>
                        </th>

                        <td><%=i.getNome_aluno()%></td>
                        <td><%=i.getNota()%></td>

                    </tr>
                <%}%>
            <%}%>
        </table>


        <!-- Rodapé -->
        <jsp:include page="rodape.jsp" />
    
    </body>
</html>