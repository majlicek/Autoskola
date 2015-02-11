/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.upjs.ics.paz1c.dao;

import sk.upjs.ics.paz1c.entity.Komisari;
import java.util.List;

public interface KomisariDao {

    public List<Komisari> dajVsetky();

    public List<Komisari> hladajPodlaMena(String meno);

    public List<Komisari> hladajPodlaPriezviska(String priezvisko);
    
    public List<Komisari> hladajPodlaHodnosti(String hodnost);
    
    public void uloz(Komisari komisar);

    public void uprav(Komisari komisar);

    public void vymaz(Komisari komisar);

}
