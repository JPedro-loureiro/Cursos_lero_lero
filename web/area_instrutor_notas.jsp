<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!-- FAZER DIREITINHO!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! -->
<%@page import="model.Aluno"%>
<%@page import="model.Matricula"%>
<%@page import="model.Turma"%>
<%@page import="model.Instrutor"%>

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
            <!-- <% List<Aluno> alunos = (List<Aluno>) request.getAttribute("alunos");
                        for (Aluno i : alunos) { %> -->

                            <form class="py-3" id="form-alunos-curso" method="POST" action="">
                            
                                <div class="form-group">
                                    <label for="Campo_cadastro">Nota do aluno <%if (aluno != null) {%><%=aluno.getNome()%><%}%> da turma <%if (turma != null) {%><%=turma.getid()%><%}%></label>
                                    <input type="text" name="instrutores_id" class="form-control instrutores_id" id="instrutores_id"
                                        value="<%if (nota != null) {%><%=matricula.getNota()%><%}%>">
                                </div>
                            
                                <div class="col-md-12 text-center mb-3">
                                    <button type="submit" class=" btn btn-primary tx-tfm">Inserir no sistema</button>
                                </div>
                            </form>

                        <%}%>
                    </tbody>
            </table>
        </div>

        <!-- Rodapé -->
        <jsp:include page="rodape.jsp" />
    </body>

</html>