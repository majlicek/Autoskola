package sk.upjs.ics.paz1c.entity;

/**
 *
 * @author Majlo
 */
public class Komisari {
    private Long id;
    private String meno;
    private String priezvisko;
    private String hodnost;

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the meno
     */
    public String getMeno() {
        return meno;
    }

    /**
     * @param meno the meno to set
     */
    public void setMeno(String meno) {
        this.meno = meno;
    }

    /**
     * @return the priezvisko
     */
    public String getPriezvisko() {
        return priezvisko;
    }

    /**
     * @param priezvisko the priezvisko to set
     */
    public void setPriezvisko(String priezvisko) {
        this.priezvisko = priezvisko;
    }

    /**
     * @return the hodnost
     */
    public String getHodnost() {
        return hodnost;
    }

    /**
     * @param hodnost the hodnost to set
     */
    public void setHodnost(String hodnost) {
        this.hodnost = hodnost;
    }
    
    @Override
    public String toString() {
        return hodnost + " " + meno + " " + priezvisko;
    }
}
