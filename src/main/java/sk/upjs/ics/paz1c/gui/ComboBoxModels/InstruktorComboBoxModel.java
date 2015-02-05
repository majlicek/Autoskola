package sk.upjs.ics.paz1c.gui.ComboBoxModels;

import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
import sk.upjs.ics.paz1c.autoskola.BeanFactory;
import sk.upjs.ics.paz1c.dao.InstruktoriDao;
import sk.upjs.ics.paz1c.entity.Instruktor;

public class InstruktorComboBoxModel extends AbstractListModel implements ComboBoxModel {

    private InstruktoriDao instruktoriDao = BeanFactory.INSTANCE.getInstruktoriDao();
    private List<Instruktor> instruktori = instruktoriDao.dajVsetky();
    
    Instruktor instruktor;

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
        instruktor = (Instruktor) objekt;
    }

    @Override
    public Object getSelectedItem() {
        return instruktor;
    }

}
