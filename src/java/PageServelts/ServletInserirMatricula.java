/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PageServelts;

import dao.MatriculaDao;
import java.io.IOException;
import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Matricula;

/**
 *
 * @author Joao_
 */
@WebServlet(name = "ServletInserirMatricula", urlPatterns = {"/ServletInserirMatricula"})
public class ServletInserirMatricula extends HttpServlet {

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
        
        Matricula nova_matricula = new Matricula();
        nova_matricula.setTurma_id(parseInt(request.getParameter("turmas_id")));
        nova_matricula.setAluno_id(parseInt(request.getParameter("alunos_id")));
        nova_matricula.setNota(parseFloat(request.getParameter("nota")));
        
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        try {
            nova_matricula.setData_matricula(format.parse(request.getParameter("data_matricula")));
        } catch (ParseException ex) {
            Logger.getLogger(ServletInserirMatricula.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        MatriculaDao matriculaDao = new MatriculaDao();
        matriculaDao.addMatricula(nova_matricula);
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
