/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import model.Model;
import model.ConversionException;

/**
 * The ControllerServlet class handles user requests for hexadecimal to decimal
 * and decimal to hexadecimal conversions.
 *
 * @author Adam Kuraczyński
 * @version 1.08
 */
@WebServlet(name = "ControllerServlet", urlPatterns = {"/Convert"})
public class ControllerServlet extends HttpServlet {

    // Create instance of model
    private Model model;
        
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request  the HttpServletRequest
     * @param response the HttpServletResponse
     * @throws ServletException if a servlet specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try (PrintWriter out = response.getWriter()) {

            model = (Model) getServletContext().getAttribute("modelContext");

            String userValues = request.getParameter("userValues");
            String conversionType = request.getParameter("conversionType");

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>HexDec Conversion</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>HexDec Conversion</h1>");

            try {
                if ("hexToDecimal".equals(conversionType)) {
                    String decimalValue = Integer.toString(model.hexToDecimal(userValues));
                    out.println("<p>Conversion Result: " + decimalValue + "</p>");
                } else if ("decimalToHex".equals(conversionType)) {
                    String hexValue = model.decimalToHex(userValues);
                    out.println("<p>Conversion Result: " + hexValue + "</p>");
                }
            } catch (ConversionException e) {
                out.println("<p>Error: " + e.getMessage() + "</p>");
            }
 
            out.println("</body>");
            out.println("</html>");
        }
    }
    

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request  the HttpServletRequest
     * @param response the HttpServletResponse
     * @throws ServletException if a servlet specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request  the HttpServletRequest
     * @param response the HttpServletResponse
     * @throws ServletException if a servlet specific error occurs
     * @throws IOException      if an I/O error occurs
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
        return "ControllerServlet for handling HexDec conversions";
    }
}
