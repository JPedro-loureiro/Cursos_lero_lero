/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PageServelts;

import dao.InstrutorDao;
import java.io.IOException;
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
public class ServletVerInstrutor extends HttpServlet {

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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        InstrutorDao instrutorDao = new InstrutorDao();
        
        if(action.equals("listInstrutores")){
            List<Instrutor> listInstrutores = instrutorDao.getAllInstrutores();
            request.setAttribute("listInstrutores", listInstrutores);
            
        } else if(action.equals("apagar")){
            int id_instrutor = parseInt(request.getParameter("id"));
            instrutorDao.deleteInstrutor(id_instrutor);
            
            //Atualizando o atributo listAlunos
            request.setAttribute("listInstrutores", instrutorDao.getAllInstrutores());
            
        } else if(action.equals("editar")){
            int id_instrutor = parseInt(request.getParameter("id"));
            Instrutor instrutor = instrutorDao.getInstrutorById(id_instrutor);
            instrutorDao.updateInstrutor(instrutor);
            request.setAttribute("instrutor", instrutor);
            
            RequestDispatcher rd = request.getRequestDispatcher("editar_instrutor.jsp");
            rd.forward(request, response);
        }
        RequestDispatcher rd = request.getRequestDispatcher("ver_instrutores.jsp");
        rd.forward(request, response);
    }

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
