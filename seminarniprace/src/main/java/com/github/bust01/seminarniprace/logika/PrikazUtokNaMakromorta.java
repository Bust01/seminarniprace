package com.github.bust01.seminarniprace.logika;

/*******************************************************************************
 * Instance třídy PrikazUtokNaMakromorta představují ...
 *
 * @author    Tomáš Bušek
 * @version   1.0
 */
public class PrikazUtokNaMakromorta implements IPrikaz
{
     private static final String NAZEV = "utok_na_makromorta";
    private HerniPlan plan;
    private Batoh batoh;

    /***************************************************************************
     *  Konstruktor ....
     */
    public PrikazUtokNaMakromorta(HerniPlan plan, Batoh batoh)
    {
        this.plan = plan;
        this.batoh = plan.getBatoh();
    }

    /**
     * Vykonává příkaz "utok_na_Makromorta". Nejdřív se ověří, že je hráč v místnosti,
     * kde má smysl útočit na Makromorta. 
     * Dále se testuje obsah batohu, hledanými věcmi jsou lektvar_odolnosti a lektvar_síly.
     * Na základě obsahu obou/jedné/žádné z těchto dvou věcí se určí výhra nebo prohra.
     * 
     *@return fraze, která se vypíše hráči.
     */ 
    public String provedPrikaz(String... parametry){   
  Prostor aktualniProstor = plan.getAktualniProstor();
  if (aktualniProstor.getNazev().equals("zkušebna")) {       
    Prisera Makromort = aktualniProstor.najdiPriseru("Makromort");
     if (batoh.nazvyVeci().contains("lektvar_síly") && batoh.nazvyVeci().contains("lektvar_odolnosti") && Makromort.jeZivy())
        {
        batoh.vyhodVec("lektvar_síly");
        batoh.vyhodVec("lektvar_odolnosti");
        batoh.vlozVec(new Vec("bakalářský_diplom",true));
        Makromort.jeMrtvy();
        aktualniProstor.vratSousedniProstor("svatyně_kamene").setViditelny(true);
        return "Porazil jsi mocného Makromorta, ze kterého vypadl bakalářský diplom. Postup do poslední místnosti a najdi kámen Vysoké školy ekonomické.";
       }
      else if ((batoh.nazvyVeci().contains("lektvar_síly") && !batoh.nazvyVeci().contains("lektvar_odolnosti") && Makromort.jeZivy()) || 
       (!batoh.nazvyVeci().contains("lektvar_síly") && batoh.nazvyVeci().contains("lektvar_odolnosti") && Makromort.jeZivy()))
         { 
         java.util.Random generator = new java.util.Random();
         int losovani = generator.nextInt(2)+1;
         if (losovani == 1) {     
                    if(batoh.nazvyVeci().contains("lektvar_odolnosti")){
                    batoh.vyhodVec("lektvar_odolnosti");
                }
                else
                {
                    batoh.vyhodVec("lektvar_síly");
                }
                    Makromort.jeMrtvy();
                    aktualniProstor.vratSousedniProstor("svatyně_kamene").setViditelny(true);
                    batoh.vlozVec(new Vec("bakalářský_diplom",true));
                    return "Dokázal jsi zabít Makromorta i s jedním lektvarem a získal jsi z něj bakalářský diplom. Postup do poslední místnosti a najdi kámen Vysoké školy ekonomické.";
                }
         if (losovani == 2) {
                    plan.setProhra(true);
                    return "Makromort tě dostal. Jeden lektvar ti proti tomuto mocnému nepříteli bohužel nestačil";
                }  
      
     }
     else if (!batoh.nazvyVeci().contains("lektvar_síly") && !batoh.nazvyVeci().contains("lektvar_odolnosti") && Makromort.jeZivy())
      {
      plan.setProhra(true);
       return "Bez lektvarů nemůžeš vyhrát. Makromort tě rozmáčkl během pár vteřin.";
      }
        }
        return "Zde se nenachází Makromort";
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
