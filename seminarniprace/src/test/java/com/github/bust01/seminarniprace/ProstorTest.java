package logika;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/*******************************************************************************
 * Testovací třída ProstorTest slouží ke komplexnímu otestování
 * třídy Prostor
 *
 * @author    Tomáš Bušek
 * @version   1.0
 */
public class ProstorTest
{

    /***************************************************************************
     * Metoda se provede před spuštěním každé testovací metody. Používá se
     * k vytvoření tzv. přípravku (fixture), což jsou datové atributy (objekty),
     * s nimiž budou testovací metody pracovat.
     */
    @Before
    public void setUp() {
    }

    /***************************************************************************
     * Úklid po testu - tato metoda se spustí po vykonání každé testovací metody.
     */
    @After
    public void tearDown() {
    }


    /**
     * Testuje, zda jsou správně nastaveny průchody mezi prostory hry.
     */
    @Test
    public  void testLzeProchazet() {		
        Prostor prostor1 = new Prostor("Harryho_mistnost","Místnost, ve které bydlí slavný Harry Lustter");
        Prostor prostor2 = new Prostor("schodiště","Staré kouzelné schodiště");
        prostor1.setVychod(prostor2);
        prostor2.setVychod(prostor1);
        assertEquals(prostor2, prostor1.vratSousedniProstor("schodiště"));
        assertEquals(null, prostor2.vratSousedniProstor("blanická_bouda"));
    }

}
