package com.github.bust01.seminarniprace.logika;

/**
 *  Třída Hra - třída představující logiku adventury.
 * 
 *  Toto je hlavní třída  logiky aplikace.  Tato třída vytváří instanci třídy HerniPlan, která inicializuje mistnosti hry
 *  a vytváří seznam platných příkazů a instance tříd provádějící jednotlivé příkazy.
 *  Vypisuje uvítací a ukončovací text hry.
 *  Také vyhodnocuje jednotlivé příkazy zadané uživatelem.
 *
 *@author     Tomáš Bušek
 *@version    1.0
 */

public class Hra implements IHra {
    private SeznamPrikazu platnePrikazy;  
    private HerniPlan plan;
    private Batoh batoh;
    private boolean konecHry = false;

    /**
     *  Vytváří hru a inicializuje místnosti (prostřednictvím třídy HerniPlan) a seznam platných příkazů.
     */
    public Hra() {
        plan = new HerniPlan();
        platnePrikazy = new SeznamPrikazu();
        Batoh batoh = new Batoh();
        platnePrikazy.vlozPrikaz(new PrikazNapoveda(platnePrikazy));
        platnePrikazy.vlozPrikaz(new PrikazJdi(plan));
        platnePrikazy.vlozPrikaz(new PrikazKonec(this));
        platnePrikazy.vlozPrikaz(new PrikazMluv(plan));
        platnePrikazy.vlozPrikaz(new PrikazProhledej(plan));
        platnePrikazy.vlozPrikaz(new PrikazSeber(plan, batoh));
        platnePrikazy.vlozPrikaz(new PrikazOdemkni(plan, batoh));
        platnePrikazy.vlozPrikaz(new PrikazUkazBatoh(plan, batoh));
        platnePrikazy.vlozPrikaz(new PrikazUtokNaMakromorta(plan, batoh));
        platnePrikazy.vlozPrikaz(new PrikazUtokNaArachnolorda(plan, batoh));
        platnePrikazy.vlozPrikaz(new PrikazUtokNaMikromorta(plan, batoh));
        platnePrikazy.vlozPrikaz(new PrikazVyhod(plan, batoh));
        platnePrikazy.vlozPrikaz(new PrikazDaruj(plan, batoh));
    }
    
    /**
     *  Vrátí úvodní zprávu pro hráče.
     */
    public String vratUvitani() {
        return "Vítejte!\n" +
               "V Žižkovicích, ve světě čar a ekonomie, vládne chaos.\n" +
               "Mocný nepřítel Makromort ukradl svatý kámen, díky kterému může získat nadvládu nad celou školou a způsobit neúspěch všech studentů v nadcházejícím zkouškovém období.\n" +
               "Kámen Vysoké školy ekonomické, jak se onomu artefaktu říká, drží uvnitř zkušebny, do které se nyní neodváží nikdo vstoupit\n" +
               "Úspěch všech tvých spolužáků, včetně tebe, leží na tvých bedrech.\n" +
               "Dokážeš sebrat odvahu a postavit se Makromortovi?\n" +
               "\n" +
               plan.getAktualniProstor().dlouhyPopis();
    }
    
    /**
     *  Vrátí závěrečnou zprávu pro hráče.
     */
    public String vratEpilog() {
        return "Dík, že jste si zahráli.  Ahoj.";
    }
    
    /** 
     * Vrací true, pokud hra skončila.
     */
     public boolean konecHry() {
        return konecHry;
    }

    /**
     *  Metoda zpracuje řetězec uvedený jako parametr, rozdělí ho na slovo příkazu a další parametry.
     *  Pak otestuje zda příkaz je klíčovým slovem  např. jdi.
     *  Pokud ano spustí samotné provádění příkazu.
     *
     *@param  radek  text, který zadal uživatel jako příkaz do hry.
     *@return          vrací se řetězec, který se má vypsat na obrazovku
     */
     public String zpracujPrikaz(String radek) {
        String [] slova = radek.split("[ \t]+");
        String slovoPrikazu = slova[0];
        String []parametry = new String[slova.length-1];
        for(int i=0 ;i<parametry.length;i++){
            parametry[i]= slova[i+1];   
        }
        String textKVypsani=" .... ";
        if (platnePrikazy.jePlatnyPrikaz(slovoPrikazu)) {
            IPrikaz prikaz = platnePrikazy.vratPrikaz(slovoPrikazu);
            textKVypsani = prikaz.provedPrikaz(parametry);
        }
        else {
            textKVypsani="Nevím co tím myslíš? Tento příkaz neznám. ";
        }
        if (plan.dosazeniVitezneMistnosti()){
            konecHry = true;
            textKVypsani = "Nalezl jsi kámen Vysoké školy ekonomické! Gratuluji, zachránil jsi celou školu.";
        }
         if (plan.jeProhra()){
             konecHry = true;
            textKVypsani = "Byl jsi poražen, zkus to znovu.";    
        }
        
        return textKVypsani;
    }
    
    
     /**
     *  Nastaví, že je konec hry, metodu využívá třída PrikazKonec,
     *  mohou ji použít i další implementace rozhraní Prikaz.
     *  
     *  @param  konecHry  hodnota false= konec hry, true = hra pokračuje
     */
    void setKonecHry(boolean konecHry) {
        this.konecHry = konecHry;
    }
    
     /**
     *  Metoda vrátí odkaz na herní plán, je využita hlavně v testech,
     *  kde se jejím prostřednictvím získává aktualní místnost hry.
     *  
     *  @return     odkaz na herní plán
     */
     public HerniPlan getHerniPlan(){
        return plan;
     }
    
     /**
      * Metoda vrátí odkaz na batoh. 
      */
     public Batoh getBatoh(){
        return batoh;
     }
    
}


