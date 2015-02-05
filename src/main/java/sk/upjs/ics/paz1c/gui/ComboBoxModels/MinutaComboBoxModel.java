package sk.upjs.ics.paz1c.gui.ComboBoxModels;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

public class MinutaComboBoxModel extends AbstractListModel implements ComboBoxModel {

    int minuta;

    @Override
    public int getSize() {
        return 60;
    }

    @Override
    public Object getElementAt(int index) {
        return index;
    }

    @Override
    public void setSelectedItem(Object objekt) {
        minuta = (int) objekt;
    }

    @Override
    public Object getSelectedItem() {
        return minuta;
    }

}
