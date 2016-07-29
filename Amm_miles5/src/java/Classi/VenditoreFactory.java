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
public class VenditoreFactory {
    // Attributi
    private static VenditoreFactory singleton;
    String connectionString;
    public static VenditoreFactory getInstance() {
        if (singleton == null) {
            singleton = new VenditoreFactory();
        }
        return singleton;
    }
    
    // Lista Venditori
    //private ArrayList<Venditore> listaVenditori = new ArrayList<Venditore>();
    
    /* // Lista Clienti
    private ArrayList<Cliente> listaClienti = new ArrayList<Cliente>();
    
    /* Costruttore */
    
    private VenditoreFactory() {
        /*
        //Venditore 1
        Venditore sel_1;
        sel_1= new Venditore();
            sel_1.setUsername("IgnazioMascia");
            sel_1.setPassword("0000");
            sel_1.setNome("Ignazio");
            sel_1.setCognome("Mascia");
            sel_1.setId(0);
            sel_1.setConto(0);
        listaVenditori.add(sel_1);
        
        //Venditore 2
        Venditore sel_2 = new Venditore();
            sel_2.setUsername("GiorgiaMascia");
            sel_2.setPassword("1111");
            sel_2.setNome("Giorgia");
            sel_2.setCognome("Mascia");
            sel_2.setId(1);
            sel_2.setConto(23.00);
        listaVenditori.add(sel_2);
        
        //Venditore 3
        Venditore sel_3 = new Venditore();
            sel_3.setUsername("DenisMulas");
            sel_3.setPassword("2222");
            sel_3.setNome("Denis");
            sel_3.setCognome("Mulas");
            sel_3.setId(2);
            sel_3.setConto(569);
        listaVenditori.add(sel_3);*/
        
       /* //Cliente 1
        Cliente cli_1 = new Cliente();
            cli_1.setUsername("Machop");
            cli_1.setPassword("8989");
            cli_1.setNome("Marco");
            cli_1.setCognome("Cioppo");
            cli_1.setId(888);
        ArrayList<ObjectSale> arrayOggettiCliente_1;
        arrayOggettiCliente_1 = new ArrayList<>();
            arrayOggettiCliente_1.add(oggetto_5);
            arrayOggettiCliente_1.add(oggetto_4);
            arrayOggettiCliente_1.add(oggetto_1);
            arrayOggettiCliente_1.add(oggetto_1);
            arrayOggettiCliente_1.add(oggetto_3);
        listaClienti.add(cli_1);
        
        //Cliente 2
        Cliente cli_2 = new Cliente();
            cli_2.setUsername("Gengi");
            cli_2.setPassword("8989");
            cli_2.setNome("Gennifer");
            cli_2.setCognome("Girolesi");
            cli_2.setId(999);
        ArrayList<ObjectSale> arrayOggettiCliente_2;
        arrayOggettiCliente_2 = new ArrayList<>();
            arrayOggettiCliente_2.add(oggetto_2);
            arrayOggettiCliente_2.add(oggetto_2);
            arrayOggettiCliente_2.add(oggetto_3);
            arrayOggettiCliente_2.add(oggetto_1);
            arrayOggettiCliente_2.add(oggetto_4);
        listaClienti.add(cli_2);*/
    
    }
    
    
    /*METODI*/
    /*Restituisce Un venditore per volta, interrogando il DB sui venditori che potrebbero avere quello user e quella
    pss.. Se nessun venditore ha user o pss uguali a quelli, allora semplicemente restituisce null*/
    public Venditore getVenditore(String username, String password)
    {
        try
        {
            Connection conn = DriverManager.getConnection(connectionString, "", "");
            // sql command
            String query = "select * from venditore where "
                    + "password = ? and username = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            // dati
            stmt.setString(1, password);
            stmt.setString(2, username);
            //
            ResultSet set = stmt.executeQuery();
            
            if(set.next())
            {
                Venditore venditore = new Venditore();
                venditore.id = set.getInt("id");
                venditore.nome = set.getString("nome");
                venditore.cognome = set.getString("cognome");
                venditore.username = set.getString("username");
                venditore.password = set.getString("password");
                venditore.conto = set.getDouble("conto");
                
                /*
                st.close();
                stmt.close();
                conn.close();
                */                
                
                return venditore;
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
        /*RICORDA!!!=  se nel form login non vi è stato inserito un venditore ma un cliente,
        questo metodo OVVIAMENTE restituisce null.. quindi devo gestire il "null" nella LoginServlet
        per far si che possa essere eseguito il pezzo di codice successivo (per cliente)...*/
    }
    
    /*Restituisce la lista dei venditori*/
    public ArrayList<Venditore> getListaVenditori()
    {
        ArrayList<Venditore> listaVenditori = new ArrayList<Venditore>();
        try 
        {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "", "");
            Statement stmt = conn.createStatement();
            String query = "select * from venditore'";
            ResultSet set = stmt.executeQuery(query);
            
             // ciclo sulle righe restituite
            while(set.next()) 
            {
                Venditore current = new Venditore();
                current.setId(set.getInt("id"));
                current.setNome(set.getString("nome"));
                current.setCognome(set.getString("cognome"));
                current.setUsername(set.getString("username"));
                current.setPassword(set.getString("password"));
                current.setConto(set.getDouble("conto"));
                listaVenditori.add(current);
            } 
            
            stmt.close();
            conn.close();
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return listaVenditori;
    }
    
    /*Restituisce il venditore avente l'id passato come parametro, altrimenti null.*/
    public Venditore getVenditoreById(int id)
    {
        try 
        {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "", "");
            // Query
            String query = "select * from venditore where id = ?";
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            // Si associano i valori
            stmt.setInt(1, id);
            // Esecuzione query
            ResultSet res = stmt.executeQuery();
            
             // ciclo sulle righe restituite
            if(res.next()) 
            {
                Venditore current = new Venditore();
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
    public ArrayList<ObjectSale> getListaOggettiVenditore(int id)
    {
        ArrayList<ObjectSale> listaOggettiVenditore = new ArrayList<ObjectSale>();
        try 
        {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "", "");
            //Statement stmt = conn.createStatement();
            String query = "select * from ObjectSale"
                    + "where ObjectSale.idVendita = ?";
            
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
                listaOggettiVenditore.add(current);
            } 
            
            stmt.close();
            conn.close();
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return listaOggettiVenditore;
    }
    
            
    /*
    NOTA AL DOCENTE: Al posto di creare i metodi per la creazione, modifica, eliminazione
    di un oggetto dalla lista degli oggetti messi in vendita, ho inglobato direttamente le
    azioni da compiersi nel metodo doPost della ServletVenditore.
    */
    
    /*
    public Venditore getVenditoreByNome(String nome)
    {
        for(Venditore u : listaVenditori)
        {
            if(u.getNome.equals(nome))
                return u;
        }
        
        return null;
    }
    
    public Venditore getVenditoreByCognome(String cognome)
    {
        for(Venditore u : listaVenditori)
        {
            if(u.getNome.equals(cognome))
                return u;
        }
        
        return null;
    }
    
    public Venditore getVenditoreByUsername(String username)
    {
        for(Venditore u : listaVenditori)
        {
            if(u.getNome.equals(username))
                return u;
        }
        
        return null;
    }
    
    public Venditore getVenditoreByPassword(String password)
    {
        for(Venditore u : listaVenditori)
        {
            if(u.getNome.equals(password))
                return u;
        }
        
        return null;
    }
    */
    
    public void setConnectionString(String s){
	this.connectionString = s;
    }
    
    public String getConnectionString(){
	return this.connectionString;
    } 
    
}
