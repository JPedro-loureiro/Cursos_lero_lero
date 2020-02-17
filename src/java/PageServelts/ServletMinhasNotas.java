/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PageServelts;

import dao.AlunoDao;
import dao.AlunoNotaTurmaDao;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Integer.parseInt;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Aluno;
import model.AlunoNotaTurma;

/**
 *
 * @author Joao_
 */
public class ServletMinhasNotas extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int aluno_id = parseInt(request.getParameter("id"));
        
        AlunoDao alunoDao = new AlunoDao();
        Aluno aluno = alunoDao.getAlunoById(aluno_id);
        
        AlunoNotaTurmaDao antDao = new AlunoNotaTurmaDao();
        List<AlunoNotaTurma> notas = antDao.getAll(aluno.getLogin());
        
        request.setAttribute("notas", notas);
        
        RequestDispatcher rd = request.getRequestDispatcher("minhas_notas.jsp");
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
