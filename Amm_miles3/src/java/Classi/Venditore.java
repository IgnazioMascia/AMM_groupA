/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classi;

import java.util.ArrayList;

/**
 *
 * @author Ignazio
 */
public class Venditore {
    
    /* Attributi venditore */
    private int id;
    private String nome;
    private String cognome;
    private String username;
    private String password;
    private double conto;
    public int getId;
    public String getNome;
    public String getCognome;
    public String getUsername;
    public String getPassword;
    public double getConto;
    
    private final ArrayList<ObjectSale> oggettiVendita = new ArrayList<ObjectSale>();
    
    /* Costruttore */
    public Venditore(){
        setId(0);
        setNome("");
        setCognome("");
        setUsername("");
        setPassword("");
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the cognome
     */
    public String getCognome() {
        return cognome;
    }

    /**
     * @param cognome the cognome to set
     */
    void setCognome(String cognome) {
        this.cognome = cognome;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    void setPassword(String password) {
        this.password = password;
    }
    
    /**
     * @return the oggettiCarrello
     */
    public ArrayList<ObjectSale> getOggettiVendita() {
        return oggettiVendita;
    }

    /**
     * @return the conto
     */
    public double getConto() {
        return conto;
    }

    /**
     * @param conto the conto to set
     */
    public void setConto(double conto) {
        this.conto = conto;
    }


}