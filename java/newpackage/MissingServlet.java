/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package newpackage;
import bean.Missing;
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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author sidhu
 */
public class MissingServlet extends HttpServlet {

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
         String sex="",nam="",guardian_name="",district_state="",place="",date="",height="",comp="",year="",eyes="",dress="",id=Integer.toString(db.getid()); 
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
        if(xy.equals("district_state"))
            district_state=  item.getString();
         if(xy.equals("guardian_name"))
            guardian_name=  item.getString();
           if(xy.equals("place"))
            place=  item.getString();
           if(xy.equals("date"))
            date=  item.getString();
            if(xy.equals("height"))
            height=  item.getString();
            if(xy.equals("comp"))
            comp=  item.getString();
            if(xy.equals("year"))
            year=  item.getString();
            if(xy.equals("eyes"))
            eyes=  item.getString();
            if(xy.equals("dress"))
            dress=  item.getString();
     
        System.out.println("....."+nam);
          }
         
         
          else{    String nm =item.getName();
                 is = item.getInputStream();
         }   }  
        is.read(b); 

        int  id1=db.getid();
      Missing m=new Missing();
      m.setSex(sex);
       m.setName(nam);
       m.setDistrict_state(district_state);
       m.setGuardian_name(guardian_name);
       m.setPlace(place);
       m.setDate(date);
       m.setHeight(height);
       m.setComplexion(comp);
       m.setYear(year);
       m.setEyes(eyes);
       m.setDress(dress);
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
                ("insert into Missing(Sex,Name,District_state,Guardian_name,Place,Date,Height,Complexion,Age,Eyes,Dress,Image)values(?,?,?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, m.getSex());
            ps.setString(2, m.getName());
            ps.setString(3, m.getDistrict_state());
            ps.setString(4, m.getGuardian_name());
            ps.setString(5, m.getPlace());
            ps.setString(6, m.getDate());
            ps.setString(7, m.getHeight());
            ps.setString(8, m.getComplexion());
            ps.setString(9, m.getYear());
            ps.setString(10, m.getEyes());
            ps.setString(11, m.getDress());
            ps.setString(12,"image/"+f1.getName());
        int i=ps.executeUpdate();
        response.sendRedirect("missingform.jsp");
        
        }
        catch(Exception e){
              response.sendRedirect("missingform.jsp?chk=invalid");
            System.out.println("Exception in insertMissing "+e);
            
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
        } catch(Exception ex) {
           
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
            Logger.getLogger(MissingServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MissingServlet.class.getName()).log(Level.SEVERE, null, ex);
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
