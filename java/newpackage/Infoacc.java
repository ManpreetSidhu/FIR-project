/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import bean.infoacc;
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
public class Infoacc extends HttpServlet {

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
            System.out.println("hellllllllllooooooo");
           
          int fr=Integer.parseInt(request.getParameter("num"));
            System.out.println(fr+".............................");
          String sub=request.getParameter("sub");
          String pos=request.getParameter("ps");
          String year=request.getParameter("year");
          String date=request.getParameter("date");
          String accp=request.getParameter("acc");
          String victim=request.getParameter("victim");
          String vehicle=request.getParameter("vehicle");
          String rank=request.getParameter("rn");
          String officer=request.getParameter("off");
                                                                      
            infoacc a1= new infoacc();
            
         a1.setFir_no(fr);
         a1.setFir_sub(sub);
         a1.setPolice_Station(pos);
         a1.setYear(year);
         a1.setDate(date);
         a1.setAccident_place(accp);
         a1.setVictim_no(victim);
         a1.setVehicle_no(vehicle);
         a1.setRank(rank);
         a1.setOfficer_name(officer);
            DBoperation db=new DBoperation();
            boolean res=db.Infoacc(a1);
            if(res)
            {
                response.sendRedirect("accinfo.jsp");
               
            }
            else
               response.sendRedirect("accinfo.jsp?chk=invalid"); 
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
