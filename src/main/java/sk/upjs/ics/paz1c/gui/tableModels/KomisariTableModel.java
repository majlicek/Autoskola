/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.upjs.ics.paz1c.gui.tableModels;

import java.util.LinkedList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import sk.upjs.ics.paz1c.autoskola.BeanFactory;
import sk.upjs.ics.paz1c.dao.KomisariDao;
import sk.upjs.ics.paz1c.entity.Komisari;

public class KomisariTableModel extends AbstractTableModel {

    private static final int POCET_STLPCOV = 3;

    private static final String[] NAZVY_STLPCOV = {"Meno", "Priezvisko", "Hodnost"};

    private static final Class[] TYPY_STLPCOV = {
        String.class,
        String.class,
        String.class
    };

    private KomisariDao komisariDao = BeanFactory.INSTANCE.getKomisariDao();
    private List<Komisari> komisari = new LinkedList<>();

    @Override
    public int getRowCount() {
        return komisari.size();
    }

    @Override
    public int getColumnCount() {
        return POCET_STLPCOV;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Komisari vybranyKomisar = komisari.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return vybranyKomisar.getMeno();
            case 1:
                return vybranyKomisar.getPriezvisko();
            case 2:
                return vybranyKomisar.getHodnost();
            default:
                return "???";
        }
    }

    public void obnov() {
        komisari = komisariDao.dajVsetky();
        fireTableDataChanged();
    }

    public void zobrazPodlaMena(String meno) {
        komisari = komisariDao.hladajPodlaMena(meno);
        fireTableDataChanged();
    }

    public void zobrazPodlaPriezviska(String priezvisko) {
        komisari = komisariDao.hladajPodlaPriezviska(priezvisko);
        fireTableDataChanged();
    }

    public void zobrazPodlaHodnosti(String hodnost) {
        komisari = komisariDao.hladajPodlaHodnosti(hodnost);
        fireTableDataChanged();
    }
    
    public Komisari dajPodlaCislaRiadku(int riadok) {
        return komisari.get(riadok);
    }

    @Override
    public String getColumnName(int column) {
        return NAZVY_STLPCOV[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return TYPY_STLPCOV[columnIndex];
    }}