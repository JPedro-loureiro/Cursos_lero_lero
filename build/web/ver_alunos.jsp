<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!-- FAZER DIREITINHO!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! -->
<!-- <%@page import="model.Aluno"%>

<%@page import="java.util.List"%> -->

<html lang="pt-br">

    <head>
        <jsp:include page="head.jsp" />
    </head>

    <body>

        <!-- Navbar -->
        <jsp:include page="navbar_administrador.jsp" />

        <div class="container">
            <div class="text-center py-5">
                <h1 class="text-primary">Alunos</h1>
            </div>

            <table class="table table-responsive-md table-hover ">
              
                <thead-light>
                    <tr>
                        <th scope="col">id</th>
                        <th scope="col">CPF</th>
                        <th scope="col">Nome</th>
                        <th scope="col">Email</th>
                        <th scope="col">Celular</th>
                        <th scope="col">Login</th>
                        <th scope="col">Endereço</th>
                        <th scope="col">Bairro</th>
                        <th scope="col">Cidade</th>
                        <th scope="col">CEP</th>
                    </tr>
                </thead>
                
                <tbody>
                    <!-- FAZER DIREITINHO!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! -->
                    <!-- <% List<Aluno> alunosAprovados = (List<Aluno>) request.getAttribute("alunosAprovados");
                        for (Aluno i : alunosAprovados) { %> 
                        <tr>
                            <th scope="row">
                                <%=i.getId()%>
                            </th>

                            <td><%=i.getCpf()%></td>
                            <td><%=i.getNome()%></td>
                            <td><%=i.getEmail()%></td>
                            <td><%=i.getCelular()%></td>
                            <td><%=i.getLogin()%></td>
                            <td><%=i.getEndereco()%></td>
                            <td><%=i.getBairro()%></td>
                            <td><%=i.getCidade()%></td>
                            <td><%=i.getCep()%></td>

                            <td>
                                <a href="">
                                    <button type="button" class="btn btn-primary">Editar</button>
                                </a>

                                <a href="ServletVerAluno?action=apagar&id_aluno=<%=i.getId()%>">
                                    <button type="button" class="btn btn-danger">Apagar</button>
                                </a>
                    
                                <a href="inserir_aluno.jsp">
                                    <button type="button" class="btn btn-danger">Incluir</button>
                                </a>
                            </td>
                        </tr>
                    <%}%> -->
                </tbody>
            </table>
        </div>

        <!-- Rodapé -->
        <jsp:include page="rodape.jsp" />
    </body>

</html>