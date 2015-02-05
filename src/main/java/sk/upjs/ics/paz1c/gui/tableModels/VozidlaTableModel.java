package sk.upjs.ics.paz1c.gui.tableModels;

import java.util.LinkedList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import sk.upjs.ics.paz1c.autoskola.BeanFactory;
import sk.upjs.ics.paz1c.dao.VozidlaDao;
import sk.upjs.ics.paz1c.entity.Vozidlo;

public class VozidlaTableModel extends AbstractTableModel {

    private static final int POCET_STLPCOV = 3;

    private static final String[] NAZVY_STLPCOV = {"SPZ", "Znacka", "Kategoria"};

    private static final Class[] TYPY_STLPCOV = {
        String.class,
        String.class,
        String.class
    };

    private VozidlaDao vozidlaDao = BeanFactory.INSTANCE.getVozidlaDao();
    private List<Vozidlo> vozidla = new LinkedList<>();

    @Override
    public int getRowCount() {
        return vozidla.size();
    }

    @Override
    public int getColumnCount() {
        return POCET_STLPCOV;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Vozidlo vybraneVozidlo = vozidla.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return vybraneVozidlo.getSpz();
            case 1:
                return vybraneVozidlo.getZnacka();
            case 2:
                return vybraneVozidlo.getKategoria();
            default:
                return "???";
        }
    }

    public void obnov() {
        vozidla = vozidlaDao.dajVsetky();
        fireTableDataChanged();
    }

    public void zobrazPodlaSpz(String spz) {
        vozidla = vozidlaDao.hladajPodlaSpz(spz);
        fireTableDataChanged();
    }

    public void zobrazPodlaZnacky(String znacka) {
        vozidla = vozidlaDao.hladajPodlaZnacky(znacka);
        fireTableDataChanged();
    }

    public void zobrazPodlaKategorie(String kategoria) {
        vozidla = vozidlaDao.hladajPodlaKategorie(kategoria);
        fireTableDataChanged();
    }

    public Vozidlo dajPodlaCislaRiadku(int riadok) {
        return vozidla.get(riadok);
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
