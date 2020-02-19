<%@page import="dao.MatriculaDao"%>
<%@page import="model.AlunoCursoTurma"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

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

        <div class="container pt-5">
            <div class="text-center py-5">
                <h1 class="text-primary">Alunos por curso/turma</h1>
            </div>

            <% List<AlunoCursoTurma> matriculas = (List<AlunoCursoTurma>) request.getAttribute("matriculas");
                        for (AlunoCursoTurma i : matriculas) { %>

                            
                            <form class="py-3" id="form-aluno" method="POST" action="ServletAtribuirNota">
                                <div class="form-group">
                                    <label for="Campo_cadastro">Nota do aluno <%if (i.getNome_aluno() != null) {%><%=i.getNome_aluno()%><%}%> da turma <%=i.getId_turma()%></label>
                                    <input type="text" name="nota" class="form-control instrutores_id" id="instrutores_id"
                                        value="<%=i.getNota()%>">
                                </div>
                                
                              
                                <div class="form-group">
                                    <label for="Campo_cadastro">id_aluno</label>
                                    <input type="hidden" name="id_aluno" class="form-control instrutores_id" id="instrutores_id"
                                        value="<%i.getId_aluno();%>">
                                </div>
                                
                                <div class="form-group">
                                    <label for="Campo_cadastro">id_turma</label>
                                    <input type="hidden" name="id_turma" class="form-control instrutores_id" id="instrutores_id"
                                           value="<%i.getId_turma();%>">
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