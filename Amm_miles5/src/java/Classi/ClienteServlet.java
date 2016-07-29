/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classi;


import Classi.Cliente;
import java.util.ArrayList;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ignazio
 */
@WebServlet(name = "ClienteServlet", urlPatterns = {"/ClienteServlet"})
public class ClienteServlet extends HttpServlet {
    
    private int IdCliente;
    /*private double CostoOgg;*/
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
        
        /*Nel caso in cui l'utente non sia loggato o non sia un cliente appare
        un messaggio di errore*/
        HttpSession session = request.getSession(false);
        if (session==null) {
            request.getRequestDispatcher("PaginaErrore.jsp").forward(request, response);
        }
        if(session != null && session.getAttribute("venditoreLoggedIn").equals(true)){
            request.getRequestDispatcher("PaginaErrore.jsp").forward(request, response);
        }
        
        /*Nel caso l’utente sia un cliente, deve mostrare la lista degli oggetti.*/
        if(session != null && session.getAttribute("clienteLoggedIn").equals(true)){
            
            
            request.setAttribute("listaOggetti", ObjectSaleFactory.getInstance().getListaOggetti());
            request.getRequestDispatcher("cliente.jsp").forward(request, response);
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
        //processRequest(request, response);
        
        /*int idOggetto = Integer.parseInt(request.getParameter("idExport"));
        
        ArrayList<ObjectSale> listaOggetti = ObjectSaleFactory.getInstance().getListaOggetti();
        for(ObjectSale u : listaOggetti)
            {
                if(u.getId() == idOggetto){
                    CostoOgg = u.getPrezzo;
                    request.setAttribute("Oggetto", u);
                    //request.setAttribute("Costo", CostoOgg);
                    request.getRequestDispatcher("RiepilogoOrdine.jsp").forward(request, response);
                }
            }*/
        
        /*HttpSession session = request.getSession(false);
        
        request.setAttribute("cliente", ClienteFactory.getInstance().getClienteById((int)session.getAttribute("id")));
        
        int idOggetto = Integer.parseInt(request.getParameter("idOggetto"));
        request.setAttribute("oggetto", ObjectSaleFactory.getInstance().getOggettoById(idOggetto));
        
        request.getRequestDispatcher("RiepilogoOrdine.jsp").forward(request, response);*/
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
        
        if(request.getParameter("submit") != null){
            
            int id = Integer.parseInt(request.getParameter("idCliente"));
            int idOgg = Integer.parseInt(request.getParameter("idOggetto"));
            
            String Output;
            try {
                Output = ClienteFactory.getInstance().TransazioneEconomica(id, idOgg);
                if (Output.equals("Transaction")){
                    request.setAttribute("Mess", Output);
                    request.getRequestDispatcher("PaginaErrore.jsp").forward(request, response);
                }
                if (Output.equals("Articolo esaurito")){
                    request.setAttribute("Mess", Output);
                    request.getRequestDispatcher("PaginaErrore.jsp").forward(request, response);
                }
                if (Output.equals("Fondi insufficienti")){
                    request.setAttribute("Mess", Output);
                    request.getRequestDispatcher("PaginaErrore.jsp").forward(request, response);
                }
                if (Output.equals("Acquisto completato")){
                    request.setAttribute("Mess", Output);
                    request.getRequestDispatcher("ConfermaOrdine.jsp").forward(request, response);
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(ClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            
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
