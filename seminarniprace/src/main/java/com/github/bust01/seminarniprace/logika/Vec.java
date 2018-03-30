package logika;
import java.util.*;

/*******************************************************************************
 * Třída Vec poskytuje informace o předmětech nacházejících se ve hře.
 *
 * @author    Tomáš Bušek
 * @version   1.0
 */
public class Vec
{
    
    private String nazev;  
    private boolean prenositelnost; 
    private boolean prohledana = false; 
    private Map<String,Vec> vycetVeci;

    /**
     * Konstruktor pro třídu Vec.
     */  
    public Vec(String nazev, boolean prenositelnost)
    {
        this.nazev = nazev;
        this.prenositelnost = prenositelnost;
        this.vycetVeci = new HashMap<String,Vec>();
    }
    
     /**
     * Metoda, která vrací název věci.
     * 
     * @return String název věci.
     */
    public String getNazev()
    {
        return nazev;
    }
    
     /**
     * Metoda, která zjišťuje, zda je věc přenositelná.
     * 
     * @return true v případě, že se věc dá přenést
     */
    public boolean jePrenositelna()
    {
        return prenositelnost;
    }
    
    /**
     * Metoda, která nastavuje, zda je věc přenositelná. 
     */
    public void setPrenositelnost(boolean novaPrenositelnost)
    {
        prenositelnost = novaPrenositelnost;
    }
    
     /**
     * Metoda, která zjišťuje, zda je věc již prozkoumaná.
     *
     * @return vrací true v případě, že je prozkoumaná.
     */
     public boolean jeProhledana() {
        return prohledana;
    }   

    /**
     * Metoda, která nastavuje, zda je věc prozkoumaná. 
     */
    public void prohledano (boolean prohledana) {
        this.prohledana = prohledana;

    }
    
      /** 
     * Metoda, která vkládá věc do jiné věci.
     */
    public void vlozVec (Vec vec) {
        vycetVeci.put(vec.getNazev(), vec);
    }
    
       /**
     * Metoda, která zjišťuje, zda se věc nachází v jiné věci.
     * 
     * @return vrací true, pokud se věc nachází v jiné věci
     */
    public boolean obsahujeVec(String nazev) {
        return prohledana && vycetVeci.containsKey(nazev);
    }
    
    /**
     * Metoda, která při prozkoumání vrací popis dané věci. Pakliže věc obsahuje ještě další věci, tak je vypíše.
     *  
     * @return popis pokud věc neobsahuje jiné věci a pokud obsahuje, tak vypíše seznam věcí.
     */
public String popisProzkoumej() {
        if (vycetVeci.isEmpty()) {
            return "Prozkoumal jsi pořádně "+nazev;
        }

        String popis = "Prozkoumal jsi pořádně "+nazev+" a našel jsi:";
        for (String nazev : vycetVeci.keySet()) {
            popis += " " + nazev;
        }
        return popis;
    }

/**
     * Metoda, která vybere věc z jiné prozkoumané věci.
     * 
     * @return vrací vybranou věc
     */
public Vec vyberVec(String nazev) {
        Vec vec = null;
        if (prohledana && vycetVeci.containsKey(nazev)) {
            vec = vycetVeci.get(nazev);
            if (vec.jePrenositelna()) {
                vycetVeci.remove(nazev);
            }
        }
        return vec;
    }
    
/**
     * Vrací odkaz na seznam věcí, které daná věc obsahuje.
     *  
     * @return výčet věcí
     */
     public String getVycetVeci() {
        String nazvy = " ";
        if(prohledana = true){
        for (String nazev : vycetVeci.keySet()){
        nazvy += nazev + " ";
            }
        }
        return nazvy;
    }
}