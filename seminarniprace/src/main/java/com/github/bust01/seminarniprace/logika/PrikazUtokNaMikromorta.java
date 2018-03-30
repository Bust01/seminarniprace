package logika;

/*******************************************************************************
 * Instance třídy PrikazUtokNaMikromorta představují ...
 *
 * @author    Tomáš Bušek
 * @version   1.0
 */
public class PrikazUtokNaMikromorta implements IPrikaz
{
     private static final String NAZEV = "utok_na_mikromorta";
    private HerniPlan plan;
    private Batoh batoh;

    /***************************************************************************
     *  Konstruktor ....
     */
    public PrikazUtokNaMikromorta(HerniPlan plan, Batoh batoh)
    {
         this.plan = plan;
        this.batoh = batoh;
    }

    /**
     * Vykonává příkaz "utok_na_Mikromorta". Nejdřív se ověří, že je hráč v místnosti,
     * kde má smysl útočit na Mikromorta. 
     * Dále se testuje obsah batohu, hledanými věcmi jsou lektvar_síly a jed_pavouků.
     * Na základě obsahu obou/jedné/žádné věci z těchto dvou věcí v batohu se určí výhra nebo prohra.
     * 
     *@return fraze, která se vypíše hráči.
     */ 
    @Override
    public String provedPrikaz(String... parametry){  
          Prostor aktualniProstor = plan.getAktualniProstor();
 if (aktualniProstor.getNazev().equals("Vencovskeho_komnaty")) {
          Prisera Mikromort = aktualniProstor.najdiPriseru("Mikromort");
          if ((batoh.nazvyVeci().contains("jed_pavouků")&& batoh.nazvyVeci().contains("lektvar_síly")&& Mikromort.jeZivy()) || (batoh.nazvyVeci().contains("jed_pavouků")&& !batoh.nazvyVeci().contains("lektvar_síly")&& Mikromort.jeZivy()))
        {
        Mikromort.jeMrtvy();
        batoh.vyhodVec("jed_pavouků");
        aktualniProstor.vratSousedniProstor("slepá_místnost").setViditelny(true);
        aktualniProstor.vratSousedniProstor("zkušebna").setViditelny(true);
        return "Jed pavouků usmrtil Mikromorta";
    }
        else if (batoh.nazvyVeci().contains("lektvar_síly") && !batoh.nazvyVeci().contains("jed_pavouků") && Mikromort.jeZivy())
        {
        Mikromort.jeMrtvy();
        aktualniProstor.vratSousedniProstor("slepá_místnost").setViditelny(true);
        aktualniProstor.vratSousedniProstor("zkušebna").setViditelny(true);
        return "Musel jsi použít lektvar síly na usmrcení Mikromorta. Tvá šance na zabití Makromorta klesla na polovinu.";
    }
     else if (Mikromort.jeZivy() && !batoh.nazvyVeci().contains("lektvar_síly") && !batoh.nazvyVeci().contains("jed_pavouků"))
      {
        plan.setProhra(true);
        return "Bez lektvaru nebo jedu pavouků není možné Mikromorta porazit.";
      }
    if (Mikromort.jeMrtvy()) 
       {
            return "Mikromort byl již zahuben";
        }
      
    }
    return "Zde se nenachází Mikromort";
}

/**
     *  Metoda vrací název příkazu (slovo které používá hráč pro jeho vyvolání)
     *  
     *  @ return nazev prikazu
     */
    @Override
    public String getNazev() {
        return NAZEV;
    }  
}