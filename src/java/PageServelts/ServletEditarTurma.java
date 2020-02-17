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
public class ServletEditarTurma extends HttpServlet {
    
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
        turmaDao.updateTurma(nova_turma);
        
        RequestDispatcher rd = request.getRequestDispatcher("ver_turmas.jsp");
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
