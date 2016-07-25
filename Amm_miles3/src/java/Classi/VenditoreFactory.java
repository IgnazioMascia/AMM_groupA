/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classi;

import java.util.*;

/**
 *
 * @author Ignazio
 */
public class VenditoreFactory {
    // Attributi
    private static VenditoreFactory singleton;
    public static VenditoreFactory getInstance() {
        if (singleton == null) {
            singleton = new VenditoreFactory();
        }
        return singleton;
    }
    
    // Lista Venditori
    private ArrayList<Venditore> listaVenditori = new ArrayList<Venditore>();
    
    /* // Lista Clienti
    private ArrayList<Cliente> listaClienti = new ArrayList<Cliente>();
    
    /* Costruttore */
    private VenditoreFactory() {
        
        //Venditore 1
        Venditore sel_1;
        sel_1= new Venditore();
            sel_1.setUsername("IgnazioMascia");
            sel_1.setPassword("0000");
            sel_1.setNome("Ignazio");
            sel_1.setCognome("Mascia");
            sel_1.setId(0);
        listaVenditori.add(sel_1);
        
        //Venditore 2
        Venditore sel_2 = new Venditore();
            sel_2.setUsername("GiorgiaMascia");
            sel_2.setPassword("1111");
            sel_2.setNome("Giorgia");
            sel_2.setCognome("Mascia");
            sel_2.setId(1);
        listaVenditori.add(sel_2);
        
        //Venditore 3
        Venditore sel_3 = new Venditore();
            sel_3.setUsername("DenisMulas");
            sel_3.setPassword("2222");
            sel_3.setNome("Denis");
            sel_3.setCognome("Mulas");
            sel_3.setId(2);
        listaVenditori.add(sel_3);
        
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
    
    
    /**
     * @return the listaVenditori
     */
    public ArrayList<Venditore> getListaVenditori() {
        return listaVenditori;
    }
    
    public Venditore getVenditoreById(int id)
    {
        for(Venditore u : listaVenditori)
        {
            if(u.getId == id)
                return u;
        }
        
        return null;
    }
    
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
    
}
