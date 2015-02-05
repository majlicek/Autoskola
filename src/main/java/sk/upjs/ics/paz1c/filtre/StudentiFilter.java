package sk.upjs.ics.paz1c.filtre;

import java.sql.Date;

public class StudentiFilter {

    private String meno;
    private String priezvisko;
    private String bydlisko;
    private Date datumNarodeniaOd;
    private Date datumNarodeniaDo;
    private Integer pocetJazdOd;
    private Integer pocetJazdDo;
    private Integer prejdeneKmOd;
    private Integer prejdeneKmDo;
    private Boolean prvaPomoc;
    private Boolean test;
    private Boolean cvicisko;
    private String kategoria;

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

    public String getBydlisko() {
        return bydlisko;
    }

    public void setBydlisko(String bydlisko) {
        this.bydlisko = bydlisko;
    }

    public Date getDatumNarodeniaOd() {
        return datumNarodeniaOd;
    }

    public void setDatumNarodeniaOd(Date datumNarodeniaOd) {
        this.datumNarodeniaOd = datumNarodeniaOd;
    }

    public Date getDatumNarodeniaDo() {
        return datumNarodeniaDo;
    }

    public void setDatumNarodeniaDo(Date datumNarodeniaDo) {
        this.datumNarodeniaDo = datumNarodeniaDo;
    }

    public Integer getPocetJazdOd() {
        return pocetJazdOd;
    }

    public void setPocetJazdOd(Integer pocetJazdOd) {
        this.pocetJazdOd = pocetJazdOd;
    }

    public Integer getPocetJazdDo() {
        return pocetJazdDo;
    }

    public void setPocetJazdDo(Integer pocetJazdDo) {
        this.pocetJazdDo = pocetJazdDo;
    }

    public Integer getPrejdeneKmOd() {
        return prejdeneKmOd;
    }

    public void setPrejdeneKmOd(Integer prejdeneKmOd) {
        this.prejdeneKmOd = prejdeneKmOd;
    }

    public Integer getPrejdeneKmDo() {
        return prejdeneKmDo;
    }

    public void setPrejdeneKmDo(Integer prejdeneKmDo) {
        this.prejdeneKmDo = prejdeneKmDo;
    }

    public Boolean getPrvaPomoc() {
        return prvaPomoc;
    }

    public void setPrvaPomoc(Boolean prvaPomoc) {
        this.prvaPomoc = prvaPomoc;
    }

    public Boolean getTest() {
        return test;
    }

    public void setTest(Boolean test) {
        this.test = test;
    }

    public Boolean getCvicisko() {
        return cvicisko;
    }

    public void setCvicisko(Boolean cvicisko) {
        this.cvicisko = cvicisko;
    }

    public String getKategoria() {
        return kategoria;
    }

    public void setKategoria(String kategoria) {
        this.kategoria = kategoria;
    }

}
