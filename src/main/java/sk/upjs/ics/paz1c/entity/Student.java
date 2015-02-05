package sk.upjs.ics.paz1c.entity;

import java.sql.Date;

public class Student {

    private Long id;
    private String meno;
    private String priezvisko;
    private Date datumNarodenia;
    private String bydlisko;
    private String kontakt;
    private boolean prvaPomoc;
    private int pocetPokusov;
    private int pocetBodov;
    private boolean cvicisko;
    private boolean jazda;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMeno() {
        return meno;
    }

    public void setMeno(String meno) {
        this.meno = meno;
    }

    public String getPriezvisko() {
        return priezvisko;
    }

    public void setPriezvisko(String priezvisko) {
        this.priezvisko = priezvisko;
    }

    public Date getDatumNarodenia() {
        return datumNarodenia;
    }

    public void setDatumNarodenia(Date datumNarodenia) {
        this.datumNarodenia = datumNarodenia;
    }

    public String getBydlisko() {
        return bydlisko;
    }

    public void setBydlisko(String bydlisko) {
        this.bydlisko = bydlisko;
    }

    public String getKontakt() {
        return kontakt;
    }

    public void setKontakt(String kontakt) {
        this.kontakt = kontakt;
    }

    public boolean isPrvaPomoc() {
        return prvaPomoc;
    }

    public void setPrvaPomoc(boolean prvaPomoc) {
        this.prvaPomoc = prvaPomoc;
    }

    public int getPocetPokusov() {
        return pocetPokusov;
    }

    public void setPocetPokusov(int pocetPokusov) {
        this.pocetPokusov = pocetPokusov;
    }

    public int getPocetBodov() {
        return pocetBodov;
    }

    public void setPocetBodov(int pocetBodov) {
        this.pocetBodov = pocetBodov;
    }

    public boolean isCvicisko() {
        return cvicisko;
    }

    public void setCvicisko(boolean cvicisko) {
        this.cvicisko = cvicisko;
    }

    public boolean isJazda() {
        return jazda;
    }

    public void setJazda(boolean jazda) {
        this.jazda = jazda;
    }

    @Override
    public String toString() {
        return meno + " " + priezvisko;
    }

}
