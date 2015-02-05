package sk.upjs.ics.paz1c.databazoveDao;

import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import sk.upjs.ics.paz1c.autoskola.BeanFactory;
import sk.upjs.ics.paz1c.dao.VozidlaDao;
import sk.upjs.ics.paz1c.entity.Vozidlo;

public class DatabazoveVozidlaDaoTest {

    private static final int POCET_VOZIDIEL_V_DB = 5;

    private static final int POCET_VOZIDIEL_V_DB_PODLA_SPZ = 1;

    private static final int POCET_VOZIDIEL_V_DB_PODLA_ZNACKY = 1;

    private static final int POCET_VOZIDIEL_V_DB_PODLA_KATEGORIE = 3;

    private final VozidlaDao vozidlaDao = BeanFactory.INSTANCE.getVozidlaDao();

    public DatabazoveVozidlaDaoTest() {
    }

    @BeforeClass
    public static void setUpTests() {
        System.setProperty("testovaciRezim", "true");
    }

    @Test
    public void testDajVsetky() {
        List<Vozidlo> vozidla = vozidlaDao.dajVsetky();
        assertEquals(POCET_VOZIDIEL_V_DB, vozidla.size());
    }

    @Test
    public void testHladajPodlaSpz() {
        List<Vozidlo> vozidla = vozidlaDao.hladajPodlaSpz("CX");
        assertEquals(POCET_VOZIDIEL_V_DB_PODLA_SPZ, vozidla.size());
    }

    @Test
    public void testHladajPodlaZnacky() {
        List<Vozidlo> vozidla = vozidlaDao.hladajPodlaZnacky("Java ");
        assertEquals(POCET_VOZIDIEL_V_DB_PODLA_ZNACKY, vozidla.size());
    }

    @Test
    public void testHladajPodlaKategorie() {
        List<Vozidlo> vozidla = vozidlaDao.hladajPodlaKategorie("B");
        assertEquals(POCET_VOZIDIEL_V_DB_PODLA_KATEGORIE, vozidla.size());
    }

    @Test
    public void testUprav() {
        List<Vozidlo> vozidla = vozidlaDao.dajVsetky();
        Vozidlo vozidlo = vozidla.get(0);
        String staraFarba = vozidlo.getFarba();

        vozidlo.setFarba("abc");
        vozidlaDao.uprav(vozidlo);
        vozidla = vozidlaDao.dajVsetky();
        assertEquals("abc", vozidla.get(0).getFarba());

        // Vrati povodnu hodnotu
        vozidlo.setFarba(staraFarba);
        vozidlaDao.uprav(vozidlo);
    }

    @Test
    public void testUlozAVymaz() {
        List<Vozidlo> vozidla = vozidlaDao.dajVsetky();
        int staraVelkost = vozidla.size();

        Vozidlo vozidlo = new Vozidlo();
        vozidlo.setSpz("PO999ZZ");
        vozidlo.setZnacka("Ford");
        vozidlo.setTyp("Mondeo");
        vozidlo.setFarba("čierna");
        vozidlo.setKategoria("B");

        // Ulozi vozidlo
        vozidlaDao.uloz(vozidlo);

        vozidla = vozidlaDao.dajVsetky();

        assertEquals(staraVelkost + 1, vozidla.size());

        // Vrati povodny stav - vymaze ulozene vozidlo        
        vozidlaDao.vymaz(vozidlo);

        vozidla = vozidlaDao.dajVsetky();

        assertEquals(staraVelkost, vozidla.size());
    }

}
