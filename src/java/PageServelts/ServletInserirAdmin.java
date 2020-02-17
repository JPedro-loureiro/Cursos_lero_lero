/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PageServelts;

import dao.AdministradorDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Administrador;

/**
 *
 * @author Joao_
 */
@WebServlet(name = "ServletInserirAdmin", urlPatterns = {"/ServletInserirAdmin"})
public class ServletInserirAdmin extends HttpServlet {

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
        Administrador novo_admin = new Administrador();
        novo_admin.setNome(request.getParameter("nome"));
        novo_admin.setLogin(request.getParameter("login"));
        novo_admin.setSenha(request.getParameter("password"));
        
        AdministradorDao adminDao = new AdministradorDao();
        adminDao.addAdminstrador(novo_admin);
        
        RequestDispatcher rd = request.getRequestDispatcher("inserir_administrador.jsp");
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
