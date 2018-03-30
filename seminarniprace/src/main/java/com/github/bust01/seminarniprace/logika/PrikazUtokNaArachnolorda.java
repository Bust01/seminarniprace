package com.github.bust01.seminarniprace.logika;

/*******************************************************************************
 * Instance třídy PrikazUtokNaArachnolorda představují ...
 *
 * @author    Tomáš Bušek
 * @version   1.0
 */
public class PrikazUtokNaArachnolorda implements IPrikaz
{
    private static final String NAZEV = "utok_na_arachnolorda";
    private HerniPlan plan;
    private Batoh batoh;

    /***************************************************************************
     *  Konstruktor ....
     */
    public PrikazUtokNaArachnolorda(HerniPlan plan, Batoh batoh)
    {
        this.plan = plan;
        this.batoh = batoh;
    }

     /**
     * Vykonává příkaz "utok_na_arachnolorda". Nejdřív se ověří, že je hráč v místnosti,
     * kde má smysl útočit na Arachnolorda.
     * Dále se testuje obsah batohu, hledanou věcí je voda a testuje se, zda je Arachnolord živý či mrtvý.
     * Na základě výsledků se určí výhra či prohra.
     * 
     *@return fraze, která se vypíše hráči.
     */ 
    public String provedPrikaz(String... parametry){   
        Prostor aktualniProstor = plan.getAktualniProstor();
        if (aktualniProstor.getNazev().equals("pavoučí_hnízdo")) {
        Prisera Arachnolord = aktualniProstor.najdiPriseru("Arachnolord");
        if(batoh.nazvyVeci().contains("voda") && Arachnolord.jeZivy()){
                Arachnolord.jeMrtvy();
                batoh.vyhodVec("voda");
                batoh.vlozVec(new Vec("jed_pavouků",true));
                return "Arachnolord zemřel díky vodě z Likešovy studny! Obdržel jsi jed pavouků."; 
            }
            else if (Arachnolord.jeZivy() && !batoh.nazvyVeci().contains("voda"))
            {
               plan.setProhra(true);
                return "Bez vody pavouka nezabiješ. Řekni Brumbdibálovi o přečtení vzkazu nalézajícího se v Harryho místnosti.";
           }
        if (Arachnolord.jeMrtvy())
            {
                return "Arachnolord byl již zahuben";
            }      
     }
     return "Zde se nenachází Arachnolord";
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
 
