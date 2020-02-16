/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PageServelts;

import dao.AlunoDao;
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

/**
 *
 * @author Joao_
 */
public class ServletAprovCadastrosPendentes extends HttpServlet {

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
        AlunoDao alunoDao = new AlunoDao();
        
        if(action.equals("listPendentes")){
            List<Aluno> aprovPendentes = alunoDao.getAllAlunosPendentes();
            request.setAttribute("aprovPendentes", aprovPendentes);
            
        } else if(action.equals("aprovar")){
            int id_aluno = parseInt(request.getParameter("id_aluno"));
            Aluno aluno = alunoDao.getAlunoById(id_aluno);
            alunoDao.aprovarAluno(aluno);
            
            request.setAttribute("aprovPendentes", alunoDao.getAllAlunosPendentes()); //Atualizando lista de alunos pendentes
        }
        RequestDispatcher rd = request.getRequestDispatcher("cadastros_pendentes.jsp");
            rd.forward(request, response);
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
