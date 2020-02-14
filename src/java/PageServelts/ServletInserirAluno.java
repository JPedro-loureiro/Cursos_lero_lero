/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PageServelts;

import dao.AlunoDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Aluno;

/**
 *
 * @author Joao_
 */
@WebServlet(name = "ServletInserirAluno", urlPatterns = {"/ServletInserirAluno"})
public class ServletInserirAluno extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Aluno novo_aluno = new Aluno();
        novo_aluno.setCpf(request.getParameter("cpf"));
        novo_aluno.setNome(request.getParameter("nome"));
        novo_aluno.setEmail(request.getParameter("email"));
        novo_aluno.setCelular(request.getParameter("celular"));
        novo_aluno.setLogin(request.getParameter("login"));
        novo_aluno.setSenha(request.getParameter("password"));
        novo_aluno.setEndereco(request.getParameter("endereco"));
        novo_aluno.setBairro(request.getParameter("bairro"));
        novo_aluno.setCidade(request.getParameter("cidade"));
        novo_aluno.setCep(request.getParameter("cep"));
        
        AlunoDao alunoDao = new AlunoDao();
        alunoDao.addAluno(novo_aluno);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
