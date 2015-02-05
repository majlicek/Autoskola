package sk.upjs.ics.paz1c.dao;

import sk.upjs.ics.paz1c.entity.Skuska;
import java.util.List;

public interface SkuskyDao {

    public List<Skuska> dajVsetky();

    public List<Skuska> hladajPodlaDatumu(String datum);

    public List<Skuska> hladajPodlaStudenta(String student);

    public List<Skuska> hladajPodlaInstruktora(String instruktor);

    public void uloz(Skuska skuska);

    public void uprav(Skuska skuska);

    public void vymaz(Skuska skuska);
}
