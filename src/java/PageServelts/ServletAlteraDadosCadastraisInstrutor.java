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
public class ServletAlteraDadosCadastraisInstrutor extends HttpServlet {

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
        
        String login = (String) request.getSession().getAttribute("userLogin");
        InstrutorDao instrutorDao = new InstrutorDao();
        Instrutor instrutor = instrutorDao.getInstrutorByLogin(login);
        
        instrutor.setNome(request.getParameter("nome"));
        instrutor.setEmail(request.getParameter("email"));
        instrutor.setLogin(request.getParameter("login"));
        instrutor.setExperiencia(request.getParameter("experiencia"));
        
        instrutorDao.updateInstrutor(instrutor);
       
        
        request.setAttribute("instrutor", instrutor);
        
        RequestDispatcher rd = request.getRequestDispatcher("area_instrutor.jsp");
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
