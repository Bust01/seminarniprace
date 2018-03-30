package com.github.bust01.seminarniprace;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.github.bust01.seminarniprace.logika.Batoh;
import com.github.bust01.seminarniprace.logika.Vec;

import static org.junit.Assert.*;

/*******************************************************************************
 * Testovací třída BatohTest slouží ke komplexnímu otestování třídy Batoh
 *
 * @author    Tomáš Bušek
 * @version   1.0
 */
public class BatohTest
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
     * Metoda testující vkládání věcí do batohu.
     */
    @Test
    public void testVkladani() {
        Batoh batoh1 = new Batoh();
        Vec vec1 = new Vec("kolo",true);
        batoh1.vlozVec(vec1);
        assertEquals(true, batoh1.obsahujeVec("kolo"));
        assertEquals(false, batoh1.obsahujeVec("auto"));
    }
    
    /**
     * Metoda testující odebírání věcí z batohu.
     */
    @Test
     public void testOdebrani() {
        Batoh batoh1 = new Batoh();
        Vec vec1 = new Vec("kolo",true);
        assertEquals(true, batoh1.vlozVec(vec1));
        batoh1.vyhodVec("kolo");
        assertEquals(false, batoh1.obsahujeVec("kolo"));
    }
    
    @Test
    /**
     * Metoda testující kapacitu batohu, která nesmí být překročena.
     */
    public void testKapacita()
    {
       Batoh batoh1 = new Batoh();   
       Vec vec1 = new Vec ("vec1",true);
       Vec vec2 = new Vec ("vec2",true);
       Vec vec3 = new Vec ("vec3",true);
       Vec vec4 = new Vec ("vec4",false);
       Vec vec5 = new Vec ("vec5",true);
       Vec vec6 = new Vec ("vec6",true);
       Vec vec7 = new Vec ("vec7",true);
       assertEquals(true, batoh1.vlozVec(vec1));
        assertEquals(true, batoh1.vlozVec(vec2));
         assertEquals(true, batoh1.vlozVec(vec3));
          assertEquals(false, batoh1.vlozVec(vec4)); 
           assertEquals(true, batoh1.vlozVec(vec5));
            assertEquals(true, batoh1.vlozVec(vec6));
             assertEquals(false, batoh1.vlozVec(vec7));
     assertEquals(false, batoh1.jeMisto());
    }
    
    @Test
    public void testVlozNeprenositelne()
    {
        Batoh batoh1 = new Batoh();   
       Vec vec1 = new Vec ("vec1",true);
       assertEquals(true, batoh1.vlozVec(vec1));
       Vec vec2 = new Vec ("vec2",false);
       Vec vec3 = new Vec ("vec3",false);
       assertEquals(false, batoh1.vlozVec(vec2));
       assertEquals(false, batoh1.vlozVec(vec3));
    }
}

