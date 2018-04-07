package com.github.bust01.seminarniprace.logika;

import java.util.*;

/**
 * Trida Prostor - popisuje jednotlivé prostory (místnosti) hry
 *
 * Tato třída je součástí jednoduché textové hry.
 *
 * "Prostor" reprezentuje jedno místo (místnost, prostor, ..) ve scénáři hry.
 * Prostor může mít sousední prostory připojené přes východy. Pro každý východ
 * si prostor ukládá odkaz na sousedící prostor.
 *
 * @author Tomáš Bušek
 * @version 1.0
 */
public class Prostor {
    private String nazev;
    private String popis;
    private Set<Prostor> vychody;
    private Set<Vec> veci;
    private Set<Postava> postavy;
    private Set<Prisera> prisery;
    private Vec klic;
    private boolean jeZamknuty = false;
    public boolean isViditelny = true;
    private Map<String, Vec> vycetVeci;
    private Map<String, Postava> vycetPostav;
    private Map<String, Prisera> vycetPriser;
    
    /**
     * Vytvoření prostoru se zadaným popisem, např. "Harryho_místnost", "rajský_dvůr", "schodiště"
     *
     * @param nazev nazev prostoru, jednoznačný identifikátor, jedno slovo nebo
     * víceslovný název bez mezer.
     * @param popis Popis prostoru.
     */
    public Prostor(String nazev, String popis) {
        this.nazev = nazev;
        this.popis = popis;
        vychody = new HashSet<Prostor>();     
        veci = new HashSet<Vec>();
        postavy = new HashSet<Postava>();     
        prisery = new HashSet<Prisera>();
        this.jeZamknuty = jeZamknuty;
        this.isViditelny = isViditelny;
        vycetVeci = new HashMap<String, Vec>();
        vycetPostav = new HashMap<String, Postava>();
        vycetPriser = new HashMap<String, Prisera>();
    }

    /**
     * Definuje východ z prostoru (sousední/vedlejsi prostor). Vzhledem k tomu,
     * že je použit Set pro uložení východů, může být sousední prostor uveden
     * pouze jednou (tj. nelze mít dvoje dveře do stejné sousední místnosti).
     * Druhé zadání stejného prostoru tiše přepíše předchozí zadání (neobjeví se
     * žádné chybové hlášení). Lze zadat též cestu ze do sebe sama.
     *
     * @param vedlejsi prostor, který sousedi s aktualnim prostorem.
     *
     */
    public void setVychod(Prostor vedlejsi) {
        vychody.add(vedlejsi);
    }

    /**
     * Metoda equals pro porovnání dvou prostorů. Překrývá se metoda equals ze
     * třídy Object. Dva prostory jsou shodné, pokud mají stejný název. Tato
     * metoda je důležitá z hlediska správného fungování seznamu východů (Set).
     *
     * Bližší popis metody equals je u třídy Object.
     *
     * @param o object, který se má porovnávat s aktuálním
     * @return hodnotu true, pokud má zadaný prostor stejný název, jinak false
     */  
      @Override
    public boolean equals(Object o) {
        // porovnáváme zda se nejedná o dva odkazy na stejnou instanci
        if (this == o) {
            return true;
        }
        // porovnáváme jakého typu je parametr 
        if (!(o instanceof Prostor)) {
            return false;    // pokud parametr není typu Prostor, vrátíme false
        }
        // přetypujeme parametr na typ Prostor 
        Prostor druhy = (Prostor) o;

        //metoda equals třídy java.util.Objects porovná hodnoty obou názvů. 
        //Vrátí true pro stejné názvy a i v případě, že jsou oba názvy null,
        //jinak vrátí false.

       return (java.util.Objects.equals(this.nazev, druhy.nazev));       
    }

    /**
     * metoda hashCode vraci ciselny identifikator instance, ktery se pouziva
     * pro optimalizaci ukladani v dynamickych datovych strukturach. Pri
     * prekryti metody equals je potreba prekryt i metodu hashCode. Podrobny
     * popis pravidel pro vytvareni metody hashCode je u metody hashCode ve
     * tride Object
     */
    @Override
    public int hashCode() {
        int vysledek = 3;
        int hashNazvu = java.util.Objects.hashCode(this.nazev);
        vysledek = 37 * vysledek + hashNazvu;
        return vysledek;
    }
      

    /**
     * Vrací název prostoru (byl zadán při vytváření prostoru jako parametr
     * konstruktoru)
     *
     * @return název prostoru
     */
    public String getNazev() {
        return nazev;       
    }

    /**
     * Vrací "dlouhý" popis prostoru, který může vypadat následovně: Jsi v
     * mistnosti/prostoru schodiště budovy VSE na Jiznim meste. vychody:
     * rektorát_profesora_Snapa Harryho_místnost rajský_dvůr
     *
     * @return Dlouhý popis prostoru
     */
    public String dlouhyPopis() {
        return "Jsi v mistnosti/prostoru :" + popis + ".\n"
                + popisVychodu()
                + getVycetVeci() + "\n"
                + getVycetPostav() + "\n"
                + getVycetPriser();
    }

    /**
     * Vrací textový řetězec, který popisuje sousední východy, například:
     * "vychody: schodiště ".
     *
     * @return Popis východů - názvů sousedních prostorů
     */
    private String popisVychodu() {
        String vracenyText = "východy:";
        for (Prostor sousedni : vychody) {
            vracenyText += " " + sousedni.getNazev();
            if (sousedni.jeZamknuty()) {
                vracenyText += "(zamknuté)";
            }
            if (!sousedni.isViditelny()) {
                 vracenyText += "(neviditelné)";
            }
        }
        vracenyText += "\n";
        return vracenyText;
    }

     /**
     * Vrací textový řetězec, který popisuje přítomné věci, například:
     * "věci: vzkaz ".
     *
     * @return Popis veci
     */
        private String popisVeci() {
        String vracenyText = "Věci:";
        for (Vec predmet : veci) {
           vracenyText += " " + predmet.getNazev();
    }
    vracenyText += "\n";
    return vracenyText;  
    }
        
        private String popisPostav() {
            String vracenyText = "Postavy:";
            for (Postava clovek : postavy) {
               vracenyText += " " + clovek.getJmeno();
        }
        vracenyText += "\n";
        return vracenyText;  
        }

     /**
     * Vrací prostor, který sousedí s aktuálním prostorem a jehož název je zadán
     * jako parametr. Pokud prostor s udaným jménem nesousedí s aktuálním prostorem,
     * vrací se hodnota null.
     *
     * @param  nazevSouseda  Jméno sousedního prostoru (východu).
     * @return            Prostor, který se nachází za příslušným východem, nebo
     *                   hodnota null, pokud prostor zadaného jména není sousedem.
     */
    public Prostor vratSousedniProstor(String nazevSouseda) {
        if (nazevSouseda == null) {
            return null;
        }
        for ( Prostor sousedni : vychody ){
            if (sousedni.getNazev().equals(nazevSouseda)) {
                return sousedni;
            }
        }
        return null; 
    }

    /**
     * Vrací kolekci obsahující prostory, se kterými tento prostor sousedí.
     * Takto získaný seznam sousedních prostor nelze upravovat (přidávat,
     * odebírat východy) protože z hlediska správného návrhu je to plně
     * záležitostí třídy Prostor.
     *
     * @return Nemodifikovatelná kolekce prostorů (východů), se kterými tento
     * prostor sousedí.
     */
    public Collection<Prostor> getVychody() {
        return Collections.unmodifiableCollection(vychody);
    }
    
    public Collection<Vec> getSeznamVeci()
    {
    	List<Vec> list = new ArrayList<Vec>(vycetVeci.values());
    	return list;
    }
    
    public Collection<Postava> getSeznamPostav() {    	
        return Collections.unmodifiableCollection(postavy);
    }
    
    public Collection<Prisera> getSeznamPriser()  {
    	List<Prisera> listt = new ArrayList<Prisera>(vycetPriser.values());
    	return listt;
    }
    
 
     /**
     * Zjistí, zda se daná věc nachází v prostoru.
     * 
     * @return vrátí true, pokud je věc v daném prostoru.
     */
       public boolean obsahujeVec(String jmeno) {         
        for (String nazev : vycetVeci.keySet()){
            if (nazev.equals(jmeno)) {
                return true;
            }             
             if ( (vycetVeci.get(nazev)).obsahujeVec(jmeno)) {
                return true;
            }
            
        }     
        return false; 
    }
    
    /**
     * Metoda vloží věc do prostoru.
     */ 
    public void vlozVec(Vec vec){
        vycetVeci.put(vec.getNazev(),vec);
        veci.add(vec);
    }
    
    /**
     * Metoda najde věci v prostoru.
     * 
     * @return vrátí nalezenou věc v prostoru.
     */
    public Vec najdiVecVProstoru(String nazev) {
        return vycetVeci.get(nazev);
    }  
    
     public boolean jeVecVProstoru(String nazev) {
        return vycetVeci.containsKey(nazev);
    }

    /**
     * Metoda vrací výčet věcí, které sa nachází v daném prostoru.
     * 
     * @return   výčet věcí.
     */
    public String getVycetVeci() {
        String nazvy = "V této místnosti se nachází tyto věci: ";
        for (String nazevVeci : vycetVeci.keySet()){
            nazvy += nazevVeci + ", ";
        }
        return nazvy;
    }

    /**
     * Metoda vrací výčet postav, které sa nachází v daném prostoru.
     * 
     * return   výčet postav.
     */
    public String getVycetPostav() {
        String nazvy = "V místnosti se nachází tyto postavy: ";
        for (String jmenoPostavy : vycetPostav.keySet()){
            nazvy += jmenoPostavy + ", ";
        }
        return nazvy;
    }
    
    /**
     * Metoda vrací výčet příšer, které sa nachází v daném prostoru.
     * 
     * return   výčet příšer.
     */
    public String getVycetPriser() {
        String nazvy = "V místnosti se nachází tyto prisery: ";
        for (String jmenoPrisery : vycetPriser.keySet()){
            nazvy += jmenoPrisery + ", ";
        }
        return nazvy;
    }

     /**
     * Metoda vybírá věc z prostoru.
     * 
     * @return vrací vybranou věc.
     */
   public Vec vyber (String jmeno) {
        Vec coChceme = null;
        for (String nazev : vycetVeci.keySet()){
            if (nazev.equals(jmeno)&& vycetVeci.get(nazev).jePrenositelna() ) {
                coChceme = vycetVeci.get(nazev);
                break;
            }
            Vec neco = vycetVeci.get(nazev);
            if ( neco.obsahujeVec(jmeno)) {
                coChceme = neco.vyberVec(jmeno);
                break;
            }
        }
        if (vycetVeci.containsKey(jmeno)){
            vycetVeci.remove(coChceme);
        }
        return coChceme;  

    }
    
    /**
     * Pomocí této metody zjistíme, zda je daný prostor zamknutý.
     * 
     * @return hodnota true jestliže je prostor zamknutý a false jestliže je odemknutý.
     */
    public boolean jeZamknuty() {
        return jeZamknuty;
    }

    /**
     * Metoda zamkne nebo odemkne prostor.
     */
    public void setZamknuty(boolean stav) {
        this.jeZamknuty = stav;
    }

    /**
     * Metoda přiřazující klíč potřebný k odemknutí daného prostoru.
     */
    public void nastavKlic(Vec klic) {
        this.klic = klic;
    }

    /**
     * Metoda vráti klíč.
     */
    public Vec getKlic() {
        return klic;
    }
    
     /**
     * Metoda vloží postavu do prostoru.
     */
    public void vlozPostavu(Postava postava)
    {
        vycetPostav.put(postava.getJmeno(), postava);
        postavy.add(postava);
    }
    
    /**
     * Metoda najde postavu.
     */
    public Postava najdiPostavu(String jmeno)
    {
        return vycetPostav.get(jmeno);
    }

      /**
     * Metoda vloží příšeru do prostoru.
     */
    public void vlozPriseru(Prisera prisera)
    {
        vycetPriser.put(prisera.getJmeno(), prisera);
        prisery.add(prisera);
    }
    
    /**
     * Metoda najde příšeru.
     */
    public Prisera najdiPriseru(String jmeno)
    {
        return vycetPriser.get(jmeno);
    }    
    
     /**
     * Metoda pro zjištění viditelnosti prostoru.
     * 
     * @return hodnota true pro viditelný, false pro neviditelný.
     */

    public boolean isViditelny() {
        return isViditelny;
    }
    
    /**
     * Metoda nastaví viditelnost prostoru.
     */

    public void setViditelny(boolean stav) {
        this.isViditelny = stav;
    }
    
     /**
     * Metoda odebere věc z prostoru.
     */
    public Vec odeberVec(String nazev) {
        return vycetVeci.remove(nazev); 
    }
    
    @Override
    public String toString() 
    {
    	return nazev;
    }
}
   