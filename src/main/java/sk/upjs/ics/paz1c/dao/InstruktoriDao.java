package sk.upjs.ics.paz1c.dao;

import sk.upjs.ics.paz1c.entity.Instruktor;
import java.util.List;

public interface InstruktoriDao {

    public List<Instruktor> dajVsetky();

    public List<Instruktor> hladajPodlaMena(String meno);

    public List<Instruktor> hladajPodlaPriezviska(String priezvisko);

    public void uloz(Instruktor instruktor);

    public void uprav(Instruktor instruktor);

    public void vymaz(Instruktor instruktor);

}
