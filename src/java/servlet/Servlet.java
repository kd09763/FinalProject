/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author kld09
 */
public class Servlet extends HttpServlet {

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

        }
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
        String age = request.getParameter("age");
        String state = request.getParameter("state");
        String gender = request.getParameter("gender");
        
        int ageFilterNum=ageFilter(age);
        int stateFilterNum=stateFilter(state);
        int genderFilterNum=genderFilter(gender);

        request.setAttribute("age", age);
        request.setAttribute("state", state);
        request.setAttribute("gender", gender);

        request.getRequestDispatcher("Data.jsp").forward(request, response);
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

    public static int ageFilter(String ageString) {
        int ageFilterNum;
        if (ageString == "allAges") {
            ageFilterNum = 0;
        } else if (ageString == "eighteen") {
            ageFilterNum = 1;
        } else {
            ageFilterNum = 2;
        }
        return ageFilterNum;
    }

    public static int stateFilter(String stateString) {
        int stateFilterNum=52;
        String[] states = {"allStates", "AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE", "DC", "FL", "GA", "HI", "ID", "IL", "IN",
            "IA", "KS", "KY", "LA", "ME", "MD", "MA", "MI", "MN", "MS", "MT", "NE", "NV", "NH", "NJ", "NM", "NY", "NC", "ND", "OH",
            "OK", "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY"};
        
        for (int i=0;i<states.length;i++){
            if(stateString==states[i]){
                stateFilterNum=i;
            }
        }
        
        return stateFilterNum;
    }
    
    public static int genderFilter(String genderString){
        int genderFilterNum;
        if (genderString == "allGenders") {
            genderFilterNum = 0;
        } else if (genderString == "female") {
            genderFilterNum = 1;
        } else {
            genderFilterNum = 2;
        }
        return genderFilterNum;
    }
}
