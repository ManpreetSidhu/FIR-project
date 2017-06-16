/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import bean.Online_fir;
import bean.Registeration;
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
public class Register_servlet extends HttpServlet {

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
          String f=request.getParameter("first");
          String l=request.getParameter("last");
          String un=request.getParameter("uname");
          String ps=request.getParameter("psd");
          String cps=request.getParameter("cpsd");
          String gen=request.getParameter("gen");
          String mn=request.getParameter("month");
          String d=request.getParameter("day");
          String y=request.getParameter("year");
          String phn=request.getParameter("mob");
          String email=request.getParameter("email");
          String q=request.getParameter("ques");
          String ans=request.getParameter("ans");
          String l1=request.getParameter("loc");
          String c1=request.getParameter("check");
           Registeration r=new Registeration();
           r.setF_name(f);
           r.setL_name(l);
           r.setUsername(un);
           r.setPassword(ps);
           r.setConfirm_pas(cps);
           r.setGender(gen);
           r.setB_month(mn);
           r.setB_day(d);
           r.setB_year(y);
           r.setMobile_no(phn);
           r.setEmail(email);
           r.setSecurity_q(q);
           r.setSecurity_a(ans);
           r.setLocation(l1);
            r.setTerms(c1);
           DBoperation db=new DBoperation();
            boolean res=db.insertRegis(r);
            if(res)
            {
               response.sendRedirect("Registration.jsp");
               
            }
            else
                response.sendRedirect("Registration.jsp?chk=invalid");
           
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
