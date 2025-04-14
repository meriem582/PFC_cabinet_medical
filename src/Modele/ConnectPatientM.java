/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

/**
 *
 * @author azus
 */
import Vue.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectPatientM {
    PreparedStatement p;
    public ResultSet rs;
    Connexion c=new Connexion();
    public ConnectPatientM() {
        try {
            p=c.connexionBdd().prepareStatement("select patient.* from patient,consultation where patient.matricule_pat=consultation.matricule_pat and consultation.medecin_id=? ");
            p.setString(1, authentification.tusername.getText());
            rs=p.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectUtilisateur.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
