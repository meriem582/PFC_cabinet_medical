/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

/**
 *
 * @author dell
 */
public class Médicament {
    String nom;
            int frequence2;
            
            public Médicament(String nom,int frequence){
                this.nom = nom;
                this.frequence2 = frequence;
            }
            
            public String getNom(){
                return nom;
            }
            public int getFrequence(){
                return frequence2;
            }
        }

