package sk.upjs.ics.paz1c.gui.ComboBoxModels;

import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
import sk.upjs.ics.paz1c.autoskola.BeanFactory;
import sk.upjs.ics.paz1c.dao.VozidlaDao;
import sk.upjs.ics.paz1c.entity.Vozidlo;

public class VozidloComboBoxModel extends AbstractListModel implements ComboBoxModel {

    private VozidlaDao vozidlaDao = BeanFactory.INSTANCE.getVozidlaDao();
    private List<Vozidlo> instruktori = vozidlaDao.dajVsetky();
    
    Vozidlo vozidlo;

    @Override
    public int getSize() {
        return instruktori.size();
    }

    @Override
    public Object getElementAt(int index) {
        return instruktori.get(index);
    }

    @Override
    public void setSelectedItem(Object objekt) {
        vozidlo = (Vozidlo) objekt;
    }

    @Override
    public Object getSelectedItem() {
        return vozidlo;
    }

}
