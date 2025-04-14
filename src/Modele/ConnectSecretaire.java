/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author azus
 */
public class ConnectSecretaire {
    PreparedStatement p;
    public ResultSet rs;
    Connexion c=new Connexion();
    public ConnectSecretaire() {
        try {
            p=c.connexionBdd().prepareStatement("select * from secretaire");
            rs=p.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectUtilisateur.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
