/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PageServelts;

import dao.InstrutorDao;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Integer.parseInt;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Instrutor;

/**
 *
 * @author Joao_
 */
public class ServletEditarInstrutor extends HttpServlet {

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        InstrutorDao instrutorDao = new InstrutorDao();
        String login = request.getParameter("login");
        Instrutor novo_instrutor = instrutorDao.getInstrutorByLogin(login);
        
        novo_instrutor.setLogin(request.getParameter("login"));
        novo_instrutor.setNome(request.getParameter("nome"));
        novo_instrutor.setEmail(request.getParameter("email"));
        novo_instrutor.setValor_hora(parseInt(request.getParameter("valor_hora")));
        novo_instrutor.setSenha(request.getParameter("password"));
        novo_instrutor.setExperiencia(request.getParameter("experiencia"));
        
        instrutorDao.updateInstrutor(novo_instrutor);
        
        List<Instrutor> listInstrutores = instrutorDao.getAllInstrutores();
        request.setAttribute("listInstrutores", listInstrutores);
        
        RequestDispatcher rd = request.getRequestDispatcher("ver_instrutores.jsp");
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
