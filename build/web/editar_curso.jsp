<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="model.Curso"%>

<html lang="pt-br">

<head>
    <jsp:include page="head.jsp" />
</head>

<body>

    <!-- Navbar -->
    <jsp:include page="navbar.jsp" />
    
    <% Curso i = (Curso) request.getAttribute("curso"); %>

    <div class="container-fluid py-5">

        <div class="myform form">

            <div class="container pt-5">
                <div class="text-center pt-5">
                    <h1 class="text-primary">Editar curso</h1>
                </div>
            </div>

            <form class="py-3 px-5" id="form-curso" method="POST" action="ServletEditarCurso">

                <div class="form-group">
                    <label for="Campo_cadastro">Nome do curso</label>
                    <input type="text" name="nome" class="form-control nome" id="nome" value="<%if (i != null) {%><%=i.getNome()%><%}%>">
                </div>

                <div class="form-group">
                    <label for="Campo_cadastro">Requisito</label>
                    <input type="text" name="requisito" class="form-control requisito" id="requisito"
                    value="<%if (i != null) {%><%=i.getRequisito()%><%}%>">
                </div>

                <div class="form-group">
                    <label for="Campo_cadastro">Ementa</label>
                    <input name="ementa" id="ementa" class="form-control ementa" value="<%if (i != null) {%><%=i.getEmenta()%><%}%>">
                </div>

                <div class="form-group">
                    <label for="Campo_cadastro">Carga horária</label>
                    <input type="text" name="carga_horaria" class="form-control carga_horaria" id="carga_horaria"
                    value="<%if (i != null) {%><%=i.getCarga_horaria()%><%}%>">
                </div>

                <div class="form-group">
                    <label for="Campo_cadastro">Preço</label>
                    <input type="text" name="preco" id="preco" class="form-control preco" value="<%if (i != null) {%><%=i.getPreco()%><%}%>">
                </div>

                <div class="col-md-12 text-center mb-3">
                    <button type="submit" class=" btn btn-primary tx-tfm">Editar</button>
                </div>
            </form>
        </div>
    </div>

    <!-- Rodapé -->
    <jsp:include page="rodape.jsp" />

    <script>
        $(document).ready(function () {
            $("#form-curso").validate({
                rules: {

                    nome: { required: true, minlength: 3, maxlength: 50 },

                    requisito: { maxlength: 255 },

                    ementa: { maxlength: 255 },

                    carga_horaria: { digits: true, maxlength: 5 },

                    preco: { number: true }

                },
                messages: {

                    nome: {
                        required: "Obrigatório",
                        minlength: "3 caracteres no mínimo",
                        maxlength: "50 caracteres no máximo"
                    },

                    requisito: { maxlength: "255 caracteres no máximo" },

                    ementa: { maxlength: "255 caracteres no máximo" },

                    carga_horaria: { maxlength: "5 caracteres no máximo" }
                },

                submitHandler: function (form) {
                    form.submit();
                }
            });
        });
    </script>
</body>

</html>