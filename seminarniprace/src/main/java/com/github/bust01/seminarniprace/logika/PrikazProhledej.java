package logika;

/*******************************************************************************
 * Instance třídy PrikazSeber představují ...
 *
 * @author    Tomáš Bušek
 * @version   1.0
 */
public class PrikazProhledej implements IPrikaz
{
    private static final String NAZEV = "prohledej";
    private HerniPlan plan;
    
    /**
     *  Konstruktor třídy
     *  
     *  @param plan herní plán, ve kterém se budou zkoumat předměty
     */    
    public PrikazProhledej(HerniPlan plan) {
        this.plan = plan;
    }

    /**
     *  Vykonává příkaz "prohledej". Zkouší se prohledat daná věc.
     *  Pokud se předmět dá prohledat, prohledá se.
     *  Jinak vrací zpravu s chybovým hlášením.

     *
     *@param parametry -  parametr obsahuje nazev veci,
     *                        která se ma prozkoumat
     *@return zpráva, která se vypíše hráčovi
     */ 
    @Override
    public String provedPrikaz(String... parametry) {
        if (parametry.length == 0) {
            return "Co mám prohledat? Buď prosímtě přesnější!";
        }

        String pomocna = parametry[0];
        Prostor aktualniProstor = plan.getAktualniProstor();

        if (aktualniProstor.obsahujeVec(pomocna)){
            Vec dalsi = aktualniProstor.najdiVecVProstoru(pomocna);             
            if (dalsi != null) {  
                dalsi.prohledano(true);
                return dalsi.popisProzkoumej();
            }               
        }           
        return "Je mi líto, ale tohle tu není. ";
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
