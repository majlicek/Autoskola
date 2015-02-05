package sk.upjs.ics.paz1c.gui.tableModels;

import java.util.LinkedList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import sk.upjs.ics.paz1c.autoskola.BeanFactory;
import sk.upjs.ics.paz1c.dao.JazdyDao;
import sk.upjs.ics.paz1c.entity.Jazda;
import sk.upjs.ics.paz1c.filtre.JazdyFilter;

public class RozsirenyJazdyTableModel extends AbstractTableModel {

    private static final int POCET_STLPCOV = 9;

    private static final String[] NAZVY_STLPCOV = {"Datum", "Cas", "Student",
        "Instruktor", "Vozidlo", "KM", "V premavke", "Na cvicisku", "S vozikom"};

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
                return vybranaJazda.getCas();
            case 2:
                return vybranaJazda.getStudent().getMeno() + " " + vybranaJazda.getStudent().getPriezvisko();
            case 3:
                return vybranaJazda.getInstruktor().getMeno() + " " + vybranaJazda.getInstruktor().getPriezvisko();
            case 4:
                return vybranaJazda.getVozidlo().getSpz();
            case 5:
                return vybranaJazda.getKm();
            case 6:
                if (vybranaJazda.isvPremavke()) {
                    return "ano";
                } else {
                    return "nie";
                }
            case 7:
                if (vybranaJazda.isNaCvicisku()) {
                    return "ano";
                } else {
                    return "nie";
                }
            case 8:
                if (vybranaJazda.issVozikom()) {
                    return "ano";
                } else {
                    return "nie";
                }
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

    public void zobrazPodlaFiltra(JazdyFilter filter) {
        jazdy = jazdyDao.hladajPodlaFiltra(filter);
        fireTableDataChanged();
    }

    public Jazda dajPodlaCislaRiadku(int riadok) {
        return jazdy.get(riadok);
    }

    @Override
    public String getColumnName(int column) {
        return NAZVY_STLPCOV[column];
    }

}
