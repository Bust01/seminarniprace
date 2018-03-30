package logika;

/*******************************************************************************
 * Instance třídy PrikazOdemkni představují ...
 *
 * @author    Tomáš Bušek
 * @version   1.0
 */
public class PrikazOdemkni implements IPrikaz
{
    private static final String NAZEV = "odemkni";
    private HerniPlan plan;
    private Batoh batoh;

    /**
     * Konstruktor tridy PrikazOdemkni
     */
    public PrikazOdemkni(HerniPlan plan, Batoh batoh){  
        this.plan = plan;
        this.batoh = batoh;
    }


    /**
     * Metoda vykonávající odemčení prostoru po příkazu "odemkni" a vrací hlášení že se
     * podařilo dveře odemknout, pokud se nachází vedle aktuálního prostoru a máme v
     * batohu klíč potřebný k odemknutí
     * 
     * @param parametry - mistnost, do ktere muzeme jit
     * 
     * @return zpráva vypsaná pro hráče
     */
    @Override
    public String provedPrikaz(String... parametry) {
        if (parametry.length == 0) {
            return "Co mám odemknout?";
        }

        String prostor= parametry[0];
        Prostor vratSousedniProstor = plan.getAktualniProstor().vratSousedniProstor(prostor);

        if (vratSousedniProstor == null) {
            return "Odsud se nedostaneš do "+prostor;
        }
        else {
            if (vratSousedniProstor.jeZamknuty()) {
                if (batoh.obsahujeVec(vratSousedniProstor.getKlic().getNazev())) {
                    vratSousedniProstor.setZamknuty(false);
                    batoh.vyhodVec(vratSousedniProstor.getKlic().getNazev());
                    return "Cesta je volná do " + prostor +"." ;

                }
                else {
                    return "Potřebuješ správný klíč!";
                }
            }
            else {
                return "Prostor "+prostor+" už je odemknutý.";
            }
        }
    }

    /**
     *  Metoda vrací název příkazu (slovo které používá hráč pro jeho vyvolání)
     *  
     *  @ return název příkazu
     */
    @Override
    public String getNazev() {
        return NAZEV;
    }
}
