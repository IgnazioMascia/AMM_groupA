/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classi;

/**
 *
 * @author Ignazio
 */
public class ObjectSale {
    
    private int id;
    private String nome;
    private String descrizione;
    private int num_Pezzi;
    private double prezzo;
    private String categoria;
    private String urlImmagine;
    private int idVendita;
    public int getId;
    public String getNome;
    public String getDescrizione;
    public int getNum_Pezzi;
    public double getPrezzo;
    public String getCategoria;
    public String getUrlImmagine;
    public String getIdVendita;
    
    /* Costruttore */
    public ObjectSale(){
        setId(0);
        setNome("");
        setDescrizione("_");
        setNum_Pezzi(0);
        setPrezzo(0);
        setCategoria("");
        setUrlImmagine("");
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
    public void setId(int id) {
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
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the descrizione
     */
    public String getDescrizione() {
        return descrizione;
    }

    /**
     * @param descrizione the descrizione to set
     */
    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    /**
     * @return the num_Pezzi
     */
    public int getNum_Pezzi() {
        return num_Pezzi;
    }

    /**
     * @param num_Pezzi the num_Pezzi to set
     */
    public void setNum_Pezzi(int num_Pezzi) {
        this.num_Pezzi = num_Pezzi;
    }

    /**
     * @return the prezzo
     */
    public double getPrezzo() {
        return prezzo;
    }

    /**
     * @param prezzo the prezzo to set
     */
    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    /**
     * @return the categoria
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * @param categoria the categoria to set
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    /**
     * @return the urlImmagine
     */
    public String getUrlImmagine() {
        return urlImmagine;
    }

    /**
     * @param urlImmagine the urlImmagine to set
     */
    public void setUrlImmagine(String urlImmagine) {
        this.urlImmagine = urlImmagine;
    }

    /**
     * @return the idVendita
     */
    public int getIdVendita() {
        return idVendita;
    }

    /**
     * @param idVendita the idVendita to set
     */
    public void setIdVendita(int idVendita) {
        this.idVendita = idVendita;
    }

    

    
    
}
