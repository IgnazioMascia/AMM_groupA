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
public class SaldoContoFactory {
    
    // Attributi
    private static SaldoContoFactory singleton;
    public static SaldoContoFactory getInstance() {
        if (singleton == null) {
            singleton = new SaldoContoFactory();
        }
        return singleton;
    }

}
