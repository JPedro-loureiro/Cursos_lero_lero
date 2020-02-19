<%@page import="model.Instrutor"%>
<%@page import="model.CursoPorInstrutor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Aluno"%>
<%@page import="java.util.List"%>

<html lang="pt-br">

    <head>
        <jsp:include page="head.jsp" />
    </head>

    <body>

        <!-- Navbar -->
        <jsp:include page="navbar.jsp" />

        <div class="text-center py-3">
            <h3 class="text-primary"> </h3>
        </div>
        
        <div class="container">
            <div class="text-center py-5">
                <h1 class="text-primary">Cursos e turmas por instrutor</h1>
            </div>

            <form class="py-3" id="form-alunos-curso" method="POST" action="ServletCursoPorInstrutor">

                <div class="form-group">
                    <label for="Campo_cadastro">id do instrutor</label>
                    <input type="text" name="instrutores_id" class="form-control instrutores_id" id="instrutores_id"
                        placeholder="(Obrigatório)">
                </div>

                <div class="col-md-12 text-center mb-3">
                    <button type="submit" class=" btn btn-primary tx-tfm">Pesquisar</button>
                </div>
            </form>
            <%if(request.getAttribute("cursos") != null){%>
            <%Instrutor instrutor = (Instrutor) request.getAttribute("instrutor");%>
            <%=instrutor.getNome()%>

            <table class="table table-responsive-md table-hover ">

                <thead-light>
                    <tr>
                        <th scope="col">id da turma</th>
                        <th scope="col">Nome do curso</th>
                    </tr>
                    </thead>

                    <tbody>
                        <% List<CursoPorInstrutor> cursos = (List<CursoPorInstrutor>) request.getAttribute("cursos");
                                    for (CursoPorInstrutor i : cursos) { %>
                            <tr>
                                <th scope="row">
                                   <%=i.getId_turma()%>
                                </th>

                                <td><%=i.getNome_curso()%></td>
                            </tr>
                    <%}%>
                </tbody>
            </table>
        </div>

        <div class="container">
                <%Float valor = instrutor.getValorAReceber(instrutor.getId());%>
                <h3 class="text-primary">Valor total: <%=valor%></h1>
            
        </div>
        <%}%>
        <!-- Rodapé -->
        <jsp:include page="rodape.jsp" />
    </body>

</html>