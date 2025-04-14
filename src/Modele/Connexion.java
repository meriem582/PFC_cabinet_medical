/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author azus
 */
public class Connexion {
    Connection c;

    public Connexion() {
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Echec de la connexion au serveur");
        }
        try {
            c=DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_cabinet_medical","root","");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Echec de la connexion a la base de données");
        }
    }
    public Connection connexionBdd(){
        return c;
    }
    public static void main(String[] args) {
        Connexion c=new Connexion();
        c.connexionBdd();
    }
}
