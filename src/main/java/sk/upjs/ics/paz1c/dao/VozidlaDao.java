package sk.upjs.ics.paz1c.dao;

import sk.upjs.ics.paz1c.entity.Vozidlo;
import java.util.List;

public interface VozidlaDao {

    public List<Vozidlo> dajVsetky();
    
    public List<Vozidlo> hladajPodlaSpz(String spz);
    
    public List<Vozidlo> hladajPodlaZnacky(String znacka);
    
    public List<Vozidlo> hladajPodlaKategorie(String kategoria);

    public void uloz(Vozidlo vozidlo);

    public void uprav(Vozidlo vozidlo);

    public void vymaz(Vozidlo vozidlo);
    
}
