/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ForPoliceStations;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sidhu
 */
public class Upservlet extends HttpServlet {

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
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try { String pos=request.getParameter("ps");
           String fir=request.getParameter("name1");
           String officer=request.getParameter("off");
           String rank=request.getParameter("rn");
           String status=request.getParameter("status");
       if(pos.equals("Amritsar Police Station")){
    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           Connection con= DriverManager.getConnection
                   ("jdbc:sqlserver://;databaseName=fir;userName=sa;password=root");
        PreparedStatement ps=con.prepareStatement
                ("update amritsar_ps set Officer_name=?,Rank=?,Status=?,Police_Station=? where Fir_no=?");
     
       ps.setString(1, officer);
       ps.setString(2, rank);
       ps.setString(3, status);
         ps.setString(4, pos);
          ps.setString(5, fir);
       int i=ps.executeUpdate();
       if(i>0)
       {
           response.sendRedirect("Amritsar_ps.jsp");
       }
       else
           response.sendRedirect("upsatatus.jsp?chk=invalid");
        } 
        else  if(pos.equals("Barnala Police Station")){
    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           Connection con= DriverManager.getConnection
                   ("jdbc:sqlserver://;databaseName=fir;userName=sa;password=root");
        PreparedStatement ps=con.prepareStatement
                ("update barnala_ps set Officer_name=?,Rank=?,Status=?,Police_Station=? where Fir_no=?");
     
       ps.setString(1, officer);
       ps.setString(2, rank);
       ps.setString(3, status);
        ps.setString(4, pos);
         ps.setString(5, fir);
       int i=ps.executeUpdate();
       if(i>0)
       {
           response.sendRedirect("Barnala_ps.jsp");
       }
       else
           response.sendRedirect("upsatatus.jsp?chk=invald");
        }
        else  if(pos.equals("Bathinda Police Station")){
    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           Connection con= DriverManager.getConnection
                   ("jdbc:sqlserver://;databaseName=fir;userName=sa;password=root");
        PreparedStatement ps=con.prepareStatement
                ("update bathinda_ps set Officer_name=?,Rank=?,Status=?,Police_Station=? where Fir_no=?");
     
       ps.setString(1, officer);
       ps.setString(2, rank);
       ps.setString(3, status);
        ps.setString(4, pos);
         ps.setString(5, fir);
       int i=ps.executeUpdate();
       if(i>0)
       {
         response.sendRedirect("Bathinda_ps.jsp");
       }
       else
          response.sendRedirect("upsatatus.jsp?chk=invald");
        } 
        else  if(pos.equals("Faridkot Police Station")){
    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           Connection con= DriverManager.getConnection
                   ("jdbc:sqlserver://;databaseName=fir;userName=sa;password=root");
        PreparedStatement ps=con.prepareStatement
                ("update faridkot_ps set Officer_name=?,Rank=?,Status=?,Police_Station=? where Fir_no=?");
     
       ps.setString(1, officer);
       ps.setString(2, rank);
       ps.setString(3, status);
        ps.setString(4, pos);
         ps.setString(5, fir);
       int i=ps.executeUpdate();
       if(i>0)
       {
          response.sendRedirect("Faridkot_ps.jsp");
       }
       else
           response.sendRedirect("upsatatus.jsp?chk=invald");
        } 
        else  if(pos.equals("Fazilka Police Station")){
    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           Connection con= DriverManager.getConnection
                   ("jdbc:sqlserver://;databaseName=fir;userName=sa;password=root");
        PreparedStatement ps=con.prepareStatement
                ("update fazilka_ps set Officer_name=?,Rank=?,Status=?,Police_Station=? where Fir_no=?");
     
       ps.setString(1, officer);
       ps.setString(2, rank);
       ps.setString(3, status);
        ps.setString(4, pos);
         ps.setString(5, fir);
       int i=ps.executeUpdate();
       if(i>0)
       {
          response.sendRedirect("Fazilka_ps.jsp");
       }
       else
          response.sendRedirect("upsatatus.jsp?chk=invald");
        } 
        else  if(pos.equals("Jalandhar Police Station")){
    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           Connection con= DriverManager.getConnection
                   ("jdbc:sqlserver://;databaseName=fir;userName=sa;password=root");
        PreparedStatement ps=con.prepareStatement
                ("update jalandhar_ps set Officer_name=?,Rank=?,Status=?,Police_Station=? where Fir_no=?");
     
       ps.setString(1, officer);
       ps.setString(2, rank);
       ps.setString(3, status);
        ps.setString(4, pos);
         ps.setString(5, fir);
       int i=ps.executeUpdate();
       if(i>0)
       {
           response.sendRedirect("Jalandhar_ps.jsp");
       }
       else
          response.sendRedirect("upsatatus.jsp?chk=invald");
        } 
        else  if(pos.equals("Ludhiana Police Station")){
    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           Connection con= DriverManager.getConnection
                   ("jdbc:sqlserver://;databaseName=fir;userName=sa;password=root");
        PreparedStatement ps=con.prepareStatement
                ("update ludhiana_ps set Officer_name=?,Rank=?,Status=?,Police_Station=? where Fir_no=?");
     
       ps.setString(1, officer);
       ps.setString(2, rank);
       ps.setString(3, status);
        ps.setString(4, pos);
         ps.setString(5, fir);
       int i=ps.executeUpdate();
       if(i>0)
       {
           response.sendRedirect("Ludhiana_ps.jsp");
       }
       else
           response.sendRedirect("upsatatus.jsp?chk=invald");
        } 
        else  if(pos.equals("Sangrur Police Station")){
    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           Connection con= DriverManager.getConnection
                   ("jdbc:sqlserver://;databaseName=fir;userName=sa;password=root");
        PreparedStatement ps=con.prepareStatement
                ("update sangrur_ps set Officer_name=?,Rank=?,Status=?,Police_Station=? where Fir_no=?");
     
       ps.setString(1, officer);
       ps.setString(2, rank);
       ps.setString(3, status);
        ps.setString(4, pos);
         ps.setString(5, fir);
       int i=ps.executeUpdate();
       if(i>0)
       {
           response.sendRedirect("Sangrur_ps.jsp");
       }
       else
          response.sendRedirect("upsatatus.jsp?chk=invald");
        } 
        }
        catch (ClassNotFoundException ex) {
            Logger.getLogger(Upservlet.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Exception is.........."+ex);
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Upservlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Upservlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
