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
@WebServlet(name = "ServletCadastro", urlPatterns = {"/ServletCadastro"})
public class ServletCadastro extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Aluno novo_aluno = new Aluno();
        novo_aluno.setNome(request.getParameter("name"));
        novo_aluno.setCpf(request.getParameter("cpf"));
        novo_aluno.setEmail(request.getParameter("email"));
        novo_aluno.setSenha(request.getParameter("password"));
        novo_aluno.setCelular(request.getParameter("celular"));
        novo_aluno.setLogin(request.getParameter("login"));
        novo_aluno.setEndereco(request.getParameter("endereco"));
        novo_aluno.setCidade(request.getParameter("cidade"));
        novo_aluno.setBairro(request.getParameter("bairro"));
        novo_aluno.setCep(request.getParameter("cep"));
        
        //Adiciona aluno ao DB
        AlunoDao alunoDao = new AlunoDao();
        alunoDao.addAluno(novo_aluno);
        
        String forward;
        forward = "area_aluno.jsp";
        RequestDispatcher rd = request.getRequestDispatcher(forward);
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
