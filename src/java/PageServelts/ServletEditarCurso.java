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
import static java.lang.Integer.parseInt;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Curso;

/**
 *
 * @author Joao_
 */
public class ServletEditarCurso extends HttpServlet {
    
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
        cursoDao.updateCurso(novo_curso);
        
        RequestDispatcher rd = request.getRequestDispatcher("ver_cursos.jsp");
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
