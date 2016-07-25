/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classi;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Ignazio
 */
@WebServlet(name = "VenditoreServlet", urlPatterns = {"/VenditoreServlet"})
public class VenditoreServlet extends HttpServlet {

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
        
        /*Nel caso in cui l'utente non sia loggato o non sia un venditore appare
        un messaggio di errore*/
        HttpSession session = request.getSession(false);
        if (session==null) {
            request.getRequestDispatcher("PaginaErrore.jsp").forward(request, response);
        }
        if(session != null && session.getAttribute("venditoreLoggedIn").equals(false)){
            request.getRequestDispatcher("PaginaErrore.jsp").forward(request, response);
        }
        
        /*Nel caso l’utente sia un venditore, deve mostrare il form di inserimento dell’oggetto.*/
        if(session != null && session.getAttribute("venditoreLoggedIn").equals(true)){
            request.getRequestDispatcher("venditore.jsp").forward(request, response);
        }
        
        /*if(request.getParameter("Submit") != null){
            request.getRequestDispatcher("objectInSaleInput.jsp").forward(request, response);
        }*/
        
        
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
                //processRequest(request, response);
                ObjectSale oggetto = new ObjectSale();
                //oggetto.setId(Integer.parseInt(request.getParameter("id")));
                oggetto.setNome(request.getParameter("nomeOggetto"));
                oggetto.setDescrizione(request.getParameter("descrizioneOgg"));
                oggetto.setNum_Pezzi(Integer.parseInt(request.getParameter("quantita")));
                oggetto.setPrezzo(Double.parseDouble(request.getParameter("prezzo")));
                
                request.setAttribute("obj", oggetto);
                request.getRequestDispatcher("objectInSaleInput.jsp").forward(request, response);
               
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
