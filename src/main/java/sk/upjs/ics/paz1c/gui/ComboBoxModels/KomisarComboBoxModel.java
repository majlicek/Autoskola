/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.upjs.ics.paz1c.gui.ComboBoxModels;

import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
import sk.upjs.ics.paz1c.autoskola.BeanFactory;
import sk.upjs.ics.paz1c.dao.KomisariDao;
import sk.upjs.ics.paz1c.entity.Komisari;

/**
 *
 * @author Majlo
 */
public class KomisarComboBoxModel extends AbstractListModel implements ComboBoxModel{
    
    private KomisariDao komisariDao = BeanFactory.INSTANCE.getKomisariDao();
    private List<Komisari> komisari = komisariDao.dajVsetky();
    
    Komisari komisar;

    @Override
    public int getSize() {
        return komisari.size();
    }

    @Override
    public Object getElementAt(int index) {
        return komisari.get(index);
    }

    @Override
    public void setSelectedItem(Object objekt) {
        komisar = (Komisari) objekt;
    }

    @Override
    public Object getSelectedItem() {
        return komisar;
    }
}
