<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html lang="pt-br">

    <head>
        <jsp:include page="head.jsp" />
    </head>

    <body>

        <!-- Navbar -->
        <jsp:include page="navbar_administrador.jsp" />

        <div class="container-fluid py-5">
        
            <div class="myform form">
        
                <div class="container pt-5">
                    <div class="text-center pt-5">
                        <h1 class="text-primary">Novo aluno</h1>
                    </div>
                </div>

                <form class="py-3" id="form-aluno" method="POST" action="ServletInserirAluno">
                    
                    <div class="form-group">
                        <label for="Campo_cadastro">CPF</label>
                        <input type="text"  name="cpf" class="form-control cpf" id="cpf" 
                        placeholder="(Obrigatório)">
                    </div>

                    <div class="form-group">
                        <label for="Campo_cadastro">Nome</label>
                        <input type="text"  name="nome" class="form-control nome" id="nome" 
                        placeholder="(Obrigatório)">
                    </div>

                    <div class="form-group">
                        <label for="Campo_cadastro">Email</label>
                        <input type="email" name="email"  class="form-control email" id="email" 
                        placeholder="(Obrigatório)">
                    </div>

                    <div class="form-group">
                        <label for="Campo_cadastro">Celular ((XX)XXXXX-XXXX)</label>
                        <input type="text" class="form-control celular" id="celular" name="celular" 
                        placeholder="(Obrigatório)">
                    </div>

                    <div class="form-group">
                        <label for="Campo_cadastro">Login</label>
                        <input type="text"  name="login" class="form-control login"
                        id="login" placeholder="(Obrigatório)">
                    </div>

                    <div class="form-group">
                        <label for="Campo_cadastro">Senha</label>
                        <input type="password" name="senha" id="senha"  
                        class="form-control senha" placeholder="(Obrigatória)">
                    </div>

                    <div class="form-group">
                        <label for="Campo_cadastro">Endereço</label>
                        <input type="text" class="form-control endereco" id="endereco" name="endereco" 
                        placeholder="(Opcional)">
                    </div>
                    
                    <div class="form-group">
                        <label for="Campo_cadastro">Bairro</label>
                        <input type="text" class="form-control bairro" id="bairro" name="bairro" 
                        placeholder="(Opcional)">
                    </div>

                    <div class="form-group">
                        <label for="Campo_cadastro">Cidade</label>
                        <input type="text" class="form-control cidade" id="cidade" name="cidade" 
                        placeholder="(Opcional)">
                    </div>
                    
                    <div class="form-group">
                        <label for="Campo_cadastro">CEP (XXXXX-XXX)</label>
                        <input type="text" class="form-control cep" id="cep" name="cep" 
                        placeholder="(Opcional)">
                    </div>

                    <div class="form-group">
                        <label for="Campo_cadastro">Comentário</label>
                        <input type="text" name="comentario" class="form-control comentario" id="comentario"
                        placeholder="(Opcional)">
                    </div>

                    <div class="form-group">
                        <label for="Campo_cadastro">Aprovado</label>
                        <input type="text" class="form-control aprovado" id="aprovado" 
                        name="comentario" placeholder="(Obrigatório)">
                    </div>

                    <div class="col-md-12 text-center mb-3">
                        <button type="submit" class=" btn btn-primary tx-tfm">Inserir no sistema</button>
                    </div>
                </form>
            </div>
        </div>
        
        <!-- Rodapé -->
        <jsp:include page="rodape.jsp" />

        <script src="js/jquery-3.4.1.min.js"></script>
        <script src="js/popper.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script type="text/javascript" src="js/jquery-validation/dist/jquery.validate.min.js"></script>
        <script type="text/javascript" src="js/validate_traducao.js"></script>

        <script>
            $(document).ready(function() {
                $("#form-aluno").validate({
                    rules: {

                        cpf: { required: true, minlength: 11, maxlength:11, digits: true },
                        
                        nome: { required: true, minlength: 3, maxlength: 50 },

                        email: { required: true },

                        celular: { required: true, minlength: 14, maxlength: 14 },

                        login: { required: true, minlength: 3, maxlength: 20 },

                        senha: { required: true, minlength: 6, maxlength: 255 },

                        endereco: {minlength: 3, maxlength: 50 },

                        bairro: {minlength: 3, maxlength: 30 },

                        cidade: {minlength: 3, maxlength: 30 },

                        cep: {minlength: 9, maxlength: 9 },

                        comentario: { minlength: 3, maxlength: 255 },

                        aprovado: { minlength: 1, maxlength: 1 }

                    },
                    messages: {

                        cpf: {required: "Obrigatório", 
                        minlength: "O CPF deve ter 11 dígitos", 
                        maxlength: "O CPF deve ter 11 dígitos"},

                        nome: {required: "Obrigatório",
                        minlength: "3 caracteres no mínimo",
                        maxlength: "50 caracteres no máximo"},

                        email: {required: "Obrigatório"},

                        celular: {required: "Obrigatório", 
                        minlength: "O celular deve ter 14 caracteres", 
                        maxlength: "O celular deve ter 14 caracteres"},

                        login: {required: "Obrigatório",
                        minlength: "3 caracteres no mínimo",
                        maxlength: "20 caracteres no máximo"},

                        senha: {required: "Obrigatória", 
                        minlength: "Mínimo de 6 caracteres", 
                        maxlength: "Máximo de 255 caracteres" },

                        endereco: {minlength: "3 caracteres no mínimo", 
                        maxlength: "50 caracteres no máximo"},

                        bairro: {minlength: "3 caracteres no mínimo", 
                        maxlength: "30 caracteres no máximo"},
            
                        cidade: {minlength: "3 caracteres no mínimo", 
                        maxlength: "30 caracteres no máximo"},
            
                        cep: {minlength: "O CEP deve ter 9 caracteres", 
                        maxlength: "O CEP deve ter 9 caracteres"},

                        comentario: {minlength: "O comentário deve ter 3 caracteres",
                        maxlength: "O comentário deve ter 255 caracteres"},

                        aprovado: { minlength: "S/N", maxlength: "S/N" },
                    },

                    submitHandler: function(form) {
                        form.submit();
                    }
                });
            });
        </script>
    </body>
</html>