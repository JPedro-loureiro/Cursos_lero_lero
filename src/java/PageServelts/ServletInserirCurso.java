/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PageServelts;

import dao.CursoDao;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Float.parseFloat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Curso;

/**
 *
 * @author Joao_
 */
@WebServlet(name = "ServletInserirCurso", urlPatterns = {"/ServletInserirCurso"})
public class ServletInserirCurso extends HttpServlet {

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
        
        Curso novo_curso = new Curso();
        novo_curso.setNome(request.getParameter("nome"));
        novo_curso.setRequisito(request.getParameter("requisito"));
        novo_curso.setEmenta(request.getParameter("ementa"));
        novo_curso.setCarga_horaria( parseInt(request.getParameter("carga_horaria")));
        novo_curso.setPreco(parseFloat(request.getParameter("preco")));
        
        CursoDao cursoDao = new CursoDao();
        cursoDao.addCurso(novo_curso);
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

    private int parseInt(String parameter) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
