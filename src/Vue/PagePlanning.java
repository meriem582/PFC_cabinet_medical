/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import Modele.Connexion;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dell
 */
public class PagePlanning extends javax.swing.JInternalFrame {

    Connexion c = new Connexion();
    PreparedStatement ps;
    ResultSet rs;

    /**
     * Creates new form PagePlanning
     */
    public PagePlanning() {
        initComponents();
        //Pour enlever le cadre JAVA le café la.
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI ui = (BasicInternalFrameUI) this.getUI();
        ui.setNorthPane(null);
        //Jusqu'ici.
        try {
            ps = c.connexionBdd().prepareStatement("select * from rendez_vous , patient where rendez_vous.matricule_pat=patient.matricule_pat and médecin_id=? and daterdv=CURDATE()");
            ps.setString(1, authentification.tusername.getText());
            rs = ps.executeQuery();
            while (rs.next()) {
                if (rs.getString("heure").equals("08:00:00")) {
                    etat1.setText("Occupé");
                    lpatient1.setText(rs.getString("patient.nom_pat") + " " + rs.getString("patient.prénom_pat"));
                    jPanel2.setBackground(new java.awt.Color(255,204,204));
                }

                if (rs.getString("heure").equals("08:30:00")) {
                    etat2.setText("Occupé");
                    lpatient2.setText(rs.getString("patient.nom_pat") + " " + rs.getString("patient.prénom_pat"));
                    jPanel3.setBackground(new java.awt.Color(255,204,204));
                }

                if (rs.getString("heure").equals("09:00:00")) {
                    etat3.setText("Occupé");
                    lpatient3.setText(rs.getString("patient.nom_pat") + " " + rs.getString("patient.prénom_pat"));
                    jPanel4.setBackground(new java.awt.Color(255,204,204));
                }
                if (rs.getString("heure").equals("09:30:00")) {
                    etat4.setText("Occupé");
                    lpatient4.setText(rs.getString("patient.nom_pat") + " " + rs.getString("patient.prénom_pat"));
                    jPanel5.setBackground(new java.awt.Color(255,204,204));
                }

                if (rs.getString("heure").equals("10:00:00")) {
                    etat5.setText("Occupé");
                    lpatient5.setText(rs.getString("patient.nom_pat") + " " + rs.getString("patient.prénom_pat"));
                    jPanel24.setBackground(new java.awt.Color(255,204,204));
                }
                if (rs.getString("heure").equals("10:30:00")) {
                    etat6.setText("Occupé");
                    lpatient6.setText(rs.getString("patient.nom_pat") + " " + rs.getString("patient.prénom_pat"));
                    jPanel27.setBackground(new java.awt.Color(255,204,204));
                    
                }
                if (rs.getString("heure").equals("11:00:00")) {
                    etat7.setText("Occupé");
                    lpatient7.setText(rs.getString("patient.nom_pat") + " " + rs.getString("patient.prénom_pat"));
                    jPanel30.setBackground(new java.awt.Color(255,204,204));
                }
                if (rs.getString("heure").equals("11:30:00")) {
                    etat8.setText("Occupé");
                    lpatient8.setText(rs.getString("patient.nom_pat") + " " + rs.getString("patient.prénom_pat"));
                    jPanel31.setBackground(new java.awt.Color(255,204,204));
                }
                if (rs.getString("heure").equals("12:00:00")) {
                    etat9.setText("Occupé");
                    lpatient9.setText(rs.getString("patient.nom_pat") + " " + rs.getString("patient.prénom_pat"));
                    jPanel23.setBackground(new java.awt.Color(255,204,204));
                }
                if (rs.getString("heure").equals("12:30:00")) {
                    etat10.setText("Occupé");
                    lpatient10.setText(rs.getString("patient.nom_pat") + " " + rs.getString("patient.prénom_pat"));
                    jPanel26.setBackground(new java.awt.Color(255,204,204));
                }
                if (rs.getString("heure").equals("13:00:00")) {
                    etat11.setText("Occupé");
                    lpatient11.setText(rs.getString("patient.nom_pat") + " " + rs.getString("patient.prénom_pat"));
                    jPanel29.setBackground(new java.awt.Color(255,204,204));
                }
                if (rs.getString("heure").equals("13:30:00")) {
                    etat12.setText("Occupé");
                    lpatient12.setText(rs.getString("patient.nom_pat") + " " + rs.getString("patient.prénom_pat"));
                    jPanel33.setBackground(new java.awt.Color(255,204,204));
                }

                if (rs.getString("heure").equals("14:00:00")) {
                    etat13.setText("Occupé");
                    lpatient13.setText(rs.getString("patient.nom_pat") + " " + rs.getString("patient.prénom_pat"));
                    jPanel22.setBackground(new java.awt.Color(255,204,204));
                }

                if (rs.getString("heure").equals("14:30:00")) {
                    etat14.setText("Occupé");
                    lpatient14.setText(rs.getString("patient.nom_pat") + " " + rs.getString("patient.prénom_pat"));
                    jPanel25.setBackground(new java.awt.Color(255,204,204));
                }
                if (rs.getString("heure").equals("15:00:00")) {
                    etat15.setText("Occupé");
                    lpatient15.setText(rs.getString("patient.nom_pat") + " " + rs.getString("patient.prénom_pat"));
                    jPanel28.setBackground(new java.awt.Color(255,204,204));
                }
                if (rs.getString("heure").equals("15:30:00")) {
                    etat16.setText("Occupé");
                    lpatient16.setText(rs.getString("patient.nom_pat") + " " + rs.getString("patient.prénom_pat"));
                    jPanel32.setBackground(new java.awt.Color(255,204,204));
                }

                if (rs.getString("heure").equals("16:00:00")) {
                    etat17.setText("Occupé");
                    lpatient17.setText(rs.getString("patient.nom_pat") + " " + rs.getString("patient.prénom_pat"));
                    jPanel8.setBackground(new java.awt.Color(255,204,204));
                }
                if (rs.getString("heure").equals("16:30:00")) {
                    etat18.setText("Occupé");
                    lpatient18.setText(rs.getString("patient.nom_pat") + " " + rs.getString("patient.prénom_pat"));
                    jPanel9.setBackground(new java.awt.Color(255,204,204));
                }
                if (rs.getString("heure").equals("17:00:00")) {
                    etat19.setText("Occupé");
                    lpatient19.setText(rs.getString("patient.nom_pat") + " " + rs.getString("patient.prénom_pat"));
                    jPanel10.setBackground(new java.awt.Color(255,204,204));
                }
                if (rs.getString("heure").equals("17:30:00")) {
                    etat20.setText("Occupé");
                    lpatient20.setText(rs.getString("patient.nom_pat") + " " + rs.getString("patient.prénom_pat"));
                    jPanel11.setBackground(new java.awt.Color(255,204,204));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(PagePlanning.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            int nbrrdv1=0;
            ps = c.connexionBdd().prepareStatement("Select COUNT(*) from rendez_vous , patient where rendez_vous.matricule_pat=patient.matricule_pat and médecin_id=? and daterdv=CURDATE()");
            ps.setString(1, authentification.tusername.getText());
            rs = ps.executeQuery();
            if(rs.next()){
                nbrrdv1 = rs.getInt(1);
            }
                        nbrrdv.setText("                                   "+nbrrdv1);          //45 espaces.

        
        
        } catch (SQLException ex) {
            Logger.getLogger(PagePlanning.class
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

        jPanel14 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        nbrrdv = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        etat1 = new javax.swing.JLabel();
        lpatient1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        lpatient13 = new javax.swing.JLabel();
        etat13 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jPanel23 = new javax.swing.JPanel();
        lpatient9 = new javax.swing.JLabel();
        etat9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel24 = new javax.swing.JPanel();
        lpatient5 = new javax.swing.JLabel();
        etat5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        etat2 = new javax.swing.JLabel();
        lpatient2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel25 = new javax.swing.JPanel();
        lpatient14 = new javax.swing.JLabel();
        etat14 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jPanel26 = new javax.swing.JPanel();
        lpatient10 = new javax.swing.JLabel();
        etat10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel27 = new javax.swing.JPanel();
        lpatient6 = new javax.swing.JLabel();
        etat6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel30 = new javax.swing.JPanel();
        lpatient7 = new javax.swing.JLabel();
        etat7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        lpatient3 = new javax.swing.JLabel();
        etat3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel28 = new javax.swing.JPanel();
        lpatient15 = new javax.swing.JLabel();
        etat15 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jPanel29 = new javax.swing.JPanel();
        lpatient11 = new javax.swing.JLabel();
        etat11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel32 = new javax.swing.JPanel();
        lpatient16 = new javax.swing.JLabel();
        etat16 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        lpatient4 = new javax.swing.JLabel();
        etat4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel31 = new javax.swing.JPanel();
        lpatient8 = new javax.swing.JLabel();
        etat8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel33 = new javax.swing.JPanel();
        lpatient12 = new javax.swing.JLabel();
        etat12 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        lpatient17 = new javax.swing.JLabel();
        etat17 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        lpatient18 = new javax.swing.JLabel();
        etat18 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        lpatient19 = new javax.swing.JLabel();
        etat19 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        lpatient20 = new javax.swing.JLabel();
        etat20 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1208, 792));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel14.setBackground(new java.awt.Color(137, 207, 239));
        jPanel14.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(89, 79, 79), 2, true));
        jPanel14.setPreferredSize(new java.awt.Dimension(1208, 792));
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/acceuil(cercle).png"))); // NOI18N
        jLabel1.setText(" Planning");
        jPanel14.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 2, 257, 118));

        jPanel6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 128), 2, true));

        jPanel7.setBackground(new java.awt.Color(0, 0, 128));
        jPanel7.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 128), 1, true));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Rendez-vous");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        nbrrdv.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        nbrrdv.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        nbrrdv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/rendez-vous.png"))); // NOI18N
        nbrrdv.setText("                                   Nombre");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nbrrdv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(nbrrdv, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel14.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 0, -1, 110));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Rendez-Vous", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(255, 51, 0))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(204, 255, 204));
        jPanel2.setPreferredSize(new java.awt.Dimension(240, 100));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        etat1.setText("Libre");
        jPanel2.add(etat1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));
        jPanel2.add(lpatient1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jLabel2.setText("08:00");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 240, 100));

        jPanel22.setBackground(new java.awt.Color(204, 255, 204));
        jPanel22.setPreferredSize(new java.awt.Dimension(240, 100));
        jPanel22.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel22.add(lpatient13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        etat13.setText("Libre");
        jPanel22.add(etat13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jLabel16.setText("14:00");
        jPanel22.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, -1, -1));

        jPanel1.add(jPanel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 240, -1));

        jPanel23.setBackground(new java.awt.Color(204, 255, 204));
        jPanel23.setPreferredSize(new java.awt.Dimension(240, 100));
        jPanel23.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel23.add(lpatient9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        etat9.setText("Libre");
        jPanel23.add(etat9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jLabel11.setText("12:00");
        jPanel23.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, -1, -1));

        jPanel1.add(jPanel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 240, -1));

        jPanel24.setBackground(new java.awt.Color(204, 255, 204));
        jPanel24.setPreferredSize(new java.awt.Dimension(240, 100));
        jPanel24.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel24.add(lpatient5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        etat5.setText("Libre");
        jPanel24.add(etat5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jLabel6.setText("10:00");
        jPanel24.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, -1, -1));

        jPanel1.add(jPanel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 240, -1));

        jPanel3.setBackground(new java.awt.Color(204, 255, 204));
        jPanel3.setPreferredSize(new java.awt.Dimension(240, 100));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        etat2.setText("Libre");
        jPanel3.add(etat2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));
        jPanel3.add(lpatient2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jLabel3.setText("08:30");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, -1, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, 240, 100));

        jPanel25.setBackground(new java.awt.Color(204, 255, 204));
        jPanel25.setPreferredSize(new java.awt.Dimension(240, 100));
        jPanel25.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel25.add(lpatient14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        etat14.setText("Libre");
        jPanel25.add(etat14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jLabel17.setText("14:30");
        jPanel25.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, -1, -1));

        jPanel1.add(jPanel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 390, 240, -1));

        jPanel26.setBackground(new java.awt.Color(204, 255, 204));
        jPanel26.setPreferredSize(new java.awt.Dimension(240, 100));
        jPanel26.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel26.add(lpatient10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        etat10.setText("Libre");
        jPanel26.add(etat10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jLabel12.setText("12:30");
        jPanel26.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, -1, -1));

        jPanel1.add(jPanel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 270, 240, -1));

        jPanel27.setBackground(new java.awt.Color(204, 255, 204));
        jPanel27.setPreferredSize(new java.awt.Dimension(240, 100));
        jPanel27.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel27.add(lpatient6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        etat6.setText("Libre");
        jPanel27.add(etat6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jLabel7.setText("10:30");
        jPanel27.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, -1, -1));

        jPanel1.add(jPanel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 150, 240, -1));

        jPanel30.setBackground(new java.awt.Color(204, 255, 204));
        jPanel30.setPreferredSize(new java.awt.Dimension(240, 100));
        jPanel30.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel30.add(lpatient7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        etat7.setText("Libre");
        jPanel30.add(etat7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jLabel9.setText("11:00");
        jPanel30.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, -1, -1));

        jPanel1.add(jPanel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 140, 240, 100));

        jPanel4.setBackground(new java.awt.Color(204, 255, 204));
        jPanel4.setPreferredSize(new java.awt.Dimension(240, 100));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel4.add(lpatient3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        etat3.setText("Libre");
        jPanel4.add(etat3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jLabel4.setText("09:00");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, -1, -1));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 20, 240, 100));

        jPanel28.setBackground(new java.awt.Color(204, 255, 204));
        jPanel28.setPreferredSize(new java.awt.Dimension(240, 100));
        jPanel28.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel28.add(lpatient15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        etat15.setText("Libre");
        jPanel28.add(etat15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jLabel18.setText("15:00");
        jPanel28.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, -1, -1));

        jPanel1.add(jPanel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 390, 240, -1));

        jPanel29.setBackground(new java.awt.Color(204, 255, 204));
        jPanel29.setPreferredSize(new java.awt.Dimension(240, 100));
        jPanel29.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel29.add(lpatient11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        etat11.setText("Libre");
        jPanel29.add(etat11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jLabel13.setText("13:00");
        jPanel29.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, -1, -1));

        jPanel1.add(jPanel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 270, 240, -1));

        jPanel32.setBackground(new java.awt.Color(204, 255, 204));
        jPanel32.setPreferredSize(new java.awt.Dimension(240, 100));
        jPanel32.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel32.add(lpatient16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        etat16.setText("Libre");
        jPanel32.add(etat16, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jLabel19.setText("15:30");
        jPanel32.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, -1, -1));

        jPanel1.add(jPanel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 390, 240, -1));

        jPanel5.setBackground(new java.awt.Color(204, 255, 204));
        jPanel5.setPreferredSize(new java.awt.Dimension(240, 100));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel5.add(lpatient4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        etat4.setText("Libre");
        jPanel5.add(etat4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jLabel5.setText("09:30");
        jPanel5.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, -1, -1));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 20, 240, -1));

        jPanel31.setBackground(new java.awt.Color(204, 255, 204));
        jPanel31.setPreferredSize(new java.awt.Dimension(240, 100));
        jPanel31.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel31.add(lpatient8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        etat8.setText("Libre");
        jPanel31.add(etat8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jLabel10.setText("11:30");
        jPanel31.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, -1, -1));

        jPanel1.add(jPanel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 140, 240, 100));

        jPanel33.setBackground(new java.awt.Color(204, 255, 204));
        jPanel33.setPreferredSize(new java.awt.Dimension(240, 100));
        jPanel33.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel33.add(lpatient12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        etat12.setText("Libre");
        jPanel33.add(etat12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jLabel15.setText("13:30");
        jPanel33.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, -1, -1));

        jPanel1.add(jPanel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 270, 240, -1));

        jPanel8.setBackground(new java.awt.Color(204, 255, 204));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel8.add(lpatient17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        etat17.setText("Libre");
        jPanel8.add(etat17, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jLabel20.setText("16:00");
        jPanel8.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, -1, -1));

        jPanel1.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 510, 240, 100));

        jPanel9.setBackground(new java.awt.Color(204, 255, 204));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel9.add(lpatient18, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        etat18.setText("Libre");
        jPanel9.add(etat18, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jLabel21.setText("16:30");
        jPanel9.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, -1, -1));

        jPanel1.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 510, 240, 100));

        jPanel10.setBackground(new java.awt.Color(204, 255, 204));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel10.add(lpatient19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        etat19.setText("Libre");
        jPanel10.add(etat19, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jLabel22.setText("17:00");
        jPanel10.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, -1, -1));

        jPanel1.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 510, 240, 100));

        jPanel11.setBackground(new java.awt.Color(204, 255, 204));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel11.add(lpatient20, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        etat20.setText("Libre");
        jPanel11.add(etat20, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jLabel23.setText("17:30");
        jPanel11.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, -1, -1));

        jPanel1.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 510, 240, 100));

        jPanel14.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 1160, 620));

        getContentPane().add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1192, 750));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel etat1;
    private javax.swing.JLabel etat10;
    private javax.swing.JLabel etat11;
    private javax.swing.JLabel etat12;
    private javax.swing.JLabel etat13;
    private javax.swing.JLabel etat14;
    private javax.swing.JLabel etat15;
    private javax.swing.JLabel etat16;
    private javax.swing.JLabel etat17;
    private javax.swing.JLabel etat18;
    private javax.swing.JLabel etat19;
    private javax.swing.JLabel etat2;
    private javax.swing.JLabel etat20;
    private javax.swing.JLabel etat3;
    private javax.swing.JLabel etat4;
    private javax.swing.JLabel etat5;
    private javax.swing.JLabel etat6;
    private javax.swing.JLabel etat7;
    private javax.swing.JLabel etat8;
    private javax.swing.JLabel etat9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel lpatient1;
    private javax.swing.JLabel lpatient10;
    private javax.swing.JLabel lpatient11;
    private javax.swing.JLabel lpatient12;
    private javax.swing.JLabel lpatient13;
    private javax.swing.JLabel lpatient14;
    private javax.swing.JLabel lpatient15;
    private javax.swing.JLabel lpatient16;
    private javax.swing.JLabel lpatient17;
    private javax.swing.JLabel lpatient18;
    private javax.swing.JLabel lpatient19;
    private javax.swing.JLabel lpatient2;
    private javax.swing.JLabel lpatient20;
    private javax.swing.JLabel lpatient3;
    private javax.swing.JLabel lpatient4;
    private javax.swing.JLabel lpatient5;
    private javax.swing.JLabel lpatient6;
    private javax.swing.JLabel lpatient7;
    private javax.swing.JLabel lpatient8;
    private javax.swing.JLabel lpatient9;
    private javax.swing.JLabel nbrrdv;
    // End of variables declaration//GEN-END:variables
}
