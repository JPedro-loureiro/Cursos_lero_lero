/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PageServelts;

import dao.AlunoDao;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
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
@WebServlet(name = "ServletEditarAluno", urlPatterns = {"/ServletEditarAluno"})
public class ServletEditarAluno extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Aluno aluno = new Aluno();
        aluno.setCpf(request.getParameter("cpf"));
        aluno.setNome(request.getParameter("nome"));
        aluno.setEmail(request.getParameter("email"));
        aluno.setCelular(request.getParameter("celular"));
        aluno.setLogin(request.getParameter("login"));
        aluno.setSenha(request.getParameter("password"));
        aluno.setEndereco(request.getParameter("endereco"));
        aluno.setBairro(request.getParameter("bairro"));
        aluno.setCidade(request.getParameter("cidade"));
        aluno.setCep(request.getParameter("cep"));
        
        AlunoDao alunoDao = new AlunoDao();
        alunoDao.updateAluno(aluno);
        
        RequestDispatcher rd = request.getRequestDispatcher("ver_alunos.jsp");
        rd.forward(request, response);
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
