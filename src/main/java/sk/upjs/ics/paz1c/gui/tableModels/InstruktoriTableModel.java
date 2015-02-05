package sk.upjs.ics.paz1c.gui.tableModels;

import java.util.LinkedList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import sk.upjs.ics.paz1c.autoskola.BeanFactory;
import sk.upjs.ics.paz1c.dao.InstruktoriDao;
import sk.upjs.ics.paz1c.entity.Instruktor;

public class InstruktoriTableModel extends AbstractTableModel {

    private static final int POCET_STLPCOV = 3;

    private static final String[] NAZVY_STLPCOV = {"Meno", "Priezvisko", "Kontakt"};

    private static final Class[] TYPY_STLPCOV = {
        String.class,
        String.class,
        String.class
    };

    private InstruktoriDao instruktoriDao = BeanFactory.INSTANCE.getInstruktoriDao();
    private List<Instruktor> instruktori = new LinkedList<>();

    @Override
    public int getRowCount() {
        return instruktori.size();
    }

    @Override
    public int getColumnCount() {
        return POCET_STLPCOV;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Instruktor vybranyInstruktor = instruktori.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return vybranyInstruktor.getMeno();
            case 1:
                return vybranyInstruktor.getPriezvisko();
            case 2:
                return vybranyInstruktor.getKontakt();
            default:
                return "???";
        }
    }

    public void obnov() {
        instruktori = instruktoriDao.dajVsetky();
        fireTableDataChanged();
    }

    public void zobrazPodlaMena(String meno) {
        instruktori = instruktoriDao.hladajPodlaMena(meno);
        fireTableDataChanged();
    }

    public void zobrazPodlaPriezviska(String priezvisko) {
        instruktori = instruktoriDao.hladajPodlaPriezviska(priezvisko);
        fireTableDataChanged();
    }

    public Instruktor dajPodlaCislaRiadku(int riadok) {
        return instruktori.get(riadok);
    }

    @Override
    public String getColumnName(int column) {
        return NAZVY_STLPCOV[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return TYPY_STLPCOV[columnIndex];
    }

}
