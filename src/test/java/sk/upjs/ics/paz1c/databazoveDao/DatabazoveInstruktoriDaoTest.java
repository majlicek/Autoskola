package sk.upjs.ics.paz1c.databazoveDao;

import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import sk.upjs.ics.paz1c.autoskola.BeanFactory;
import sk.upjs.ics.paz1c.dao.InstruktoriDao;
import sk.upjs.ics.paz1c.entity.Instruktor;

public class DatabazoveInstruktoriDaoTest {

    private static final int POCET_INSTRUKTOROV_V_DB = 5;

    private static final int POCET_INSTUKTOROV_V_DB_PODLA_MENA = 2;

    private static final int POCET_INSTUKTOROV_V_DB_PODLA_PRIEZVISKA = 1;

    private final InstruktoriDao instruktoriDao = BeanFactory.INSTANCE.getInstruktoriDao();

    public DatabazoveInstruktoriDaoTest() {
    }

    @BeforeClass
    public static void setUpTests() {
        System.setProperty("testovaciRezim", "true");
    }

    @Test
    public void testDajVsetky() {
        List<Instruktor> instruktori = instruktoriDao.dajVsetky();
        assertEquals(POCET_INSTRUKTOROV_V_DB, instruktori.size());
    }

    @Test
    public void testHladajPodlaMena() {
        List<Instruktor> instruktori = instruktoriDao.hladajPodlaMena("ant");
        assertEquals(POCET_INSTUKTOROV_V_DB_PODLA_MENA, instruktori.size());
    }

    @Test
    public void testHladajPodlaPriezviska() {
        List<Instruktor> instruktori = instruktoriDao.hladajPodlaPriezviska(" Tra  ");
        assertEquals(POCET_INSTUKTOROV_V_DB_PODLA_PRIEZVISKA, instruktori.size());
    }

    @Test
    public void testUprav() {
        List<Instruktor> instruktori = instruktoriDao.dajVsetky();
        Instruktor instruktor = instruktori.get(0);
        String staryKontakt = instruktor.getKontakt();

        instruktor.setKontakt("abc");
        instruktoriDao.uprav(instruktor);
        instruktori = instruktoriDao.dajVsetky();
        assertEquals("abc", instruktori.get(0).getKontakt());

        // Vrati povodnu hodnotu
        instruktor.setKontakt(staryKontakt);
        instruktoriDao.uprav(instruktor);
    }

    @Test
    public void testUlozAVymaz() {
        List<Instruktor> instruktori = instruktoriDao.dajVsetky();
        int staraVelkost = instruktori.size();

        Instruktor instruktor = new Instruktor();
        instruktor.setMeno("Artur");
        instruktor.setPriezvisko("Velky");
        instruktor.setKontakt("0902345789");

        // Ulozi instruktora
        instruktoriDao.uloz(instruktor);

        instruktori = instruktoriDao.dajVsetky();

        assertEquals(staraVelkost + 1, instruktori.size());

        // Vrati povodny stav - vymaze ulozeneho instruktora        
        instruktoriDao.vymaz(instruktor);

        instruktori = instruktoriDao.dajVsetky();

        assertEquals(staraVelkost, instruktori.size());
    }

}
