/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

/**
 *
 * @author Ignazio
 */
public class ClienteFactory {
    // Attributi
    
    private static ClienteFactory singleton;
    String connectionString;
    public static ClienteFactory getInstance() {
        if (singleton == null) {
            singleton = new ClienteFactory();
        }
        return singleton;
    }
    
    // Lista Clienti
    //public ArrayList<Cliente> listaClienti = new ArrayList<Cliente>();
    
    /* Costruttore */
    private ClienteFactory() {
        /*
        //Cliente 1
        Cliente cli_1 = new Cliente();
            cli_1.setUsername("Machop");
            cli_1.setPassword("8989");
            cli_1.setNome("Marco");
            cli_1.setCognome("Cioppo");
            cli_1.setId(888);
            cli_1.setConto(222.99);
        ArrayList<ObjectSale> arrayOggettiCliente_1;
        arrayOggettiCliente_1 = new ArrayList<ObjectSale>();
            arrayOggettiCliente_1.add(ObjectSaleFactory.getInstance().getOggettoById(0));
            arrayOggettiCliente_1.add(ObjectSaleFactory.getInstance().getOggettoById(3));
            arrayOggettiCliente_1.add(ObjectSaleFactory.getInstance().getOggettoById(0));
            arrayOggettiCliente_1.add(ObjectSaleFactory.getInstance().getOggettoById(2));
            arrayOggettiCliente_1.add(ObjectSaleFactory.getInstance().getOggettoById(4));
        listaClienti.add(cli_1);
        
        //Cliente 2
        Cliente cli_2 = new Cliente();
            cli_2.setUsername("Gengi");
            cli_2.setPassword("8989");
            cli_2.setNome("Gennifer");
            cli_2.setCognome("Girolesi");
            cli_2.setId(999);
            cli_2.setConto(1.00);
        ArrayList<ObjectSale> arrayOggettiCliente_2;
        arrayOggettiCliente_2 = new ArrayList<ObjectSale>();
            arrayOggettiCliente_2.add(ObjectSaleFactory.getInstance().getOggettoById(1));
            arrayOggettiCliente_2.add(ObjectSaleFactory.getInstance().getOggettoById(1));
            arrayOggettiCliente_2.add(ObjectSaleFactory.getInstance().getOggettoById(2));
            arrayOggettiCliente_2.add(ObjectSaleFactory.getInstance().getOggettoById(0));
            arrayOggettiCliente_2.add(ObjectSaleFactory.getInstance().getOggettoById(3));
        listaClienti.add(cli_2);
        */
    
    }
    
    
    /*METODI*/
    /*Restituisce Un cliente per volta, interrogando il DB, interrogando il DB sui clienti che potrebbero avere quello user e quella
    pss.. Se nessun cliente ha user o pss uguali a quelli, allora semplicemente restituisce null*/
    public Cliente getCliente(String username, String password)
    {
        try
        {
            Connection conn = DriverManager.getConnection(connectionString, "", "");
            // sql command
            String query = "select * from cliente where "
                    + "password = ? and username = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            // dati
            stmt.setString(1, password);
            stmt.setString(2, username);
            //
            ResultSet set = stmt.executeQuery();
            
            if(set.next())
            {
                Cliente cliente = new Cliente();
                cliente.id = set.getInt("id");
                cliente.nome = set.getString("nome");
                cliente.cognome = set.getString("cognome");
                cliente.username = set.getString("username");
                cliente.password = set.getString("password");
                cliente.conto = set.getDouble("conto");
                
                /*
                st.close();
                stmt.close();
                conn.close();
                */                
                
                return cliente;
            }
            
            /*
            stmt.close();
            conn.close();
            */
        }
        catch(SQLException e)
        {
            
        }
        return null;
    }
    
    /*Restituisce la lista dei clienti*/
    public ArrayList<Cliente> getListaClienti()
    {
        ArrayList<Cliente> listaClienti = new ArrayList<Cliente>();
        try 
        {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "", "");
            Statement stmt = conn.createStatement();
            String query = "select * from APP.cliente";
            ResultSet set = stmt.executeQuery(query);
            
             // ciclo sulle righe restituite
            while(set.next()) 
            {
                Cliente current = new Cliente();
                current.setId(set.getInt("id"));
                current.setNome(set.getString("nome"));
                current.setCognome(set.getString("cognome"));
                current.setUsername(set.getString("username"));
                current.setPassword(set.getString("password"));
                current.setConto(set.getDouble("conto"));
                listaClienti.add(current);
            } 
            
            stmt.close();
            conn.close();
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return listaClienti;
    }
    
    /*Restituisce il cliente avente l'id passato come parametro, altrimenti null.*/
    public Cliente getClienteById(int id)
    {
        try 
        {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "", "");
            // Query
            String query = "select * from cliente where id = ?";
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            // Si associano i valori
            stmt.setInt(1, id);
            // Esecuzione query
            ResultSet res = stmt.executeQuery();
            
             // ciclo sulle righe restituite
            if(res.next()) 
            {
                Cliente current = new Cliente();
                current.setId(res.getInt("id"));
                current.setNome(res.getString("nome"));
                current.setCognome(res.getString("cognome"));
                current.setUsername(res.getString("username"));
                current.setPassword(res.getString("password"));
                current.setConto(res.getDouble("conto"));
                
                /*
                st.close();
                stmt.close();
                conn.close();
                */
                
                return current;
            }   
            stmt.close();
            conn.close();
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return null;
    }
    
    /*Metodo che riceve in input l'id del cliente e fa una ricerca sul db restituendo
    la lista di oggetti del "carrello" del cliente.*/
    public ArrayList<ObjectSale> getListaOggettiCliente(int id)
    {
        ArrayList<ObjectSale> listaOggettiCliente = new ArrayList<ObjectSale>();
        try 
        {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "", "");
            //Statement stmt = conn.createStatement();
            String query = "select * from ObjectSale"
                    + "join carrello_oggetto "
                    + "on ObjectSale.id = carrello_oggetto.idOggetto "
                    + "where carrello_oggetto.idCliente = ?";
            
            PreparedStatement stmt = conn.prepareStatement(query);
            // Si associano i valori
            stmt.setInt(1, id);
            // Esecuzione query
            ResultSet set = stmt.executeQuery();
            
            //ResultSet set = stmt.executeQuery(query);
            
             // ciclo sulle righe restituite
            while(set.next()) 
            {
                ObjectSale current = new ObjectSale();
                
                current.setId(set.getInt("id"));
                current.setNome(set.getString("nome"));
                current.setDescrizione(set.getString("descrizione"));
                current.setNum_Pezzi(set.getInt("num_pezzi"));
                current.setPrezzo(set.getDouble("prezzo"));
                current.setCategoria(set.getString("categoria"));
                current.setUrlImmagine(set.getString("urlImmagine"));
                current.setIdVendita(set.getInt("idVendita"));
                listaOggettiCliente.add(current);
            } 
            
            stmt.close();
            conn.close();
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return listaOggettiCliente;
    }
    
    /*Creo il metodo che mi permette di eseguire la transazione economica del punto 6 della MIlestonen n.4*/
    public String TransazioneEconomica(int idOggetto, int idCliente) throws SQLException{
        Double CostoOggetto =0.0;
        int PezziOggetto =0;
        int IdVenditore = 0;
        Double FondiVenditore = 0.0;
        Double FondiCliente = 0.0;
        String Errore = "none";
        String Conferma = "none";
        
        
        /*Eseguo query per pescare i valori di CostoOgg e il num di pezzi dell'ogg...*/
        try 
        {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "", "");
            //Statement stmt = conn.createStatement();
            String query = "select prezzo, num_pezzi, idvendita from ObjectSale"
                    + "where id = ?";
            
            PreparedStatement stmt = conn.prepareStatement(query);
            // Si associano i valori
            stmt.setInt(1, idOggetto);
            // Esecuzione query
            ResultSet set = stmt.executeQuery();
            
            //ResultSet set = stmt.executeQuery(query);
            
            CostoOggetto = set.getDouble("prezzo");
            PezziOggetto = set.getInt("id");
            IdVenditore = set.getInt("idVendita");
            
            stmt.close();
            conn.close();
        } 
        catch (SQLException e) 
        {
            throw e;
        }
        
        /*Eseguo la query per pescare il valore dei fondi del cliente*/
        try 
        {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "", "");
            //Statement stmt = conn.createStatement();
            String query = "select conto from Cliente"
                    + "where id = ?";
            
            PreparedStatement stmt = conn.prepareStatement(query);
            // Si associano i valori
            stmt.setInt(1, idCliente);
            // Esecuzione query
            ResultSet set = stmt.executeQuery();
            
            //ResultSet set = stmt.executeQuery(query);
            
            FondiCliente = set.getDouble("conto");
            
            stmt.close();
            conn.close();
        } 
        catch (SQLException e) 
        {
            throw e;
        }
        
        /*Eseguo la query per pescare il valore dei fondi del venditore*/
        try 
        {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "", "");
            //Statement stmt = conn.createStatement();
            String query = "select conto from Venditore"
                    + "where id = ?";
            
            PreparedStatement stmt = conn.prepareStatement(query);
            // Si associano i valori
            stmt.setInt(1, IdVenditore);
            // Esecuzione query
            ResultSet set = stmt.executeQuery();
            
            //ResultSet set = stmt.executeQuery(query);
            
            FondiVenditore = set.getDouble("conto");
            
            stmt.close();
            conn.close();
        } 
        catch (SQLException e) 
        {
            throw e;
        }
        finally
        {
            
        }
        
        /*Ora eseguo controlli per poter continuare:*/
        if(FondiCliente < CostoOggetto){
            Errore = "Fondi insufficienti";
                    return Errore;
        }
        if(PezziOggetto <= 0){
            Errore = "Articolo esaurito";
                    return Errore;
        }
        
        PezziOggetto--;
        FondiCliente = FondiCliente - CostoOggetto;
        FondiVenditore = FondiVenditore + CostoOggetto;
                
        /*____________________________________________________________________
        
                            TRANSAZIONE
          ____________________________________________________________________*/
        /*Eseguo il blocco try-catch per la transazione.*/
        Connection conn = null;
        PreparedStatement stmt = null;
        try
        {
            conn = DriverManager.getConnection(connectionString, "", "");
            conn.setAutoCommit(false);  //Inizio transazione
            //PreparedStatement stmt;
            String query;
            
        
            /*Eseguo query per uploadare il numero dei pezzi dell'ogg...*/
            try 
            {
                query = "update ObjectSale "
                        + "set num_pezzi = ?"
                        + "where id = ?";

                stmt = conn.prepareStatement(query);
                // Si associano i valori
                stmt.setInt(1, PezziOggetto);
                stmt.setInt(2, idOggetto);
                // Esecuzione query
                stmt.executeQuery();
            } 
            catch(SQLException ex)
            {
                conn.rollback();    //Se qualcosa non dovesse andare, viene evocato il rollback,
                                    //quindi le modifiche al DB non vengono immesse.
                throw ex;
                /*Errore = "Transazione bloccata. Motivo sconosciuto.";
                return Errore;*/
            }

            /*Eseguo query per uploadare il valore del conto di cliente*/
            try 
            {
                query = "update Cliente "
                        + "set conto = ?"
                        + "where id = ?";

                stmt = conn.prepareStatement(query);
                // Si associano i valori
                stmt.setDouble(1, FondiCliente);
                stmt.setInt(2, idCliente);
                // Esecuzione query
                stmt.executeQuery();
            } 
            catch (SQLException ex) 
            {
                conn.rollback();
                throw ex;
                /*Errore = "Transazione bloccata. Motivo sconosciuto.";
                return Errore;*/
            }

            /*Eseguo query per uploadare il valore del conto di venditore*/
            try 
            {
                query = "update Venditore "
                        + "set conto = ?"
                        + "where id = ?";

                stmt = conn.prepareStatement(query);
                // Si associano i valori
                stmt.setDouble(1, FondiVenditore);
                stmt.setInt(2, idOggetto);
                // Esecuzione query
                stmt.executeQuery();
            } 
            catch (SQLException ex) 
            {
                conn.rollback();
                throw ex;
                /*Errore = "Transazione bloccata. Motivo sconosciuto.";
                return Errore;*/
            }
        
        conn.commit();
        Conferma = "Acquisto completato";
        return Conferma;
        }
        catch(SQLException ex)
        {
            conn.rollback();
            throw ex;
            /*Errore = "Transazione bloccata. Motivo sconosciuto.";
            return Errore;*/
            
        }
        finally
        {
            if (stmt != null){
                stmt.close();
            }
            if (conn != null){
                conn.close();
            }
            //Se la transazione dovesse andare a buon fine, nel blocco try verrebbe
            //restituito "Conferma" e il campo finally non verrebbe eseguito.
            //Quindi se finally dovesse essere eseguito, allora vorrebbe dire che 
            //la transazione non è andata a buon fine.
            Errore = "Transaction";
            return Errore;
        }
        
    }
    
    
    /*
    public Cliente getClienteByNome(String nome)
    {
        for(Cliente u : listaClienti)
        {
            if(u.getNome.equals(nome))
                return u;
        }
        
        return null;
    }
    
    public Cliente getClienteByCognome(String cognome)
    {
        for(Cliente u : listaClienti)
        {
            if(u.getNome.equals(cognome))
                return u;
        }
        
        return null;
    }
    
    public Cliente getClienteByUsername(String username)
    {
        for(Cliente u : listaClienti)
        {
            if(u.getNome.equals(username))
                return u;
        }
        
        return null;
    }
    
    public Cliente getClienteByPassword(String password)
    {
        for(Cliente u : listaClienti)
        {
            if(u.getNome.equals(password))
                return u;
        }
        
        return null;
    }*/
    
    public void setConnectionString(String s){
	this.connectionString = s;
    }
    
    public String getConnectionString(){
	return this.connectionString;
    } 
    
}
