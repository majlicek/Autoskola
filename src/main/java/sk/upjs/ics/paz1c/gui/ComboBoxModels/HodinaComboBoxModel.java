package sk.upjs.ics.paz1c.gui.ComboBoxModels;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

public class HodinaComboBoxModel extends AbstractListModel implements ComboBoxModel {

    int hodina;

    @Override
    public int getSize() {
        return 24;
    }

    @Override
    public Object getElementAt(int index) {
        return index;
    }

    @Override
    public void setSelectedItem(Object objekt) {
        hodina = (int) objekt;
    }

    @Override
    public Object getSelectedItem() {
        return hodina;
    }

}
