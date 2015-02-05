package sk.upjs.ics.paz1c.entity;

import java.sql.Date;
import java.sql.Time;

public class Jazda {

    private Long id;
    private Student student;
    private Instruktor instruktor;
    private Vozidlo vozidlo;
    private Date datum;
    private Time cas;
    private int km;
    private boolean vPremavke;
    private boolean naCvicisku;
    private boolean sVozikom;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Instruktor getInstruktor() {
        return instruktor;
    }

    public void setInstruktor(Instruktor instruktor) {
        this.instruktor = instruktor;
    }

    public Vozidlo getVozidlo() {
        return vozidlo;
    }

    public void setVozidlo(Vozidlo vozidlo) {
        this.vozidlo = vozidlo;
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

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public boolean isvPremavke() {
        return vPremavke;
    }

    public void setvPremavke(boolean vPremavke) {
        this.vPremavke = vPremavke;
    }

    public boolean isNaCvicisku() {
        return naCvicisku;
    }

    public void setNaCvicisku(boolean naCvicisku) {
        this.naCvicisku = naCvicisku;
    }

    public boolean issVozikom() {
        return sVozikom;
    }

    public void setsVozikom(boolean sVozikom) {
        this.sVozikom = sVozikom;
    }

    @Override
    public String toString() {
        return "Jazda{" + "id=" + id + ", student=" + student + ", instruktor=" + instruktor + ", vozidlo=" + vozidlo + ", datum=" + datum + ", cas=" + cas + ", km=" + km + ", vPremavke=" + vPremavke + ", naCvicisku=" + naCvicisku + ", sVozikom=" + sVozikom + '}';
    }

}
