package sk.upjs.ics.paz1c.databazoveDao;

import java.sql.Date;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import sk.upjs.ics.paz1c.autoskola.BeanFactory;
import sk.upjs.ics.paz1c.dao.SkuskyDao;
import sk.upjs.ics.paz1c.dao.StudentiDao;
import sk.upjs.ics.paz1c.entity.Skuska;
import sk.upjs.ics.paz1c.entity.Student;
import sk.upjs.ics.paz1c.filtre.StudentiFilter;

public class DatabazoveStudentiDaoTest {

    private static final int POCET_STUDENTOV_V_DB = 5;

    private static final int POCET_STUDENTOV_NA_SKUSKE = 2;

    private static final int POCET_STUDENTOV_V_DB_PODLA_MENA = 1;

    private static final int POCET_STUDENTOV_V_DB_PODLA_PRIEZVISKA = 1;

    private static final int POCET_STUDENTOV_V_DB_PODLA_KRITERIA = 1;

    private final StudentiDao studentiDao = BeanFactory.INSTANCE.getStudentiDao();

    private final SkuskyDao skuskyDao = BeanFactory.INSTANCE.getSkuskyDao();

    public DatabazoveStudentiDaoTest() {
    }

    @BeforeClass
    public static void setUpTests() {
        System.setProperty("testovaciRezim", "true");
    }

    @Test
    public void testDajVsetky() {
        List<Student> studenti = studentiDao.dajVsetky();
        assertEquals(POCET_STUDENTOV_V_DB, studenti.size());
    }

    @Test
    public void testDajPodlaSkusky() {
        Skuska skuska = skuskyDao.dajVsetky().get(1);
        List<Student> studenti = studentiDao.dajPodlaSkusky(skuska);
        assertEquals(POCET_STUDENTOV_NA_SKUSKE, studenti.size());
    }

    @Test
    public void testHladajPodlaMena() {
        List<Student> studenti = studentiDao.hladajPodlaMena("Jakub");
        assertEquals(POCET_STUDENTOV_V_DB_PODLA_MENA, studenti.size());
    }

    @Test
    public void testHladajPodlaPriezviska() {
        List<Student> studenti = studentiDao.hladajPodlaPriezviska("Novot");
        assertEquals(POCET_STUDENTOV_V_DB_PODLA_PRIEZVISKA, studenti.size());
    }

    @Test
    public void testHladajPodlaFiltra() {
        StudentiFilter filter = new StudentiFilter();
        filter.setMeno("Jakub");
        filter.setPriezvisko("ed");
        filter.setBydlisko("Prešov");
        filter.setDatumNarodeniaOd(Date.valueOf("1993-01-01"));
        filter.setDatumNarodeniaDo(Date.valueOf("1996-01-01"));
        filter.setPocetJazdOd(0);
        filter.setPocetJazdDo(2);
        filter.setPrejdeneKmOd(16);
        filter.setPrejdeneKmDo(35);
        filter.setKategoria("B");
        List<Student> studenti = studentiDao.hladajPodlaFiltra(filter);
        assertEquals(POCET_STUDENTOV_V_DB_PODLA_KRITERIA, studenti.size());
    }

    @Test
    public void testUprav() {
        List<Student> studenti = studentiDao.dajVsetky();
        Student student = studenti.get(0);
        String stareBydlisko = student.getBydlisko();

        student.setBydlisko("abc");
        studentiDao.uprav(student);
        studenti = studentiDao.dajVsetky();
        assertEquals("abc", studenti.get(0).getBydlisko());

        // Vrati povodnu hodnotu
        student.setBydlisko(stareBydlisko);
        studentiDao.uprav(student);
    }

    @Test
    public void testUlozAVymaz() {
        List<Student> studenti = studentiDao.dajVsetky();
        int staraVelkost = studenti.size();

        Student student = new Student();
        student.setMeno("Artur");
        student.setPriezvisko("Veľký");
        student.setDatumNarodenia(Date.valueOf("1993-03-02"));
        student.setBydlisko("Karpatská 7, Prešov");
        student.setKontakt("0902345789");
        student.setPrvaPomoc(true);
        student.setPocetPokusov(0);
        student.setPocetBodov(0);
        student.setCvicisko(false);
        student.setJazda(false);

        // Ulozi studenta
        studentiDao.uloz(student);

        studenti = studentiDao.dajVsetky();

        assertEquals(staraVelkost + 1, studenti.size());

        // Vrati povodny stav - vymaze ulozeneho studenta        
        studentiDao.vymaz(student);

        studenti = studentiDao.dajVsetky();

        assertEquals(staraVelkost, studenti.size());
    }

}
