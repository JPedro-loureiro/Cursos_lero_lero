<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="model.Aluno"%>

<html lang="pt-br">

    <head>
        <jsp:include page="head.jsp" />
    </head>

    <body>

        <!-- Navbar -->
        <jsp:include page="navbar.jsp" />

        <% Aluno i = (Aluno) request.getAttribute("aluno"); %>

        <div class="container pt-5">
            <div class="text-center pt-5">
                <h1 class="text-primary">Bem vindo, <%if (i != null) {%><%=i.getNome()%><%}%> </h1>
            </div>
        </div>

        <div class="row d-flex justify-content-center">
            <div class="btn-group btn-group-lg" role="group">
        
                <a type="button" class="btn btn-outline-primary px-4" 
                href="ServletTurmasDisponiveis">Turmas Disponíneis</a>

                <a type="button" class="btn btn-outline-primary px-4" 
                href="ServletMinhasNotas?id=<%=i.getId()%>">Minhas Notas</a>
                
                <a type="button" class="btn btn-outline-primary px-4" 
                href="">Subir foto (não disponível)</a>
            </div>
        </div>

        <div class="container pt-5">
            <div class="text-center pt-5">
                <h3 class="text-secondary">Meus dados </h3>
            </div>
        </div>

        <div class="myform form py-5">

            <form class="py-3" id="form-aluno" method="POST" action="ServletAlterarDadosCadastraisAluno">
        
                <div class="form-group">
                    <label for="Campo_cadastro">Nome</label>
                    <input type="text" name="nome" class="form-control nome" id="nome"
                    value="<%if (i != null) {%><%=i.getNome()%><%}%>">
                </div>
                
                <div class="form-group">
                    <label for="Campo_cadastro">CPF</label>
                    <input type="text" name="cpf" class="form-control cpf" id="cpf""
                     value="<%if (i != null) {%><%=i.getCpf()%><%}%>">
                </div>
        
                <div class="form-group">
                    <label for="Campo_cadastro">Email</label>
                    <input type="email" name="email" class="form-control email" id="email"
                    value="<%if (i != null) {%><%=i.getEmail()%><%}%>">
                </div>
        
                <div class="form-group">
                    <label for="Campo_cadastro">Celular ((XX)XXXXX-XXXX)</label>
                    <input type="text" class="form-control celular" id="celular" name="celular"
                    value="<%if (i != null) {%><%=i.getCelular()%><%}%>")>
                </div>
        
                <div class="form-group">
                    <label for="Campo_cadastro">Login</label>
                    <input type="text" name="login" class="form-control login" id="login"
                    value="<%if (i != null) {%><%=i.getLogin()%><%}%>">
                </div>
        
                <div class="form-group">
                    <label for="Campo_cadastro">Endereço</label>
                    <input type="text" class="form-control endereco" id="endereco" name="endereco"
                    value="<%if (i != null) {%><%=i.getEndereco()%><%}%>">
                </div>
        
                <div class="form-group">
                    <label for="Campo_cadastro">Bairro</label>
                    <input type="text" class="form-control bairro" id="bairro" name="bairro"
                    value="<%if (i != null) {%><%=i.getBairro()%><%}%>">
                </div>
        
                <div class="form-group">
                    <label for="Campo_cadastro">Cidade</label>
                    <input type="text" class="form-control cidade" id="cidade" name="cidade"
                    value="<%if (i != null) {%><%=i.getCidade()%><%}%>">
                </div>
        
                <div class="form-group">
                    <label for="Campo_cadastro">CEP (XXXXX-XXX)</label>
                    <input type="text" class="form-control cep" id="cep" name="cep"
                    value="<%if (i != null) {%><%=i.getCep()%><%}%>">
                </div>
        
                <div class="col-md-12 text-center mb-3">
                    <button type="submit" class=" btn btn-primary tx-tfm">Enviar</button>
                </div>
            </form>
        </div>


        <!-- Rodapé -->
        <jsp:include page="rodape.jsp" />

        <script>
            $(document).ready(function () {
                $("#form-aluno").validate({
                    rules: {

                        cpf: { required: true, minlength: 11, maxlength: 11, digits: true },

                        nome: { required: true, minlength: 3, maxlength: 50 },

                        email: { required: true },

                        celular: { required: true, minlength: 14, maxlength: 14 },

                        login: { required: true, minlength: 3, maxlength: 20 },

                        endereco: { minlength: 3, maxlength: 50 },

                        bairro: { minlength: 3, maxlength: 30 },

                        cidade: { minlength: 3, maxlength: 30 },

                        cep: { minlength: 9, maxlength: 9 }

                    },
                    messages: {

                        cpf: {
                            required: "Obrigatório",
                            minlength: "O CPF deve ter 11 dígitos",
                            maxlength: "O CPF deve ter 11 dígitos"
                        },

                        nome: {
                            required: "Obrigatório",
                            minlength: "3 caracteres no mínimo",
                            maxlength: "50 caracteres no máximo"
                        },

                        email: { required: "Obrigatório" },

                        celular: {
                            required: "Obrigatório",
                            minlength: "O celular deve ter 14 caracteres",
                            maxlength: "O celular deve ter 14 caracteres"
                        },

                        login: {
                            required: "Obrigatório",
                            minlength: "3 caracteres no mínimo",
                            maxlength: "20 caracteres no máximo"
                        },

                        endereco: {
                            minlength: "3 caracteres no mínimo",
                            maxlength: "50 caracteres no máximo"
                        },

                        bairro: {
                            minlength: "3 caracteres no mínimo",
                            maxlength: "30 caracteres no máximo"
                        },

                        cidade: {
                            minlength: "3 caracteres no mínimo",
                            maxlength: "30 caracteres no máximo"
                        },

                        cep: {
                            minlength: "O CEP deve ter 9 caracteres",
                            maxlength: "O CEP deve ter 9 caracteres"
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
