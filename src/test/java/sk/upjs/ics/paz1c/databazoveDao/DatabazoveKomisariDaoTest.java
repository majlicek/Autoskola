/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.upjs.ics.paz1c.databazoveDao;

import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import sk.upjs.ics.paz1c.autoskola.BeanFactory;
import sk.upjs.ics.paz1c.dao.InstruktoriDao;
import sk.upjs.ics.paz1c.dao.KomisariDao;
import sk.upjs.ics.paz1c.entity.Instruktor;
import sk.upjs.ics.paz1c.entity.Komisari;

public class DatabazoveKomisariDaoTest {

    private static final int POCET_KOMISAROV_V_DB = 3;

    private static final int POCET_KOMISAROV_V_DB_PODLA_MENA = 1;

    private static final int POCET_KOMISAROV_V_DB_PODLA_PRIEZVISKA = 1;
    
    private static final int POCET_KOMISAROV_V_DB_PODLA_HODNOSTI = 2;

    private final KomisariDao komisariDao = BeanFactory.INSTANCE.getKomisariDao();

    public DatabazoveKomisariDaoTest() {
    }

    @Test
    public void testDajVsetky() {
        List<Komisari> komisari = komisariDao.dajVsetky();
        assertEquals(POCET_KOMISAROV_V_DB, komisari.size());
    }

    @Test
    public void testHladajPodlaMena() {
        List<Komisari> komisari = komisariDao.hladajPodlaMena("arm");
        assertEquals(POCET_KOMISAROV_V_DB_PODLA_MENA, komisari.size());
    }

    @Test
    public void testHladajPodlaPriezviska() {
        List<Komisari> komisari = komisariDao.hladajPodlaPriezviska(" Ro  ");
        assertEquals(POCET_KOMISAROV_V_DB_PODLA_PRIEZVISKA, komisari.size());
    }
    
    @Test
    public void testHladajPodlaHodnosti() {
        List<Komisari> komisari = komisariDao.hladajPodlaHodnosti(" p  ");
        assertEquals(POCET_KOMISAROV_V_DB_PODLA_HODNOSTI, komisari.size());
    }

    @Test
    public void testUprav() {
        List<Komisari> komisari = komisariDao.dajVsetky();
        Komisari komisar = komisari.get(0);
        String staraHodnost = komisar.getHodnost();

        komisar.setHodnost("abc");
        komisariDao.uprav(komisar);
        komisari = komisariDao.dajVsetky();
        assertEquals("abc", komisari.get(0).getHodnost());

        // Vrati povodnu hodnotu
        komisar.setHodnost(staraHodnost);
        komisariDao.uprav(komisar);
    }

    @Test
    public void testUlozAVymaz() {
        List<Komisari> komisari = komisariDao.dajVsetky();
        int staraVelkost = komisari.size();

        Komisari komisar = new Komisari();
        komisar.setMeno("Artur");
        komisar.setPriezvisko("Veľký");
        komisar.setHodnost("abs");

        // Ulozi komisara
        komisariDao.uloz(komisar);

        komisari = komisariDao.dajVsetky();

        assertEquals(staraVelkost + 1, komisari.size());

        // Vrati povodny stav - vymaze ulozeneho komisara        
        komisariDao.vymaz(komisar);

        komisari = komisariDao.dajVsetky();

        assertEquals(staraVelkost, komisari.size());
    }

}
