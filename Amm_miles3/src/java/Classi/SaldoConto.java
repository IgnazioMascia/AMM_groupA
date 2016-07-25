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
public class SaldoConto {
    
    /*attributi*/
    private double Portafoglio;
    private double CapitaleMinimo;
    private double CapitaleMassimo;
    
    public SaldoConto(){
        /*costruttore*/
        setPortafoglio(0);
        setCapitaleMinimo(0);
        setCapitaleMassimo(1000);
    }
    
    /*metodi*/

    /**
     * @return the Portafoglio
     */
    public double getPortafoglio() {
        return Portafoglio;
    }

    /**
     * @param Portafoglio the Portafoglio to set
     */
    public void setPortafoglio(double Portafoglio) {
        this.Portafoglio = Portafoglio;
    }

    /**
     * @return the CapitaleMinimo
     */
    public double getCapitaleMinimo() {
        return CapitaleMinimo;
    }

    /**
     * @param CapitaleMinimo the CapitaleMinimo to set
     */
    public void setCapitaleMinimo(double CapitaleMinimo) {
        this.CapitaleMinimo = CapitaleMinimo;
    }

    /**
     * @return the CapitaleMassimo
     */
    public double getCapitaleMassimo() {
        return CapitaleMassimo;
    }

    /**
     * @param CapitaleMassimo the CapitaleMassimo to set
     */
    public void setCapitaleMassimo(double CapitaleMassimo) {
        this.CapitaleMassimo = CapitaleMassimo;
    }
    
    
}
