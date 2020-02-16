<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html lang="pt-br">

<head>
    <jsp:include page="head.jsp" />
</head>

<body>

    <!-- Navbar -->
    <jsp:include page="navbar_administrador.jsp" />

    <div class="painel_controle_opcoes py-5 my-5">
    
        <div class="container py-5 my-5">
    
            <div class="text-center py-5">
                <h1 class="text-primary">Painel de controle</h1>
            </div>
    
            <div class="row d-flex justify-content-center">
                <div class="btn-group btn-group-lg" role="group">

                    <a type="button" class="btn btn-outline-primary px-4" 
                    href="ServletAprovCadastrosPendentes?action=listPendentes">Aprovar registros</a>

                    <a type="button" class="btn btn-outline-primary px-4" 
                    href="tabelas.jsp">Inserir dados</a>
                </div>
            </div>

            <div class="text-center py-5">
                <h3 class="text-primary">Ver dados</h3>
            </div>
            
            <div class="row d-flex justify-content-center">
                <div class="btn-group btn-group-lg" role="group">

                    <a type="button" class="btn btn-outline-primary px-4" 
                    href="ServletVerAluno?action=listAlunos">Alunos</a>

                    <a type="button" class="btn btn-outline-primary px-4" 
                    href="ServletVerCurso?action=listCursos">Cursos</a>

                    <a type="button" class="btn btn-outline-primary px-4" 
                    href="ServletVerInstrutor?action=listInstrutores">Instrutores</a>

                    <a type="button" class="btn btn-outline-primary px-4" 
                    href="ServletVerTurma?action=listTurmas">Turmas</a>

                    <a type="button" class="btn btn-outline-primary px-4" 
                    href="ver_alunos_por_curso_turma.jsp">Alunos por curso/turma</a>

                    <a type="button" class="btn btn-outline-primary px-4" 
                    href="ver_curso_turma_por_instrutor.jsp">Curso/turma por instrutor</a>
                </div>
            </div>

            <div class="text-center py-5">
                <h3 class="text-primary">Upload de imagens</h3>
            </div>
            
            <!-- FAZER DIREITINHO!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! -->
            <div class="row d-flex justify-content-center pb-4">
                <div class="btn-group btn-group-lg" role="group">
            
                    <a type="button" class="btn btn-outline-primary px-4" href="">Foto do curso (não disponível)</a>
            
                    <a type="button" class="btn btn-outline-primary px-4" href="">Foto do instrutor (não disponível)</a>
                </div>
            </div>

        </div>
    </div>

    <!-- Rodapé -->
    <jsp:include page="rodape.jsp" />
</body>

</html>