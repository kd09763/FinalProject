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
import database.Database;
import static java.awt.PageAttributes.MediaType.A;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import servlet.DataFilter;

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
        Database db = new Database();
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

        String state = request.getParameter("state");
        String filter = request.getParameter("filters");

        int stateNum = stateFilter(state);
        int filterNum = filterFilter(filter);

        request.setAttribute("stateNum", stateNum);
        request.setAttribute("state", state);
        request.setAttribute("filter", filter);

        DataFilter df = new DataFilter(stateNum, filterNum);

        String[] stateArray = df.getStateArray(stateNum, filterNum);
        int[] caseArray = df.getCaseArray(stateNum, filterNum);
        int[] deathArray = df.getDeathArray(stateNum, filterNum);
        int[] vaccineArray = df.getVaccineArray(stateNum, filterNum);

        
        
        request.setAttribute("stateArray", stateArray);
        request.setAttribute("caseArray", caseArray);
        request.setAttribute("deathArray", deathArray);
        request.setAttribute("vaccineArray", vaccineArray);

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

    //factory static method
    public static int stateFilter(String stateString) {
        int stateFilterNum = 52;
        String[] states = {"allStates", "AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE", "DC", "FL", "GA", "HI", "ID", "IL", "IN",
            "IA", "KS", "KY", "LA", "ME", "MD", "MA", "MI", "MN", "MS", "MT", "NE", "NV", "NH", "NJ", "NM", "NY", "NC", "ND", "OH",
            "OK", "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY"};

        for (int i = 0; i < states.length; i++) {
            if (stateString.equals(states[i]) ) {
                stateFilterNum = i;
            }
        }

        return stateFilterNum;
    }

    //factory static method
    public static int filterFilter(String filterString) {
        int genderFilterNum;
        if (filterString == "nofilter") {
            genderFilterNum = 0;
        } else if (filterString == "under18") {
            genderFilterNum = 1;
        } else if (filterString == "18+") {
            genderFilterNum = 2;
        } else if (filterString == "65+") {
            genderFilterNum = 3;
        } else if (filterString == "male") {
            genderFilterNum = 4;
        } else {
            genderFilterNum = 5;
        }
        return genderFilterNum;
    }

}
