/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PageServelts;

import dao.TurmaDao;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Turma;

/**
 *
 * @author Joao_
 */
public class ServletInserirTurma extends HttpServlet {

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
        
        Turma nova_turma = new Turma();
        nova_turma.setInstrutor_id(parseInt(request.getParameter("instrutores_id")));
        nova_turma.setCurso_id(parseInt(request.getParameter("cursos_id")));
        nova_turma.setCarga_horaria(parseInt(request.getParameter("carga_horaria")));
        
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        try {
            nova_turma.setData_inicio(format.parse(request.getParameter("data_inicio")));
            nova_turma.setData_fim(format.parse(request.getParameter("data_final")));
        } catch (ParseException ex) {
            Logger.getLogger(ServletInserirTurma.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        TurmaDao turmaDao = new TurmaDao();
        turmaDao.addTurma(nova_turma);
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
