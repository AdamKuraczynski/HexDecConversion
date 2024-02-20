/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import model.Model;
import database.Database;
import java.util.ArrayList;

/**
 * The HistoryServlet class displays the conversion history and total visit count.
 * 
 * @author Adam Kuraczyński
 * @version 1.16
 */
@WebServlet(name = "HistoryServlet", urlPatterns = {"/History"})
public class HistoryServlet extends HttpServlet {

    // Create an instance of the model
    private Model model;
    private Database database;
    private int listOfEntries = 0;
    
    /**
     * Processes requests for both HTTP GET and POST methods.
     * Manages cookies, prints values of saved data into database and in current session.
     * 
     * @param request  the HttpServletRequest
     * @param response the HttpServletResponse
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try (PrintWriter out = response.getWriter()) {

            model = (Model) getServletContext().getAttribute("modelContext");
            ArrayList<String> conversionHistory = model.getConversionHistory();
            database = new Database();
            database.createConversionTables();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Conversion History</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Conversion History</h1>");

            int totalVisitsAmount = 0;
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("totalVisits")) {
                        totalVisitsAmount = Integer.parseInt(cookie.getValue());
                    }
                }
            }
            Cookie totalVisitsCookie = new Cookie("totalVisits", String.valueOf(++totalVisitsAmount));
            response.addCookie(totalVisitsCookie);

            out.println("Total Visits Count (from cookies): " + totalVisitsAmount + "<br>");
            out.println("<p>Results from oldest to newest: </p>");

            for (int i = 0; i < conversionHistory.size(); i++) {
                out.println("Successful conversion result: " + conversionHistory.get(i) + "<br>");
            }
            
            out.println("<p>Saved in the database:</p>");
            
            for (int i = listOfEntries; i < conversionHistory.size(); i++) {
                String convertedValue = conversionHistory.get(i);
                database.insertConversionData(1, convertedValue);
                listOfEntries++;
            }
                     
            ArrayList<ArrayList<String>> returnConvertedValues = database.selectConversionData();
            
            for (ArrayList<String> convertedValue : returnConvertedValues) {
                out.println("Converted value: " + convertedValue.get(0) + "<br/>");
            }
                   
            out.println("</body>");
            out.println("</html>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request  the HttpServletRequest
     * @param response the HttpServletResponse
     * @throws ServletException if a servlet-specific error occurs
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
     * @throws ServletException if a servlet-specific error occurs
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
     * @return a String containing the servlet description
     */
    @Override
    public String getServletInfo() {
        return "Servlet for displaying conversion history and total visit count.";
    }
}