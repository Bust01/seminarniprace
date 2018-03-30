package logika;

/*******************************************************************************
 * Instance třídy PrikazMluv představují ...
 *
 * @author    Tomáš Bušek
 * @version   1.0
 */
public class PrikazMluv implements IPrikaz
{
    private static final String NAZEV = "mluv";
    private HerniPlan plan;
    
    /**
     *  Konstruktor třídy
     */    
    public PrikazMluv(HerniPlan plan) {
        this.plan = plan;
    }
    
    /**
     *Metoda vykonávající příkaz "mluv". Zkouší se hovořit se zadanou postavou. 
     *@param parametr - jmeno postavy, se kterou se má hovořit
     *@return proslov postavy, který se vypíše hráči
     */ 
    @Override
    public String provedPrikaz(String... parametry) { 
        if (parametry.length == 0) {
            return "S kým mám hovořit?";
        }
        String jmeno = parametry[0];
        Prostor aktProst = plan.getAktualniProstor();
        Postava postava = aktProst.najdiPostavu(jmeno);
        if (postava == null) {
            return "Ten tu není!";
        }
        else
        {
       return postava.getVeta();
    }
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
