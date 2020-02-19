<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="model.Instrutor"%>

<html lang="pt-br">

<head>
    <jsp:include page="head.jsp" />
</head>

<body>

    <!-- Navbar -->
    <jsp:include page="navbar.jsp" />

    <% Instrutor i = (Instrutor) request.getAttribute("instrutor"); %>

    <div class="container pt-5">
        <div class="text-center py-5">
            <h1 class="text-primary">Bem vindo, instrutor <%if (i != null) {%><%=i.getNome()%><%}%> </h1>
            </div>
        </div>

        <div class="row d-flex justify-content-center">
            <div class="btn-group btn-group-lg" role="group">
        
                <a type="button" class="btn btn-outline-primary px-4" 
                href="ServletAtribuirNota?id_instrutor=<%=i.getId()%>">Alunos e notas</a>
                
                <a type="button" class="btn btn-outline-primary px-4" 
                href="ServletRecebiveis?id_instrutor=<%=i.getId()%>">Valor a Receber</a>
            </div>
        </div>

        <div class="container">
            <div class="text-center pt-5">
                <h3 class="text-secondary">Meus dados </h3>
            </div>
        </div>

        <div class="myform form py-5 px-5">

            <form class="py-3" id="form-instrutor" method="POST" action="ServletAlteraDadosCadastraisInstrutor">
        
                <div class="form-group">
                    <label for="Campo_cadastro">Nome</label>
                    <input type="text" name="nome" class="form-control nome" id="nome"
                    value="<%if (i != null) {%><%=i.getNome()%><%}%>">
                </div>
        
                <div class="form-group">
                    <label for="Campo_cadastro">Email</label>
                    <input type="email" name="email" class="form-control email" id="email"
                    value="<%if (i != null) {%><%=i.getEmail()%><%}%>">
                </div>
        
                <div class="form-group">
                    <label for="Campo_cadastro">Login</label>
                    <input type="text" name="login" class="form-control login" id="login"
                    value="<%if (i != null) {%><%=i.getLogin()%><%}%>">
                </div>
        
                <div class="form-group">
                    <label for="Campo_cadastro">Experiência</label>
                    <input type="text" name="experiencia" class="form-control experiencia" id=" 
                    experiencia"value="<%if (i != null) {%><%=i.getExperiencia()%><%}%>">
                </div>
        
                <div class="col-md-12 text-center mb-3">
                    <button type="submit" class=" btn btn-primary tx-tfm">Inserir no sistema</button>
                </div>
            </form>
        </div>


        <!-- Rodapé -->
        <jsp:include page="rodape.jsp" />

        <script>
            $(document).ready(function () {
                $('#form-instrutor').validate({
                    rules: {

                        nome: { required: true, minlength: 3, maxlength: 50 },

                        email: { required: true },

                        valor_hora: { number: true },

                        login: { required: true, minlength: 3, maxlength: 20 },

                        experiencia: { minlength: 3, maxlength: 255 },

                    },
                    messages: {

                        nome: {
                            required: "Obrigatório",
                            minlength: "3 caracteres no mínimo",
                            maxlength: "50 caracteres no máximo"
                        },

                        email: { required: "Obrigatório" },

                        login: {
                            required: "Obrigatório",
                            minlength: "3 caracteres no mínimo",
                            maxlength: "20 caracteres no máximo"
                        },

                        experiencia: {
                            minlength: "Deve ter 3 caracteres",
                            maxlength: "Deve ter 255 caracteres"
                        },

                    },

                    submitHandler: function (form) {
                        form.submit();
                    }
                });
            });
        </script>
    </body>
</html>