/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PageServelts;

import dao.CursoPorInstrutorDao;
import dao.InstrutorDao;
import dao.TurmaDao;
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
import model.Turma;

/**
 *
 * @author Joao_
 */
public class ServletCursoPorInstrutor extends HttpServlet {

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
        int id_instrutor = parseInt(request.getParameter("instrutores_id"));
        
        InstrutorDao instrutorDao = new InstrutorDao();
        Instrutor instrutor = instrutorDao.getInstrutorById(id_instrutor);
        
        TurmaDao turmaDao = new TurmaDao();
        List<Turma> turmas = turmaDao.getTurmasByInstrutor(instrutor);
        
        CursoPorInstrutorDao cpiDao = new CursoPorInstrutorDao();
        request.setAttribute("cursos", cpiDao.getAll(turmas));
        
        request.setAttribute("instrutor", instrutor);
        
        RequestDispatcher rd = request.getRequestDispatcher("ver_curso_turma_por_instrutor.jsp");
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
