package sk.upjs.ics.paz1c.dao;

import sk.upjs.ics.paz1c.entity.Student;
import java.util.List;
import sk.upjs.ics.paz1c.entity.Skuska;
import sk.upjs.ics.paz1c.filtre.StudentiFilter;

public interface StudentiDao {

    public List<Student> dajVsetky();

    public List<Student> dajPodlaSkusky(Skuska skuska);

    public List<Student> hladajPodlaMena(String meno);

    public List<Student> hladajPodlaPriezviska(String priezvisko);

    public List<Student> hladajPodlaFiltra(StudentiFilter filter);

    public void uloz(Student student);

    public void uprav(Student student);

    public void vymaz(Student student);

}
