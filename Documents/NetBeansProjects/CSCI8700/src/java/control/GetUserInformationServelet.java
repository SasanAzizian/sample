/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import database.InsertUserInformation;
import database.Search;
import entity.USerInformation;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sasan
 */
public class GetUserInformationServelet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet GetUserInformationServelet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet GetUserInformationServelet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

               
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        
        USerInformation user=new USerInformation(
                request.getParameter("fname"),
                request.getParameter("lname"),
                request.getParameter("address"),
                request.getParameter("zip"),
                request.getParameter("tel"),
                request.getParameter("state"),
                request.getParameter("email"));
        System.out.println(user.getfName()+"   "+ user.getlName()+" "+user.getState()+"   "+
                user.getAddress()+"        "+ user.getEmail()+"    " +user.getZipcode()+"   "+ user.getTel());
        
        if(InsertUserInformation.insert(user)){       
             out.println("<html><h1><B> The customer with following</B></h1> </html>");
             out.println("<h1><html><B> information has just been regiestered  </B> </h1></html>");
              out.println("<html><B>First Name:</B> </html>");out.println(user.getfName());out.println("<html><br><br/> </html>");
              out.println("<html><B>Last Name:</B> </html>");out.println(user.getlName());out.println("<html><br><br/> </html>");
              out.println("<html><B>TEl:</B> </html>");out.println(user.getTel());out.println("<html><br><br/> </html>");
              out.println("<html><B>Zip Code:</B> </html>");out.println(user.getZipcode());out.println("<html><br><br/> </html>");
              out.println("<html><B>Type:</B> </html>");out.println(user.getState());out.println("<html><br><br/> </html>");
              out.println("<html><B>Email:</B> </html>");out.println(user.getEmail());out.println("<html><br><br/> </html>");
              out.println("<html><B>Address:</B> </html>");out.println(user.getAddress());out.println("<html><br><br/> </html>");
        }
      
        out.close();
        
        

        

    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
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
     * Handles the HTTP <code>POST</code> method.
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
