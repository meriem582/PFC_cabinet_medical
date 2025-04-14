/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import Modele.Connexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author azus
 */
public class DetailsParamètre extends javax.swing.JFrame {

    Connexion c = new Connexion();
    PreparedStatement ps;
    DefaultTableModel dft = new DefaultTableModel();
    ResultSet rs;

    /**
     * Creates new form DetailsParamètre
     */
    public DetailsParamètre() {
        initComponents();
        setLocationRelativeTo(this);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        try {
            ps = c.connexionBdd().prepareStatement("select specialite from medecin where nom_utilisateur=?");
            ps.setString(1, Paramètre.tutilisateur.getValueAt(Paramètre.tutilisateur.getSelectedRow(), 0) + "");
            rs = ps.executeQuery();
            while (rs.next()) {
                tspecialite.setText(rs.getString("specialite"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProfilParamètreMAJ.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {

            ps = c.connexionBdd().prepareStatement("select * from utilisateurs where nom_utilisateur=?");
            ps.setString(1, Paramètre.tutilisateur.getValueAt(Paramètre.tutilisateur.getSelectedRow(), 0) + "");
            rs = ps.executeQuery();
            while (rs.next()) {
                tusername.setText(rs.getString("nom_utilisateur"));
                tnom.setText(rs.getString("nom"));
                tprenom.setText(rs.getString("prénom"));
                tpassword.setText(rs.getString("mdp"));

                if (rs.getString("privilége").charAt(0) == '1') {
                    caddpatient.setSelected(true);
                }
                if (rs.getString("privilége").charAt(1) == '1') {
                    cmodifierpatient.setSelected(true);
                }
                if (rs.getString("privilége").charAt(2) == '1') {
                    cdelpatient.setSelected(true);
                }
                if (rs.getString("privilége").charAt(3) == '1') {
                    cdetailspatient.setSelected(true);
                }
                if (rs.getString("privilége").charAt(4) == '1') {
                    cimprimerfichepatient.setSelected(true);
                }
                if (rs.getString("privilége").charAt(5) == '1') {
                    cadddepense.setSelected(true);
                }
                if (rs.getString("privilége").charAt(6) == '1') {
                    cmodifierdepense.setSelected(true);
                }
                if (rs.getString("privilége").charAt(7) == '1') {
                    cdeldepense.setSelected(true);
                }
                if (rs.getString("privilége").charAt(8) == '1') {
                    cimprimerlistedep.setSelected(true);
                }
                if (rs.getString("privilége").charAt(9) == '1') {
                    caddconsultation.setSelected(true);
                }
                if (rs.getString("privilége").charAt(10) == '1') {
                    cmodifierconsultation.setSelected(true);
                }
                if (rs.getString("privilége").charAt(11) == '1') {
                    cdelconsultation.setSelected(true);
                }
                if (rs.getString("privilége").charAt(12) == '1') {
                    cimprimerconsultation.setSelected(true);
                }
                if (rs.getString("privilége").charAt(13) == '1') {
                    caddrdv.setSelected(true);
                }
                if (rs.getString("privilége").charAt(14) == '1') {
                    cmodifierrdv.setSelected(true);
                }
                if (rs.getString("privilége").charAt(15) == '1') {
                    cdelrdv.setSelected(true);
                }
                if (rs.getString("privilége").charAt(16) == '1') {
                    caddordonance.setSelected(true);
                }

                if (rs.getString("privilége").charAt(17) == '1') {
                    cmodifierordonance.setSelected(true);
                }

                if (rs.getString("privilége").charAt(18) == '1') {
                    cdelordonance.setSelected(true);
                }
                if (rs.getString("privilége").charAt(19) == '1') {
                    cimprimerordonance.setSelected(true);
                }
                if (rs.getString("privilége").charAt(20) == '1') {
                    caddsalleattente.setSelected(true);
                }
                if (rs.getString("privilége").charAt(21) == '1') {
                    cdelsalleattente.setSelected(true);
                }
                if (rs.getString("privilége").charAt(22) == '1') {
                    csalleattente.setSelected(true);
                }
                if (rs.getString("privilége").charAt(23) == '1') {
                    caddrevenue.setSelected(true);
                }
                if (rs.getString("privilége").charAt(24) == '1') {
                    cmodifierrevenue.setSelected(true);
                }
                if (rs.getString("privilége").charAt(25) == '1') {
                    cdelrevenue.setSelected(true);
                }
                if (rs.getString("privilége").charAt(26) == '1') {
                    cimprimerrevenue.setSelected(true);
                }
                if (rs.getString("privilége").charAt(27) == '1') {
                    caddnote.setSelected(true);
                }
                if (rs.getString("privilége").charAt(28) == '1') {
                    cmodifiernote.setSelected(true);
                }
                if (rs.getString("privilége").charAt(29) == '1') {
                    cdelnote.setSelected(true);
                }
                if (rs.getString("privilége").charAt(30) == '1') {
                    creglerfacture.setSelected(true);
                }
                if (rs.getString("privilége").charAt(31) == '1') {
                    cimprimerfac.setSelected(true);
                }
                if (rs.getString("privilége").charAt(32) == '1') {
                    cdetailsconsultation.setSelected(true);
                }
                if (rs.getString("privilége").charAt(33) == '1') {
                    cdetailsordonance.setSelected(true);
                }
                if (rs.getString("privilége").charAt(34) == '1') {
                    cdetailsrdv.setSelected(true);
                }
                ltype.setText(rs.getString("type_utilisateur"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DetailsParamètre.class.getName()).log(Level.SEVERE, null, ex);
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tusername = new javax.swing.JTextField();
        tprenom = new javax.swing.JTextField();
        tnom = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        caddpatient = new javax.swing.JCheckBox();
        cdetailspatient = new javax.swing.JCheckBox();
        cmodifierpatient = new javax.swing.JCheckBox();
        cdelpatient = new javax.swing.JCheckBox();
        cmodifierconsultation = new javax.swing.JCheckBox();
        cdelconsultation = new javax.swing.JCheckBox();
        caddconsultation = new javax.swing.JCheckBox();
        caddrdv = new javax.swing.JCheckBox();
        cdelrdv = new javax.swing.JCheckBox();
        cmodifierrdv = new javax.swing.JCheckBox();
        cimprimerfac = new javax.swing.JCheckBox();
        caddrevenue = new javax.swing.JCheckBox();
        creglerfacture = new javax.swing.JCheckBox();
        cmodifierdepense = new javax.swing.JCheckBox();
        cdeldepense = new javax.swing.JCheckBox();
        cadddepense = new javax.swing.JCheckBox();
        cdelrevenue = new javax.swing.JCheckBox();
        cmodifierrevenue = new javax.swing.JCheckBox();
        cdelordonance = new javax.swing.JCheckBox();
        caddordonance = new javax.swing.JCheckBox();
        cmodifierordonance = new javax.swing.JCheckBox();
        cdelsalleattente = new javax.swing.JCheckBox();
        cimprimerfichepatient = new javax.swing.JCheckBox();
        caddsalleattente = new javax.swing.JCheckBox();
        cdelnote = new javax.swing.JCheckBox();
        caddnote = new javax.swing.JCheckBox();
        cmodifiernote = new javax.swing.JCheckBox();
        cimprimerlistedep = new javax.swing.JCheckBox();
        cimprimerconsultation = new javax.swing.JCheckBox();
        cimprimerrevenue = new javax.swing.JCheckBox();
        cimprimerordonance = new javax.swing.JCheckBox();
        csalleattente = new javax.swing.JCheckBox();
        cdetailsrdv = new javax.swing.JCheckBox();
        cdetailsconsultation = new javax.swing.JCheckBox();
        cdetailsordonance = new javax.swing.JCheckBox();
        tspecialite = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tpassword = new javax.swing.JTextField();
        ltype = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setText("Username * :");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 60, -1, -1));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setText("Prénom * :");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, -1, -1));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setText("Password * :");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 100, -1, -1));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setText("Type * :");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 60, -1, -1));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setText("Nom * :");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, -1, -1));

        tusername.setEditable(false);
        tusername.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        getContentPane().add(tusername, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 60, 140, -1));

        tprenom.setEditable(false);
        tprenom.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        getContentPane().add(tprenom, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, 140, -1));

        tnom.setEditable(false);
        tnom.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tnom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tnomActionPerformed(evt);
            }
        });
        getContentPane().add(tnom, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 60, 140, -1));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Les privilèges"));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        caddpatient.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        caddpatient.setText("Ajouter Patient");
        jPanel1.add(caddpatient, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        cdetailspatient.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        cdetailspatient.setText("Détails patient");
        jPanel1.add(cdetailspatient, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        cmodifierpatient.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        cmodifierpatient.setText("Modifier Patient");
        cmodifierpatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmodifierpatientActionPerformed(evt);
            }
        });
        jPanel1.add(cmodifierpatient, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        cdelpatient.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        cdelpatient.setText("Supprimer Patient");
        jPanel1.add(cdelpatient, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        cmodifierconsultation.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        cmodifierconsultation.setText("Modifier Consultation");
        jPanel1.add(cmodifierconsultation, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, -1, -1));

        cdelconsultation.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        cdelconsultation.setText("Supprimer Consultation");
        jPanel1.add(cdelconsultation, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, -1, -1));

        caddconsultation.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        caddconsultation.setText("Ajouter Consultation");
        jPanel1.add(caddconsultation, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, -1, -1));

        caddrdv.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        caddrdv.setText("Ajouter Rendez-vous");
        caddrdv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                caddrdvActionPerformed(evt);
            }
        });
        jPanel1.add(caddrdv, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 200, -1, -1));

        cdelrdv.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        cdelrdv.setText("Supprimer Rendez-vous");
        jPanel1.add(cdelrdv, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 260, -1, -1));

        cmodifierrdv.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        cmodifierrdv.setText("Modifier Rendez-vous");
        jPanel1.add(cmodifierrdv, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 230, -1, -1));

        cimprimerfac.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        cimprimerfac.setText("Imprimer facture");
        jPanel1.add(cimprimerfac, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 230, -1, -1));

        caddrevenue.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        caddrevenue.setText("Ajouter Revenue");
        jPanel1.add(caddrevenue, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 30, -1, -1));

        creglerfacture.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        creglerfacture.setText("Régler facture");
        jPanel1.add(creglerfacture, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 200, -1, -1));

        cmodifierdepense.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        cmodifierdepense.setText("Modifier dépense");
        cmodifierdepense.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmodifierdepenseActionPerformed(evt);
            }
        });
        jPanel1.add(cmodifierdepense, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        cdeldepense.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        cdeldepense.setText("Supprimer dépense");
        jPanel1.add(cdeldepense, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, -1, -1));

        cadddepense.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        cadddepense.setText("Ajouter Dépense");
        jPanel1.add(cadddepense, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, -1));

        cdelrevenue.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        cdelrevenue.setText("Supprimer Revenue");
        jPanel1.add(cdelrevenue, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 90, -1, -1));

        cmodifierrevenue.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        cmodifierrevenue.setText("Modifier Revenue");
        jPanel1.add(cmodifierrevenue, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 60, -1, -1));

        cdelordonance.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        cdelordonance.setText("Supprimer Ordonance");
        jPanel1.add(cdelordonance, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 90, -1, -1));

        caddordonance.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        caddordonance.setText("Ajouter Ordonance");
        jPanel1.add(caddordonance, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 30, -1, -1));

        cmodifierordonance.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        cmodifierordonance.setText("Modifier Ordonance");
        jPanel1.add(cmodifierordonance, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 60, -1, -1));

        cdelsalleattente.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        cdelsalleattente.setText("Supprimer de salle d'attente");
        cdelsalleattente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cdelsalleattenteActionPerformed(evt);
            }
        });
        jPanel1.add(cdelsalleattente, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 230, -1, -1));

        cimprimerfichepatient.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        cimprimerfichepatient.setText("Imprimer Fiche patient");
        cimprimerfichepatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cimprimerfichepatientActionPerformed(evt);
            }
        });
        jPanel1.add(cimprimerfichepatient, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));

        caddsalleattente.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        caddsalleattente.setText("Ajouter Salle d'attente");
        jPanel1.add(caddsalleattente, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 200, -1, -1));

        cdelnote.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        cdelnote.setText("Supprimer Note");
        jPanel1.add(cdelnote, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 260, -1, -1));

        caddnote.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        caddnote.setText("Ajouter Note");
        caddnote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                caddnoteActionPerformed(evt);
            }
        });
        jPanel1.add(caddnote, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 200, -1, -1));

        cmodifiernote.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        cmodifiernote.setText("Modifier Note");
        jPanel1.add(cmodifiernote, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 230, -1, -1));

        cimprimerlistedep.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        cimprimerlistedep.setText("Imprimer liste Dépense");
        cimprimerlistedep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cimprimerlistedepActionPerformed(evt);
            }
        });
        jPanel1.add(cimprimerlistedep, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, -1, -1));

        cimprimerconsultation.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        cimprimerconsultation.setText("Imprimer liste consultation");
        cimprimerconsultation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cimprimerconsultationActionPerformed(evt);
            }
        });
        jPanel1.add(cimprimerconsultation, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 120, -1, -1));

        cimprimerrevenue.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        cimprimerrevenue.setText("Imprimer liste Revenues");
        cimprimerrevenue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cimprimerrevenueActionPerformed(evt);
            }
        });
        jPanel1.add(cimprimerrevenue, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 120, -1, -1));

        cimprimerordonance.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        cimprimerordonance.setText("Imprimer Ordonance");
        jPanel1.add(cimprimerordonance, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 120, -1, -1));

        csalleattente.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        csalleattente.setText("Fenêtre Salle d'attente");
        csalleattente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                csalleattenteActionPerformed(evt);
            }
        });
        jPanel1.add(csalleattente, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 260, -1, -1));

        cdetailsrdv.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        cdetailsrdv.setText("Détails Rendez-vous");
        jPanel1.add(cdetailsrdv, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 290, -1, -1));

        cdetailsconsultation.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        cdetailsconsultation.setText("Détails consultation");
        jPanel1.add(cdetailsconsultation, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 150, -1, -1));

        cdetailsordonance.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        cdetailsordonance.setText("Détails Ordonance");
        jPanel1.add(cdetailsordonance, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 150, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 750, 320));

        tspecialite.setEditable(false);
        tspecialite.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tspecialite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tspecialiteActionPerformed(evt);
            }
        });
        getContentPane().add(tspecialite, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 100, 140, -1));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setText("spécialité * :");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 100, -1, -1));

        tpassword.setEditable(false);
        tpassword.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        getContentPane().add(tpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 100, 140, -1));

        ltype.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        ltype.setText("...");
        getContentPane().add(ltype, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 60, -1, -1));

        jButton1.setBackground(new java.awt.Color(255, 0, 0));
        jButton1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/croix.png"))); // NOI18N
        jButton1.setText("Quitter");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 480, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tnomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tnomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tnomActionPerformed

    private void cmodifierpatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmodifierpatientActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmodifierpatientActionPerformed

    private void caddrdvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_caddrdvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_caddrdvActionPerformed

    private void cmodifierdepenseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmodifierdepenseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmodifierdepenseActionPerformed

    private void cdelsalleattenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cdelsalleattenteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cdelsalleattenteActionPerformed

    private void cimprimerfichepatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cimprimerfichepatientActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cimprimerfichepatientActionPerformed

    private void caddnoteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_caddnoteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_caddnoteActionPerformed

    private void cimprimerlistedepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cimprimerlistedepActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cimprimerlistedepActionPerformed

    private void cimprimerconsultationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cimprimerconsultationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cimprimerconsultationActionPerformed

    private void cimprimerrevenueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cimprimerrevenueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cimprimerrevenueActionPerformed

    private void csalleattenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_csalleattenteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_csalleattenteActionPerformed

    private void tspecialiteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tspecialiteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tspecialiteActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(DetailsParamètre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DetailsParamètre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DetailsParamètre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DetailsParamètre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DetailsParamètre().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox caddconsultation;
    private javax.swing.JCheckBox cadddepense;
    private javax.swing.JCheckBox caddnote;
    private javax.swing.JCheckBox caddordonance;
    private javax.swing.JCheckBox caddpatient;
    private javax.swing.JCheckBox caddrdv;
    private javax.swing.JCheckBox caddrevenue;
    private javax.swing.JCheckBox caddsalleattente;
    private javax.swing.JCheckBox cdelconsultation;
    private javax.swing.JCheckBox cdeldepense;
    private javax.swing.JCheckBox cdelnote;
    private javax.swing.JCheckBox cdelordonance;
    private javax.swing.JCheckBox cdelpatient;
    private javax.swing.JCheckBox cdelrdv;
    private javax.swing.JCheckBox cdelrevenue;
    private javax.swing.JCheckBox cdelsalleattente;
    private javax.swing.JCheckBox cdetailsconsultation;
    private javax.swing.JCheckBox cdetailsordonance;
    private javax.swing.JCheckBox cdetailspatient;
    private javax.swing.JCheckBox cdetailsrdv;
    private javax.swing.JCheckBox cimprimerconsultation;
    private javax.swing.JCheckBox cimprimerfac;
    private javax.swing.JCheckBox cimprimerfichepatient;
    private javax.swing.JCheckBox cimprimerlistedep;
    private javax.swing.JCheckBox cimprimerordonance;
    private javax.swing.JCheckBox cimprimerrevenue;
    private javax.swing.JCheckBox cmodifierconsultation;
    private javax.swing.JCheckBox cmodifierdepense;
    private javax.swing.JCheckBox cmodifiernote;
    private javax.swing.JCheckBox cmodifierordonance;
    private javax.swing.JCheckBox cmodifierpatient;
    private javax.swing.JCheckBox cmodifierrdv;
    private javax.swing.JCheckBox cmodifierrevenue;
    private javax.swing.JCheckBox creglerfacture;
    private javax.swing.JCheckBox csalleattente;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel ltype;
    private javax.swing.JTextField tnom;
    private javax.swing.JTextField tpassword;
    private javax.swing.JTextField tprenom;
    private javax.swing.JTextField tspecialite;
    private javax.swing.JTextField tusername;
    // End of variables declaration//GEN-END:variables
}
