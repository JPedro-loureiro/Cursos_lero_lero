/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PageServelts;

import dao.AlunoCursoTurmaDao;
import dao.AlunoDao;
import dao.CursoDao;
import dao.MatriculaDao;
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
import model.AlunoCursoTurma;
import model.Matricula;
import model.Turma;

/**
 *
 * @author Joao_
 */
public class ServletAlunoPorCurso extends HttpServlet {

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
        int turma_id = parseInt(request.getParameter("turma_id"));
        
        TurmaDao turmaDao = new TurmaDao();
        Turma turma = turmaDao.getTurmaById(turma_id);
        
        AlunoCursoTurmaDao actDao = new AlunoCursoTurmaDao();
        List<AlunoCursoTurma> lst = actDao.getAll(turma);
        request.setAttribute("alunos", lst);
        request.setAttribute("curso", lst.get(0).getNome_curso());
        request.setAttribute("turma", turma_id);
        
        RequestDispatcher rd = request.getRequestDispatcher("ver_alunos_por_curso_turma.jsp");
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
