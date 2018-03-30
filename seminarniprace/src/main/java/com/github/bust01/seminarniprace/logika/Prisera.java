package logika;

/*******************************************************************************
 * Instance třídy Prisera představují informace o příšerách
 *
 * @author    Tomáš Bušek
 * @version   1.0
 */
public class Prisera
{
   private String jmeno;   
   private boolean isZivy = true;
    
   /**
     * Konstruktor třídy Prisera. Nastavuje příšeře její jméno.
     */
    public Prisera(String jmeno) {
        this.jmeno = jmeno;
    }

     /**
     * Metoda, která vrátí jméno příšery
     * 
     * @return  String jméno příšery.
     */
    public String getJmeno() {
        return jmeno; 
    }
   
       /**
     * Metoda, která říká, že příšera žije
     * 
     * @return hodnota true
     */
    public boolean jeZivy()
    {
        return isZivy;
    }
    
    /**
     * Metoda, která říká, že příšera je mrtvá
     * 
     * @return hodnota false
     */
    public boolean jeMrtvy()
    {
        return isZivy = false;
    }
}
