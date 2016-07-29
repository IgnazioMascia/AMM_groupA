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
        
        /*
        //Oggetti
        ObjectSale oggetto_1;
        oggetto_1 = new ObjectSale();
        oggetto_1.setId(0);
        oggetto_1.setNome("Ciondolo dei doni della morte");
        oggetto_1.setDescrizione("Gadget tratto dalla saga di Harry Potter, é il simbolo di Grindelwald, indossato come ciondolo \n" +
                                "da uno dei personaggi.");
        oggetto_1.setNum_Pezzi(1);
        oggetto_1.setPrezzo(5.60);
        oggetto_1.setCategoria("gadget");
        oggetto_1.setUrlImmagine("images/Ciondolo.jpeg");
        listaOggetti.add(oggetto_1);
        
        //Oggetti
        ObjectSale oggetto_2;
        oggetto_2 = new ObjectSale();
        oggetto_2.setId(1);
        oggetto_2.setNome("Abito elegante uomo");
        oggetto_2.setDescrizione("Abito elegante di Valentino, tg.42, collezione primavera 2012. Colore: grigio. (Scarpe e camicia non inclusi). ");
        oggetto_2.setNum_Pezzi(3);
        oggetto_2.setPrezzo(670.23);
        oggetto_2.setCategoria("vestiario");
        oggetto_2.setUrlImmagine("images/AbitoUomo.jpg");
        listaOggetti.add(oggetto_2);
        
        //Oggetti
        ObjectSale oggetto_3;
        oggetto_3 = new ObjectSale();
        oggetto_3.setId(2);
        oggetto_3.setNome("Cellulare Nokia Lumia");
        oggetto_3.setDescrizione("Smartphone Nokia Lumia 535. Può fare tante cose! Persino il café, Wow! ");
        oggetto_3.setNum_Pezzi(27);
        oggetto_3.setPrezzo(119.99);
        oggetto_3.setCategoria("telefonia");
        oggetto_3.setUrlImmagine("images/Cellulare.jpeg");
        listaOggetti.add(oggetto_3);
        
        //Oggetti
        ObjectSale oggetto_4;
        oggetto_4 = new ObjectSale();
        oggetto_4.setId(3);
        oggetto_4.setNome("Tenda da sole Tempotest");
        oggetto_4.setDescrizione("Tenda da sole per Balconi, modello UglySole, con bracci estensibili. Colore: Azzurro e bianco. Misure: 295x200cm. ");
        oggetto_4.setNum_Pezzi(0);
        oggetto_4.setPrezzo(221.99);
        oggetto_4.setCategoria("arredamento");
        oggetto_4.setUrlImmagine("images/TendeDaSole.jpeg");
        listaOggetti.add(oggetto_4);
        
        //Oggetti
        ObjectSale oggetto_5;
        oggetto_5 = new ObjectSale();
        oggetto_5.setId(0);
        oggetto_5.setNome("Tiragraffi per gatti");
        oggetto_5.setDescrizione("Tiragraffi per gatti, modello Miao dell'azienda Gatoh&Co. Differenti colori disponibili. Misure: 120x50x36mm. ");
        oggetto_5.setNum_Pezzi(100);
        oggetto_5.setPrezzo(35.00);
        oggetto_5.setCategoria("giocattoli");
        oggetto_5.setUrlImmagine("images/Tiragraffi.jpg");
        listaOggetti.add(oggetto_5);
        */
        
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

    // Restituisce la lista di tutti gli studenti il cui nome e cognome contiene la stringa in input
    public ArrayList<ObjectSale> getOggetti(String text)
    {
        ArrayList<ObjectSale> lista = new ArrayList<ObjectSale>();
        
        try
        {
            Connection conn = DriverManager.getConnection(connectionString, "", "");
            String query = "select * " +
                           "from ObjectSale " + 
                           "where ObjectSale.nome LIKE ? OR ObjectSale.descrizione LIKE ?";         
            PreparedStatement stmt = conn.prepareStatement(query);
            // Raccogli dati
            text = "%"+text+"%";
            stmt.setString(1, text);
            stmt.setString(2, text);
            ResultSet res = stmt.executeQuery();
            
            while(res.next())
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
                lista.add(current);
            }
            
            stmt.close();
            conn.close();
        }
        catch(SQLException e)
        {}
        
        return lista;
    }
    
        /*
        public ObjectSale getOggettoByNome(String nome)
        {
            for(ObjectSale u : listaOggetti)
            {
                if(u.getNome.equals(nome))
                    return u;
            }

            return null;
        }
        
        public ObjectSale getOggettoByDescrizione(String descrizione)
        {
            for(ObjectSale u : listaOggetti)
            {
                if(u.getDescrizione.equals(descrizione))
                    return u;
            }

            return null;
        }
        
        public ObjectSale getOggettoByNum_Pezzi(int Num_Pezzi)
        {
            for(ObjectSale u : listaOggetti)
            {
                if(u.getNum_Pezzi == Num_Pezzi)
                    return u;
            }

            return null;
        }
        
        public ObjectSale getOggettoByPrezzo(double Prezzo)
        {
            for(ObjectSale u : listaOggetti)
            {
                if(u.getPrezzo == Prezzo)
                    return u;
            }

            return null;
        }
        
        public ObjectSale getOggettoByCategoria(String categoria)
        {
            for(ObjectSale u : listaOggetti)
            {
                if(u.getCategoria.equals(categoria))
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
