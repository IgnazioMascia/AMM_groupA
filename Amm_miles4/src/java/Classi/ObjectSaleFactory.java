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
public class ObjectSaleFactory {
    // Attributi
    
    private static ObjectSaleFactory singleton;
    String connectionString;
    public static ObjectSaleFactory getInstance() {
        if (singleton == null) {
            singleton = new ObjectSaleFactory();
        }
        return singleton;
    }
    
    // Lista Oggetti in vendita/acquistati
    //private ArrayList<ObjectSale> listaOggetti = new ArrayList<ObjectSale>();
   
    /* Costruttore */
    private ObjectSaleFactory() {

    }

    
    /*METODI*/
    
    /*Restituisce la lista degli oggetti.*/
    public ArrayList<ObjectSale> getListaOggetti()
    {
        ArrayList<ObjectSale> listaOggetti = new ArrayList<ObjectSale>();
        try 
        {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "", "");
            Statement stmt = conn.createStatement();
            String query = "select * from ObjectSale'";
            ResultSet set = stmt.executeQuery(query);
            
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
                listaOggetti.add(current);
            } 
            
            stmt.close();
            conn.close();
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return listaOggetti;
    }

        /*Restituisce l'oggeto avente l'id uguale a quello passato per parametro. Altrimenti restituisce null*/
    public ObjectSale getOggettoById(int id)
    {
        try 
        {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "", "");
            // Query
            String query = "select * from OjectSale where id = ?";
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            // Si associano i valori
            stmt.setInt(1, id);
            // Esecuzione query
            ResultSet res = stmt.executeQuery();
            
             // ciclo sulle righe restituite
            if(res.next()) 
            {
                ObjectSale current = new ObjectSale();
                
                current.setId(res.getInt("id"));
                current.setNome(res.getString("nome"));
                current.setDescrizione(res.getString("descrizione"));
                current.setNum_Pezzi(res.getInt("num_pezzi"));
                current.setPrezzo(res.getDouble("prezzo"));
                current.setCategoria(res.getString("categoria"));
                current.setUrlImmagine(res.getString("urlImmagine"));
                current.setIdVendita(res.getInt("idVendita"));
                
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

        
        public void setConnectionString(String s){
            this.connectionString = s;
        }
    
        public String getConnectionString(){
            return this.connectionString;
        } 
        
        
}
