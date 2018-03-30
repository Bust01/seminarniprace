package logika;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/*******************************************************************************
 * Testovací třída HraTest slouží ke komplexnímu otestování
 * třídy Hra
 *
 * @author    Tomáš Bušek
 * @version  1.0
 */
public class HraTest {
    private Hra hra1;

    /***************************************************************************
     * Metoda se provede před spuštěním každé testovací metody. Používá se
     * k vytvoření tzv. přípravku (fixture), což jsou datové atributy (objekty),
     * s nimiž budou testovací metody pracovat.
     */
    @Before
    public void setUp() {
        hra1 = new Hra();
    }

    /***************************************************************************
     * Úklid po testu - tato metoda se spustí po vykonání každé testovací metody.
     */
    @After
    public void tearDown() {
    }
/***************************************************************************
     * Testuje průběh hry, po zavolání každěho příkazu testuje, zda hra končí
     * a v jaké aktuální místnosti se hráč nachází.
     * Při dalším rozšiřování hry doporučujeme testovat i jaké věci nebo osoby
     * jsou v místnosti a jaké věci jsou v batohu hráče.
     * 
     */
    @Test
    public void testPrubehHry() {
        assertEquals("Harryho_mistnost", hra1.getHerniPlan().getAktualniProstor().getNazev());
        hra1.zpracujPrikaz("nápověda");
        assertEquals(false, hra1.konecHry());
        hra1.zpracujPrikaz("prohledej začátečnická_truhla");
        assertEquals(false, hra1.konecHry());
        hra1.zpracujPrikaz("seber vzkaz_pro_Brumbdibála");
        assertEquals(false, hra1.konecHry());
        hra1.zpracujPrikaz("jdi schodiště");
        assertEquals("schodiště", hra1.getHerniPlan().getAktualniProstor().getNazev());
        assertEquals(false, hra1.konecHry());
        hra1.zpracujPrikaz("jdi rektorát_profesora_Snapa");
        assertEquals("rektorát_profesora_Snapa", hra1.getHerniPlan().getAktualniProstor().getNazev());
        hra1.zpracujPrikaz("mluv snape");
        assertEquals(false, hra1.konecHry());
        hra1.zpracujPrikaz("seber lektvar_síly");
        assertEquals(false, hra1.konecHry());
        hra1.zpracujPrikaz("jdi rajský_dvůr");
        assertEquals("rajský_dvůr", hra1.getHerniPlan().getAktualniProstor().getNazev());
        assertEquals(false, hra1.konecHry());
        hra1.zpracujPrikaz("mluv hermelina");
        assertEquals(false, hra1.konecHry());
        hra1.zpracujPrikaz("jdi blanická_bouda");
        assertEquals("blanická_bouda", hra1.getHerniPlan().getAktualniProstor().getNazev());
        assertEquals(false, hra1.konecHry());
        hra1.zpracujPrikaz("mluv brumbdibal");
        assertEquals(false, hra1.konecHry());
        hra1.zpracujPrikaz("daruj vzkaz_pro_Brumbdibála");
        assertEquals(false, hra1.konecHry());
        hra1.zpracujPrikaz("seber klíč");
        assertEquals(false, hra1.konecHry());
        hra1.zpracujPrikaz("jdi jižní_les");
        assertEquals("jižní_les", hra1.getHerniPlan().getAktualniProstor().getNazev());
        assertEquals(false, hra1.konecHry());
        hra1.zpracujPrikaz("jdi Likešova_studna");
        assertEquals("Likešova_studna", hra1.getHerniPlan().getAktualniProstor().getNazev());
        assertEquals(false, hra1.konecHry());
        hra1.zpracujPrikaz("seber voda");
        assertEquals(false, hra1.konecHry());
        hra1.zpracujPrikaz("jdi jižní_les");
        assertEquals("jižní_les", hra1.getHerniPlan().getAktualniProstor().getNazev());
        assertEquals(false, hra1.konecHry());
        hra1.zpracujPrikaz("jdi pavoučí_hnízdo");
        assertEquals("pavoučí_hnízdo", hra1.getHerniPlan().getAktualniProstor().getNazev());
        assertEquals(false, hra1.konecHry());
        hra1.zpracujPrikaz("utok_na_arachnolorda");
        assertEquals(false, hra1.konecHry());
        hra1.zpracujPrikaz("jdi jižní_les");
        assertEquals("jižní_les", hra1.getHerniPlan().getAktualniProstor().getNazev());
        assertEquals(false, hra1.konecHry());
        hra1.zpracujPrikaz("jdi stará_chalupa");
        assertEquals("stará_chalupa", hra1.getHerniPlan().getAktualniProstor().getNazev());
        assertEquals(false, hra1.konecHry());
        hra1.zpracujPrikaz("seber kniha");
        assertEquals(false, hra1.konecHry());
        hra1.zpracujPrikaz("seber nůž");
        assertEquals(false, hra1.konecHry());
        hra1.zpracujPrikaz("vyhod nů");
        assertEquals(false, hra1.konecHry());
        hra1.zpracujPrikaz("jdi jižní_les");
        assertEquals("jižní_les", hra1.getHerniPlan().getAktualniProstor().getNazev());
        assertEquals(false, hra1.konecHry());
        hra1.zpracujPrikaz("jdi rajský_dvůr");
        assertEquals("rajský_dvůr", hra1.getHerniPlan().getAktualniProstor().getNazev());
        assertEquals(false, hra1.konecHry());
        hra1.zpracujPrikaz("daruj kniha");
        hra1.zpracujPrikaz("jdi jižní_les");
        assertEquals("jižní_les", hra1.getHerniPlan().getAktualniProstor().getNazev());
        assertEquals(false, hra1.konecHry());
        hra1.zpracujPrikaz("jdi stará_chalupa");
        assertEquals("stará_chalupa", hra1.getHerniPlan().getAktualniProstor().getNazev());
        assertEquals(false, hra1.konecHry());
        hra1.zpracujPrikaz("odemkni Vencovskeho_komnaty");
        assertEquals(false, hra1.konecHry());
        hra1.zpracujPrikaz("jdi Vencovskeho_komnaty");
        assertEquals("Vencovskeho_komnaty", hra1.getHerniPlan().getAktualniProstor().getNazev());
        assertEquals(false, hra1.konecHry());
        hra1.zpracujPrikaz("utok_na_Mikromorta");
        assertEquals(false, hra1.konecHry());
        hra1.zpracujPrikaz("jdi slepá_místnost");
        assertEquals("Vencovskeho_komnaty", hra1.getHerniPlan().getAktualniProstor().getNazev());
        assertEquals(false, hra1.konecHry());
        hra1.zpracujPrikaz("seber lektvar_odolnosti");
        assertEquals(false, hra1.konecHry());
        hra1.zpracujPrikaz("jdi Vencovskeho_komnaty");
        assertEquals("Vencovskeho_komnaty", hra1.getHerniPlan().getAktualniProstor().getNazev());
        assertEquals(false, hra1.konecHry());
        hra1.zpracujPrikaz("jdi zkušebna");
        assertEquals("Vencovskeho_komnaty", hra1.getHerniPlan().getAktualniProstor().getNazev());
        assertEquals(false, hra1.konecHry());
        hra1.zpracujPrikaz("utok_na_Makromorta");
        assertEquals(false, hra1.konecHry());
        hra1.zpracujPrikaz("odemkni svatyně_kamene");
        assertEquals(false, hra1.konecHry());
        hra1.zpracujPrikaz("prohledej truhla_makromorta");
        assertEquals(false, hra1.konecHry());
        hra1.zpracujPrikaz("seber kámen_Vysoké_školy_ekonomické");
        assertEquals(false, hra1.konecHry());
        hra1.zpracujPrikaz("jdi svatyně");
    }
    
    
    @Test
    public void testKonceHry() {
    assertEquals("Harryho_mistnost", hra1.getHerniPlan().getAktualniProstor().getNazev());
    hra1.zpracujPrikaz("konec");
    assertEquals(true, hra1.konecHry());
}
}
