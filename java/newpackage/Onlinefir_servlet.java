/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;


import bean.Online_fir;
import bean.Suggestion;
import conn.DBoperation;
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
public class Onlinefir_servlet extends HttpServlet {

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
          
          String tp=request.getParameter("topic");
          String des=request.getParameter("des");
          String n=request.getParameter("name");
          String ph=request.getParameter("phn");
          String email=request.getParameter("email");
          String add1=request.getParameter("add");
          String pos=request.getParameter("ps");
          String id=request.getParameter("id");
           String idnum=request.getParameter("num");
          String dp=request.getParameter("name1");
          String add2=request.getParameter("add1");
        
           
           Online_fir s=new Online_fir();
           
           s.setTopic(tp);
           s.setDescription(des);
           s.setApp_name(n);
           s.setPhone_no(ph);
           s.setEmail(email);
           s.setApp_add(add1);
           s.setPolice_station(pos);
           s.setId_proof(id);
           s.setProof_no(idnum);
           s.setName(dp);
           s.setAddress(add2);
            DBoperation db=new DBoperation();
            boolean res=db.insertFir(s);
            if(res)
            {
                  out.print("sucessfull");
               String polst=request.getParameter("ps");
             if(polst.equals("Amritsar Police Station")){
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
         Connection con= DriverManager.getConnection
                   ("jdbc:sqlserver://;databaseName=fir;userName=sa;password=root");
        PreparedStatement ps=con.prepareStatement
                ("select * from amritsar_ps");
      
      String mail=null;
      int fir=0;
       ResultSet rs=ps.executeQuery();
        while(rs.next())
        {
            
      fir=rs.getInt(1);
      mail=rs.getString(6);
       pos=rs.getString(8);
        
        }
        response.sendRedirect("mail1.jsp?fir="+fir+"&pos="+pos+"&mail="+mail);
        }
             else     if(polst.equals("Barnala Police Station")){
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
         Connection con= DriverManager.getConnection
                   ("jdbc:sqlserver://;databaseName=fir;userName=sa;password=root");
        PreparedStatement ps=con.prepareStatement
                ("select * from barnala_ps");
      
      String mail=null;
      int fir=0;
       ResultSet rs=ps.executeQuery();
        while(rs.next())
        {
            
      fir=rs.getInt(1);
      mail=rs.getString(6);
       pos=rs.getString(8);
        
        }
        response.sendRedirect("mail1.jsp?fir="+fir+"&pos="+pos+"&mail="+mail);
        }
             else     if(polst.equals("Bathinda Police Station")){
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
         Connection con= DriverManager.getConnection
                   ("jdbc:sqlserver://;databaseName=fir;userName=sa;password=root");
        PreparedStatement ps=con.prepareStatement
                ("select * from bathinda_ps");
      
      String mail=null;
      int fir=0;
       ResultSet rs=ps.executeQuery();
        while(rs.next())
        {
            
      fir=rs.getInt(1);
      mail=rs.getString(6);
       pos=rs.getString(8);
        
        }
        response.sendRedirect("mail1.jsp?fir="+fir+"&pos="+pos+"&mail="+mail);
        }
             else     if(polst.equals("Faridkot Police Station")){
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
         Connection con= DriverManager.getConnection
                   ("jdbc:sqlserver://;databaseName=fir;userName=sa;password=root");
        PreparedStatement ps=con.prepareStatement
                ("select * from faridkot_ps");
      
      String mail=null;
      int fir=0;
       ResultSet rs=ps.executeQuery();
        while(rs.next())
        {
            
      fir=rs.getInt(1);
      mail=rs.getString(6);
       pos=rs.getString(8);
        
        }
        response.sendRedirect("mail1.jsp?fir="+fir+"&pos="+pos+"&mail="+mail);
        }
             else     if(polst.equals("Fazilka Police Station")){
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
         Connection con= DriverManager.getConnection
                   ("jdbc:sqlserver://;databaseName=fir;userName=sa;password=root");
        PreparedStatement ps=con.prepareStatement
                ("select * from fazilka_ps");
      
      String mail=null;
      int fir=0;
       ResultSet rs=ps.executeQuery();
        while(rs.next())
        {
            
      fir=rs.getInt(1);
      mail=rs.getString(6);
       pos=rs.getString(8);
        
        }
        response.sendRedirect("mail1.jsp?fir="+fir+"&pos="+pos+"&mail="+mail);
        }
             else     if(polst.equals("Jalandhar Police Station")){
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
         Connection con= DriverManager.getConnection
                   ("jdbc:sqlserver://;databaseName=fir;userName=sa;password=root");
        PreparedStatement ps=con.prepareStatement
                ("select * from jalandhar_ps");
      
      String mail=null;
      int fir=0;
       ResultSet rs=ps.executeQuery();
        while(rs.next())
        {
            
      fir=rs.getInt(1);
      mail=rs.getString(6);
       pos=rs.getString(8);
        
        }
        response.sendRedirect("mail1.jsp?fir="+fir+"&pos="+pos+"&mail="+mail);
        }
             else     if(polst.equals("Ludhiana Police Station")){
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
         Connection con= DriverManager.getConnection
                   ("jdbc:sqlserver://;databaseName=fir;userName=sa;password=root");
        PreparedStatement ps=con.prepareStatement
                ("select * from ludhiana_ps");
      
      String mail=null;
      int fir=0;
       ResultSet rs=ps.executeQuery();
        while(rs.next())
        {
            
      fir=rs.getInt(1);
      mail=rs.getString(6);
       pos=rs.getString(8);
        
        }
        response.sendRedirect("mail1.jsp?fir="+fir+"&pos="+pos+"&mail="+mail);
        }
             else     if(polst.equals("Sangrur Police Station")){
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
         Connection con= DriverManager.getConnection
                   ("jdbc:sqlserver://;databaseName=fir;userName=sa;password=root");
        PreparedStatement ps=con.prepareStatement
                ("select * from sangrur_ps");
      
      String mail=null;
      int fir=0;
       ResultSet rs=ps.executeQuery();
        while(rs.next())
        {
            
      fir=rs.getInt(1);
      mail=rs.getString(6);
       pos=rs.getString(8);
        
        }
        response.sendRedirect("mail1.jsp?fir="+fir+"&pos="+pos+"&mail="+mail);
        }
               
            }
            else{
                response.sendRedirect("online_fir.jsp?chk=invalid");
            }
       
           
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
