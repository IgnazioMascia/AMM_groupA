/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classi;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    
    String connectionString;
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
                
        
            String scelta = request.getParameter("azione");
            switch(scelta){
                
                /*____________________________________________________________________________________________________
                    
                  CASE CREA
                  __________________________________________________________________________________________________*/
                case "Crea":
                    
                    String nome = request.getParameter("nomeOggetto");
                    int pezzi = Integer.parseInt(request.getParameter("quantita"));
                    double prezzo = Double.parseDouble(request.getParameter("prezzo"));
                    String url = request.getParameter("urlImmagine");
                    String desc = request.getParameter("descrizioneOgg");
                    String cat = request.getParameter("categoria");
                    int idVenditore = Integer.parseInt(request.getParameter("venditore"));
                    
                    try 
                    {
                            
                            // path, username, password
                            Connection conn = DriverManager.getConnection(connectionString, "", "");
                            //Statement stmt = conn.createStatement();
                            String query = "insert into ObjectSale"
                                            +"(id, nome, num_pezzi, prezzo, urlImmagine, descrizione, categoria, idvendita) "
                                            +"values (default, ?, ?, ?, ?, ?, ?, ?);";

                            PreparedStatement stmt = conn.prepareStatement(query);
                            // Si associano i valori
                            stmt.setString(1, nome);
                            stmt.setInt(2, pezzi);
                            stmt.setDouble(3, prezzo);
                            stmt.setString(4, url);
                            stmt.setString(5, desc);
                            stmt.setString(6, cat);
                            stmt.setInt(7, idVenditore);
                            // Esecuzione query
                            stmt.executeQuery();
                    
                            stmt.close();
                            conn.close();
                    }
                    
                    catch(SQLException e)
                    {

                    }
                    
                        ObjectSale oggetto = new ObjectSale();
                        oggetto.setNome(request.getParameter("nomeOggetto"));
                        oggetto.setUrlImmagine(request.getParameter("urlImmagine"));
                        oggetto.setDescrizione(request.getParameter("descrizioneOgg"));
                        oggetto.setNum_Pezzi(Integer.parseInt(request.getParameter("quantita")));
                        oggetto.setPrezzo(Double.parseDouble(request.getParameter("prezzo")));
                        
                        /*Invia l'oggetto alla pagina objectSaleInput per la visione dell'oggetto in questione.*/
                        request.setAttribute("obj", oggetto);
                        request.getRequestDispatcher("objectInSaleInput.jsp").forward(request, response);
                    
                    break;
                    
                /*____________________________________________________________________________________________________
                    
                    CASE MODIFICA
                  __________________________________________________________________________________________________*/
                case "Modifica":
                    String Modificato = request.getParameter("flagPerModifica");
                    if (Modificato.equals(false)){
                        int idOggettoModify = Integer.parseInt(request.getParameter("idOggetto"));
                        int idVenditoreModify = Integer.parseInt(request.getParameter("idVenditore"));
                        request.setAttribute("idOggetto", idOggettoModify);
                        request.setAttribute("idVenditore", idVenditoreModify);
                        request.getRequestDispatcher("ModificaObject.jsp").forward(request, response);
                    } else {
                            /*In questo rampo si processano i dati immessi dal venditore nella pagina ModificaOrdine
                            e quindi si pescano i valori immessi e ci si interfaccia al DataBase per l'upload.*/
                            String m_nome = request.getParameter("nomeOggetto");
                            int m_pezzi = Integer.parseInt(request.getParameter("quantita"));
                            double m_prezzo = Double.parseDouble(request.getParameter("prezzo"));
                            String m_url = request.getParameter("urlImmagine");
                            String m_desc = request.getParameter("descrizioneOgg");
                            String m_cat = request.getParameter("categoria");
                            int m_idVenditore = Integer.parseInt(request.getParameter("idVenditore"));
                            int m_idOggetto = Integer.parseInt(request.getParameter("idOggetto"));
                    
                            try 
                            {

                                    // path, username, password
                                    Connection conn = DriverManager.getConnection(connectionString, "", "");
                                    //Statement stmt = conn.createStatement();
                                    String query = "UPDATE ObjectSale"
                                                    +"SET nome = ?, num_pezzi = ?, prezzo = ?, urlImmagine = ?, descrizione = ?, categoria = ?"
                                                    +"WHERE idVendita = ? AND id = ?";

                                    PreparedStatement stmt = conn.prepareStatement(query);
                                    // Si associano i valori
                                    stmt.setString(1, m_nome);
                                    stmt.setInt(2, m_pezzi);
                                    stmt.setDouble(3, m_prezzo);
                                    stmt.setString(4, m_url);
                                    stmt.setString(5, m_desc);
                                    stmt.setString(6, m_cat);
                                    stmt.setInt(7, m_idVenditore);
                                    stmt.setInt(8, m_idOggetto);
                                    // Esecuzione query
                                    stmt.executeQuery();

                                    stmt.close();
                                    conn.close();
                            }

                            catch(SQLException e)
                            {

                            }
                            
                    }
                    break;
                
                /*____________________________________________________________________________________________________
                    
                  CASE ELIMINA
                  __________________________________________________________________________________________________*/
                case "Elimina":
                    
                    int idOggettoDelete = Integer.parseInt(request.getParameter("idOggetto"));
                    int idVenditoreDelete = Integer.parseInt(request.getParameter("idVenditore"));
                    try 
                    {
                        // path, username, password
                        Connection conn = DriverManager.getConnection(connectionString, "", "");
                        // Query
                        String query = "delete * from ObjectSale where id = ? and idVendita = ?";
                        // Prepared Statement
                        PreparedStatement stmt = conn.prepareStatement(query);
                        // Si associano i valori
                        stmt.setInt(1, idOggettoDelete);
                        stmt.setInt(2, idVenditoreDelete);
                        // Esecuzione query
                        stmt.executeQuery();

                        
                        stmt.close();
                        conn.close();
                    } 
                    catch (SQLException e) 
                    {
                        e.printStackTrace();
                    }
                    
                    break;
                    
                default: ;
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
