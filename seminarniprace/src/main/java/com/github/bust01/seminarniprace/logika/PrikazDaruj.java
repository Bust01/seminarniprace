package com.github.bust01.seminarniprace.logika;

/*******************************************************************************
 * Instance třídy PrikazDej představují ...
 *
 * @author    Tomáš Bušek
 * @version   1.0
 */
public class PrikazDaruj implements IPrikaz
{
    private static final String NAZEV = "daruj";
    private HerniPlan plan;
    private Batoh batoh;
    
    /***************************************************************************
     *  Konstruktor třídy PrikazPouzij
     */
    public PrikazDaruj(HerniPlan plan, Batoh batoh)
    {
        this.plan = plan;
        this.batoh = plan.getBatoh();
        
    }

    /**
     *  Vykonává příkaz "daruj". Můžeme zkoušet darovat různé věci, ale 
     *  v závislosti na okolnostech dostaneme různé výsledky.
     *@param parametry - parametr jméno věci, kterou chceme darovat
     *@return zpráva, která se vypíše hráčovi
     */ 
    public String provedPrikaz(String... parametry){
        if (parametry.length == 0) {
            return "Co mám darovat? Musíš napsat název věci!";  
        }
        Prostor kdeJsme = plan.getAktualniProstor();
        String nazevCoPouzit = parametry[0];
        Vec vec = batoh.getVec(nazevCoPouzit);
        if (vec == null){
            return "Tohle nemáš v batohu.";
        }
        if ( vec.getNazev().equals("kniha") && kdeJsme.getNazev().equals("rajský_dvůr")){
            batoh.vyhodVec("kniha");
            batoh.vlozVec(new Vec("dopis_s_heslem",true));
            return "Hermelina: Jsi báječný! Děkuji ti za tu knihu. Tady máš slibovaný dopis s heslem.";
        }
        
        if ( vec.getNazev().equals("vzkaz_pro_Brumbdibála") && kdeJsme.getNazev().equals("blanická_bouda")){
            batoh.vyhodVec("vzkaz_pro_Brumbdibala");
            return "Brumbdibál: Dva lektvary možnost dají ti, na 100% Makromorta \n" +
            "uzemniti. S jedním to už je jen půlka a co když ti ho Mikromort \n" +
            "zlouská. Mikromortovi jed pavoučí nevoní, uvolní ti cestu bez lektvarového \n" +
            "ubytí. Jed je ovšem pavouky střežen, bez vody budeš na pavučině \n" +
            "vězněn. Bez hesla vchod neotevřeš a bez klíče kámen neodneseš. \n";
        }
        else{

            return "Tohle není dobrá volba.";
        }
        
    }

    /**
     *  Metoda vrací název příkazu (slovo které používá hráč pro jeho vyvolání)
     *  
     *  @ return nazev prikazu
     */

    public String getNazev()
    {
        return NAZEV;
    }

}
