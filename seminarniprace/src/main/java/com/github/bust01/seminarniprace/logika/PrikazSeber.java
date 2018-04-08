package com.github.bust01.seminarniprace.logika;

/*******************************************************************************
 * Instance třídy PrikazSeber představují ...
 *
 * @author    Tomáš Bušek
 * @version   1.0
 */

public class PrikazSeber implements IPrikaz{
    private static final String NAZEV = "seber";
    private HerniPlan plan;
    private Batoh batoh;

    /**
     *  Konstruktor třídy
     */    
    public PrikazSeber (HerniPlan plan, Batoh batoh) {
        this.plan = plan;
        this.batoh = plan.getBatoh();
    }

    /**
     *  Vykonává příkaz "seber". Zkouší sebrat zadaný předmět. Pokud není
     *  zadán název předmětu, vypíše se chybové hlášení. Pokud je předmět
     *  nepřenositelný, vypíše se chybové hlášení. Jinak se předmět uloží do batohu. To však
     *  pouze v případě, že je v batohu místo, jinak se opět vypíše chybové hlášení.
     *  
     *@param parametr - nazev veci ,kterou chceme sebrat
     *@return zpráva, ktorá se vypíše hráčovi
     */ 
 
      public String provedPrikaz(String... parametry) {
     if (parametry.length == 0) {

            return "Co mám sebrat? Musíš zadat název věci.";
        }
        String nazev = parametry[0];   
        Prostor aktualniProstor = plan.getAktualniProstor();
        if (aktualniProstor.obsahujeVec(nazev)){
            Vec pomocna = aktualniProstor.vyber(nazev);
             if (pomocna == null)
                 {  
                return "Tohle nelze sebrat.";
              } else {
              if(batoh.vlozVec(pomocna) && pomocna.jePrenositelna()) {                    
                    aktualniProstor.odeberVec(parametry[0]);
                    return "Věc kterou jsi sebral se nazývá: "+ pomocna.getNazev() + " Byla uložena do batohu a je připravena k použití."; 
                }            
                else {
                    aktualniProstor.vlozVec(pomocna);                                   
                    return "Máš plný batoh. Musíš ho vyprázdnit.";
                }
            }
            }
        
        else {
            return "Tohle neznám";
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



