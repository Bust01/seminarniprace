package com.github.bust01.seminarniprace.logika;

/*******************************************************************************
 * Instance třídy PrikazUkazkaBatohu představují ...
 *
 * @author    Tomáš Bušek
 * @version   1.0
 */
class PrikazUkazBatoh implements IPrikaz {  
 private static final String NAZEV = "ukaz_batoh";
 private Batoh batoh;

    /***************************************************************************
     *  Konstruktor ....
     */
    public PrikazUkazBatoh(Batoh batoh)
    {
        this.batoh = batoh;
    }

    
    /**
     * Metoda vracející řetězec, ve kterém je vypsaný obsah batohu 
     * 
     * @return obsah batohu
     */
    public String provedPrikaz(String... parametry) {
        return batoh.nazvyVeci();
    }
    
     /**
     *  Metoda vrací název příkazu (slovo které používá hráč pro jeho vyvolání)
     *  
     *  @ return nazev prikazu
     */
    public String getNazev() {
        return NAZEV;
     }

}
    //== Soukromé metody (instancí i třídy) ========================================

