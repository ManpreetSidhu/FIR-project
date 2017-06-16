/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import bean.Complain1;
import conn.DBoperation;
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
public class complain_servlet extends HttpServlet {

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
            String n=request.getParameter("name");
          String ph=request.getParameter("phn");
          String email=request.getParameter("email");
          String c=request.getParameter("city");
          String ad=request.getParameter("add");
          String sub=request.getParameter("sub");
          String detail=request.getParameter("detail");
                                                                      
            Complain1 cp= new Complain1();
           cp.setName(n);
           cp.setPhone_no(ph);
           cp.setEmail(email);
           cp.setCity(c);
           cp.setAddress(ad);
           cp.setComplain_sub(sub);
           cp.setComplain_detail(detail);
            DBoperation db=new DBoperation();
            boolean res=db.insertComplain(cp);
            if(res)
            {
                response.sendRedirect("complaint.jsp");
               
            }
            else
               response.sendRedirect("complaint.jsp?chk=invalid"); 
        } 
        catch(Exception e)
        {
            System.out.println("Exception......."+e);
        }
         finally {            
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
