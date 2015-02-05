package sk.upjs.ics.paz1c.filtre;

import java.sql.Date;
import java.sql.Time;

public class JazdyFilter {

    private String student;
    private String instruktor;
    private String vozidlo;
    private Date datumOd;
    private Date datumDo;
    private Time casOd;
    private Time casDo;
    private Integer kmOd;
    private Integer kmDo;
    private Boolean vPremavke;
    private Boolean naCvicisku;
    private Boolean sVozikom;
    private String kategoria;

    public String getStudent() {
        return student;
    }

    public void setStudent(String student) {
        this.student = student;
    }

    public String getInstruktor() {
        return instruktor;
    }

    public void setInstruktor(String instruktor) {
        this.instruktor = instruktor;
    }

    public String getVozidlo() {
        return vozidlo;
    }

    public void setVozidlo(String vozidlo) {
        this.vozidlo = vozidlo;
    }

    public Date getDatumOd() {
        return datumOd;
    }

    public void setDatumOd(Date datumOd) {
        this.datumOd = datumOd;
    }

    public Date getDatumDo() {
        return datumDo;
    }

    public void setDatumDo(Date datumDo) {
        this.datumDo = datumDo;
    }

    public Time getCasOd() {
        return casOd;
    }

    public void setCasOd(Time casOd) {
        this.casOd = casOd;
    }

    public Time getCasDo() {
        return casDo;
    }

    public void setCasDo(Time casDo) {
        this.casDo = casDo;
    }

    public Integer getKmOd() {
        return kmOd;
    }

    public void setKmOd(Integer kmOd) {
        this.kmOd = kmOd;
    }

    public Integer getKmDo() {
        return kmDo;
    }

    public void setKmDo(Integer kmDo) {
        this.kmDo = kmDo;
    }

    public Boolean getvPremavke() {
        return vPremavke;
    }

    public void setvPremavke(Boolean vPremavke) {
        this.vPremavke = vPremavke;
    }

    public Boolean getNaCvicisku() {
        return naCvicisku;
    }

    public void setNaCvicisku(Boolean naCvicisku) {
        this.naCvicisku = naCvicisku;
    }

    public Boolean getsVozikom() {
        return sVozikom;
    }

    public void setsVozikom(Boolean sVozikom) {
        this.sVozikom = sVozikom;
    }

    public String getKategoria() {
        return kategoria;
    }

    public void setKategoria(String kategoria) {
        this.kategoria = kategoria;
    }

}
