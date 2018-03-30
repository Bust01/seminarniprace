package logika;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/*******************************************************************************
 * Testovací třída VecTest slouží ke komplexnímu otestování třídy Vec 
 *
 * @author    Tomáš Bušek
 * @version   1.0
 */
public class VecTest
{

    /***************************************************************************
     * Inicializace předcházející spuštění každého testu a připravující tzv.
     * přípravek (fixture), což je sada objektů, s nimiž budou testy pracovat.
     */
    @Before
    public void setUp()
    {
    }

    /***************************************************************************
     * Úklid po testu - tato metoda se spustí po vykonání každého testu.
     */
    @After
    public void tearDown()
    {
    }

    /**
     * Metodda, která testuje, zda se ve věci nachází další věc.
     */
    @Test
    public void testObsahujeVec() {
        Vec vec1 = new Vec("vec1",false);
        Vec vec2 = new Vec("vec2",true);
        vec1.vlozVec(vec2);
        vec1.prohledano(true);
        assertEquals(true, vec1.obsahujeVec("vec2"));
        assertEquals(false, vec1.obsahujeVec("vec3"));
    }
}
