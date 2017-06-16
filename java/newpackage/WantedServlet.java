/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import bean.Missing;
import bean.Wanted;
import conn.DBoperation;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author dell
 */
@WebServlet(urlPatterns = {"/WantedServlet"})
public class WantedServlet extends HttpServlet {

            
           

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
     String Temp="E:/New";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        DBoperation db=new DBoperation();
         String sex="",nam="",Dob="",lang="",nationality="",height="",hair="",eyes="",cat="",wanted="",id=Integer.toString(db.getid()); 
        int sid=0;
        try {
         DiskFileItemFactory factory = new DiskFileItemFactory();
       factory.setSizeThreshold(500000);
   factory.setRepository(new File(Temp));
   
   ServletFileUpload upload = new ServletFileUpload(factory);
     List<FileItem> items = upload.parseRequest(request);
    System.out.println("1");   
    byte[] b= new byte[5000000]; 
    
    InputStream is=null;
     for (FileItem item : items) {
          
         if (item.isFormField()) {
              String xy=item.getFieldName();
               if(xy.equals("nam"))
                nam=item.getString();        
        if(xy.equals("sex"))
            sex=  item.getString();
        if(xy.equals("Dob"))
            Dob=  item.getString();
         if(xy.equals("lang"))
            lang=  item.getString();
           if(xy.equals("nationality"))
            nationality=  item.getString();
           if(xy.equals("height"))
           height =  item.getString();
            if(xy.equals("hair"))
            hair=  item.getString();
            if(xy.equals("eyes"))
            eyes=  item.getString();
            if(xy.equals("cat"))
            cat=  item.getString();
            if(xy.equals("wanted"))
            wanted=  item.getString();
             
        System.out.println("....."+nam);
          }
         else{    String nm =item.getName();
                 is = item.getInputStream();
         }   }  
        is.read(b); 

        int  id1=db.getid();
      Wanted w=new Wanted();
     
       w.setName(nam);
       w.setSex(sex);
       w.setDob(Dob);
       w.setLanguage(lang);
      w.setNationality(nationality);
      w.setHeight(height);
      w.setHair(hair);
      w.setEyes(eyes);
      w.setCategories(cat);
      w.setWanted(wanted);
    
       
      File f1=new File("C:\\Users\\sidhu\\Documents\\NetBeansProjects\\Fir_project1\\web\\image\\"+id1+".jpg");
        System.out.println(f1.getAbsolutePath());
                   FileOutputStream ot=new FileOutputStream(f1);
                   ot.write(b); 
        out.print("jjjjj"+sid);
            System.out.println("connection");
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
          Connection con= DriverManager.getConnection
                   ("jdbc:sqlserver://;databaseName=fir;userName=sa;password=root");
            PreparedStatement ps=con.prepareStatement
                ("insert into Wanted(Name,Sex,Dob,Language,Nationality,Height,Hair,Eyes,Categories,Wanted,Image)values(?,?,?,?,?,?,?,?,?,?,?)");
           ps.setString(1, w.getName());
            ps.setString(2, w.getSex());
            ps.setString(3, w.getDob());
            ps.setString(4, w.getLanguage());
            ps.setString(5, w.getNationality());
            ps.setString(6, w.getHeight());
            ps.setString(7, w.getHair());
            ps.setString(8, w.getEyes());
            ps.setString(9, w.getCategories());
            ps.setString(10, w.getWanted());
            ps.setString(11, "image/"+f1.getName());
            System.out.println(w.getName());

        int i=ps.executeUpdate();
        
       
       response.sendRedirect("Wantedform.jsp");
      }
       catch(Exception e)
       {  response.sendRedirect("Wantedform.jsp?chk=invalid");
           System.out.println("Exception....."+e);
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
          
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
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(WantedServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(WantedServlet.class.getName()).log(Level.SEVERE, null, ex);
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

