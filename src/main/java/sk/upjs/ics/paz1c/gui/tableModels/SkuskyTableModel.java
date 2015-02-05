package sk.upjs.ics.paz1c.gui.tableModels;

import java.util.LinkedList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import sk.upjs.ics.paz1c.autoskola.BeanFactory;
import sk.upjs.ics.paz1c.dao.SkuskyDao;
import sk.upjs.ics.paz1c.entity.Skuska;

public class SkuskyTableModel extends AbstractTableModel {

    private static final int POCET_STLPCOV = 4;

    private static final String[] NAZVY_STLPCOV = {"Datum", "Cas", "Pocet prihlasenych", "Instruktor"};

    /*
    private static final Class[] TYPY_STLPCOV = {
     Date.class,
     Time.class,
     Integer.class,
     String.class
     };
    */
    
    private SkuskyDao skuskyDao = BeanFactory.INSTANCE.getSkuskyDao();
    private List<Skuska> skusky = new LinkedList<>();

    @Override
    public int getRowCount() {
        return skusky.size();
    }

    @Override
    public int getColumnCount() {
        return POCET_STLPCOV;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Skuska vybranaSkuska = skusky.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return vybranaSkuska.getDatum();
            case 1:
                return vybranaSkuska.getCas();
            case 2:
                return vybranaSkuska.getStudenti().size();
            case 3:
                return vybranaSkuska.getInstruktor().getMeno() + " " + vybranaSkuska.getInstruktor().getPriezvisko();
            default:
                return "???";
        }
    }

    public void obnov() {
        skusky = skuskyDao.dajVsetky();
        fireTableDataChanged();
    }

    public void zobrazPodlaDatumu(String datum) {
        skusky = skuskyDao.hladajPodlaDatumu(datum);
        fireTableDataChanged();
    }

    public void zobrazPodlaStudenta(String student) {
        skusky = skuskyDao.hladajPodlaStudenta(student);
        fireTableDataChanged();
    }

    public void zobrazPodlaInstruktora(String instruktor) {
        skusky = skuskyDao.hladajPodlaInstruktora(instruktor);
        fireTableDataChanged();
    }

    public Skuska dajPodlaCislaRiadku(int riadok) {
        return skusky.get(riadok);
    }

    @Override
    public String getColumnName(int column) {
        return NAZVY_STLPCOV[column];
    }
    
    /*
     @Override
     public Class<?> getColumnClass(int columnIndex) {
     return TYPY_STLPCOV[columnIndex];
     }
     */
}
