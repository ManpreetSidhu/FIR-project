/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sidhu
 */
public class Cancelfir_Servlet extends HttpServlet {

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
            String pos=request.getParameter("pos");
            String fir=request.getParameter("num");
            if(pos.equals("Amritsar Police Station"))
            {
              Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://;databaseName=fir;userName=sa;password=root");
            PreparedStatement ps = con.prepareStatement("delete from amritsar_ps where Fir_no=?");
            ps.setString(1, fir);
            int i=ps.executeUpdate();
        if(i>0){
            System.out.println("sucessfully deleted"+i);
             response.sendRedirect("checkstatus2.jsp");
        }
        }
            else if(pos.equals("Barnala Police Station"))
            {
              Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://;databaseName=fir;userName=sa;password=root");
            PreparedStatement ps = con.prepareStatement("delete from barnala_ps where Fir_no=?");
            ps.setString(1, fir);
            int i=ps.executeUpdate();
        if(i>0){
            System.out.println("sucessfully deleted"+i);
             response.sendRedirect("checkstatus2.jsp");
        }
        }
         else  if(pos.equals("Bathinda Police Station"))
            {
              Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://;databaseName=fir;userName=sa;password=root");
            PreparedStatement ps = con.prepareStatement("delete from bathinda_ps where Fir_no=?");
            ps.setString(1, fir);
            int i=ps.executeUpdate();
        if(i>0){
            System.out.println("sucessfully deleted"+i);
             response.sendRedirect("checkstatus2.jsp");
        }
        }
         else  if(pos.equals("Fazilka Police Station"))
            {
              Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://;databaseName=fir;userName=sa;password=root");
            PreparedStatement ps = con.prepareStatement("delete from fazilka_ps where Fir_no=?");
            ps.setString(1, fir);
            int i=ps.executeUpdate();
        if(i>0){
            System.out.println("sucessfully deleted"+i);
             response.sendRedirect("checkstatus2.jsp");
        }
        }
               else  if(pos.equals("Faridkot Police Station"))
            {
              Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://;databaseName=fir;userName=sa;password=root");
            PreparedStatement ps = con.prepareStatement("delete from faridkot_ps where Fir_no=?");
            ps.setString(1, fir);
            int i=ps.executeUpdate();
        if(i>0){
            System.out.println("sucessfully deleted"+i);
             response.sendRedirect("checkstatus2.jsp");
        }
        }
               else  if(pos.equals("Jalandhar Police Station"))
            {
              Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://;databaseName=fir;userName=sa;password=root");
            PreparedStatement ps = con.prepareStatement("delete from jalandhar_ps where Fir_no=?");
            ps.setString(1, fir);
            int i=ps.executeUpdate();
        if(i>0){
            System.out.println("sucessfully deleted"+i);
             response.sendRedirect("checkstatus2.jsp");
        }
        }
               else  if(pos.equals("Ludhiana Police Station"))
            {
              Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://;databaseName=fir;userName=sa;password=root");
            PreparedStatement ps = con.prepareStatement("delete from ludhiana_ps where Fir_no=?");
            ps.setString(1, fir);
            int i=ps.executeUpdate();
        if(i>0){
            System.out.println("sucessfully deleted"+i);
             response.sendRedirect("checkstatus2.jsp");
        }
        }
               else  if(pos.equals("Sangrur Police Station"))
            {
              Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://;databaseName=fir;userName=sa;password=root");
            PreparedStatement ps = con.prepareStatement("delete from sangrur_ps where Fir_no=?");
            ps.setString(1, fir);
            int i=ps.executeUpdate();
        if(i>0){
            System.out.println("sucessfully deleted"+i);
             response.sendRedirect("checkstatus2.jsp");
        }
        }
               else {
            response.sendRedirect("checkstatus2.jsp");
        }}
catch(Exception e)
        {
            System.out.println("Exception..........."+e);
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
