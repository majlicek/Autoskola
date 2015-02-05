package sk.upjs.ics.paz1c.entity;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

public class Skuska {

    private Long id;
    private Date datum;
    private Time cas;
    private List<Student> studenti;
    private Instruktor instruktor;
    private String policajt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public Time getCas() {
        return cas;
    }

    public void setCas(Time cas) {
        this.cas = cas;
    }

    public List<Student> getStudenti() {
        return studenti;
    }

    public void setStudenti(List<Student> studenti) {
        this.studenti = studenti;
    }

    public Instruktor getInstruktor() {
        return instruktor;
    }

    public void setInstruktor(Instruktor instruktor) {
        this.instruktor = instruktor;
    }

    public String getPolicajt() {
        return policajt;
    }

    public void setPolicajt(String policajt) {
        this.policajt = policajt;
    }

    @Override
    public String toString() {
        return "Skuska{" + "id=" + id + ", datum=" + datum + ", cas=" + cas + ", studenti=" + studenti + ", instruktor=" + instruktor + ", policajt=" + policajt + '}';
    }

}
