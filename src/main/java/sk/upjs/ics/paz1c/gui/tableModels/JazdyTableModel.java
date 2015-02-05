package sk.upjs.ics.paz1c.gui.tableModels;

import java.sql.Date;
import java.util.LinkedList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import sk.upjs.ics.paz1c.autoskola.BeanFactory;
import sk.upjs.ics.paz1c.dao.JazdyDao;
import sk.upjs.ics.paz1c.entity.Jazda;

public class JazdyTableModel extends AbstractTableModel {

    private static final int POCET_STLPCOV = 3;

    private static final String[] NAZVY_STLPCOV = {"Datum", "Student", "Instruktor"};

    private static final Class[] TYPY_STLPCOV = {
        Date.class,
        String.class,
        String.class
    };

    private JazdyDao jazdyDao = BeanFactory.INSTANCE.getJazdyDao();
    private List<Jazda> jazdy = new LinkedList<>();

    @Override
    public int getRowCount() {
        return jazdy.size();
    }

    @Override
    public int getColumnCount() {
        return POCET_STLPCOV;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Jazda vybranaJazda = jazdy.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return vybranaJazda.getDatum();
            case 1:
                return vybranaJazda.getStudent().getMeno() + " " + vybranaJazda.getStudent().getPriezvisko();
            case 2:
                return vybranaJazda.getInstruktor().getMeno() + " " + vybranaJazda.getInstruktor().getPriezvisko();
            default:
                return "???";
        }
    }

    public void obnov() {
        jazdy = jazdyDao.dajVsetky();
        fireTableDataChanged();
    }

    public void zobrazPodlaDatumu(String datum) {
        jazdy = jazdyDao.hladajPodlaDatumu(datum);
        fireTableDataChanged();
    }

    public void zobrazPodlaStudenta(String student) {
        jazdy = jazdyDao.hladajPodlaStudenta(student);
        fireTableDataChanged();
    }

    public void zobrazPodlaInstruktora(String instruktor) {
        jazdy = jazdyDao.hladajPodlaInstruktora(instruktor);
        fireTableDataChanged();
    }

    public Jazda dajPodlaCislaRiadku(int riadok) {
        return jazdy.get(riadok);
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
