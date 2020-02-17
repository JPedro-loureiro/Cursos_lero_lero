/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PageServelts;

import dao.InstrutorDao;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Integer.parseInt;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Instrutor;

/**
 *
 * @author Joao_
 */
public class ServletRecebiveis extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id_instrutor = parseInt(request.getParameter("id_instrutor"));
        
        InstrutorDao instrutorDao = new InstrutorDao();
        Instrutor instrutor = instrutorDao.getInstrutorById(id_instrutor);
        
        float valor = instrutor.getValorAReceber(id_instrutor);
        
        request.setAttribute("valor", valor);
        
        RequestDispatcher rd = request.getRequestDispatcher("area_instrutor_valores.jsp");
        rd.forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
