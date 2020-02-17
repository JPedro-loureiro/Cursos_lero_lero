/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PageServelts;

import dao.TurmaDao;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Turma;

/**
 *
 * @author Joao_
 */
public class ServletVerTurma extends HttpServlet {

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
        TurmaDao turmaDao = new TurmaDao();
        
        if(action.equals("listTurmas")){
            List<Turma> listTurmas = turmaDao.getAllTurmas();
            request.setAttribute("listInstrutores", listTurmas);
            
        } else if(action.equals("apagar")){
            int id_turma = parseInt(request.getParameter("id_turma"));
            turmaDao.deleteTurma(id_turma);
            
            //Atualizando o atributo listAlunos
            request.setAttribute("listInstrutores", turmaDao.getAllTurmas());
            
        } else if(action.equals("editar")){
            int id_turma = parseInt(request.getParameter("id_turma"));
            request.setAttribute("turma", turmaDao.getTurmaById(id_turma));
            
            RequestDispatcher rd = request.getRequestDispatcher("editar_turma.jsp");
            rd.forward(request, response);
        }
        RequestDispatcher rd = request.getRequestDispatcher("ver_turmas.jsp");
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
