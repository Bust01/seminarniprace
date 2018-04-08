package com.github.bust01.seminarniprace.logika;
import java.util.*;

/*******************************************************************************
 * Třída batoh představuje inventář s omezenou kapacitou a umožňuje nám manipulovat s věcmi v batohu.
 *
 * @author    Tomáš Bušek
 * @version   1.0
 */
public class Batoh
{
    public Map<String, Vec> sezVeci;  
    private static final int KapacitaBatohu = 5; 
    private List<Vec> obsahBatohu; 
    
    
    
    /**
     * Konstruktor třídy
     */
    public Batoh() {
        sezVeci = new HashMap <String, Vec> ();
        obsahBatohu = new ArrayList<Vec>();
    }

    /**
     *  Metoda, která najde určitou věc.
     *  
     *  @param  vec  Parametrem je věc, kterou chceme získat.
     */     
    public Vec getVec(String nazev) {
        return sezVeci.get(nazev);
    }
    
    public List<Vec> getSezVeci()  {
    	List<Vec> listtt = new ArrayList<Vec>(sezVeci.values());
    	return listtt;
    }
    
    public List<Vec> getObsahBatohu()
    {
    	return obsahBatohu;
    }
    
    public Map<String, Vec> getMapaBatoh()
    {
    	return sezVeci;
    }
    
    
/**
     * Metoda přidá věc do batohu, pokud v něm je místo.
     * 
     * @param vec věc, která má být do batohu přidána.
     * 
     * return true, pokud dojde k úspěšnému přidání do batohu.
     */
public boolean vlozVec(Vec vec){
        if(jeMisto() && (vec.jePrenositelna())){
            sezVeci.put(vec.getNazev(),vec);
            obsahBatohu.add(vec);
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * Metoda vyhodí věc pryč z batohu.
     * 
     * @param  vec  Parametrem je věc, kterou chceme odebrat z batohu.
     * 
     * return   Vrátí jméno vyhozené věci, pokud dojde k úspěšnému vyhození.
     */   
    public Vec vyhodVec(String nazev){
        Vec vyhozenaVec = null;
        if (sezVeci.containsKey(nazev)) {
            vyhozenaVec = sezVeci.get(nazev);
            sezVeci.remove(nazev);            
            obsahBatohu.remove(vyhozenaVec);
        }
        return vyhozenaVec;  
    } 

    /**
     *  Metoda zjišťuje, zda je daná věc obsažena v batohu.
     *  
     *  @param  vec  Parametrem je věc, o které zjišťujeme, zda se v batohu nachází
     */   
    public boolean obsahujeVec (String nazev) {
        if (this.sezVeci.containsKey(nazev)) {
            return true;
        }
        return false;
    }


    /**
     *  Metoda zjistí obsah batohu. Pokud je prázdný, tak vrací : Batoh je prázdný.
     *  
     *  return seznam věcí obsažených v batohu.
     */   
    public String nazvyVeci() {
        if(sezVeci.isEmpty()) { 
            return "Batoh je prázdný.";
        }
        String nazvy = "V batohu máš: ";
        for (String nazevVeci : sezVeci.keySet()){
            nazvy += nazevVeci + " ";
        }
        return nazvy;
    }
    
     /**
     *  Metoda zjistí, zda se věc vejde do batohu.
     *
     *  return  Vrací true, pokud se věc vejde do batohu.
     */
    public boolean jeMisto() {
        if (sezVeci.size() < KapacitaBatohu) {
            return true;
        }
        return false;
    }
}

