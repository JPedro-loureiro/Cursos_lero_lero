/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PageServelts;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Joao_
 */
public class ServletLogin extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String login = request.getParameter("login");
        String tipo_usuario = request.getParameter("dropdown_tipo_usuario");
        String forward;
        
        if("adm".equals(tipo_usuario)){
            forward = "painel_controle.jsp";
        } else if("inst".equals(tipo_usuario)){
            forward = "area_instrutor.jsp";
        } else {
            forward = "area_aluno.jsp";
        }
        
        //Session
        HttpSession session = request.getSession();
        session.setAttribute("userLogin", login);
        
        //Redirect
        RequestDispatcher rd = request.getRequestDispatcher(forward);
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
