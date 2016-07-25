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
public class ClienteFactory {
    // Attributi
    private static ClienteFactory singleton;
    public static ClienteFactory getInstance() {
        if (singleton == null) {
            singleton = new ClienteFactory();
        }
        return singleton;
    }
    
    // Lista Clienti
    public ArrayList<Cliente> listaClienti = new ArrayList<Cliente>();
    
    /* Costruttore */
    private ClienteFactory() {
        
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
    
    }
    
    
    /**
     * @return the listaVenditori
     */
    public ArrayList<Cliente> getListaClienti() {
        return listaClienti;
    }

    public Cliente getClienteById(int id)
    {
        for(Cliente u : listaClienti)
        {
            if(u.getId == id)
                return u;
        }
        
        return null;
    }
    
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
    }
    
}
