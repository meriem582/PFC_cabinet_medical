/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import Modele.*;
import static Vue.AcceuilSecretaire.tpatient;
import static Vue.AcceuilSecretaire.prv;
import java.awt.Image;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author azus
 */
public class DetailsPatient extends javax.swing.JFrame {
    
    static Connexion c = new Connexion();
    static PreparedStatement ps;
    static DefaultTableModel dft = new DefaultTableModel();
    static DefaultTableModel dft1 = new DefaultTableModel();
    static DefaultTableModel dft2 = new DefaultTableModel();
    static ResultSet rs;
    
    public DetailsPatient() {
        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        try {
            ps = c.connexionBdd().prepareStatement("select * from patient where matricule_pat=?");
            ps.setString(1, AcceuilSecretaire.tpatient.getValueAt(AcceuilSecretaire.tpatient.getSelectedRow(), 0) + "");
            rs = ps.executeQuery();
            while (rs.next()) {
                nomprenom.setText(rs.getString("nom_pat") + " " + rs.getString("prénom_pat"));
                tmatricule.setText(rs.getString("matricule_pat"));
                tnom.setText(rs.getString("nom_pat"));
                tprenom.setText(rs.getString("prénom_pat"));
                tdate.setText(rs.getDate("date_naissance") + "");
                tmaladie.setText(rs.getString("maladie_pat"));
                temail.setText(rs.getString("email"));
                ttel.setText(rs.getString("numTel"));
                ttelurgence.setText(rs.getString("numTelUrgence"));
                tnumsecurite.setText(rs.getString("num_sécurité_social"));
                tadresse.setText(rs.getString("adresse_pat"));
                tnote.setText(rs.getString("note"));
                tantchirurgicaux.setText(rs.getString("antécédents_chirurgicaux"));
                tantfamiliaux.setText(rs.getString("antécédents_familiaux"));
                tantmedicaux.setText(rs.getString("antécédents_médicaux"));
                tantpersonnels.setText(rs.getString("antécédents_personnels"));
                tsanguin.setText(rs.getString("groupe_sanguin"));
                tsexe.setText(rs.getString("sexe"));
                tsituationfamiliale.setText(rs.getString("situation_familiale"));
                byte[] photo = rs.getBytes("photo_patient");
                ImageIcon imgic = new ImageIcon(photo);
                Image img = imgic.getImage().getScaledInstance(limage.getWidth(), limage.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon imgf = new ImageIcon(img);
                limage.setIcon(imgf);
                tpath.setText(rs.getString("tpath"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DetailsPatient.class.getName()).log(Level.SEVERE, null, ex);
        }
        actualiserc();
        actualiserRDV();
        actualiserfac();
        
    }
    
    public static void actualiserfac() {
        dft.setRowCount(0);
        dft.setColumnCount(0);
        try {
            dft.addColumn("N° facture");
            dft.addColumn("Montant");
            dft.addColumn("Montant Versé");
            dft.addColumn("Reste");
            
            ps = c.connexionBdd().prepareStatement("select * from facture where matricule_pat=?");
            ps.setString(1, tmatricule.getText());
            rs = ps.executeQuery();
            while (rs.next()) {
                dft.addRow(new Object[]{
                    rs.getString("facture_id"),
                    rs.getString("montant"),
                    rs.getString("montant_versé"),
                    rs.getString("reste")
                }
                );
            }
            tfacture.setModel(dft);
        } catch (SQLException ex) {
            Logger.getLogger(DetailsPatient.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void actualiserc() {
        tpoids.setText("");
        ttaille.setText("");
        ttempérature.setText("");
        tfrequence.setText("");
        tglycemie.setText("");
        tpression.setText("");
        tobservation.setText("");
        dft1.setRowCount(0);
        dft1.setColumnCount(0);
        try {
            dft1.addColumn("N° Consultation");
            dft1.addColumn("Date Consultation");
            dft1.addColumn("N° Médecin");
            dft1.addColumn("Prix Consultation");
            
            ps = c.connexionBdd().prepareStatement("select * from consultation where matricule_pat=?");
            ps.setString(1, tmatricule.getText());
            rs = ps.executeQuery();
            while (rs.next()) {
                dft1.addRow(new Object[]{
                    rs.getString("consultation_id"),
                    rs.getString("date_cons"),
                    rs.getString("medecin_id"),
                    rs.getString("prix_consultation")
                }
                );
            }
            tconsultation.setModel(dft1);
        } catch (SQLException ex) {
            Logger.getLogger(DetailsPatient.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void actualiserRDV() {
        dft2.setRowCount(0);
        dft2.setColumnCount(0);
        try {
            dft2.addColumn("N° Rendez-vous");
            dft2.addColumn("Médecin");
            dft2.addColumn("Heur");
            dft2.addColumn("Date");
            ps = c.connexionBdd().prepareStatement("select * from rendez_vous where matricule_pat=?");
            ps.setString(1, tmatricule.getText());
            rs = ps.executeQuery();
            while (rs.next()) {
                dft2.addRow(new Object[]{
                    rs.getString("rdv_id"),
                    rs.getString("médecin_id"),
                    rs.getString("heure"),
                    rs.getString("daterdv")
                }
                );
            }
            trendezvous.setModel(dft2);
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

        tpath = new javax.swing.JTextField();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        tnom = new javax.swing.JTextField();
        tprenom = new javax.swing.JTextField();
        tmaladie = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        ttel = new javax.swing.JTextField();
        ttelurgence = new javax.swing.JTextField();
        tnumsecurite = new javax.swing.JTextField();
        temail = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tadresse = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        tnote = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        tantpersonnels = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        tantfamiliaux = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        tantmedicaux = new javax.swing.JTextArea();
        jScrollPane6 = new javax.swing.JScrollPane();
        tantchirurgicaux = new javax.swing.JTextArea();
        tmatricule = new javax.swing.JLabel();
        tsexe = new javax.swing.JTextField();
        tsituationfamiliale = new javax.swing.JTextField();
        tsanguin = new javax.swing.JTextField();
        tdate = new javax.swing.JTextField();
        bimprimer = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        limage = new javax.swing.JLabel();
        lfondInfo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        tpoids = new javax.swing.JTextField();
        ttaille = new javax.swing.JTextField();
        ttempérature = new javax.swing.JTextField();
        tfrequence = new javax.swing.JTextField();
        tpression = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        tobservation = new javax.swing.JTextArea();
        tglycemie = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        bactualiserc = new javax.swing.JButton();
        bajouterc = new javax.swing.JButton();
        bmodifierc = new javax.swing.JButton();
        bsupprimerc = new javax.swing.JButton();
        bimprimerc = new javax.swing.JButton();
        bdetailsc = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tconsultation = new javax.swing.JTable();
        jLabel23 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        trendezvous = new javax.swing.JTable();
        jLabel22 = new javax.swing.JLabel();
        bactualiserrdv = new javax.swing.JButton();
        bajouterrdv = new javax.swing.JButton();
        bsupprimerrdv = new javax.swing.JButton();
        bmodifierrdv = new javax.swing.JButton();
        bdetailsrdv = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        bactualiserpaiement = new javax.swing.JButton();
        bvalidation = new javax.swing.JButton();
        BimprimerFac = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        tfacture = new javax.swing.JTable();
        jLabel24 = new javax.swing.JLabel();
        bdetailfac = new javax.swing.JButton();
        nomprenom = new javax.swing.JLabel();

        tpath.setEditable(false);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N

        jPanel1.setEnabled(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setText("Nom :");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, -1, -1));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setText("prénom :");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 250, -1, -1));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setText("Date de naissance :");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 310, -1, -1));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setText("Maladie :");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 370, -1, -1));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setText("N° tél :");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 180, -1, -1));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setText("Adresse :");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 330, -1, -1));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setText("Antécédents personnels :");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 480, -1, -1));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setText("Antécédents familiaux :");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 360, -1, -1));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel9.setText("Antécédents médicaux :");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 120, -1, -1));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel10.setText("Groupe sanguin :");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 430, -1, -1));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel11.setText("Sexe :");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 480, -1, -1));

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel12.setText("N° sécurité social :");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 280, -1, -1));

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel13.setText("Note :");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 460, -1, -1));

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel14.setText("émail :");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 130, -1, -1));

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel15.setText("Matricule :");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, -1, -1));

        jLabel16.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel16.setText("N° tél cas d'urgence");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 230, -1, -1));

        jLabel17.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel17.setText("Antécédents chirurgicaux");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 240, -1, -1));

        tnom.setEditable(false);
        tnom.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tnom.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tnomFocusLost(evt);
            }
        });
        tnom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tnomActionPerformed(evt);
            }
        });
        jPanel1.add(tnom, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, 340, -1));

        tprenom.setEditable(false);
        tprenom.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tprenom.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tprenomFocusLost(evt);
            }
        });
        jPanel1.add(tprenom, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 280, 340, -1));

        tmaladie.setEditable(false);
        tmaladie.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tmaladie.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tmaladieFocusGained(evt);
            }
        });
        jPanel1.add(tmaladie, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 390, 340, -1));

        jLabel18.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel18.setText("Situation familial");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 530, -1, -1));

        ttel.setEditable(false);
        ttel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel1.add(ttel, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 200, 390, -1));

        ttelurgence.setEditable(false);
        ttelurgence.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel1.add(ttelurgence, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 250, 390, -1));

        tnumsecurite.setEditable(false);
        tnumsecurite.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel1.add(tnumsecurite, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 300, 390, -1));

        temail.setEditable(false);
        temail.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel1.add(temail, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 150, 390, -1));

        tadresse.setEditable(false);
        tadresse.setColumns(20);
        tadresse.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tadresse.setRows(5);
        jScrollPane1.setViewportView(tadresse);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 350, 390, -1));

        tnote.setEditable(false);
        tnote.setColumns(20);
        tnote.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tnote.setRows(5);
        jScrollPane2.setViewportView(tnote);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 480, 390, 110));

        tantpersonnels.setEditable(false);
        tantpersonnels.setColumns(20);
        tantpersonnels.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tantpersonnels.setRows(5);
        jScrollPane3.setViewportView(tantpersonnels);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 500, 480, -1));

        tantfamiliaux.setEditable(false);
        tantfamiliaux.setColumns(20);
        tantfamiliaux.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tantfamiliaux.setRows(5);
        jScrollPane4.setViewportView(tantfamiliaux);

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 380, 480, -1));

        tantmedicaux.setEditable(false);
        tantmedicaux.setColumns(20);
        tantmedicaux.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tantmedicaux.setRows(5);
        jScrollPane5.setViewportView(tantmedicaux);

        jPanel1.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 140, 480, -1));

        tantchirurgicaux.setEditable(false);
        tantchirurgicaux.setColumns(20);
        tantchirurgicaux.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tantchirurgicaux.setRows(5);
        jScrollPane6.setViewportView(tantchirurgicaux);

        jPanel1.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 260, 480, -1));

        tmatricule.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel1.add(tmatricule, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, 340, 30));

        tsexe.setEditable(false);
        tsexe.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel1.add(tsexe, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 500, 340, -1));

        tsituationfamiliale.setEditable(false);
        tsituationfamiliale.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel1.add(tsituationfamiliale, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 560, 340, -1));

        tsanguin.setEditable(false);
        tsanguin.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel1.add(tsanguin, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 450, 340, -1));

        tdate.setEditable(false);
        tdate.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel1.add(tdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 330, 340, -1));

        bimprimer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/imprimante.png"))); // NOI18N
        bimprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bimprimerActionPerformed(evt);
            }
        });
        jPanel1.add(bimprimer, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jPanel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        limage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                limageMouseClicked(evt);
            }
        });
        jPanel8.add(limage, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 90, 100));

        jPanel1.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 0, 90, 100));

        lfondInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/detailspatientInfo.png"))); // NOI18N
        jPanel1.add(lfondInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jTabbedPane1.addTab("Infos", jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Constants vitales", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14), new java.awt.Color(0, 204, 204))); // NOI18N
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel28.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel28.setText("Taille (m):");
        jPanel7.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        jLabel29.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel29.setText("Poids (kg) :");
        jPanel7.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        jLabel30.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel30.setText("Fréquence cardiaque :");
        jPanel7.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, -1));

        jLabel31.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel31.setText("Températur (C°) :");
        jPanel7.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        tpoids.setEditable(false);
        tpoids.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        tpoids.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tpoidsActionPerformed(evt);
            }
        });
        jPanel7.add(tpoids, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, 70, -1));

        ttaille.setEditable(false);
        ttaille.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        ttaille.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ttailleActionPerformed(evt);
            }
        });
        jPanel7.add(ttaille, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, 70, -1));

        ttempérature.setEditable(false);
        ttempérature.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        ttempérature.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ttempératureActionPerformed(evt);
            }
        });
        jPanel7.add(ttempérature, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 70, -1));

        tfrequence.setEditable(false);
        tfrequence.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        tfrequence.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfrequenceActionPerformed(evt);
            }
        });
        jPanel7.add(tfrequence, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 160, 70, -1));

        tpression.setEditable(false);
        tpression.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        tpression.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tpressionActionPerformed(evt);
            }
        });
        jPanel7.add(tpression, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 240, 70, -1));

        jLabel19.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel19.setText("Observation :");
        jPanel7.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, -1, -1));

        tobservation.setEditable(false);
        tobservation.setColumns(20);
        tobservation.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        tobservation.setRows(5);
        jScrollPane10.setViewportView(tobservation);

        jPanel7.add(jScrollPane10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, 220, 160));

        tglycemie.setEditable(false);
        tglycemie.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        tglycemie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tglycemieActionPerformed(evt);
            }
        });
        jPanel7.add(tglycemie, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 200, 70, -1));

        jLabel20.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel20.setText("Pression Artérielle :");
        jPanel7.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, -1, -1));

        jLabel21.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel21.setText("Glycémie :");
        jPanel7.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, -1, -1));

        jPanel2.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 90, 240, 520));

        bactualiserc.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        bactualiserc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/mettre-a-jour.png"))); // NOI18N
        bactualiserc.setText("Actualiser");
        bactualiserc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bactualisercActionPerformed(evt);
            }
        });
        jPanel2.add(bactualiserc, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 20, 120, -1));

        bajouterc.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        bajouterc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/plus.png"))); // NOI18N
        bajouterc.setText("Ajouter");
        bajouterc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bajoutercActionPerformed(evt);
            }
        });
        jPanel2.add(bajouterc, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 20, 120, -1));

        bmodifierc.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        bmodifierc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/crayon.png"))); // NOI18N
        bmodifierc.setText("Modifier");
        bmodifierc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bmodifiercActionPerformed(evt);
            }
        });
        jPanel2.add(bmodifierc, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 20, 120, -1));

        bsupprimerc.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        bsupprimerc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/supprimer-le-symbole.png"))); // NOI18N
        bsupprimerc.setText("Supprimer");
        bsupprimerc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bsupprimercActionPerformed(evt);
            }
        });
        jPanel2.add(bsupprimerc, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 20, 130, -1));

        bimprimerc.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        bimprimerc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/imprimante.png"))); // NOI18N
        bimprimerc.setText("Imprimer");
        bimprimerc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bimprimercActionPerformed(evt);
            }
        });
        jPanel2.add(bimprimerc, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 20, 120, 30));

        bdetailsc.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        bdetailsc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/info.png"))); // NOI18N
        bdetailsc.setText("Details");
        bdetailsc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bdetailscActionPerformed(evt);
            }
        });
        jPanel2.add(bdetailsc, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 20, 120, -1));

        jPanel5.setBackground(new java.awt.Color(0, 0, 204));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tconsultation.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tconsultation.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N° Consultation", "Date Consultation", "N° Médecin", "Prix Consultation"
            }
        ));
        tconsultation.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tconsultationMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(tconsultation);
        if (tconsultation.getColumnModel().getColumnCount() > 0) {
            tconsultation.getColumnModel().getColumn(3).setResizable(false);
        }

        jPanel5.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 1100, 490));

        jLabel23.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Les Consultation :");
        jPanel5.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 10, -1, -1));

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 1101, 530));

        jTabbedPane1.addTab("Consultations", jPanel2);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBackground(new java.awt.Color(0, 255, 0));
        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        trendezvous.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        trendezvous.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N° Rendez-vous", "Médecin", "Heure", "Date"
            }
        ));
        jScrollPane7.setViewportView(trendezvous);

        jPanel6.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 1360, 500));

        jLabel22.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Les Rendez-vous :");
        jPanel6.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 0, -1, 30));

        jPanel3.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 1362, 530));

        bactualiserrdv.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        bactualiserrdv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/mettre-a-jour.png"))); // NOI18N
        bactualiserrdv.setText("Actualiser");
        bactualiserrdv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bactualiserrdvActionPerformed(evt);
            }
        });
        jPanel3.add(bactualiserrdv, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 10, 130, -1));

        bajouterrdv.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        bajouterrdv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/plus.png"))); // NOI18N
        bajouterrdv.setText("Ajouter");
        bajouterrdv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bajouterrdvActionPerformed(evt);
            }
        });
        jPanel3.add(bajouterrdv, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 10, 120, -1));

        bsupprimerrdv.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        bsupprimerrdv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/supprimer-le-symbole.png"))); // NOI18N
        bsupprimerrdv.setText("Supprimer");
        bsupprimerrdv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bsupprimerrdvActionPerformed(evt);
            }
        });
        jPanel3.add(bsupprimerrdv, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 10, 130, -1));

        bmodifierrdv.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        bmodifierrdv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/crayon.png"))); // NOI18N
        bmodifierrdv.setText("Modifier");
        bmodifierrdv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bmodifierrdvActionPerformed(evt);
            }
        });
        jPanel3.add(bmodifierrdv, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 10, 120, -1));

        bdetailsrdv.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        bdetailsrdv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/info.png"))); // NOI18N
        bdetailsrdv.setText("Details");
        bdetailsrdv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bdetailsrdvActionPerformed(evt);
            }
        });
        jPanel3.add(bdetailsrdv, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 10, 120, -1));

        jTabbedPane1.addTab("Rendez-vous", jPanel3);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bactualiserpaiement.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        bactualiserpaiement.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/mettre-a-jour.png"))); // NOI18N
        bactualiserpaiement.setText("Actualiser");
        bactualiserpaiement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bactualiserpaiementActionPerformed(evt);
            }
        });
        jPanel4.add(bactualiserpaiement, new org.netbeans.lib.awtextra.AbsoluteConstraints(1240, 30, -1, -1));

        bvalidation.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        bvalidation.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/verifier.png"))); // NOI18N
        bvalidation.setText("Valider");
        bvalidation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bvalidationActionPerformed(evt);
            }
        });
        jPanel4.add(bvalidation, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 30, -1, -1));

        BimprimerFac.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        BimprimerFac.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/imprimante.png"))); // NOI18N
        BimprimerFac.setText("Imprimer");
        BimprimerFac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BimprimerFacActionPerformed(evt);
            }
        });
        jPanel4.add(BimprimerFac, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 30, -1, -1));

        jPanel9.setBackground(new java.awt.Color(0, 255, 204));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tfacture.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tfacture.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N° facture", "Montant", "Montant versé", "Reste"
            }
        ));
        tfacture.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tfactureMouseClicked(evt);
            }
        });
        jScrollPane9.setViewportView(tfacture);

        jPanel9.add(jScrollPane9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 1360, 530));

        jLabel24.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel24.setText("Les factures :");
        jPanel9.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 0, -1, 30));

        jPanel4.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 1361, 540));

        bdetailfac.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/info.png"))); // NOI18N
        bdetailfac.setText("Détails");
        bdetailfac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bdetailfacActionPerformed(evt);
            }
        });
        jPanel4.add(bdetailfac, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 30, -1, -1));

        jTabbedPane1.addTab("Paiement", jPanel4);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, -1, -1));

        nomprenom.setFont(new java.awt.Font("Arial", 1, 26)); // NOI18N
        nomprenom.setText("....");
        getContentPane().add(nomprenom, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bimprimercActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bimprimercActionPerformed
        if (prv.charAt(12) == '1') {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_cabinet_medical", "root", "");
                JasperDesign jdesing = JRXmlLoader.load("C:\\Users\\azus\\Documents\\NetBeansProjects\\gestion d'une cabinet medicale V7\\src\\EtatImpression\\ListeConsultation.jrxml");
                String query = "select * from consultation where matricule_pat='" + tmatricule.getText() + "'";
                JRDesignQuery updateQuery = new JRDesignQuery();
                updateQuery.setText(query);
                jdesing.setQuery(updateQuery);
                JasperReport jreport = JasperCompileManager.compileReport(jdesing);
                JasperPrint jprint = JasperFillManager.fillReport(jreport, null, con);
                
                JasperViewer.viewReport(jprint);
                
            } catch (ClassNotFoundException | SQLException | JRException ex) {
                Logger.getLogger(DetailsPatient.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Vous disposer pas de ce privilége !");
        }
    }//GEN-LAST:event_bimprimercActionPerformed

    private void bmodifiercActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bmodifiercActionPerformed
        if (prv.charAt(10) == '1') {
            if (tconsultation.getSelectedRowCount() == 1) {
                DetailsConsultationMAJ dcm = new DetailsConsultationMAJ();
                dcm.setVisible(true);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Vous disposer pas de ce privilége !");
        }
    }//GEN-LAST:event_bmodifiercActionPerformed

    private void bsupprimercActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsupprimercActionPerformed
        if (prv.charAt(11) == '1') {
            if (tconsultation.getSelectedRowCount() == 1) {
                if (JOptionPane.showConfirmDialog(this, "Voulez vous vraiment supprimer la consultation ?", "confirmation", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    try {
                        ps = c.connexionBdd().prepareStatement("delete from consultation where consultation_id=?");
                        ps.setString(1, tconsultation.getValueAt(tconsultation.getSelectedRow(), 0) + "");
                        ps.executeUpdate();
                        JOptionPane.showMessageDialog(this, "Suppression faite avec succés");
                        actualiserc();
                    } catch (SQLException ex) {
                        Logger.getLogger(DetailsPatient.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Vous disposer pas de ce privilége !");
        }
    }//GEN-LAST:event_bsupprimercActionPerformed

    private void bdetailscActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bdetailscActionPerformed
        if (prv.charAt(32) == '1') {
            if (tconsultation.getSelectedRowCount() == 1) {
                DetailsConsultationVoir dcv = new DetailsConsultationVoir();
                dcv.setVisible(true);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Vous disposer pas de ce privilége !");
        }
    }//GEN-LAST:event_bdetailscActionPerformed

    private void bajoutercActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bajoutercActionPerformed
        if (prv.charAt(9) == '1') {
            DetailsConsultation dc = new DetailsConsultation();
            dc.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Vous disposer pas de ce privilége !");
        }
    }//GEN-LAST:event_bajoutercActionPerformed

    private void bsupprimerrdvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsupprimerrdvActionPerformed
        if (prv.charAt(15) == '1') {
            if (trendezvous.getSelectedRowCount() == 1) {
                if (JOptionPane.showConfirmDialog(this, "Voulez vous vraiment supprimer le rendez-vous ?", "confirmation", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    try {
                        ps = c.connexionBdd().prepareStatement("delete from rendez_vous where rdv_id=?");
                        ps.setString(1, trendezvous.getValueAt(trendezvous.getSelectedRow(), 0) + "");
                        ps.executeUpdate();
                        JOptionPane.showMessageDialog(this, "Suppression faite avec succés");
                        actualiserRDV();
                    } catch (SQLException ex) {
                        Logger.getLogger(DetailsPatient.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Vous disposer pas de ce privilége !");
        }
    }//GEN-LAST:event_bsupprimerrdvActionPerformed

    private void bmodifierrdvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bmodifierrdvActionPerformed
        if (prv.charAt(14) == '1') {
            if (trendezvous.getSelectedRowCount() == 1) {
                DetailsRDVMAJ drdvm = new DetailsRDVMAJ();
                drdvm.setVisible(true);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Vous disposer pas de ce privilége !");
        }
    }//GEN-LAST:event_bmodifierrdvActionPerformed

    private void bajouterrdvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bajouterrdvActionPerformed
        if (prv.charAt(13) == '1') {
            DetailsRDV rdv = new DetailsRDV();
            rdv.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Vous disposer pas de ce privilége !");
        }
    }//GEN-LAST:event_bajouterrdvActionPerformed

    private void bactualisercActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bactualisercActionPerformed
        actualiserc();
    }//GEN-LAST:event_bactualisercActionPerformed

    private void bdetailsrdvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bdetailsrdvActionPerformed
        if (prv.charAt(34) == '1') {
            if (trendezvous.getSelectedRowCount() == 1) {
                DetailsRDVvoir drdvv = new DetailsRDVvoir();
                drdvv.setVisible(true);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Vous disposer pas de ce privilége !");
        }
    }//GEN-LAST:event_bdetailsrdvActionPerformed

    private void tnomFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tnomFocusLost

    }//GEN-LAST:event_tnomFocusLost

    private void tnomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tnomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tnomActionPerformed

    private void tprenomFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tprenomFocusLost

    }//GEN-LAST:event_tprenomFocusLost

    private void tmaladieFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tmaladieFocusGained

    }//GEN-LAST:event_tmaladieFocusGained

    private void limageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_limageMouseClicked

    }//GEN-LAST:event_limageMouseClicked

    private void bactualiserrdvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bactualiserrdvActionPerformed
        actualiserRDV();
    }//GEN-LAST:event_bactualiserrdvActionPerformed

    private void tfactureMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfactureMouseClicked

    }//GEN-LAST:event_tfactureMouseClicked

    private void bactualiserpaiementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bactualiserpaiementActionPerformed
        actualiserfac();
    }//GEN-LAST:event_bactualiserpaiementActionPerformed

    private void bvalidationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bvalidationActionPerformed
        if (prv.charAt(30) == '1') {
            if (tfacture.getSelectedColumnCount() == 1) {
                ValiderPayement vp = new ValiderPayement();
                vp.setVisible(true);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Vous disposer pas de ce privilége !");
        }
    }//GEN-LAST:event_bvalidationActionPerformed

    private void bimprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bimprimerActionPerformed
        if (prv.charAt(4) == '1') {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_cabinet_medical", "root", "");
                JasperDesign jdesing = JRXmlLoader.load("C:\\Users\\azus\\Documents\\NetBeansProjects\\gestion d'une cabinet medicale V7\\src\\EtatImpression\\Patient.jrxml");
                String query = "select * from patient where matricule_pat='" + tmatricule.getText() + "'";
                JRDesignQuery updateQuery = new JRDesignQuery();
                updateQuery.setText(query);
                jdesing.setQuery(updateQuery);
                JasperReport jreport = JasperCompileManager.compileReport(jdesing);
                JasperPrint jprint = JasperFillManager.fillReport(jreport, null, con);
                
                JasperViewer.viewReport(jprint);
                
            } catch (ClassNotFoundException | SQLException | JRException ex) {
                Logger.getLogger(DetailsPatient.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Vous disposer pas de ce privilége !");
        }
    }//GEN-LAST:event_bimprimerActionPerformed

    private void tpoidsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tpoidsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tpoidsActionPerformed

    private void ttailleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ttailleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ttailleActionPerformed

    private void ttempératureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ttempératureActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ttempératureActionPerformed

    private void tfrequenceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfrequenceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfrequenceActionPerformed

    private void tpressionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tpressionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tpressionActionPerformed

    private void tglycemieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tglycemieActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tglycemieActionPerformed

    private void BimprimerFacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BimprimerFacActionPerformed
        if (prv.charAt(31) == '1') {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_cabinet_medical", "root", "");
                JasperDesign jdesing = JRXmlLoader.load("C:\\Users\\azus\\Documents\\NetBeansProjects\\gestion d'une cabinet medicale V7\\src\\EtatImpression\\ListeFacture.jrxml");
                String query = "select * from facture where matricule_pat='" + tmatricule.getText() + "'";
                JRDesignQuery updateQuery = new JRDesignQuery();
                updateQuery.setText(query);
                jdesing.setQuery(updateQuery);
                JasperReport jreport = JasperCompileManager.compileReport(jdesing);
                JasperPrint jprint = JasperFillManager.fillReport(jreport, null, con);
                
                JasperViewer.viewReport(jprint);
                
            } catch (ClassNotFoundException | SQLException | JRException ex) {
                Logger.getLogger(DetailsPatient.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Vous disposer pas de ce privilége !");
        }
    }//GEN-LAST:event_BimprimerFacActionPerformed

    private void tconsultationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tconsultationMouseClicked
        try {
            ps = c.connexionBdd().prepareStatement("select * from consultation where consultation_id=?");
            ps.setString(1, tconsultation.getValueAt(DetailsPatient.tconsultation.getSelectedRow(), 0) + "");
            rs = ps.executeQuery();
            while (rs.next()) {
                tpoids.setText(rs.getString("poids"));
                ttaille.setText(rs.getString("taille"));
                ttempérature.setText(rs.getString("température"));
                tfrequence.setText(rs.getString("fréquence_cardiaque"));
                tglycemie.setText(rs.getString("glycémie"));
                tpression.setText(rs.getString("pression_artérielle"));
                tobservation.setText("observation");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DetailsConsultationVoir.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tconsultationMouseClicked

    private void bdetailfacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bdetailfacActionPerformed
        FactureDétails fd = new FactureDétails();
        fd.setVisible(true);
    }//GEN-LAST:event_bdetailfacActionPerformed

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
            java.util.logging.Logger.getLogger(DetailsPatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DetailsPatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DetailsPatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DetailsPatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DetailsPatient().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BimprimerFac;
    private javax.swing.JButton bactualiserc;
    private javax.swing.JButton bactualiserpaiement;
    private javax.swing.JButton bactualiserrdv;
    private javax.swing.JButton bajouterc;
    private javax.swing.JButton bajouterrdv;
    private javax.swing.JButton bdetailfac;
    private javax.swing.JButton bdetailsc;
    private javax.swing.JButton bdetailsrdv;
    private javax.swing.JButton bimprimer;
    private javax.swing.JButton bimprimerc;
    private javax.swing.JButton bmodifierc;
    private javax.swing.JButton bmodifierrdv;
    private javax.swing.JButton bsupprimerc;
    private javax.swing.JButton bsupprimerrdv;
    private javax.swing.JButton bvalidation;
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
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lfondInfo;
    private javax.swing.JLabel limage;
    private javax.swing.JLabel nomprenom;
    private javax.swing.JTextArea tadresse;
    private javax.swing.JTextArea tantchirurgicaux;
    private javax.swing.JTextArea tantfamiliaux;
    private javax.swing.JTextArea tantmedicaux;
    private javax.swing.JTextArea tantpersonnels;
    public static javax.swing.JTable tconsultation;
    private javax.swing.JTextField tdate;
    private javax.swing.JTextField temail;
    public static javax.swing.JTable tfacture;
    public static javax.swing.JTextField tfrequence;
    public static javax.swing.JTextField tglycemie;
    private javax.swing.JTextField tmaladie;
    public static javax.swing.JLabel tmatricule;
    private javax.swing.JTextField tnom;
    private javax.swing.JTextArea tnote;
    private javax.swing.JTextField tnumsecurite;
    public static javax.swing.JTextArea tobservation;
    private javax.swing.JTextField tpath;
    public static javax.swing.JTextField tpoids;
    private javax.swing.JTextField tprenom;
    public static javax.swing.JTextField tpression;
    public static javax.swing.JTable trendezvous;
    private javax.swing.JTextField tsanguin;
    private javax.swing.JTextField tsexe;
    private javax.swing.JTextField tsituationfamiliale;
    public static javax.swing.JTextField ttaille;
    private javax.swing.JTextField ttel;
    private javax.swing.JTextField ttelurgence;
    public static javax.swing.JTextField ttempérature;
    // End of variables declaration//GEN-END:variables
}
