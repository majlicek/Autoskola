package sk.upjs.ics.paz1c.gui.tableModels;

import java.util.*;
import javax.swing.table.AbstractTableModel;
import sk.upjs.ics.paz1c.autoskola.BeanFactory;
import sk.upjs.ics.paz1c.dao.StudentiDao;
import sk.upjs.ics.paz1c.entity.*;

public class StudentiTableModel extends AbstractTableModel {

    private static final int POCET_STLPCOV = 3;

    private static final String[] NAZVY_STLPCOV = {"Meno", "Priezvisko", "Kontakt"};

    private static final Class[] TYPY_STLPCOV = {
        String.class,
        String.class,
        String.class
    };

    private StudentiDao studentiDao = BeanFactory.INSTANCE.getStudentiDao();
    private List<Student> studenti = new LinkedList<>();

    @Override
    public int getRowCount() {
        return studenti.size();
    }

    @Override
    public int getColumnCount() {
        return POCET_STLPCOV;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Student vybranyStudent = studenti.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return vybranyStudent.getMeno();
            case 1:
                return vybranyStudent.getPriezvisko();
            case 2:
                return vybranyStudent.getKontakt();
            default:
                return "???";
        }
    }

    public void obnov() {
        studenti = studentiDao.dajVsetky();
        fireTableDataChanged();
    }

    public void zobrazPodlaMena(String meno) {
        studenti = studentiDao.hladajPodlaMena(meno);
        fireTableDataChanged();
    }

    public void zobrazPodlaPriezviska(String priezvisko) {
        studenti = studentiDao.hladajPodlaPriezviska(priezvisko);
        fireTableDataChanged();
    }

    public Student dajPodlaCislaRiadku(int riadok) {
        return studenti.get(riadok);
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
