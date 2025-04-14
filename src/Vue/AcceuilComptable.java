/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import Modele.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.*;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author azus
 */
public class AcceuilComptable extends javax.swing.JFrame {

    Connexion c = new Connexion();
    PreparedStatement ps, ps1;
    DefaultTableModel dft = new DefaultTableModel();
    DefaultTableModel dft1 = new DefaultTableModel();
    ResultSet rs;
    String prv = "";

    public AcceuilComptable() {
        initComponents();
        setLocationRelativeTo(this);
        actualiserdep();
        actualiserrev();
        try {
            ps = c.connexionBdd().prepareStatement("select privilége from utilisateurs where nom_utilisateur=?");
            ps.setString(1, authentification.tusername.getText());
            rs = ps.executeQuery();
            while (rs.next()) {
                prv = rs.getString("privilége");
            }
        } catch (SQLException ex) {
            Logger.getLogger(AcceuilComptable.class.getName()
            ).log(Level.SEVERE, null, ex);
        }
    }

    public void reset() {
        tnumrevenue.setText("");
        jdate.setDate(null);
        tmontant.setText("");
        ctyperevenue.setSelectedIndex(0);
        cmodepaiement.setSelectedIndex(0);
        cstatutpaiement.setSelectedIndex(0);
        tmatricule.setText("");
        csource.setSelectedIndex(0);
    }

    public void reset1() {
        tnumdep.setText("");
        jdatedep.setDate(null);
        tmontantdep.setText("");
        tfournisseur.setText("");
        ccategorie.setSelectedIndex(0);
        cmodepaiementdep.setSelectedIndex(0);
        tperiodicite.setText("");
        tdescription.setText("");
        tfacture.setText("");
    }

    public void actualiserrev() {
        dft.setRowCount(0);
        dft.setColumnCount(0);
        try {
            dft.addColumn("N° Revenue");
            dft.addColumn("Date d'enregistrement");
            dft.addColumn("Montant");
            dft.addColumn("Type revenue");
            dft.addColumn("Mode paiement");
            dft.addColumn("Statut paiement");
            dft.addColumn("Matricule patient");
            dft.addColumn("Source");
            ps = c.connexionBdd().prepareStatement("select * from revenue");
            rs = ps.executeQuery();
            while (rs.next()) {
                dft.addRow(new Object[]{
                    rs.getString("revenue_id"),
                    rs.getString("date_enregistrement"),
                    rs.getString("montant"),
                    rs.getString("type_revenue"),
                    rs.getString("mode_paiement"),
                    rs.getString("statut_paiement"),
                    rs.getString("matricule_pat"),
                    rs.getString("source_revenue")
                }
                );
            }
            trevenue.setModel(dft);
        } catch (SQLException ex) {
            Logger.getLogger(DetailsPatient.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void actualiserdep() {
        dft1.setRowCount(0);
        dft1.setColumnCount(0);
        try {
            dft1.addColumn("N° Depense");
            dft1.addColumn("N° Fournisseur");
            dft1.addColumn("N° Facture");
            dft1.addColumn("Catégorie");
            dft1.addColumn("Montant");
            dft1.addColumn("Mode de paiement");
            dft1.addColumn("Date");
            dft1.addColumn("Périodicité");
            dft1.addColumn("Description");
            ps = c.connexionBdd().prepareStatement("select * from depense");
            rs = ps.executeQuery();
            while (rs.next()) {
                dft1.addRow(new Object[]{
                    rs.getString("depense_id"),
                    rs.getString("fournisseur_id"),
                    rs.getString("num_facture"),
                    rs.getString("catégorie"),
                    rs.getString("montant"),
                    rs.getString("mode_paiement"),
                    rs.getString("date_enregistrement"),
                    rs.getString("periodicité"),
                    rs.getString("description")
                }
                );
            }
            tdepense.setModel(dft1);
        } catch (SQLException ex) {
            Logger.getLogger(DetailsPatient.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        cmodepaiement = new javax.swing.JComboBox<>();
        cstatutpaiement = new javax.swing.JComboBox<>();
        csource = new javax.swing.JComboBox<>();
        tmatricule = new javax.swing.JTextField();
        tmontant = new javax.swing.JTextField();
        jdate = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        ctyperevenue = new javax.swing.JComboBox<>();
        bajouterrev = new javax.swing.JButton();
        bmodifierrev = new javax.swing.JButton();
        bsupprimerrev = new javax.swing.JButton();
        bactualiserrev = new javax.swing.JButton();
        tnumrevenue = new javax.swing.JTextField();
        bimprimerrev = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        trevenue = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        cmodepaiementdep = new javax.swing.JComboBox<>();
        tfournisseur = new javax.swing.JTextField();
        tfacture = new javax.swing.JTextField();
        tmontantdep = new javax.swing.JTextField();
        tperiodicite = new javax.swing.JTextField();
        tdescription = new javax.swing.JTextField();
        tnumdep = new javax.swing.JTextField();
        ccategorie = new javax.swing.JComboBox<>();
        jdatedep = new com.toedter.calendar.JDateChooser();
        bactualiserdep = new javax.swing.JButton();
        bajoutdep = new javax.swing.JButton();
        bmodifierdep = new javax.swing.JButton();
        bsupprimerdep = new javax.swing.JButton();
        bimprimerdep = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tdepense = new javax.swing.JTable();
        jLabel20 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.setBorder(javax.swing.BorderFactory.createCompoundBorder());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setText("Date * :");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setText("Montant * :");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setText("Matricule patient * :");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 70, -1, -1));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setText("Statut de paiement * :");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 140, -1, -1));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setText("n° Revenu :");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 130, -1, -1));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel10.setText("Source de revenu * :");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 110, -1, -1));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel11.setText("Mode de paiement * :");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 110, -1, -1));

        cmodepaiement.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cmodepaiement.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Espèce", "Carte bancaire", "Chèque", "Portefeuille électronique", "Mobile", "Viremment bancaire", "Monnaies virtuelles" }));
        cmodepaiement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmodepaiementActionPerformed(evt);
            }
        });
        jPanel1.add(cmodepaiement, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 110, 140, -1));

        cstatutpaiement.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cstatutpaiement.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Payé", "en attente", "annulé" }));
        jPanel1.add(cstatutpaiement, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 140, 140, -1));

        csource.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        csource.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Paiement du patient", "Remboursements d'assurance maladie", "Paiement des gouvernements", "Paiement de tiers" }));
        jPanel1.add(csource, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 110, 210, -1));

        tmatricule.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tmatricule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tmatriculeActionPerformed(evt);
            }
        });
        jPanel1.add(tmatricule, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 60, 210, -1));

        tmontant.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel1.add(tmontant, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, 140, -1));
        jPanel1.add(jdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, 140, -1));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setText("Type de revenu * :");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 70, -1, -1));

        ctyperevenue.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        ctyperevenue.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Trimestriel", "Mansuel", "Annuel" }));
        ctyperevenue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ctyperevenueActionPerformed(evt);
            }
        });
        jPanel1.add(ctyperevenue, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 70, 140, -1));

        bajouterrev.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        bajouterrev.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ajouter-un-bouton (1) (1).png"))); // NOI18N
        bajouterrev.setText("Ajouter");
        bajouterrev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bajouterrevActionPerformed(evt);
            }
        });
        jPanel1.add(bajouterrev, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 10, -1, -1));

        bmodifierrev.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        bmodifierrev.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/report (1).png"))); // NOI18N
        bmodifierrev.setText("Modifier");
        bmodifierrev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bmodifierrevActionPerformed(evt);
            }
        });
        jPanel1.add(bmodifierrev, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 10, -1, -1));

        bsupprimerrev.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        bsupprimerrev.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/garbage-bin (1).png"))); // NOI18N
        bsupprimerrev.setText("Supprimer");
        bsupprimerrev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bsupprimerrevActionPerformed(evt);
            }
        });
        jPanel1.add(bsupprimerrev, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 10, -1, -1));

        bactualiserrev.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/real-time (1).png"))); // NOI18N
        bactualiserrev.setBorder(null);
        bactualiserrev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bactualiserrevActionPerformed(evt);
            }
        });
        jPanel1.add(bactualiserrev, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 10, -1, 30));

        tnumrevenue.setEditable(false);
        tnumrevenue.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel1.add(tnumrevenue, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, 140, -1));

        bimprimerrev.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        bimprimerrev.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/printer (2).png"))); // NOI18N
        bimprimerrev.setText("Imprimer");
        bimprimerrev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bimprimerrevActionPerformed(evt);
            }
        });
        jPanel1.add(bimprimerrev, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 10, -1, -1));

        jPanel4.setBackground(new java.awt.Color(0, 102, 102));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        trevenue.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        trevenue.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N° Revenu", "Date d'enregistrement", "Montant", "Type de revenu", "Mode Paiement", "Statut paiement", "Matricule Patient", "Source"
            }
        ));
        trevenue.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                trevenueMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(trevenue);

        jPanel4.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 860, 210));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setText("Les revenues");
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, -1, -1));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 860, 250));

        jTabbedPane1.addTab("Revenu", jPanel1);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setText("Date * :");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 70, -1, -1));

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel12.setText("Montant * :");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 100, -1, -1));

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel13.setText("N° fournisseur  * :");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, -1));

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel14.setText("Catégorie * :");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 70, -1, -1));

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel15.setText("N° Facture * :");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));

        jLabel16.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel16.setText("Mode de paiement * :");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 130, -1, -1));

        jLabel17.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel17.setText("N° Dépense :");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        jLabel18.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel18.setText("Description  :");
        jPanel2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 130, -1, -1));

        jLabel19.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel19.setText("Périodicité  :");
        jPanel2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 100, -1, -1));

        cmodepaiementdep.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cmodepaiementdep.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Espèce", "Carte bancaire", "Chèque", "Portefeuille électronique", "Mobile", "Viremment bancaire", "Monnaies virtuelles", " " }));
        jPanel2.add(cmodepaiementdep, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 130, 150, -1));

        tfournisseur.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel2.add(tfournisseur, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 160, -1));

        tfacture.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel2.add(tfacture, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 160, -1));

        tmontantdep.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel2.add(tmontantdep, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 100, 160, -1));

        tperiodicite.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel2.add(tperiodicite, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 100, 140, -1));

        tdescription.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel2.add(tdescription, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 130, 140, -1));

        tnumdep.setEditable(false);
        tnumdep.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel2.add(tnumdep, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 160, -1));

        ccategorie.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        ccategorie.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Les charges d'exploitation", "Les charges de personel", "Les charges financières", "Les charges exceptionnelles", "Les amortissements" }));
        jPanel2.add(ccategorie, new org.netbeans.lib.awtextra.AbsoluteConstraints(454, 70, 160, -1));
        jPanel2.add(jdatedep, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 60, 140, -1));

        bactualiserdep.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/real-time (1).png"))); // NOI18N
        bactualiserdep.setBorder(null);
        bactualiserdep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bactualiserdepActionPerformed(evt);
            }
        });
        jPanel2.add(bactualiserdep, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 10, -1, 30));

        bajoutdep.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        bajoutdep.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ajouter-un-bouton (1) (1).png"))); // NOI18N
        bajoutdep.setText("Ajouter");
        bajoutdep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bajoutdepActionPerformed(evt);
            }
        });
        jPanel2.add(bajoutdep, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 10, -1, -1));

        bmodifierdep.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        bmodifierdep.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/report (1).png"))); // NOI18N
        bmodifierdep.setText("Modifier");
        bmodifierdep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bmodifierdepActionPerformed(evt);
            }
        });
        jPanel2.add(bmodifierdep, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 10, -1, -1));

        bsupprimerdep.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        bsupprimerdep.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/garbage-bin (1).png"))); // NOI18N
        bsupprimerdep.setText("Supprimer");
        bsupprimerdep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bsupprimerdepActionPerformed(evt);
            }
        });
        jPanel2.add(bsupprimerdep, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 10, -1, -1));

        bimprimerdep.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        bimprimerdep.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/printer (2).png"))); // NOI18N
        bimprimerdep.setText("Imprimer");
        bimprimerdep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bimprimerdepActionPerformed(evt);
            }
        });
        jPanel2.add(bimprimerdep, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, -1, -1));

        jPanel5.setBackground(new java.awt.Color(0, 102, 102));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tdepense.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tdepense.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N° Dépense", "N° Fournisseur", "N° Facture", "Catégorie", "Montant", "Mode de paiement", "Date", "Périodicité", "Descriprtion"
            }
        ));
        tdepense.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tdepenseMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tdepense);

        jPanel5.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 910, 200));

        jLabel20.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Les dépenses :");
        jPanel5.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 10, -1, -1));

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 910, 230));

        jTabbedPane1.addTab("Dépense", jPanel2);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 950, 480));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bactualiserdepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bactualiserdepActionPerformed
        actualiserdep();
        reset1();
    }//GEN-LAST:event_bactualiserdepActionPerformed

    private void bajouterrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bajouterrevActionPerformed
        if (prv.charAt(23) == '1') {
            if (tmontant.getText().isEmpty() || tmatricule.getText().isEmpty() || jdate.getDate() == null) {
                JOptionPane.showMessageDialog(this, "Veuillez renseigner tout les champs !!");
            } else {
                try {
                    if (authentification.ctype.getSelectedItem().equals("Admin")) {
                        ps = c.connexionBdd().prepareStatement("insert into revenue(date_enregistrement,montant,matricule_pat,mode_paiement,statut_paiement,type_revenue,source_revenue) values(?,?,?,?,?,?,?)");
                    }
                    if (authentification.ctype.getSelectedItem().equals("Comptable")) {
                        ps = c.connexionBdd().prepareStatement("insert into revenue(date_enregistrement,montant,matricule_pat,mode_paiement,statut_paiement,type_revenue,source_revenue,comptable_id) values(?,?,?,?,?,?,?,?)");
                    }
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    String dater = sdf.format(jdate.getDate());
                    ps.setString(1, dater);
                    ps.setString(2, tmontant.getText());
                    ps.setString(3, tmatricule.getText());
                    ps.setString(4, cmodepaiement.getSelectedItem() + "");
                    ps.setString(5, cstatutpaiement.getSelectedItem() + "");
                    ps.setString(6, ctyperevenue.getSelectedItem() + "");
                    ps.setString(7, csource.getSelectedItem() + "");
                    if (authentification.ctype.getSelectedItem().equals("Comptable")) {
                        ps.setString(8, authentification.tusername.getText());
                    }
                    ps.executeUpdate();
                    JOptionPane.showMessageDialog(this, "Le revenue a été ajouter avec succés");
                    reset();
                    actualiserrev();
                } catch (SQLException ex) {
                    Logger.getLogger(AcceuilComptable.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Vous disposer pas de ce privilége !");
        }
    }//GEN-LAST:event_bajouterrevActionPerformed

    private void bmodifierrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bmodifierrevActionPerformed
        if (prv.charAt(24) == '1') {
            if (trevenue.getSelectedRowCount() == 1) {
                if (JOptionPane.showConfirmDialog(this, "Voullez vous vraiment modifier?",
                        "Confirmation de modification",
                        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    try {
                        ps = c.connexionBdd().prepareStatement("update revenue set date_enregistrement=?, montant=? ,matricule_pat=? ,mode_paiement=? ,statut_paiement=? ,type_revenue=? ,source_revenue=?,comptable_id=? where revenue_id=?");
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        String dater = sdf.format(jdate.getDate());
                        ps.setString(1, dater);
                        ps.setString(2, tmontant.getText());
                        ps.setString(3, tmatricule.getText());
                        ps.setString(4, cmodepaiement.getSelectedItem() + "");
                        ps.setString(5, cstatutpaiement.getSelectedItem() + "");
                        ps.setString(6, ctyperevenue.getSelectedItem() + "");
                        ps.setString(7, csource.getSelectedItem() + "");
                        ps.setString(8, authentification.tusername.getText());
                        ps.setString(9, tnumrevenue.getText());
                        ps.executeUpdate();
                        JOptionPane.showMessageDialog(this, "Mise à jour faites avec succés");
                        actualiserrev();
                        reset();
                    } catch (SQLException ex) {
                        Logger.getLogger(AcceuilComptable.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Vous disposer pas de ce privilége !");
        }
    }//GEN-LAST:event_bmodifierrevActionPerformed

    private void bsupprimerrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsupprimerrevActionPerformed
        if (prv.charAt(25) == '1') {
            if (trevenue.getSelectedRowCount() == 1) {
                if (JOptionPane.showConfirmDialog(this, "Voulez vous vraiment supprimer le revenue", "confirmation", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    try {
                        ps = c.connexionBdd().prepareStatement("delete from revenue where revenue_id=?");
                        ps.setString(1, tnumrevenue.getText());
                        ps.executeUpdate();
                        JOptionPane.showMessageDialog(this, "Suppression avec faite succés");
                        reset();
                        actualiserrev();
                    } catch (SQLException ex) {
                        Logger.getLogger(AcceuilComptable.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Vous disposer pas de ce privilége !");
        }
    }//GEN-LAST:event_bsupprimerrevActionPerformed

    private void bajoutdepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bajoutdepActionPerformed
        if (prv.charAt(5) == '1') {
            if (tfournisseur.getText().isEmpty() || tfacture.getText().isEmpty() || tmontantdep.getText().isEmpty() || jdatedep.getDate() == null || tperiodicite.getText().isEmpty() || tdescription.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Veuillez renseigner tout les champs !!");
            } else {
                try {
                    if (authentification.ctype.getSelectedItem().equals("Admin")) {
                        ps = c.connexionBdd().prepareStatement("insert into depense(date_enregistrement,montant,fournisseur_id,catégorie,num_facture,mode_paiement,periodicité,description) values(?,?,?,?,?,?,?,?)");
                    }
                    if (authentification.ctype.getSelectedItem().equals("Comptable")) {
                        ps = c.connexionBdd().prepareStatement("insert into depense(date_enregistrement,montant,fournisseur_id,catégorie,num_facture,mode_paiement,periodicité,description,comptable_id) values(?,?,?,?,?,?,?,?,?)");
                    }
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    String dated = sdf.format(jdatedep.getDate());
                    ps.setString(1, dated);
                    ps.setString(2, tmontantdep.getText());
                    ps.setString(3, tfournisseur.getText());
                    ps.setString(4, ccategorie.getSelectedItem() + "");
                    ps.setString(5, tfacture.getText());
                    ps.setString(6, cmodepaiementdep.getSelectedItem() + "");
                    ps.setString(7, tperiodicite.getText());
                    ps.setString(8, tdescription.getText());
                    if (authentification.ctype.getSelectedItem().equals("Comptable")) {
                        ps.setString(9, authentification.tusername.getText());
                    }

                    ps.executeUpdate();
                    JOptionPane.showMessageDialog(this, "La depense a été ajouter avec succés");
                    reset1();
                    actualiserdep();
                } catch (SQLException ex) {
                    Logger.getLogger(AcceuilComptable.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Vous disposer pas de ce privilége !");
        }
    }//GEN-LAST:event_bajoutdepActionPerformed

    private void bactualiserrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bactualiserrevActionPerformed
        actualiserrev();
        reset();
    }//GEN-LAST:event_bactualiserrevActionPerformed

    private void trevenueMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_trevenueMouseClicked
        try {
            ps = c.connexionBdd().prepareStatement("select * from revenue where revenue_id=?");
            ps.setString(1, trevenue.getValueAt(trevenue.getSelectedRow(), 0) + "");
            rs = ps.executeQuery();
            while (rs.next()) {
                tnumrevenue.setText(rs.getString("revenue_id"));
                jdate.setDate(rs.getDate("date_enregistrement"));
                tmontant.setText(rs.getString("montant"));
                ctyperevenue.setSelectedItem(rs.getString("type_revenue"));
                cmodepaiement.setSelectedItem(rs.getString("mode_paiement"));
                cstatutpaiement.setSelectedItem(rs.getString("statut_paiement"));
                tmatricule.setText(rs.getString("matricule_pat"));
                csource.setSelectedItem(rs.getString("source_revenue"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AcceuilComptable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_trevenueMouseClicked

    private void tdepenseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tdepenseMouseClicked
        try {
            ps = c.connexionBdd().prepareStatement("select * from depense where depense_id=?");
            ps.setString(1, tdepense.getValueAt(tdepense.getSelectedRow(), 0) + "");
            rs = ps.executeQuery();
            while (rs.next()) {
                tnumdep.setText(rs.getString("depense_id"));
                tfournisseur.setText(rs.getString("fournisseur_id"));
                tfacture.setText(rs.getString("num_facture"));
                ccategorie.setSelectedItem(rs.getString("catégorie"));
                tmontantdep.setText(rs.getString("montant"));
                cmodepaiementdep.setSelectedItem(rs.getString("mode_paiement"));
                jdatedep.setDate(rs.getDate("date_enregistrement"));
                tperiodicite.setText(rs.getString("periodicité"));
                tdescription.setText(rs.getString("description"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AcceuilComptable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tdepenseMouseClicked

    private void bmodifierdepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bmodifierdepActionPerformed

        if (prv.charAt(6) == '1') {
            if (tdepense.getSelectedRowCount() == 1) {
                if (JOptionPane.showConfirmDialog(this, "Voullez vous vraiment modifier?",
                        "Confirmation de modification",
                        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    try {
                        ps = c.connexionBdd().prepareStatement("update depense set date_enregistrement=?, montant=? ,fournisseur_id=? ,catégorie=? ,num_facture=? ,mode_paiement=? ,comptable_id=?,periodicité=? ,description=? where depense_id=?");
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        String daten = sdf.format(jdatedep.getDate());
                        ps.setString(1, daten);
                        ps.setString(2, tmontantdep.getText());
                        ps.setString(3, tfournisseur.getText());
                        ps.setString(4, ccategorie.getSelectedItem() + "");
                        ps.setString(5, tfacture.getText());
                        ps.setString(6, cmodepaiementdep.getSelectedItem() + "");
                        ps.setString(7, authentification.tusername.getText());
                        ps.setString(8, tperiodicite.getText());
                        ps.setString(9, tdescription.getText());
                        ps.setString(10, tnumdep.getText());
                        ps.executeUpdate();
                        JOptionPane.showMessageDialog(this, "Mise à jour faite avec succés");
                        actualiserdep();
                        reset1();
                    } catch (SQLException ex) {
                        Logger.getLogger(AcceuilComptable.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Vous disposer pas de ce privilége !");
        }
    }//GEN-LAST:event_bmodifierdepActionPerformed

    private void bsupprimerdepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsupprimerdepActionPerformed

        if (prv.charAt(7) == '1') {
            if (tdepense.getSelectedRowCount() == 1) {
                if (JOptionPane.showConfirmDialog(this, "Voulez vous vraiment supprimer la depense", "confirmation", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    try {
                        ps = c.connexionBdd().prepareStatement("delete from depense where depense_id=?");
                        ps.setString(1, tnumdep.getText());
                        ps.executeUpdate();
                        JOptionPane.showMessageDialog(this, "Suppression avec faite succés");
                        reset1();
                        actualiserdep();
                    } catch (SQLException ex) {
                        Logger.getLogger(AcceuilComptable.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Vous disposer pas de ce privilége !");
        }
    }//GEN-LAST:event_bsupprimerdepActionPerformed

    private void bimprimerrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bimprimerrevActionPerformed

        if (prv.charAt(26) == '1') {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_cabinet_medical", "root", "");
                String reportPath = "C:\\Users\\azus\\Documents\\NetBeansProjects\\gestion d'une cabinet medicale V7\\src\\EtatImpression\\Revenue.jrxml";
                JasperReport jr = JasperCompileManager.compileReport(reportPath);
                JasperPrint jp = JasperFillManager.fillReport(jr, null, con);
                JasperViewer.viewReport(jp, false);

            } catch (ClassNotFoundException | SQLException | JRException ex) {
                Logger.getLogger(AcceuilComptable.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Vous disposer pas de ce privilége !");
        }
    }//GEN-LAST:event_bimprimerrevActionPerformed

    private void bimprimerdepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bimprimerdepActionPerformed

        if (prv.charAt(8) == '1') {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_cabinet_medical", "root", "");
                String reportPath = "C:\\Users\\azus\\Documents\\NetBeansProjects\\gestion d'une cabinet medicale V7\\src\\EtatImpression\\Depense.jrxml";
                JasperReport jr = JasperCompileManager.compileReport(reportPath);
                JasperPrint jp = JasperFillManager.fillReport(jr, null, con);
                JasperViewer.viewReport(jp, false);

            } catch (ClassNotFoundException | SQLException | JRException ex) {
                Logger.getLogger(AcceuilComptable.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Vous disposer pas de ce privilége !");
        }
    }//GEN-LAST:event_bimprimerdepActionPerformed

    private void ctyperevenueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ctyperevenueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ctyperevenueActionPerformed

    private void tmatriculeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tmatriculeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tmatriculeActionPerformed

    private void cmodepaiementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmodepaiementActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmodepaiementActionPerformed

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
            java.util.logging.Logger.getLogger(AcceuilComptable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AcceuilComptable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AcceuilComptable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AcceuilComptable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AcceuilComptable().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bactualiserdep;
    private javax.swing.JButton bactualiserrev;
    private javax.swing.JButton bajoutdep;
    private javax.swing.JButton bajouterrev;
    private javax.swing.JButton bimprimerdep;
    private javax.swing.JButton bimprimerrev;
    private javax.swing.JButton bmodifierdep;
    private javax.swing.JButton bmodifierrev;
    private javax.swing.JButton bsupprimerdep;
    private javax.swing.JButton bsupprimerrev;
    private javax.swing.JComboBox<String> ccategorie;
    private javax.swing.JComboBox<String> cmodepaiement;
    private javax.swing.JComboBox<String> cmodepaiementdep;
    private javax.swing.JComboBox<String> csource;
    private javax.swing.JComboBox<String> cstatutpaiement;
    private javax.swing.JComboBox<String> ctyperevenue;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private com.toedter.calendar.JDateChooser jdate;
    private com.toedter.calendar.JDateChooser jdatedep;
    private javax.swing.JTable tdepense;
    private javax.swing.JTextField tdescription;
    private javax.swing.JTextField tfacture;
    private javax.swing.JTextField tfournisseur;
    private javax.swing.JTextField tmatricule;
    private javax.swing.JTextField tmontant;
    private javax.swing.JTextField tmontantdep;
    private javax.swing.JTextField tnumdep;
    private javax.swing.JTextField tnumrevenue;
    private javax.swing.JTextField tperiodicite;
    private javax.swing.JTable trevenue;
    // End of variables declaration//GEN-END:variables
}
