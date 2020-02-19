/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PageServelts;

import dao.AlunoDao;
import dao.MatriculaDao;
import dao.TurmaDao;
import dao.TurmasDisponiveisDao;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Integer.parseInt;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Aluno;
import model.Matricula;
import model.Turma;

/**
 *
 * @author Joao_
 */
public class ServletTurmasDisponiveis extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate now = LocalDate.now();
        Date date = Date.from(now.atStartOfDay(ZoneId.systemDefault()).toInstant());
        
        if("matricular".equals(action)){
            MatriculaDao matriculaDao = new MatriculaDao();
            Matricula matricula = new Matricula();
            
            int id_turma = parseInt(request.getParameter("turma"));
            matricula.setTurma_id(id_turma);
            matricula.setNota((float) 0.0);
            matricula.setData_matricula(date);
            
            AlunoDao alunoDao = new AlunoDao();
            Aluno aluno = alunoDao.getAlunoByLogin((String) request.getSession().getAttribute("userLogin"));
            matricula.setAluno_id(aluno.getId());
            
            matriculaDao.addMatricula(matricula);
            
            TurmaDao turmaDao = new TurmaDao();

            List<Turma> turmas = turmaDao.getTurmasByDate(now);

            TurmasDisponiveisDao tnDao = new TurmasDisponiveisDao();
            request.setAttribute("turmas_disponiveis", tnDao.getAll(turmas));
            
        } else {
            TurmaDao turmaDao = new TurmaDao();

            List<Turma> turmas = turmaDao.getTurmasByDate(now);

            TurmasDisponiveisDao tnDao = new TurmasDisponiveisDao();
            request.setAttribute("turmas_disponiveis", tnDao.getAll(turmas));
        }
        
        RequestDispatcher rd = request.getRequestDispatcher("turmas_disponiveis.jsp");
        rd.forward(request, response);
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private Date parseDate(LocalDate now) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
