/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classi;

import java.util.logging.Logger;
import java.util.ArrayList;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.util.logging.Level;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author Ignazio
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"}, loadOnStartup = 0)
public class LoginServlet extends HttpServlet {
    
    private static final String JDBC_DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
    private static final String DB_CLEAN_PATH = "../../web/WEB-INF/db/ammdb";
    private static final String DB_BUILD_PATH = "WEB-INF/db/ammdb";
    
    @Override 
    public void init(){
        String dbConnection = "jdbc:derby:" + this.getServletContext().getRealPath("/") + DB_BUILD_PATH;
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        ObjectSaleFactory.getInstance().setConnectionString(dbConnection);
        ClienteFactory.getInstance().setConnectionString(dbConnection);
        VenditoreFactory.getInstance().setConnectionString(dbConnection);
        
    }
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
        
        HttpSession session = request.getSession(true);
        
        //int flag=0;
        if(request.getParameter("submit") != null)
        {
            // Preleva i dati inviati
            String username = request.getParameter("username");
            String password = request.getParameter("passwd");
            
            ArrayList<Venditore> listaVenditori = VenditoreFactory.getInstance().getListaVenditori();
            
            for(Venditore u : listaVenditori)
            {
                if(u.getUsername().equals(username) && u.getPassword().equals(password))
                {
                    session.setAttribute("venditoreLoggedIn", true);
                    request.setAttribute("venditore", u);
                    request.setAttribute("oggettiVendita", VenditoreFactory.getInstance().getListaOggettiVenditore(u.id));
                    request.getRequestDispatcher("venditore.jsp").forward(request, response);
                    //flag=1;
                    
                }
            }
            
            //if(flag==0){
                ArrayList<Cliente> listaClienti = ClienteFactory.getInstance().getListaClienti();
                for(Cliente z : listaClienti)
                {
                    if(z.getUsername().equals(username) && z.getPassword().equals(password))
                    {
                        session.setAttribute("clienteLoggedIn", true);
                        request.setAttribute("cliente", z);
                        request.setAttribute("oggetti", ObjectSaleFactory.getInstance().getListaOggetti());
                        request.getRequestDispatcher("cliente.jsp").forward(request, response);
                        //flag=1;
                    }
                }
            //}
            
            //if(flag==0){
                /*println("Errore, login fallito. riprovare.");*/
                request.getRequestDispatcher("PaginaErrore.jsp").forward(request, response);               
            //}
        } else
        request.getRequestDispatcher("login.jsp").forward(request, response);
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
