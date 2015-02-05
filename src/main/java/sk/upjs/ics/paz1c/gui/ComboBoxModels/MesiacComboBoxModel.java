package sk.upjs.ics.paz1c.gui.ComboBoxModels;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

public class MesiacComboBoxModel extends AbstractListModel implements ComboBoxModel {

    int mesiac;

    @Override
    public int getSize() {
        return 12;
    }

    @Override
    public Object getElementAt(int index) {
        return index + 1;
    }

    @Override
    public void setSelectedItem(Object objekt) {
        mesiac = (int) objekt;
    }

    @Override
    public Object getSelectedItem() {
        return mesiac;
    }

}
