package sk.upjs.ics.paz1c.gui.tableModels;

import java.sql.Date;
import java.util.LinkedList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import sk.upjs.ics.paz1c.autoskola.BeanFactory;
import sk.upjs.ics.paz1c.dao.StudentiDao;
import sk.upjs.ics.paz1c.entity.*;
import sk.upjs.ics.paz1c.filtre.StudentiFilter;

public class RozsirenyStudentiTableModel extends AbstractTableModel {

    private static final int POCET_STLPCOV = 10;

    private static final String[] NAZVY_STLPCOV = {"Meno", "Priezvisko", "Bydlisko",
        "Datum narodenia", "Kontakt", "Prva pomoc", "Pocet pokusov", "Pocet bodov", "Cvicisko", "Jazda"};

    private static final Class[] TYPY_STLPCOV = {
        String.class,
        String.class,
        String.class,
        Date.class,
        String.class,
        String.class,
        Integer.class,
        Integer.class,
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
                return vybranyStudent.getBydlisko();
            case 3:
                return vybranyStudent.getDatumNarodenia();
            case 4:
                return vybranyStudent.getKontakt();
            case 5:
                if (vybranyStudent.isPrvaPomoc()) {
                    return "ano";
                } else {
                    return "nie";
                }
            case 6:
                return vybranyStudent.getPocetPokusov();
            case 7:
                return vybranyStudent.getPocetBodov();
            case 8:
                if (vybranyStudent.isCvicisko()) {
                    return "ano";
                } else {
                    return "nie";
                }
            case 9:
                if (vybranyStudent.isJazda()) {
                    return "ano";
                } else {
                    return "nie";
                }
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

    public void zobrazPodlaFiltra(StudentiFilter filter) {
        studenti = studentiDao.hladajPodlaFiltra(filter);
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
