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
public class ServletVerAluno extends HttpServlet {

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
        
        if("listAlunos".equals(action)){
            List<Aluno> alunosAprovados = alunoDao.getAllAlunosAprovados();
            request.setAttribute("alunosAprovados", alunosAprovados);
            
            RequestDispatcher rd = request.getRequestDispatcher("ver_alunos.jsp");
            rd.forward(request, response);
            
        } else if(action.equals("apagar")){
            int id_aluno = parseInt(request.getParameter("id_aluno"));
            alunoDao.deleteAluno(id_aluno);
            
            //Atualizando o atributo listAlunos
            request.setAttribute("alunosAprovados", alunoDao.getAllAlunosAprovados());
            
        } else if(action.equals("editar")){
            int id_aluno = parseInt(request.getParameter("id_aluno"));
            request.setAttribute("aluno", alunoDao.getAlunoById(id_aluno));
            
            RequestDispatcher rd = request.getRequestDispatcher("editar_aluno.jsp");
            rd.forward(request, response);
        }
        RequestDispatcher rd = request.getRequestDispatcher("ver_alunos.jsp");
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
