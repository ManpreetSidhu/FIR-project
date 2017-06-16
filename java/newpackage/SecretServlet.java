/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sidhu
 */
public class SecretServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
          String un=request.getParameter("t1");
          String sc=request.getParameter("t2");
          if(un.equals("amritsar")&&sc.equals("100"))
          {
              response.sendRedirect("Amritsar_ps.jsp");
          }
          else if(un.equals("barnala")&&sc.equals("200"))
          {
              response.sendRedirect("Barnala_ps.jsp");
          }
           else if(un.equals("bathinda")&&sc.equals("300"))
          {
              response.sendRedirect("Bathinda_ps.jsp");
          }
           else if(un.equals("faridkot")&&sc.equals("400"))
          {
              response.sendRedirect("Faridkot_ps.jsp");
          }
           else if(un.equals("fazilka")&&sc.equals("500"))
          {
              response.sendRedirect("Fazilka_ps.jsp");
          }
           else if(un.equals("jalandhar")&&sc.equals("600"))
          {
              response.sendRedirect("Jalandhar_ps.jsp");
          }
           else if(un.equals("ludhiana")&&sc.equals("700"))
          {
              response.sendRedirect("Ludhiana_ps.jsp");
          }
           else if(un.equals("sangrur")&&sc.equals("800"))
          {
              response.sendRedirect("Sangrur_ps.jsp");
          }
           else{
             response.sendRedirect("login2.jsp?a=true");

           }
              
        } finally {            
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
