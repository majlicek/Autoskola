package sk.upjs.ics.paz1c.gui;

import sk.upjs.ics.paz1c.gui.tableModels.*;
import javax.swing.JOptionPane;
import sk.upjs.ics.paz1c.dao.*;
import sk.upjs.ics.paz1c.entity.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableRowSorter;
import sk.upjs.ics.paz1c.autoskola.BeanFactory;

public class HlavnyFormular extends javax.swing.JFrame {

    private JazdyDao jazdyDao = BeanFactory.INSTANCE.getJazdyDao();
    private JazdyTableModel jazdyTableModel = new JazdyTableModel();
    private TableRowSorter jazdyRowSorter = new TableRowSorter(jazdyTableModel);

    private SkuskyDao skuskyDao = BeanFactory.INSTANCE.getSkuskyDao();
    private SkuskyTableModel skuskyTableModel = new SkuskyTableModel();
    private TableRowSorter skuskyRowSorter = new TableRowSorter(skuskyTableModel);

    private StudentiDao studentiDao = BeanFactory.INSTANCE.getStudentiDao();
    private StudentiTableModel studentiTableModel = new StudentiTableModel();
    private TableRowSorter studentiRowSorter = new TableRowSorter(studentiTableModel);

    private InstruktoriDao instruktoriDao = BeanFactory.INSTANCE.getInstruktoriDao();
    private InstruktoriTableModel instruktoriTableModel = new InstruktoriTableModel();
    private TableRowSorter instruktoriRowSorter = new TableRowSorter(instruktoriTableModel);

    private VozidlaDao vozidlaDao = BeanFactory.INSTANCE.getVozidlaDao();
    private VozidlaTableModel vozidlaTableModel = new VozidlaTableModel();
    private TableRowSorter vozidlaRowSorter = new TableRowSorter(vozidlaTableModel);
    
    private KomisariDao komisariDao = BeanFactory.INSTANCE.getKomisariDao();
    private KomisariTableModel komisariTableModel = new KomisariTableModel();
    private TableRowSorter komisariRowSorter = new TableRowSorter(komisariTableModel);

    public HlavnyFormular() {
        initComponents();
        nastavJazdy();
        nastavSkusky();
        nastavStudenti();
        nastavInstruktori();
        nastavVozidla();
        nastavKomisari();
    }

    private void nastavJazdy() {
        tblJazdy.setModel(jazdyTableModel);

        tblJazdy.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                tblJazdySelectionValueChanged(e);
            }
        });

        rbtnJazdyDatum.doClick();
        aktualizujZoznamJazd();
    }

    private void tblJazdySelectionValueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
            if (!tblJazdy.getSelectionModel().isSelectionEmpty()) {
                btnJazdyUprav.setEnabled(true);
                btnJazdyVymaz.setEnabled(true);
                btnJazdyDetail.setEnabled(true);
            } else {
                btnJazdyUprav.setEnabled(false);
                btnJazdyVymaz.setEnabled(false);
                btnJazdyDetail.setEnabled(false);
            }
        }
    }

    public void aktualizujZoznamJazd() {
        jazdyTableModel.obnov();
    }

    private void nastavSkusky() {
        tblSkusky.setModel(skuskyTableModel);

        tblSkusky.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                tblSkuskySelectionValueChanged(e);
            }
        });

        rbtnSkuskyDatum.doClick();
        aktualizujZoznamSkusok();
    }

    private void tblSkuskySelectionValueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
            if (!tblSkusky.getSelectionModel().isSelectionEmpty()) {
                btnSkuskyUprav.setEnabled(true);
                btnSkuskyVymaz.setEnabled(true);
                btnSkuskyDetail.setEnabled(true);
            } else {
                btnSkuskyUprav.setEnabled(false);
                btnSkuskyVymaz.setEnabled(false);
                btnSkuskyDetail.setEnabled(false);
            }
        }
    }

    public void aktualizujZoznamSkusok() {
        skuskyTableModel.obnov();
    }

    private void nastavStudenti() {
        tblStudenti.setModel(studentiTableModel);

        tblStudenti.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                tblStudentiSelectionValueChanged(e);
            }
        });

        rbtnStudentiMeno.doClick();
        aktualizujZoznamStudentov();
    }

    private void tblStudentiSelectionValueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
            if (!tblStudenti.getSelectionModel().isSelectionEmpty()) {
                btnStudentiUprav.setEnabled(true);
                btnStudentiVymaz.setEnabled(true);
                btnStudentiDetail.setEnabled(true);
            } else {
                btnStudentiUprav.setEnabled(false);
                btnStudentiVymaz.setEnabled(false);
                btnStudentiDetail.setEnabled(false);
            }
        }
    }

    public void aktualizujZoznamStudentov() {
        studentiTableModel.obnov();
    }

    private void nastavInstruktori() {
        tblInstruktori.setModel(instruktoriTableModel);

        tblInstruktori.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                tblInstruktoriSelectionValueChanged(e);
            }
        });

        rbtnInstruktoriMeno.doClick();
        aktualizujZoznamInstruktorov();
    }

    private void tblInstruktoriSelectionValueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
            if (!tblInstruktori.getSelectionModel().isSelectionEmpty()) {
                btnInstruktoriUprav.setEnabled(true);
                btnInstruktoriVymaz.setEnabled(true);
                btnInstruktoriDetail.setEnabled(true);
            } else {
                btnInstruktoriUprav.setEnabled(false);
                btnInstruktoriVymaz.setEnabled(false);
                btnInstruktoriDetail.setEnabled(false);
            }
        }
    }

    public void aktualizujZoznamInstruktorov() {
        instruktoriTableModel.obnov();
    }

    private void nastavVozidla() {
        tblVozidla.setModel(vozidlaTableModel);

        tblVozidla.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                tblVozidlaSelectionValueChanged(e);
            }
        });

        rbtnVozidlaSpz.doClick();
        aktualizujZoznamVozidiel();
    }

    private void tblVozidlaSelectionValueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
            if (!tblVozidla.getSelectionModel().isSelectionEmpty()) {
                btnVozidlaUprav.setEnabled(true);
                btnVozidlaVymaz.setEnabled(true);
                btnVozidlaDetail.setEnabled(true);
            } else {
                btnVozidlaUprav.setEnabled(false);
                btnVozidlaVymaz.setEnabled(false);
                btnVozidlaDetail.setEnabled(false);
            }
        }
    }

    public void aktualizujZoznamVozidiel() {
        vozidlaTableModel.obnov();
    }

    private void nastavKomisari() {
        tblKomisari.setModel(komisariTableModel);

        tblKomisari.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                tblKomisariSelectionValueChanged(e);
            }
        });

        rbtnKomisariMeno.doClick();
        aktualizujZoznamKomisarov();
    }

    private void tblKomisariSelectionValueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
            if (!tblKomisari.getSelectionModel().isSelectionEmpty()) {
                btnKomisariUprav.setEnabled(true);
                btnKomisariVymaz.setEnabled(true);
                btnKomisariDetail.setEnabled(true);
            } else {
                btnKomisariUprav.setEnabled(false);
                btnKomisariVymaz.setEnabled(false);
                btnKomisariDetail.setEnabled(false);
            }
        }
    }

    public void aktualizujZoznamKomisarov() {
        komisariTableModel.obnov();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btngJazdy = new javax.swing.ButtonGroup();
        btngSkusky = new javax.swing.ButtonGroup();
        btngStudenti = new javax.swing.ButtonGroup();
        btngInstruktori = new javax.swing.ButtonGroup();
        btngVozidla = new javax.swing.ButtonGroup();
        tabbedPaneHlavny = new javax.swing.JTabbedPane();
        paneJazdy = new javax.swing.JPanel();
        txtJazdyHladaj = new javax.swing.JTextField();
        btnJazdyHladaj = new javax.swing.JButton();
        lblJazdyHladajPodla = new javax.swing.JLabel();
        rbtnJazdyStudent = new javax.swing.JRadioButton();
        rbtnJazdyInstruktor = new javax.swing.JRadioButton();
        rbtnJazdyDatum = new javax.swing.JRadioButton();
        btnJazdyVynuluj = new javax.swing.JButton();
        scrollPaneJazdy = new javax.swing.JScrollPane();
        tblJazdy = new javax.swing.JTable();
        btnJazdyRozsireneVyhladavanie = new javax.swing.JButton();
        btnJazdyDetail = new javax.swing.JButton();
        btnJazdyUprav = new javax.swing.JButton();
        btnJazdyVymaz = new javax.swing.JButton();
        btnJazdyPridaj = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        paneSkusky = new javax.swing.JPanel();
        txtSkuskyHladaj = new javax.swing.JTextField();
        btnSkuskyHladaj = new javax.swing.JButton();
        btnSkuskyVynuluj = new javax.swing.JButton();
        lblSkuskyHladajPodla = new javax.swing.JLabel();
        rbtnSkuskyDatum = new javax.swing.JRadioButton();
        rbtnSkuskyStudent = new javax.swing.JRadioButton();
        rbtnSkuskyInstruktor = new javax.swing.JRadioButton();
        scrollPaneSkusky = new javax.swing.JScrollPane();
        tblSkusky = new javax.swing.JTable();
        btnSkuskyVymaz = new javax.swing.JButton();
        btnSkuskyUprav = new javax.swing.JButton();
        btnSkuskyDetail = new javax.swing.JButton();
        btnSkuskyPridaj = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        paneStudenti = new javax.swing.JPanel();
        txtStudentiHladaj = new javax.swing.JTextField();
        btnStudentiHladaj = new javax.swing.JButton();
        btnStudentiVynuluj = new javax.swing.JButton();
        lblStudentiHladajPodla = new javax.swing.JLabel();
        rbtnStudentiMeno = new javax.swing.JRadioButton();
        rbtnStudentiPriezvisko = new javax.swing.JRadioButton();
        scrollPaneStudenti = new javax.swing.JScrollPane();
        tblStudenti = new javax.swing.JTable();
        btnStudentiRozsireneVyhladavanie = new javax.swing.JButton();
        btnStudentiVymaz = new javax.swing.JButton();
        btnStudentiUprav = new javax.swing.JButton();
        btnStudentiDetail = new javax.swing.JButton();
        btnStudentiPridaj = new javax.swing.JButton();
        paneInstruktori = new javax.swing.JPanel();
        txtInstruktoriHladaj = new javax.swing.JTextField();
        btnInstruktoriHladaj = new javax.swing.JButton();
        btnInstruktoriVynuluj = new javax.swing.JButton();
        lblInstruktoriHladajPodla = new javax.swing.JLabel();
        rbtnInstruktoriMeno = new javax.swing.JRadioButton();
        rbtnInstruktoriPriezvisko = new javax.swing.JRadioButton();
        scrollPaneInstruktori = new javax.swing.JScrollPane();
        tblInstruktori = new javax.swing.JTable();
        btnInstruktoriVymaz = new javax.swing.JButton();
        btnInstruktoriUprav = new javax.swing.JButton();
        btnInstruktoriDetail = new javax.swing.JButton();
        btnInstruktoriPridaj = new javax.swing.JButton();
        paneVozidla = new javax.swing.JPanel();
        txtVozidlaHladaj = new javax.swing.JTextField();
        btnVozidlaHladaj = new javax.swing.JButton();
        btnVozidlaVynuluj = new javax.swing.JButton();
        lblVozidlaHladajPodla = new javax.swing.JLabel();
        rbtnVozidlaSpz = new javax.swing.JRadioButton();
        rbtnVozidlaZnacka = new javax.swing.JRadioButton();
        rbtnVozidlaKategoria = new javax.swing.JRadioButton();
        scrollPaneVozidla = new javax.swing.JScrollPane();
        tblVozidla = new javax.swing.JTable();
        btnVozidlaVymaz = new javax.swing.JButton();
        btnVozidlaUprav = new javax.swing.JButton();
        btnVozidlaDetail = new javax.swing.JButton();
        btnVozidlaPridaj = new javax.swing.JButton();
        paneKomisari = new javax.swing.JPanel();
        txtKomisariHladaj = new javax.swing.JTextField();
        btnKomisariHladaj = new javax.swing.JButton();
        btnKomisariVynuluj = new javax.swing.JButton();
        lblKomisariHladajPodla1 = new javax.swing.JLabel();
        rbtnKomisariMeno = new javax.swing.JRadioButton();
        rbtnKomisariPriezvisko = new javax.swing.JRadioButton();
        rbtnKomisariHodnost = new javax.swing.JRadioButton();
        scrollPaneVozidla1 = new javax.swing.JScrollPane();
        tblKomisari = new javax.swing.JTable();
        btnKomisariVymaz = new javax.swing.JButton();
        btnKomisariUprav = new javax.swing.JButton();
        btnKomisariDetail = new javax.swing.JButton();
        btnKomisariPridaj = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Autoskola");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setName("hlavnyFrame"); // NOI18N
        setResizable(false);

        btnJazdyHladaj.setText("Hladaj");
        btnJazdyHladaj.setPreferredSize(new java.awt.Dimension(70, 25));
        btnJazdyHladaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJazdyHladajActionPerformed(evt);
            }
        });

        lblJazdyHladajPodla.setText("Hladaj podla:");

        btngJazdy.add(rbtnJazdyStudent);
        rbtnJazdyStudent.setText("Studenta");

        btngJazdy.add(rbtnJazdyInstruktor);
        rbtnJazdyInstruktor.setText("Instruktora");

        btngJazdy.add(rbtnJazdyDatum);
        rbtnJazdyDatum.setText("Datumu");

        btnJazdyVynuluj.setText("Vynuluj");
        btnJazdyVynuluj.setPreferredSize(new java.awt.Dimension(70, 25));
        btnJazdyVynuluj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJazdyVynulujActionPerformed(evt);
            }
        });

        tblJazdy.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblJazdy.setRowSorter(jazdyRowSorter);
        tblJazdy.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblJazdyMouseClicked(evt);
            }
        });
        scrollPaneJazdy.setViewportView(tblJazdy);

        btnJazdyRozsireneVyhladavanie.setText("Rozsirene vyhladavanie");
        btnJazdyRozsireneVyhladavanie.setPreferredSize(new java.awt.Dimension(145, 25));
        btnJazdyRozsireneVyhladavanie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJazdyRozsireneVyhladavanieActionPerformed(evt);
            }
        });

        btnJazdyDetail.setText("Detail");
        btnJazdyDetail.setEnabled(false);
        btnJazdyDetail.setPreferredSize(new java.awt.Dimension(70, 25));
        btnJazdyDetail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJazdyDetailActionPerformed(evt);
            }
        });

        btnJazdyUprav.setText("Uprav");
        btnJazdyUprav.setEnabled(false);
        btnJazdyUprav.setPreferredSize(new java.awt.Dimension(70, 25));
        btnJazdyUprav.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJazdyUpravActionPerformed(evt);
            }
        });

        btnJazdyVymaz.setText("Vymaz");
        btnJazdyVymaz.setEnabled(false);
        btnJazdyVymaz.setPreferredSize(new java.awt.Dimension(70, 25));
        btnJazdyVymaz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJazdyVymazActionPerformed(evt);
            }
        });

        btnJazdyPridaj.setText("Pridaj");
        btnJazdyPridaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJazdyPridajActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("?");
        jLabel2.setToolTipText("<html>\nDatum:<br>\nzadavajte v tvare \"RRRR-MM-DD\"<br>\n<br>\nStudent/Instruktor:<br>\nvyhladavanie podla mena, priezviska, mena aj priezviska\n</html>");
        jLabel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout paneJazdyLayout = new javax.swing.GroupLayout(paneJazdy);
        paneJazdy.setLayout(paneJazdyLayout);
        paneJazdyLayout.setHorizontalGroup(
            paneJazdyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneJazdyLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paneJazdyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollPaneJazdy, javax.swing.GroupLayout.DEFAULT_SIZE, 755, Short.MAX_VALUE)
                    .addGroup(paneJazdyLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lblJazdyHladajPodla)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rbtnJazdyDatum)
                        .addGap(18, 18, 18)
                        .addComponent(rbtnJazdyStudent)
                        .addGap(18, 18, 18)
                        .addComponent(rbtnJazdyInstruktor)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnJazdyVynuluj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(paneJazdyLayout.createSequentialGroup()
                        .addComponent(btnJazdyRozsireneVyhladavanie, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnJazdyPridaj, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnJazdyVymaz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnJazdyUprav, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnJazdyDetail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(paneJazdyLayout.createSequentialGroup()
                        .addComponent(txtJazdyHladaj)
                        .addGap(18, 18, 18)
                        .addComponent(btnJazdyHladaj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        paneJazdyLayout.setVerticalGroup(
            paneJazdyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneJazdyLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paneJazdyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtJazdyHladaj, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnJazdyHladaj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(paneJazdyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblJazdyHladajPodla, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbtnJazdyDatum, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbtnJazdyStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbtnJazdyInstruktor, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnJazdyVynuluj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrollPaneJazdy, javax.swing.GroupLayout.DEFAULT_SIZE, 447, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(paneJazdyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnJazdyRozsireneVyhladavanie, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnJazdyDetail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnJazdyUprav, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnJazdyVymaz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnJazdyPridaj, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        tabbedPaneHlavny.addTab("Jazdy", paneJazdy);

        btnSkuskyHladaj.setText("Hladaj");
        btnSkuskyHladaj.setPreferredSize(new java.awt.Dimension(70, 25));
        btnSkuskyHladaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSkuskyHladajActionPerformed(evt);
            }
        });

        btnSkuskyVynuluj.setText("Vynuluj");
        btnSkuskyVynuluj.setPreferredSize(new java.awt.Dimension(70, 25));
        btnSkuskyVynuluj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSkuskyVynulujActionPerformed(evt);
            }
        });

        lblSkuskyHladajPodla.setText("Hladaj podla:");

        btngSkusky.add(rbtnSkuskyDatum);
        rbtnSkuskyDatum.setText("Datumu");

        btngSkusky.add(rbtnSkuskyStudent);
        rbtnSkuskyStudent.setText("Studenta");

        btngSkusky.add(rbtnSkuskyInstruktor);
        rbtnSkuskyInstruktor.setText("Instruktora");

        tblSkusky.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblSkusky.setRowSorter(skuskyRowSorter);
        tblSkusky.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSkuskyMouseClicked(evt);
            }
        });
        scrollPaneSkusky.setViewportView(tblSkusky);

        btnSkuskyVymaz.setText("Vymaz");
        btnSkuskyVymaz.setEnabled(false);
        btnSkuskyVymaz.setPreferredSize(new java.awt.Dimension(70, 25));
        btnSkuskyVymaz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSkuskyVymazActionPerformed(evt);
            }
        });

        btnSkuskyUprav.setText("Uprav");
        btnSkuskyUprav.setEnabled(false);
        btnSkuskyUprav.setPreferredSize(new java.awt.Dimension(70, 25));
        btnSkuskyUprav.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSkuskyUpravActionPerformed(evt);
            }
        });

        btnSkuskyDetail.setText("Detail");
        btnSkuskyDetail.setEnabled(false);
        btnSkuskyDetail.setPreferredSize(new java.awt.Dimension(70, 25));
        btnSkuskyDetail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSkuskyDetailActionPerformed(evt);
            }
        });

        btnSkuskyPridaj.setText("Pridaj");
        btnSkuskyPridaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSkuskyPridajActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("?");
        jLabel1.setToolTipText("<html>\nDatum:<br>\nzadavajte v tvare \"RRRR-MM-DD\"<br>\n<br>\nStudent/Instruktor:<br>\nvyhladavanie podla mena, priezviska, mena aj priezviska\n</html>");
        jLabel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout paneSkuskyLayout = new javax.swing.GroupLayout(paneSkusky);
        paneSkusky.setLayout(paneSkuskyLayout);
        paneSkuskyLayout.setHorizontalGroup(
            paneSkuskyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneSkuskyLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paneSkuskyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paneSkuskyLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lblSkuskyHladajPodla)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rbtnSkuskyDatum)
                        .addGap(18, 18, 18)
                        .addComponent(rbtnSkuskyStudent)
                        .addGap(18, 18, 18)
                        .addComponent(rbtnSkuskyInstruktor)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSkuskyVynuluj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(scrollPaneSkusky, javax.swing.GroupLayout.DEFAULT_SIZE, 755, Short.MAX_VALUE)
                    .addGroup(paneSkuskyLayout.createSequentialGroup()
                        .addComponent(txtSkuskyHladaj)
                        .addGap(18, 18, 18)
                        .addComponent(btnSkuskyHladaj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneSkuskyLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSkuskyPridaj, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSkuskyVymaz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSkuskyUprav, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSkuskyDetail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        paneSkuskyLayout.setVerticalGroup(
            paneSkuskyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneSkuskyLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paneSkuskyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSkuskyHladaj, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSkuskyHladaj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(paneSkuskyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSkuskyHladajPodla, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbtnSkuskyDatum, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbtnSkuskyStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbtnSkuskyInstruktor, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSkuskyVynuluj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrollPaneSkusky, javax.swing.GroupLayout.DEFAULT_SIZE, 447, Short.MAX_VALUE)
                .addGap(11, 11, 11)
                .addGroup(paneSkuskyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSkuskyDetail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSkuskyUprav, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSkuskyVymaz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSkuskyPridaj, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        tabbedPaneHlavny.addTab("Skusky", paneSkusky);

        btnStudentiHladaj.setText("Hladaj");
        btnStudentiHladaj.setPreferredSize(new java.awt.Dimension(70, 25));
        btnStudentiHladaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStudentiHladajActionPerformed(evt);
            }
        });

        btnStudentiVynuluj.setText("Vynuluj");
        btnStudentiVynuluj.setPreferredSize(new java.awt.Dimension(70, 25));
        btnStudentiVynuluj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStudentiVynulujActionPerformed(evt);
            }
        });

        lblStudentiHladajPodla.setText("Hladaj podla:");

        btngStudenti.add(rbtnStudentiMeno);
        rbtnStudentiMeno.setText("Mena");

        btngStudenti.add(rbtnStudentiPriezvisko);
        rbtnStudentiPriezvisko.setText("Priezviska");

        tblStudenti.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblStudenti.setRowSorter(studentiRowSorter);
        tblStudenti.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblStudentiMouseClicked(evt);
            }
        });
        scrollPaneStudenti.setViewportView(tblStudenti);

        btnStudentiRozsireneVyhladavanie.setText("Rozsirene vyhladavanie");
        btnStudentiRozsireneVyhladavanie.setPreferredSize(new java.awt.Dimension(145, 25));
        btnStudentiRozsireneVyhladavanie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStudentiRozsireneVyhladavanieActionPerformed(evt);
            }
        });

        btnStudentiVymaz.setText("Vymaz");
        btnStudentiVymaz.setEnabled(false);
        btnStudentiVymaz.setPreferredSize(new java.awt.Dimension(70, 25));
        btnStudentiVymaz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStudentiVymazActionPerformed(evt);
            }
        });

        btnStudentiUprav.setText("Uprav");
        btnStudentiUprav.setEnabled(false);
        btnStudentiUprav.setPreferredSize(new java.awt.Dimension(70, 25));
        btnStudentiUprav.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStudentiUpravActionPerformed(evt);
            }
        });

        btnStudentiDetail.setText("Detail");
        btnStudentiDetail.setEnabled(false);
        btnStudentiDetail.setPreferredSize(new java.awt.Dimension(70, 25));
        btnStudentiDetail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStudentiDetailActionPerformed(evt);
            }
        });

        btnStudentiPridaj.setText("Pridaj");
        btnStudentiPridaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStudentiPridajActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout paneStudentiLayout = new javax.swing.GroupLayout(paneStudenti);
        paneStudenti.setLayout(paneStudentiLayout);
        paneStudentiLayout.setHorizontalGroup(
            paneStudentiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneStudentiLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paneStudentiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollPaneStudenti, javax.swing.GroupLayout.DEFAULT_SIZE, 755, Short.MAX_VALUE)
                    .addGroup(paneStudentiLayout.createSequentialGroup()
                        .addComponent(btnStudentiRozsireneVyhladavanie, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnStudentiPridaj, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnStudentiVymaz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnStudentiUprav, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnStudentiDetail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(paneStudentiLayout.createSequentialGroup()
                        .addComponent(txtStudentiHladaj)
                        .addGap(18, 18, 18)
                        .addComponent(btnStudentiHladaj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(paneStudentiLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lblStudentiHladajPodla)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rbtnStudentiMeno)
                        .addGap(18, 18, 18)
                        .addComponent(rbtnStudentiPriezvisko)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnStudentiVynuluj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        paneStudentiLayout.setVerticalGroup(
            paneStudentiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneStudentiLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paneStudentiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtStudentiHladaj, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnStudentiHladaj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(paneStudentiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblStudentiHladajPodla, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbtnStudentiMeno, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbtnStudentiPriezvisko, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnStudentiVynuluj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrollPaneStudenti, javax.swing.GroupLayout.DEFAULT_SIZE, 447, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(paneStudentiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnStudentiRozsireneVyhladavanie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnStudentiDetail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnStudentiUprav, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnStudentiVymaz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnStudentiPridaj, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        tabbedPaneHlavny.addTab("Studenti", paneStudenti);

        btnInstruktoriHladaj.setText("Hladaj");
        btnInstruktoriHladaj.setPreferredSize(new java.awt.Dimension(70, 25));
        btnInstruktoriHladaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInstruktoriHladajActionPerformed(evt);
            }
        });

        btnInstruktoriVynuluj.setText("Vynuluj");
        btnInstruktoriVynuluj.setPreferredSize(new java.awt.Dimension(70, 25));
        btnInstruktoriVynuluj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInstruktoriVynulujActionPerformed(evt);
            }
        });

        lblInstruktoriHladajPodla.setText("Hladaj podla:");

        btngInstruktori.add(rbtnInstruktoriMeno);
        rbtnInstruktoriMeno.setText("Mena");
        rbtnInstruktoriMeno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnInstruktoriMenoActionPerformed(evt);
            }
        });

        btngInstruktori.add(rbtnInstruktoriPriezvisko);
        rbtnInstruktoriPriezvisko.setText("Priezviska");
        rbtnInstruktoriPriezvisko.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnInstruktoriPriezviskoActionPerformed(evt);
            }
        });

        tblInstruktori.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblInstruktori.setRowSorter(instruktoriRowSorter);
        tblInstruktori.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblInstruktoriMouseClicked(evt);
            }
        });
        scrollPaneInstruktori.setViewportView(tblInstruktori);

        btnInstruktoriVymaz.setText("Vymaz");
        btnInstruktoriVymaz.setEnabled(false);
        btnInstruktoriVymaz.setPreferredSize(new java.awt.Dimension(70, 25));
        btnInstruktoriVymaz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInstruktoriVymazActionPerformed(evt);
            }
        });

        btnInstruktoriUprav.setText("Uprav");
        btnInstruktoriUprav.setEnabled(false);
        btnInstruktoriUprav.setPreferredSize(new java.awt.Dimension(70, 25));
        btnInstruktoriUprav.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInstruktoriUpravActionPerformed(evt);
            }
        });

        btnInstruktoriDetail.setText("Detail");
        btnInstruktoriDetail.setEnabled(false);
        btnInstruktoriDetail.setPreferredSize(new java.awt.Dimension(70, 25));
        btnInstruktoriDetail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInstruktoriDetailActionPerformed(evt);
            }
        });

        btnInstruktoriPridaj.setText("Pridaj");
        btnInstruktoriPridaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInstruktoriPridajActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout paneInstruktoriLayout = new javax.swing.GroupLayout(paneInstruktori);
        paneInstruktori.setLayout(paneInstruktoriLayout);
        paneInstruktoriLayout.setHorizontalGroup(
            paneInstruktoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneInstruktoriLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paneInstruktoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollPaneInstruktori, javax.swing.GroupLayout.DEFAULT_SIZE, 755, Short.MAX_VALUE)
                    .addGroup(paneInstruktoriLayout.createSequentialGroup()
                        .addComponent(txtInstruktoriHladaj)
                        .addGap(18, 18, 18)
                        .addComponent(btnInstruktoriHladaj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(paneInstruktoriLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lblInstruktoriHladajPodla)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rbtnInstruktoriMeno)
                        .addGap(18, 18, 18)
                        .addComponent(rbtnInstruktoriPriezvisko)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnInstruktoriVynuluj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneInstruktoriLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnInstruktoriPridaj, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnInstruktoriVymaz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnInstruktoriUprav, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnInstruktoriDetail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        paneInstruktoriLayout.setVerticalGroup(
            paneInstruktoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneInstruktoriLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paneInstruktoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtInstruktoriHladaj, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnInstruktoriHladaj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(paneInstruktoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblInstruktoriHladajPodla, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbtnInstruktoriMeno, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbtnInstruktoriPriezvisko, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnInstruktoriVynuluj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrollPaneInstruktori, javax.swing.GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(paneInstruktoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInstruktoriDetail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnInstruktoriUprav, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnInstruktoriVymaz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnInstruktoriPridaj, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        tabbedPaneHlavny.addTab("Instruktori", paneInstruktori);

        btnVozidlaHladaj.setText("Hladaj");
        btnVozidlaHladaj.setPreferredSize(new java.awt.Dimension(70, 25));
        btnVozidlaHladaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVozidlaHladajActionPerformed(evt);
            }
        });

        btnVozidlaVynuluj.setText("Vynuluj");
        btnVozidlaVynuluj.setPreferredSize(new java.awt.Dimension(70, 25));
        btnVozidlaVynuluj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVozidlaVynulujActionPerformed(evt);
            }
        });

        lblVozidlaHladajPodla.setText("Hladaj podla:");

        btngVozidla.add(rbtnVozidlaSpz);
        rbtnVozidlaSpz.setText("SPZ");
        rbtnVozidlaSpz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnVozidlaSpzActionPerformed(evt);
            }
        });

        btngVozidla.add(rbtnVozidlaZnacka);
        rbtnVozidlaZnacka.setText("Znacky");

        btngVozidla.add(rbtnVozidlaKategoria);
        rbtnVozidlaKategoria.setText("Kategorie");

        tblVozidla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblVozidla.setRowSorter(vozidlaRowSorter);
        tblVozidla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblVozidlaMouseClicked(evt);
            }
        });
        scrollPaneVozidla.setViewportView(tblVozidla);

        btnVozidlaVymaz.setText("Vymaz");
        btnVozidlaVymaz.setEnabled(false);
        btnVozidlaVymaz.setPreferredSize(new java.awt.Dimension(70, 25));
        btnVozidlaVymaz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVozidlaVymazActionPerformed(evt);
            }
        });

        btnVozidlaUprav.setText("Uprav");
        btnVozidlaUprav.setEnabled(false);
        btnVozidlaUprav.setPreferredSize(new java.awt.Dimension(70, 25));
        btnVozidlaUprav.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVozidlaUpravActionPerformed(evt);
            }
        });

        btnVozidlaDetail.setText("Detail");
        btnVozidlaDetail.setEnabled(false);
        btnVozidlaDetail.setPreferredSize(new java.awt.Dimension(70, 25));
        btnVozidlaDetail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVozidlaDetailActionPerformed(evt);
            }
        });

        btnVozidlaPridaj.setText("Pridaj");
        btnVozidlaPridaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVozidlaPridajActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout paneVozidlaLayout = new javax.swing.GroupLayout(paneVozidla);
        paneVozidla.setLayout(paneVozidlaLayout);
        paneVozidlaLayout.setHorizontalGroup(
            paneVozidlaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneVozidlaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paneVozidlaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paneVozidlaLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lblVozidlaHladajPodla)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rbtnVozidlaSpz)
                        .addGap(18, 18, 18)
                        .addComponent(rbtnVozidlaZnacka)
                        .addGap(18, 18, 18)
                        .addComponent(rbtnVozidlaKategoria)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnVozidlaVynuluj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(scrollPaneVozidla, javax.swing.GroupLayout.DEFAULT_SIZE, 755, Short.MAX_VALUE)
                    .addGroup(paneVozidlaLayout.createSequentialGroup()
                        .addComponent(txtVozidlaHladaj)
                        .addGap(18, 18, 18)
                        .addComponent(btnVozidlaHladaj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneVozidlaLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnVozidlaPridaj, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnVozidlaVymaz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnVozidlaUprav, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnVozidlaDetail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        paneVozidlaLayout.setVerticalGroup(
            paneVozidlaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneVozidlaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paneVozidlaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtVozidlaHladaj, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVozidlaHladaj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(paneVozidlaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblVozidlaHladajPodla, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVozidlaVynuluj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbtnVozidlaSpz, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbtnVozidlaZnacka, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbtnVozidlaKategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrollPaneVozidla, javax.swing.GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(paneVozidlaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVozidlaDetail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVozidlaUprav, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVozidlaVymaz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVozidlaPridaj, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        tabbedPaneHlavny.addTab("Vozidla", paneVozidla);

        txtKomisariHladaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtKomisariHladajActionPerformed(evt);
            }
        });

        btnKomisariHladaj.setText("Hladaj");
        btnKomisariHladaj.setPreferredSize(new java.awt.Dimension(70, 25));
        btnKomisariHladaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKomisariHladajActionPerformed(evt);
            }
        });

        btnKomisariVynuluj.setText("Vynuluj");
        btnKomisariVynuluj.setPreferredSize(new java.awt.Dimension(70, 25));
        btnKomisariVynuluj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKomisariVynulujActionPerformed(evt);
            }
        });

        lblKomisariHladajPodla1.setText("Hladaj podla:");

        btngVozidla.add(rbtnKomisariMeno);
        rbtnKomisariMeno.setText("Mena");
        rbtnKomisariMeno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnKomisariMenoActionPerformed(evt);
            }
        });

        btngVozidla.add(rbtnKomisariPriezvisko);
        rbtnKomisariPriezvisko.setText("Priezviska");

        btngVozidla.add(rbtnKomisariHodnost);
        rbtnKomisariHodnost.setText("Hodnosti");
        rbtnKomisariHodnost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnKomisariHodnostActionPerformed(evt);
            }
        });

        tblKomisari.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblKomisari.setRowSorter(komisariRowSorter);
        tblKomisari.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKomisariMouseClicked(evt);
            }
        });
        scrollPaneVozidla1.setViewportView(tblKomisari);

        btnKomisariVymaz.setText("Vymaz");
        btnKomisariVymaz.setEnabled(false);
        btnKomisariVymaz.setPreferredSize(new java.awt.Dimension(70, 25));
        btnKomisariVymaz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKomisariVymazActionPerformed(evt);
            }
        });

        btnKomisariUprav.setText("Uprav");
        btnKomisariUprav.setEnabled(false);
        btnKomisariUprav.setPreferredSize(new java.awt.Dimension(70, 25));
        btnKomisariUprav.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKomisariUpravActionPerformed(evt);
            }
        });

        btnKomisariDetail.setText("Detail");
        btnKomisariDetail.setEnabled(false);
        btnKomisariDetail.setPreferredSize(new java.awt.Dimension(70, 25));
        btnKomisariDetail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKomisariDetailActionPerformed(evt);
            }
        });

        btnKomisariPridaj.setText("Pridaj");
        btnKomisariPridaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKomisariPridajActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout paneKomisariLayout = new javax.swing.GroupLayout(paneKomisari);
        paneKomisari.setLayout(paneKomisariLayout);
        paneKomisariLayout.setHorizontalGroup(
            paneKomisariLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneKomisariLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paneKomisariLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paneKomisariLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lblKomisariHladajPodla1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rbtnKomisariMeno)
                        .addGap(18, 18, 18)
                        .addComponent(rbtnKomisariPriezvisko)
                        .addGap(18, 18, 18)
                        .addComponent(rbtnKomisariHodnost)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnKomisariVynuluj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(scrollPaneVozidla1, javax.swing.GroupLayout.DEFAULT_SIZE, 755, Short.MAX_VALUE)
                    .addGroup(paneKomisariLayout.createSequentialGroup()
                        .addComponent(txtKomisariHladaj)
                        .addGap(18, 18, 18)
                        .addComponent(btnKomisariHladaj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneKomisariLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnKomisariPridaj, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnKomisariVymaz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnKomisariUprav, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnKomisariDetail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        paneKomisariLayout.setVerticalGroup(
            paneKomisariLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneKomisariLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paneKomisariLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtKomisariHladaj, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnKomisariHladaj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(paneKomisariLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblKomisariHladajPodla1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnKomisariVynuluj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbtnKomisariMeno, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbtnKomisariPriezvisko, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbtnKomisariHodnost, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrollPaneVozidla1, javax.swing.GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(paneKomisariLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnKomisariDetail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnKomisariUprav, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnKomisariVymaz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnKomisariPridaj, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        tabbedPaneHlavny.addTab("Komisari", paneKomisari);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabbedPaneHlavny)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabbedPaneHlavny)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnJazdyRozsireneVyhladavanieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJazdyRozsireneVyhladavanieActionPerformed
        RozsireneVyhladavanieJazdyFormular rozsireneVyhladavanieJazdyFormular = new RozsireneVyhladavanieJazdyFormular();
        rozsireneVyhladavanieJazdyFormular.setVisible(true);
    }//GEN-LAST:event_btnJazdyRozsireneVyhladavanieActionPerformed

    private void btnStudentiRozsireneVyhladavanieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStudentiRozsireneVyhladavanieActionPerformed
        RozsireneVyhladavanieStudentiFormular rozsireneVyhladavanieStudentiFormular = new RozsireneVyhladavanieStudentiFormular();
        rozsireneVyhladavanieStudentiFormular.setVisible(true);
    }//GEN-LAST:event_btnStudentiRozsireneVyhladavanieActionPerformed

    private void tblJazdyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblJazdyMouseClicked
        if (evt.getClickCount() == 2) {
            btnJazdyDetail.doClick();
        }
    }//GEN-LAST:event_tblJazdyMouseClicked

    private void tblSkuskyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSkuskyMouseClicked
        if (evt.getClickCount() == 2) {
            btnSkuskyDetail.doClick();
        }
    }//GEN-LAST:event_tblSkuskyMouseClicked

    private void tblStudentiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblStudentiMouseClicked
        if (evt.getClickCount() == 2) {
            btnStudentiDetail.doClick();
        }
    }//GEN-LAST:event_tblStudentiMouseClicked

    private void tblInstruktoriMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblInstruktoriMouseClicked
        if (evt.getClickCount() == 2) {
            btnInstruktoriDetail.doClick();
        }
    }//GEN-LAST:event_tblInstruktoriMouseClicked

    private void tblVozidlaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblVozidlaMouseClicked
        if (evt.getClickCount() == 2) {
            btnVozidlaDetail.doClick();
        }
    }//GEN-LAST:event_tblVozidlaMouseClicked

    private void btnJazdyDetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJazdyDetailActionPerformed
        int vybranyRiadok = tblJazdy.getSelectedRow();
        int vybratyIndexVModeli = tblJazdy.convertRowIndexToModel(vybranyRiadok);

        Jazda vybranaJazda = jazdyTableModel.dajPodlaCislaRiadku(vybratyIndexVModeli);

        DetailJazdyFormular detailJazdyFormular = new DetailJazdyFormular(vybranaJazda);
        detailJazdyFormular.setVisible(true);
    }//GEN-LAST:event_btnJazdyDetailActionPerformed

    private void btnSkuskyDetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSkuskyDetailActionPerformed
        int vybranyRiadok = tblSkusky.getSelectedRow();
        int vybratyIndexVModeli = tblSkusky.convertRowIndexToModel(vybranyRiadok);

        Skuska vybranaSkuska = skuskyTableModel.dajPodlaCislaRiadku(vybratyIndexVModeli);

        DetailSkuskyFormular detailSkuskyFormular = new DetailSkuskyFormular(vybranaSkuska);
        detailSkuskyFormular.setVisible(true);
    }//GEN-LAST:event_btnSkuskyDetailActionPerformed

    private void btnStudentiDetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStudentiDetailActionPerformed
        int vybranyRiadok = tblStudenti.getSelectedRow();
        int vybratyIndexVModeli = tblStudenti.convertRowIndexToModel(vybranyRiadok);

        Student vybranyStudent = studentiTableModel.dajPodlaCislaRiadku(vybratyIndexVModeli);

        DetailStudentiFormular detailStudentiFormular = new DetailStudentiFormular(vybranyStudent);
        detailStudentiFormular.setVisible(true);
    }//GEN-LAST:event_btnStudentiDetailActionPerformed

    private void btnInstruktoriDetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInstruktoriDetailActionPerformed
        int vybranyRiadok = tblInstruktori.getSelectedRow();
        int vybratyIndexVModeli = tblInstruktori.convertRowIndexToModel(vybranyRiadok);

        Instruktor vybratyInstruktor = instruktoriTableModel.dajPodlaCislaRiadku(vybratyIndexVModeli);

        DetailInstruktoriFormular detailInstruktoriFormular = new DetailInstruktoriFormular(vybratyInstruktor);
        detailInstruktoriFormular.setVisible(true);
    }//GEN-LAST:event_btnInstruktoriDetailActionPerformed

    private void btnVozidlaDetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVozidlaDetailActionPerformed
        int vybranyRiadok = tblVozidla.getSelectedRow();
        int vybratyIndexVModeli = tblVozidla.convertRowIndexToModel(vybranyRiadok);

        Vozidlo vybraneVozidlo = vozidlaTableModel.dajPodlaCislaRiadku(vybratyIndexVModeli);

        DetailVozidlaFormular detailVozidlaFormular = new DetailVozidlaFormular(vybraneVozidlo);
        detailVozidlaFormular.setVisible(true);
    }//GEN-LAST:event_btnVozidlaDetailActionPerformed


    private void btnJazdyUpravActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJazdyUpravActionPerformed
        int vybranyRiadok = tblJazdy.getSelectedRow();
        int vybratyIndexVModeli = tblJazdy.convertRowIndexToModel(vybranyRiadok);

        Jazda vybranaJazda = jazdyTableModel.dajPodlaCislaRiadku(vybratyIndexVModeli);

        UpravaJazdyFormular upravaJazdyFormular = new UpravaJazdyFormular(this, vybranaJazda);
        upravaJazdyFormular.setVisible(true);
    }//GEN-LAST:event_btnJazdyUpravActionPerformed

    private void btnSkuskyUpravActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSkuskyUpravActionPerformed
        int vybranyRiadok = tblSkusky.getSelectedRow();
        int vybratyIndexVModeli = tblSkusky.convertRowIndexToModel(vybranyRiadok);

        Skuska vybranaSkuska = skuskyTableModel.dajPodlaCislaRiadku(vybratyIndexVModeli);

        UpravaSkuskyFormular upravaSkuskyFormular = new UpravaSkuskyFormular(this, vybranaSkuska);
        upravaSkuskyFormular.setVisible(true);
    }//GEN-LAST:event_btnSkuskyUpravActionPerformed

    private void btnStudentiUpravActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStudentiUpravActionPerformed
        int vybranyRiadok = tblStudenti.getSelectedRow();
        int vybratyIndexVModeli = tblStudenti.convertRowIndexToModel(vybranyRiadok);

        Student vybranyStudent = studentiTableModel.dajPodlaCislaRiadku(vybratyIndexVModeli);

        UpravaStudentiFormular upravaStudentiFormular = new UpravaStudentiFormular(this, vybranyStudent);
        upravaStudentiFormular.setVisible(true);
    }//GEN-LAST:event_btnStudentiUpravActionPerformed

    private void btnInstruktoriUpravActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInstruktoriUpravActionPerformed
        int vybranyRiadok = tblInstruktori.getSelectedRow();
        int vybratyIndexVModeli = tblInstruktori.convertRowIndexToModel(vybranyRiadok);

        Instruktor vybratyInstruktor = instruktoriTableModel.dajPodlaCislaRiadku(vybratyIndexVModeli);

        UpravaInstruktoriFormular upravaInstruktoriFormular = new UpravaInstruktoriFormular(this, vybratyInstruktor);
        upravaInstruktoriFormular.setVisible(true);
    }//GEN-LAST:event_btnInstruktoriUpravActionPerformed

    private void btnVozidlaUpravActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVozidlaUpravActionPerformed
        int vybranyRiadok = tblVozidla.getSelectedRow();
        int vybratyIndexVModeli = tblVozidla.convertRowIndexToModel(vybranyRiadok);

        Vozidlo vybraneVozidlo = vozidlaTableModel.dajPodlaCislaRiadku(vybratyIndexVModeli);

        UpravaVozidlaFormular upravaVozidlaFormular = new UpravaVozidlaFormular(this, vybraneVozidlo);
        upravaVozidlaFormular.setVisible(true);
    }//GEN-LAST:event_btnVozidlaUpravActionPerformed

    private void btnJazdyVymazActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJazdyVymazActionPerformed
        int vybranyRiadok = tblJazdy.getSelectedRow();
        int vybratyIndexVModeli = tblJazdy.convertRowIndexToModel(vybranyRiadok);

        Jazda vybranaJazda = jazdyTableModel.dajPodlaCislaRiadku(vybratyIndexVModeli);

        int tlacidlo = JOptionPane.showConfirmDialog(this,
                "Naozaj odstranit?",
                "Odstranit jazdu",
                JOptionPane.YES_NO_OPTION
        );
        if (tlacidlo == JOptionPane.YES_OPTION) {
            jazdyDao.vymaz(vybranaJazda);
            aktualizujZoznamJazd();
        }
    }//GEN-LAST:event_btnJazdyVymazActionPerformed

    private void btnSkuskyVymazActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSkuskyVymazActionPerformed
        int vybranyRiadok = tblSkusky.getSelectedRow();
        int vybratyIndexVModeli = tblSkusky.convertRowIndexToModel(vybranyRiadok);

        Skuska vybranaSkuska = skuskyTableModel.dajPodlaCislaRiadku(vybratyIndexVModeli);

        int tlacidlo = JOptionPane.showConfirmDialog(this,
                "Naozaj odstranit?",
                "Odstranit skusku",
                JOptionPane.YES_NO_OPTION
        );
        if (tlacidlo == JOptionPane.YES_OPTION) {
            skuskyDao.vymaz(vybranaSkuska);
            aktualizujZoznamSkusok();
        }
    }//GEN-LAST:event_btnSkuskyVymazActionPerformed

    private void btnStudentiVymazActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStudentiVymazActionPerformed
        int vybranyRiadok = tblStudenti.getSelectedRow();
        int vybratyIndexVModeli = tblStudenti.convertRowIndexToModel(vybranyRiadok);

        Student vybranyStudent = studentiTableModel.dajPodlaCislaRiadku(vybratyIndexVModeli);

        int tlacidlo = JOptionPane.showConfirmDialog(this,
                "Naozaj odstranit?",
                "Odstranit studenta",
                JOptionPane.YES_NO_OPTION
        );
        if (tlacidlo == JOptionPane.YES_OPTION) {
            studentiDao.vymaz(vybranyStudent);
            aktualizujZoznamStudentov();
        }
    }//GEN-LAST:event_btnStudentiVymazActionPerformed

    private void btnInstruktoriVymazActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInstruktoriVymazActionPerformed
        int vybranyRiadok = tblInstruktori.getSelectedRow();
        int vybratyIndexVModeli = tblInstruktori.convertRowIndexToModel(vybranyRiadok);

        Instruktor vybratyInstruktor = instruktoriTableModel.dajPodlaCislaRiadku(vybratyIndexVModeli);

        int tlacidlo = JOptionPane.showConfirmDialog(this,
                "Naozaj odstranit?",
                "Odstranit instruktora",
                JOptionPane.YES_NO_OPTION
        );
        if (tlacidlo == JOptionPane.YES_OPTION) {
            instruktoriDao.vymaz(vybratyInstruktor);
            aktualizujZoznamInstruktorov();
        }
    }//GEN-LAST:event_btnInstruktoriVymazActionPerformed

    private void btnVozidlaVymazActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVozidlaVymazActionPerformed
        int vybranyRiadok = tblVozidla.getSelectedRow();
        int vybratyIndexVModeli = tblVozidla.convertRowIndexToModel(vybranyRiadok);

        Vozidlo vybraneVozidlo = vozidlaTableModel.dajPodlaCislaRiadku(vybratyIndexVModeli);

        int tlacidlo = JOptionPane.showConfirmDialog(this,
                "Naozaj odstranit?",
                "Odstranit vozidlo",
                JOptionPane.YES_NO_OPTION
        );
        if (tlacidlo == JOptionPane.YES_OPTION) {
            vozidlaDao.vymaz(vybraneVozidlo);
            aktualizujZoznamVozidiel();
        }
    }//GEN-LAST:event_btnVozidlaVymazActionPerformed

    private void btnJazdyPridajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJazdyPridajActionPerformed
        UpravaJazdyFormular pridanieJazdyFormular = new UpravaJazdyFormular(this, new Jazda());
        pridanieJazdyFormular.setVisible(true);
    }//GEN-LAST:event_btnJazdyPridajActionPerformed

    private void btnSkuskyPridajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSkuskyPridajActionPerformed
        UpravaSkuskyFormular pridanieSkuskyFormular = new UpravaSkuskyFormular(this, new Skuska());
        pridanieSkuskyFormular.setVisible(true);
    }//GEN-LAST:event_btnSkuskyPridajActionPerformed

    private void btnStudentiPridajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStudentiPridajActionPerformed
        UpravaStudentiFormular pridanieStudentiFormular = new UpravaStudentiFormular(this, new Student());
        pridanieStudentiFormular.setVisible(true);
    }//GEN-LAST:event_btnStudentiPridajActionPerformed

    private void btnInstruktoriPridajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInstruktoriPridajActionPerformed
        UpravaInstruktoriFormular pridanieInstruktoriFormular = new UpravaInstruktoriFormular(this, new Instruktor());
        pridanieInstruktoriFormular.setVisible(true);
    }//GEN-LAST:event_btnInstruktoriPridajActionPerformed

    private void btnVozidlaPridajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVozidlaPridajActionPerformed
        UpravaVozidlaFormular pridanieVozidlaFormular = new UpravaVozidlaFormular(this, new Vozidlo());
        pridanieVozidlaFormular.setVisible(true);
    }//GEN-LAST:event_btnVozidlaPridajActionPerformed

    private void btnJazdyHladajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJazdyHladajActionPerformed
        String filter = txtJazdyHladaj.getText().trim();

        if (rbtnJazdyDatum.isSelected()) {
            jazdyTableModel.zobrazPodlaDatumu(filter);
        }
        if (rbtnJazdyStudent.isSelected()) {
            jazdyTableModel.zobrazPodlaStudenta(filter);
        }
        if (rbtnJazdyInstruktor.isSelected()) {
            jazdyTableModel.zobrazPodlaInstruktora(filter);
        }

    }//GEN-LAST:event_btnJazdyHladajActionPerformed

    private void btnSkuskyHladajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSkuskyHladajActionPerformed
        String filter = txtSkuskyHladaj.getText().trim();

        if (rbtnSkuskyDatum.isSelected()) {
            skuskyTableModel.zobrazPodlaDatumu(filter);
        }
        if (rbtnSkuskyStudent.isSelected()) {
            skuskyTableModel.zobrazPodlaStudenta(filter);
        }
        if (rbtnSkuskyInstruktor.isSelected()) {
            skuskyTableModel.zobrazPodlaInstruktora(filter);
        }

    }//GEN-LAST:event_btnSkuskyHladajActionPerformed

    private void btnStudentiHladajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStudentiHladajActionPerformed
        String filter = txtStudentiHladaj.getText().trim();

        if (rbtnStudentiMeno.isSelected()) {
            studentiTableModel.zobrazPodlaMena(filter);
        }
        if (rbtnStudentiPriezvisko.isSelected()) {
            studentiTableModel.zobrazPodlaPriezviska(filter);
        }

    }//GEN-LAST:event_btnStudentiHladajActionPerformed

    private void btnInstruktoriHladajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInstruktoriHladajActionPerformed
        String filter = txtInstruktoriHladaj.getText().trim();

        if (rbtnInstruktoriMeno.isSelected()) {
            instruktoriTableModel.zobrazPodlaMena(filter);
        }
        if (rbtnInstruktoriPriezvisko.isSelected()) {
            instruktoriTableModel.zobrazPodlaPriezviska(filter);
        }

    }//GEN-LAST:event_btnInstruktoriHladajActionPerformed

    private void btnVozidlaHladajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVozidlaHladajActionPerformed
        String filter = txtVozidlaHladaj.getText().trim();

        if (rbtnVozidlaSpz.isSelected()) {
            vozidlaTableModel.zobrazPodlaSpz(filter);
        }
        if (rbtnVozidlaZnacka.isSelected()) {
            vozidlaTableModel.zobrazPodlaZnacky(filter);
        }
        if (rbtnVozidlaKategoria.isSelected()) {
            vozidlaTableModel.zobrazPodlaKategorie(filter);
        }

    }//GEN-LAST:event_btnVozidlaHladajActionPerformed

    private void btnJazdyVynulujActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJazdyVynulujActionPerformed
        txtJazdyHladaj.setText("");
        rbtnJazdyDatum.doClick();
        aktualizujZoznamJazd();
    }//GEN-LAST:event_btnJazdyVynulujActionPerformed

    private void btnSkuskyVynulujActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSkuskyVynulujActionPerformed
        txtSkuskyHladaj.setText("");
        rbtnSkuskyDatum.doClick();
        aktualizujZoznamSkusok();
    }//GEN-LAST:event_btnSkuskyVynulujActionPerformed

    private void btnStudentiVynulujActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStudentiVynulujActionPerformed
        txtStudentiHladaj.setText("");
        rbtnStudentiMeno.doClick();
        aktualizujZoznamStudentov();
    }//GEN-LAST:event_btnStudentiVynulujActionPerformed

    private void btnInstruktoriVynulujActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInstruktoriVynulujActionPerformed
        txtInstruktoriHladaj.setText("");
        rbtnInstruktoriMeno.doClick();
        aktualizujZoznamInstruktorov();
    }//GEN-LAST:event_btnInstruktoriVynulujActionPerformed

    private void btnVozidlaVynulujActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVozidlaVynulujActionPerformed
        txtVozidlaHladaj.setText("");
        rbtnVozidlaSpz.doClick();
        aktualizujZoznamVozidiel();
    }//GEN-LAST:event_btnVozidlaVynulujActionPerformed

    private void btnKomisariHladajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKomisariHladajActionPerformed
        String filter = txtKomisariHladaj.getText().trim();

        if (rbtnKomisariMeno.isSelected()) {
            komisariTableModel.zobrazPodlaMena(filter);
        }
        if (rbtnKomisariPriezvisko.isSelected()) {
            komisariTableModel.zobrazPodlaPriezviska(filter);
        }
        if (rbtnKomisariHodnost.isSelected()) {
            komisariTableModel.zobrazPodlaHodnosti(filter);
        }
    }//GEN-LAST:event_btnKomisariHladajActionPerformed

    private void btnKomisariVynulujActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKomisariVynulujActionPerformed
        txtKomisariHladaj.setText("");
        rbtnKomisariMeno.doClick();
        aktualizujZoznamKomisarov();
    }//GEN-LAST:event_btnKomisariVynulujActionPerformed

    private void tblKomisariMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKomisariMouseClicked
        if (evt.getClickCount() == 2) {
            btnKomisariDetail.doClick();
        }
    }//GEN-LAST:event_tblKomisariMouseClicked

    private void btnKomisariVymazActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKomisariVymazActionPerformed
        int vybranyRiadok = tblKomisari.getSelectedRow();
        int vybratyIndexVModeli = tblKomisari.convertRowIndexToModel(vybranyRiadok);

        Komisari vybranyKomisar = komisariTableModel.dajPodlaCislaRiadku(vybratyIndexVModeli);

        int tlacidlo = JOptionPane.showConfirmDialog(this,
                "Naozaj odstranit?",
                "Odstranit komisara",
                JOptionPane.YES_NO_OPTION
        );
        if (tlacidlo == JOptionPane.YES_OPTION) {
            komisariDao.vymaz(vybranyKomisar);
            aktualizujZoznamKomisarov();
        }
    }//GEN-LAST:event_btnKomisariVymazActionPerformed

    private void btnKomisariUpravActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKomisariUpravActionPerformed
        int vybranyRiadok = tblKomisari.getSelectedRow();
        int vybratyIndexVModeli = tblKomisari.convertRowIndexToModel(vybranyRiadok);

        Komisari vybratyKomisar = komisariTableModel.dajPodlaCislaRiadku(vybratyIndexVModeli);

        UpravaKomisariFormular upravaKomisariFormular = new UpravaKomisariFormular(this, vybratyKomisar);
        upravaKomisariFormular.setVisible(true);
    }//GEN-LAST:event_btnKomisariUpravActionPerformed

    private void btnKomisariDetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKomisariDetailActionPerformed
        int vybranyRiadok = tblKomisari.getSelectedRow();
        int vybratyIndexVModeli = tblKomisari.convertRowIndexToModel(vybranyRiadok);

        Komisari vybratyKomisar = komisariTableModel.dajPodlaCislaRiadku(vybratyIndexVModeli);

        DetailKomisariFormular detailKomisariFormular = new DetailKomisariFormular(vybratyKomisar);
        detailKomisariFormular.setVisible(true);
    }//GEN-LAST:event_btnKomisariDetailActionPerformed

    private void btnKomisariPridajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKomisariPridajActionPerformed
        UpravaKomisariFormular pridanieKomisariFormular = new UpravaKomisariFormular(this, new Komisari());
        pridanieKomisariFormular.setVisible(true);
    }//GEN-LAST:event_btnKomisariPridajActionPerformed

    private void txtKomisariHladajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKomisariHladajActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtKomisariHladajActionPerformed

    private void rbtnKomisariMenoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnKomisariMenoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbtnKomisariMenoActionPerformed

    private void rbtnVozidlaSpzActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnVozidlaSpzActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbtnVozidlaSpzActionPerformed

    private void rbtnInstruktoriMenoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnInstruktoriMenoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbtnInstruktoriMenoActionPerformed

    private void rbtnInstruktoriPriezviskoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnInstruktoriPriezviskoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbtnInstruktoriPriezviskoActionPerformed

    private void rbtnKomisariHodnostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnKomisariHodnostActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbtnKomisariHodnostActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HlavnyFormular.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HlavnyFormular.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HlavnyFormular.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HlavnyFormular.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HlavnyFormular().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnInstruktoriDetail;
    private javax.swing.JButton btnInstruktoriHladaj;
    private javax.swing.JButton btnInstruktoriPridaj;
    private javax.swing.JButton btnInstruktoriUprav;
    private javax.swing.JButton btnInstruktoriVymaz;
    private javax.swing.JButton btnInstruktoriVynuluj;
    private javax.swing.JButton btnJazdyDetail;
    private javax.swing.JButton btnJazdyHladaj;
    private javax.swing.JButton btnJazdyPridaj;
    private javax.swing.JButton btnJazdyRozsireneVyhladavanie;
    private javax.swing.JButton btnJazdyUprav;
    private javax.swing.JButton btnJazdyVymaz;
    private javax.swing.JButton btnJazdyVynuluj;
    private javax.swing.JButton btnKomisariDetail;
    private javax.swing.JButton btnKomisariHladaj;
    private javax.swing.JButton btnKomisariPridaj;
    private javax.swing.JButton btnKomisariUprav;
    private javax.swing.JButton btnKomisariVymaz;
    private javax.swing.JButton btnKomisariVynuluj;
    private javax.swing.JButton btnSkuskyDetail;
    private javax.swing.JButton btnSkuskyHladaj;
    private javax.swing.JButton btnSkuskyPridaj;
    private javax.swing.JButton btnSkuskyUprav;
    private javax.swing.JButton btnSkuskyVymaz;
    private javax.swing.JButton btnSkuskyVynuluj;
    private javax.swing.JButton btnStudentiDetail;
    private javax.swing.JButton btnStudentiHladaj;
    private javax.swing.JButton btnStudentiPridaj;
    private javax.swing.JButton btnStudentiRozsireneVyhladavanie;
    private javax.swing.JButton btnStudentiUprav;
    private javax.swing.JButton btnStudentiVymaz;
    private javax.swing.JButton btnStudentiVynuluj;
    private javax.swing.JButton btnVozidlaDetail;
    private javax.swing.JButton btnVozidlaHladaj;
    private javax.swing.JButton btnVozidlaPridaj;
    private javax.swing.JButton btnVozidlaUprav;
    private javax.swing.JButton btnVozidlaVymaz;
    private javax.swing.JButton btnVozidlaVynuluj;
    private javax.swing.ButtonGroup btngInstruktori;
    private javax.swing.ButtonGroup btngJazdy;
    private javax.swing.ButtonGroup btngSkusky;
    private javax.swing.ButtonGroup btngStudenti;
    private javax.swing.ButtonGroup btngVozidla;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblInstruktoriHladajPodla;
    private javax.swing.JLabel lblJazdyHladajPodla;
    private javax.swing.JLabel lblKomisariHladajPodla1;
    private javax.swing.JLabel lblSkuskyHladajPodla;
    private javax.swing.JLabel lblStudentiHladajPodla;
    private javax.swing.JLabel lblVozidlaHladajPodla;
    private javax.swing.JPanel paneInstruktori;
    private javax.swing.JPanel paneJazdy;
    private javax.swing.JPanel paneKomisari;
    private javax.swing.JPanel paneSkusky;
    private javax.swing.JPanel paneStudenti;
    private javax.swing.JPanel paneVozidla;
    private javax.swing.JRadioButton rbtnInstruktoriMeno;
    private javax.swing.JRadioButton rbtnInstruktoriPriezvisko;
    private javax.swing.JRadioButton rbtnJazdyDatum;
    private javax.swing.JRadioButton rbtnJazdyInstruktor;
    private javax.swing.JRadioButton rbtnJazdyStudent;
    private javax.swing.JRadioButton rbtnKomisariHodnost;
    private javax.swing.JRadioButton rbtnKomisariMeno;
    private javax.swing.JRadioButton rbtnKomisariPriezvisko;
    private javax.swing.JRadioButton rbtnSkuskyDatum;
    private javax.swing.JRadioButton rbtnSkuskyInstruktor;
    private javax.swing.JRadioButton rbtnSkuskyStudent;
    private javax.swing.JRadioButton rbtnStudentiMeno;
    private javax.swing.JRadioButton rbtnStudentiPriezvisko;
    private javax.swing.JRadioButton rbtnVozidlaKategoria;
    private javax.swing.JRadioButton rbtnVozidlaSpz;
    private javax.swing.JRadioButton rbtnVozidlaZnacka;
    private javax.swing.JScrollPane scrollPaneInstruktori;
    private javax.swing.JScrollPane scrollPaneJazdy;
    private javax.swing.JScrollPane scrollPaneSkusky;
    private javax.swing.JScrollPane scrollPaneStudenti;
    private javax.swing.JScrollPane scrollPaneVozidla;
    private javax.swing.JScrollPane scrollPaneVozidla1;
    private javax.swing.JTabbedPane tabbedPaneHlavny;
    private javax.swing.JTable tblInstruktori;
    private javax.swing.JTable tblJazdy;
    private javax.swing.JTable tblKomisari;
    private javax.swing.JTable tblSkusky;
    private javax.swing.JTable tblStudenti;
    private javax.swing.JTable tblVozidla;
    private javax.swing.JTextField txtInstruktoriHladaj;
    private javax.swing.JTextField txtJazdyHladaj;
    private javax.swing.JTextField txtKomisariHladaj;
    private javax.swing.JTextField txtSkuskyHladaj;
    private javax.swing.JTextField txtStudentiHladaj;
    private javax.swing.JTextField txtVozidlaHladaj;
    // End of variables declaration//GEN-END:variables

}
