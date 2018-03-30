package logika;

/*******************************************************************************
 * Třída postava nám uchovává informace o použitých postavách ve hře.
 *
 * @author    Tomáš Bušek
 * @version   1.0
 */
public class Postava
{
    private String jmeno;   
    private String veta;   

    /**
     * Konstruktor třídy Postava. Nastavuje postavě její jméno a větu, kterou řekne.
     */
    public Postava(String jmeno, String veta) {
        this.jmeno = jmeno;
        this.veta = veta;
    }

    /**
     * Metoda, která vrátí jméno postavy
     * 
     * @return  String jméno postavy.
     */
    public String getJmeno() {
        return jmeno; 
    }

    /**
     * Metoda vrací větu, kterou postava řekne.
     * 
     * @return  String věta postavy.
     */
    public String getVeta() {
        return veta;
    }

    /**
     * Metoda, která umožňuje nastavit větu.
     */
    public void setVeta(String novaVeta)
    {
        this.veta = novaVeta;
    }
}
   