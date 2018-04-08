package com.github.bust01.seminarniprace.logika;

/*******************************************************************************
 * Instance třídy PrikazVyhod implementuje pro naší jednoduchou textovou hru příkaz vyhoď.
 *
 * @author    Tomáš Bušek
 * @version   1.0
 */
public class PrikazVyhod implements IPrikaz  {

    private static final String NAZEV ="vyhod";
    private HerniPlan plan;
    private Batoh batoh;

    /**
     *  Konstruktor třídy
     */    
    public PrikazVyhod(HerniPlan plan, Batoh batoh)
    {
        this.plan = plan;
        this.batoh = plan.getBatoh();
    }


    /**
     *  Vykonává příkaz "vyhod". Zkouší se vyhodit zadaný předmět ven z batohu. Jestliže
     *  je požadovaný předmět uvnitř batohu tak se vloží do aktuální místnosti. Pokud však
     *  požadovaný předmět batoh neobsahuje, vypíše se chybové hlášení.
     *
     *@param parametr - jmeno veci, kterou požadujeme vyhodit
     *@return zpráva, která se vypíše hráči
     */     
    public String provedPrikaz(String... parametry) {
        if (parametry.length == 0) {
         return "Co mám vyhodit? Zadej prosím jméno věci.";
        }
        String nazev = parametry[0];
        Vec vec = batoh.vyhodVec(nazev);
        if (vec == null) {
         return "Tuto věc ve svém batohu nemáš!";
        }
        else {  
         plan.getAktualniProstor().vlozVec(vec);
         return "Vyhodil jsi " + nazev;
        }
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