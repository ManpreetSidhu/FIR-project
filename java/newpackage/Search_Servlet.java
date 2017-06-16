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
public class Search_Servlet extends HttpServlet {

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

            String search = request.getParameter("search");
            String search1 = search.trim();
            if (search1.equals("Home")) {
                response.sendRedirect("main1.jsp");
            }
           else if (search1.equals("About us")) {
                response.sendRedirect("about_us.jsp");
            }
          else  if (search1.equals("Online FIR")) {
                response.sendRedirect("online_fir.jsp");
            }
           else if (search1.equals("Site Map")) {
                response.sendRedirect("sitemap.jsp");
            }
           else if (search1.equals("FAQ")) {
                response.sendRedirect("faq1.jsp");
            }
          else  if (search1.equals("Children Safety Tips")) {
                response.sendRedirect("children.jsp");
            }
          else if (search1.equals("Home Safety Tips")) {
                response.sendRedirect("home.jsp");
            }
           else if (search1.equals("Vehicle Safety Tips")) {
                response.sendRedirect("vehicle.jsp");
            }
           else if (search1.equals("Personnel Safety Tips")) {
                response.sendRedirect("personnel.jsp");
            }
           else if (search1.equals("Road Safety Tips")) {
                response.sendRedirect("roadsafetyrules.jsp");
            }
          else  if (search1.equals("Gallantry Awards")) {
                response.sendRedirect("gallantry.jsp");
            }
          else  if (search1.equals("Meritorious Awards")) {
                response.sendRedirect("meritirious.jsp");
            }
          else  if (search1.equals("Info About Accident")) {
                response.sendRedirect("info1.jsp");
            }
          else  if (search1.equals("Complaint")) {
                response.sendRedirect("complaint.jsp");
            }
          else  if (search1.equals("Suggestion")) {
                response.sendRedirect("suggestion.jsp");
            }
         else   if (search1.equals("Act & Rules")) {
                response.sendRedirect("actANDrules.jsp");
            }
           else if (search1.equals("Newsletter")) {
                response.sendRedirect("newsletter.jsp");
            }
           else if (search1.equals("Missing")) {
                response.sendRedirect("missing.jsp");
            }
          else  if (search1.equals("Wanted")) {
                response.sendRedirect("wanted.jsp");
            }
           else if (search1.equals("Contact us")) {
                response.sendRedirect("contactus.jsp");
            }
           else if (search1.equals("Helpline Number")) {
                response.sendRedirect("helpline.jsp");
            }
           else {
                response.sendRedirect("main1.jsp");
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
