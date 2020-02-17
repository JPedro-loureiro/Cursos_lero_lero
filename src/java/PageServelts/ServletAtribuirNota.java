/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PageServelts;

import dao.AlunoDao;
import dao.InstrutorDao;
import dao.MatriculaDao;
import dao.TurmaDao;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Aluno;
import model.AlunoCursoTurma;
import model.Instrutor;
import model.Matricula;
import model.Turma;

/**
 *
 * @author Joao_
 */
public class ServletAtribuirNota extends HttpServlet {

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
        
        int id_instrutor = parseInt(request.getParameter("id_instrutor"));
        InstrutorDao instrutorDao = new InstrutorDao();
        Instrutor instrutor = instrutorDao.getInstrutorById(id_instrutor);
        
        TurmaDao turmaDao = new TurmaDao();
        List<Turma> turmas = turmaDao.getTurmasByInstrutor(instrutor);
        
        MatriculaDao matriculaDao = new MatriculaDao();
        List <Matricula> matriculas_por_turma;
        
        List <AlunoCursoTurma> matriculas = new ArrayList<AlunoCursoTurma>();
        
        AlunoDao alunoDao = new AlunoDao();
        int id_aluno;
        int id_turma;
        float nota;
        
        for(int i=0; i<turmas.size(); i++){
            matriculas_por_turma = matriculaDao.getMatriculasByTurma(turmas.get(i));
            for(int j=0; j<matriculas_por_turma.size(); j++){
                
                //Nome Aluno
                id_aluno = matriculas_por_turma.get(j).getAluno_id();
                Aluno aluno = alunoDao.getAlunoById(id_aluno);
                
                AlunoCursoTurma act = new AlunoCursoTurma();
                act.setId_aluno(id_aluno);
                act.setNome_aluno(aluno.getNome());
                
                //id_turma
                id_turma = matriculas_por_turma.get(j).getTurma_id();
                act.setId_turma(id_turma);
                
                //nota
                nota = matriculas_por_turma.get(j).getNota();
                act.setNota(nota);
                
                //add list
                matriculas.add(act);
            }
        }
        
        request.setAttribute("matriculas", matriculas);
        
        RequestDispatcher rd = request.getRequestDispatcher("area_instrutor_notas.jsp");
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
        float nota = parseFloat(request.getParameter("nota"));
        int id_aluno = parseInt(request.getParameter("id_aluno"));
        int id_turma = parseInt(request.getParameter("id_turma"));
        
        AlunoDao alunoDao = new AlunoDao();
        Aluno aluno = alunoDao.getAlunoById(id_aluno);
        
        TurmaDao turmaDao = new TurmaDao();
        Turma turma = turmaDao.getTurmaById(id_turma);
        
        MatriculaDao matriculaDao = new MatriculaDao();
        Matricula matricula = matriculaDao.getMatriculaByTurmaEAluno(turma, aluno);
        
        matricula.setNota(nota);
        
        RequestDispatcher rd = request.getRequestDispatcher("area_instrutor_notas.jsp");
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
