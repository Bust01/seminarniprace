package com.github.bust01.seminarniprace.logika;

/**
 *  Třída PrikazNapoveda implementuje pro hru příkaz napoveda.
 *  Tato třída je součástí jednoduché textové hry.
 *  
 *@author     Tomáš Bušek
 *@version    1.0
 *  
 */
class PrikazNapoveda implements IPrikaz {    
    private static final String NAZEV = "nápověda";
    private SeznamPrikazu platnePrikazy;    
    
     /**
    *  Konstruktor třídy
    *  
    *  @param platnePrikazy seznam příkazů,
    *                       které je možné ve hře použít,
    *                       aby je nápověda mohla zobrazit uživateli. 
    */    
    public PrikazNapoveda(SeznamPrikazu platnePrikazy) {
        this.platnePrikazy = platnePrikazy;
    }
    
    /**
     *  Vrací základní nápovědu po zadání příkazu "napoveda". Nyní se vypisuje
     *  vcelku primitivní zpráva a seznam dostupných příkazů.
     *  
     *  @return napoveda ke hre
     */
    public String provedPrikaz(String... parametry) {
        return "Tvým úkolem je zachránit Žižkovice od bratrů Makromorta a Mikromorta\n"
        + "a nastolit tak klidné zkouškové období.\n"
        + "\n"
        + "Můžeš zadat tyto příkazy:\n"
        + platnePrikazy.vratNazvyPrikazu();
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
