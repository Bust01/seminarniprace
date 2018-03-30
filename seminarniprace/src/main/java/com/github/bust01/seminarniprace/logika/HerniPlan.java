package com.github.bust01.seminarniprace.logika;

/**
 *  Class HerniPlan - třída představující mapu a stav adventury.
 * 
 *  Tato třída inicializuje prvky ze kterých se hra skládá:
 *  vytváří všechny prostory,
 *  propojuje je vzájemně pomocí východů 
 *  a pamatuje si aktuální prostor, ve kterém se hráč právě nachází.
 *
 *@author     Tomáš Bušek
 *@version    1.0
 */
public class HerniPlan {
    
    private Prostor aktualniProstor;
    private Prostor viteznyProstor;
    private Batoh batoh;
    private Postava postava;
    private HerniPlan plan;
    private boolean prohra = false; 
    private boolean vyhra = false;
     /**
     *  Konstruktor který vytváří jednotlivé prostory a propojuje je pomocí východů.
     *  Jako výchozí aktuální prostor nastaví Harryho místnost.
     */
    public HerniPlan() {
        zalozProstoryHry();
        batoh = new Batoh();
    }
    /**
     *  Vytváří jednotlivé prostory a propojuje je pomocí východů.
     *  Jako výchozí aktuální prostor nastaví Harryho místnost.
     *  Vytváří jednotlivé postavy a přiřazuje jim jména a rozhovory.
     *  Nastavuje postavám i jejich umístění.
     *  Vytváří jednotlivé věci a přiřazuje jim místa.
     *  Nastavuje vítězný prostor, zamčené místnosti a neviditelné místnosti.
     */
    private void zalozProstoryHry() {
        // vytvářejí se jednotlivé prostory
        Prostor HarryhoMistnost = new Prostor("Harryho_mistnost","Místnost, ve které bydlí slavný Harry Lustter");
        Prostor schodiste = new Prostor("schodiště","Staré kouzelné schodiště");
        Prostor rektoratProfesoraSnapa = new Prostor("rektorát_profesora_Snapa", "Rektorát obávaného profesora Snapa. Vyzařuje odtud černá magie");
        Prostor rajskyDvur = new Prostor("rajský_dvůr","Rajský dvůr, který je celý posetý voňavými květinami");
        Prostor blanickaBouda = new Prostor("blanická_bouda","Blanická bouda, kterou obývá Brumbdibál, skrývá spoustu užitečných věcí");
        Prostor jizniLes = new Prostor("jižní_les","Jižní les, který spojuje spoustu lokací. Lze zde nalézt spousta hub");
        Prostor likesovaStudna = new Prostor("Likešova_studna","Likešova studna obsahující zbytkovou vodu");
        Prostor pavouciHnizdo = new Prostor("pavoučí_hnízdo","Pavoučí hnízdo, oblast plná pavouků společně s vůdcem Arachnolordem");
        Prostor staraChalupa = new Prostor("stará_chalupa","Stará chalupa, která na první pohled nenabízí nic zajímavého");
        Prostor VencovskehoKomnaty = new Prostor("Vencovskeho_komnaty","Věncovského komnaty, které chrání Mikromort, slabší bratr Makromorta");
        Prostor slepaMistnost = new Prostor("slepá_místnost","Slepá místnost, která nikam nebvede");
        Prostor zkusebna = new Prostor("zkušebna","Zkušebna, místnost, ve které se nachází hlavní nepřítel Žižkovic");
        Prostor svatyneKamene = new Prostor("svatyně_kamene","Místnost ukrývající mocný kámen Vysoké školy ekonomické");
        Prostor svatyne = new Prostor("svatyně","Závěrečná místnost této hry");

         // přiřazují se průchody mezi prostory (sousedící prostory)
        HarryhoMistnost.setVychod(schodiste);
        schodiste.setVychod(rektoratProfesoraSnapa);
        schodiste.setVychod(rajskyDvur);
        schodiste.setVychod(HarryhoMistnost);
        rektoratProfesoraSnapa.setVychod(schodiste);
        rektoratProfesoraSnapa.setVychod(rajskyDvur);
        rajskyDvur.setVychod(rektoratProfesoraSnapa);
        rajskyDvur.setVychod(schodiste);
        rajskyDvur.setVychod(blanickaBouda);
        rajskyDvur.setVychod(jizniLes);
        blanickaBouda.setVychod(jizniLes);
        blanickaBouda.setVychod(rajskyDvur);
        jizniLes.setVychod(blanickaBouda);
        jizniLes.setVychod(rajskyDvur);
        jizniLes.setVychod(likesovaStudna);
        jizniLes.setVychod(pavouciHnizdo);
        jizniLes.setVychod(staraChalupa);
        likesovaStudna.setVychod(jizniLes);
        pavouciHnizdo.setVychod(jizniLes);
        staraChalupa.setVychod(jizniLes);
        staraChalupa.setVychod(VencovskehoKomnaty);
        VencovskehoKomnaty.setVychod(staraChalupa);
        VencovskehoKomnaty.setVychod(slepaMistnost);
        VencovskehoKomnaty.setVychod(zkusebna);
        slepaMistnost.setVychod(VencovskehoKomnaty);
        zkusebna.setVychod(VencovskehoKomnaty);
        zkusebna.setVychod(svatyneKamene);
        svatyneKamene.setVychod(svatyne);
 
        
        Vec zacatecnickaTruhla = new Vec ("začátečnická_truhla", false);
        zacatecnickaTruhla.vlozVec (new Vec("vzkaz_pro_Brumbdibála", true));
        zacatecnickaTruhla.vlozVec (new Vec("hůlka", true));
        Vec postel = new Vec("postel", false);
        HarryhoMistnost.vlozVec(zacatecnickaTruhla);
        HarryhoMistnost.vlozVec(postel);
        Vec lektvarSily = new Vec("lektvar_síly", true);
        rektoratProfesoraSnapa.vlozVec(lektvarSily);
        Vec dopisSHeslem = new Vec ("dopis_s_heslem", true);
        Vec klic = new Vec("klíč", true);
        Vec jidlo = new Vec("jídlo", true);
        Vec stul = new Vec("stůl", false);
        blanickaBouda.vlozVec(klic);
        blanickaBouda.vlozVec(jidlo);
        blanickaBouda.vlozVec(stul);
        Vec voda = new Vec("voda", true);
        likesovaStudna.vlozVec(voda);
        Vec jedPavouku = new Vec("jed_pavouků", true);
        Vec nuz = new Vec("nůž", true);
        Vec kniha = new Vec("kniha", true);
        staraChalupa.vlozVec(nuz);
        staraChalupa.vlozVec(kniha);
        Vec amulet = new Vec("amulet", true);
        VencovskehoKomnaty.vlozVec(amulet);
        Vec lektvarOdolnosti = new Vec("lektvar_odolnosti", true);
        Vec carodejuvPlast = new Vec("čarodějův_plášť", true);
        slepaMistnost.vlozVec(lektvarOdolnosti);
        slepaMistnost.vlozVec(carodejuvPlast);
        Vec bakalarskyDiplom = new Vec("bakalářský_diplom", true);
        Vec truhlaMakromorta = new Vec("truhla_makromorta", false);
        svatyneKamene.vlozVec(truhlaMakromorta);
        truhlaMakromorta.vlozVec (new Vec("kámen_Vysoké_školy_ekonomické", true));
           
         
        aktualniProstor = HarryhoMistnost;     // hra začíná v domečku     
        viteznyProstor = svatyne;        

        rektoratProfesoraSnapa.vlozPostavu(new Postava("snape","SNAPE: Co tu chceš Harry? . \n" + 
                                                  "JÁ: Vydávám se na cestu za Makromortem, mohu si vzít jeden z tvých lektvarů?. \n" +
                                                  "SNAPE: Ano. Porozhlídni se tu a vyber, který je pro tebe nejlepší. \n" +
                                                  "JÁ: Uvítal bych lektvar síly a nějakou radu, kterou na svých cestách uvítám. \n" +
                                                  "SNAPE: Vím jen jednu pomůcku, která ti může zachránit život. Prohledávej i slepé místnosti Harry, mohou skrývat důležité věci. \n" +
                                                  "JÁ: Děkuji mnohokrát, budu se tím řídit. \n"));
        rajskyDvur.vlozPostavu(new Postava("hermelina","HERMELÍNA: Ahoj Harry, kam tak uháníš?\n" +
                                                            "JÁ: Musím k Brumbdibálovi, prý zná heslo, které mi dovolí projít do Vencovských komnat. \n" +
                                                            "HERMELÍNA: Heslo znám, ale mám ho napsané v knize, kterou jsem nechala ve staré chalupě. \n" +
                                                            "JÁ: Donesu ti jí. Nechci, aby jsi se dostala do nějakých nebezpečí. \n" +
                                                            "HERMELÍNA Děkuji ti, ale pospěš si, mám za chvilku hodinu. \n" +
                                                            "JÁ: Šprtko.\n"));
        blanickaBouda.vlozPostavu(new Postava("brumbdibal", "BRUMBDIBÁL: Už jsem si myslel, že nepřijdeš. \n" +
                                                    "JÁ: Omlouvám se, ale trochu jsem se zdržel při hledání toho vzkazu. \n" +
                                                    "BRUMBDIBÁL: Dobrá, máš už pouhých 6 hodin, musíš co nejdříve vyrazit. Neposílám tě tam rád, ale vím, že ty jsi jediný, kdo to může zastavit. \n" +
                                                    "JÁ: Rád to udělám. Záleží mi na osudu této školy. \n" +
                                                    "BRUMBDIBÁL: To mi těší. Harry, máš pro mě ten vzkaz z tvého pokoje? Má být plný rad pro tvoji cestu. Pokud ano, předej mi ho. \n"));

        pavouciHnizdo.vlozPriseru(new Prisera("Arachnolord"));
        VencovskehoKomnaty.vlozPriseru(new Prisera("Mikromort"));
        zkusebna.vlozPriseru(new Prisera("Makromort")); 
        svatyneKamene.setZamknuty(true);
        svatyneKamene.nastavKlic(klic);
        VencovskehoKomnaty.setZamknuty(true);
        VencovskehoKomnaty.nastavKlic(dopisSHeslem);        
        zkusebna.setViditelny(false);
        svatyneKamene.setViditelny(false);
        slepaMistnost.setViditelny(false);                                       
    }
    
    /**
     *  Metoda vrací odkaz na aktuální prostor, ve ktetém se hráč právě nachází.
     *
     *@return     aktuální prostor
     */  
    public Prostor getAktualniProstor() {
        return aktualniProstor;
    }
    
    /**
     *  Metoda nastaví aktuální prostor, používá se nejčastěji při přechodu mezi prostory
     *
     *@param  prostor nový aktuální prostor
     */
    public void setAktualniProstor(Prostor prostor) {
       aktualniProstor = prostor;
    }
    
     /**
     *  Metoda vrací odkaz na vítěznou místnost.
     * 
     *  @param mistnost - vítězná místnost.
     */
    public void setViteznyProstor(Prostor prostor) {
        viteznyProstor = prostor;
    }
    
     /**
     *  Metoda, která zjišťuje, zda jsem ve vítězném prostoru.
     * 
     *  @return true, pokud jsem ve vítězném prostoru, jinak false.
     */
    public boolean dosazeniVitezneMistnosti() {
        return aktualniProstor.equals(viteznyProstor);
    }
       
    /**
     * Metoda, která vrací batoh.
     */
    public Batoh getBatoh() {
        return batoh;
    }
    
    public boolean isVyhra() {
        return vyhra;
    }
    
    public void setVyhra(boolean stav) {
        this.vyhra = stav;
    }
    
    /**
     * Metoda, která vrací prohru jako false.
     */
    public boolean jeProhra() {
        return prohra;
    }
    
    /**
     * Metoda, která nastavuje, zda bude prohra true či false.
     */
    public void setProhra(boolean skutecnost) {
        this.prohra = skutecnost;
    }      
}
    
