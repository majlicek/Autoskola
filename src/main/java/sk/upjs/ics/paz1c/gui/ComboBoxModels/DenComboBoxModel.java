package sk.upjs.ics.paz1c.gui.ComboBoxModels;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

public class DenComboBoxModel extends AbstractListModel implements ComboBoxModel {

    int den;

    @Override
    public int getSize() {
        return 31;
    }

    @Override
    public Object getElementAt(int index) {
        return index + 1;
    }

    @Override
    public void setSelectedItem(Object objekt) {
        den = (int) objekt;
    }

    @Override
    public Object getSelectedItem() {
        return den;
    }

}
