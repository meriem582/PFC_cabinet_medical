/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

/**
 *
 * @author azus
 */
public class CalculerIMC {
    public static float calcul(float taille,float poids){
        return (poids/(taille*taille));
    }
    public static String typeIMC(float imcVal){
        String str=null;
        if(imcVal<18.5){
            str="Maigre";
        }
        if((imcVal>=18.5)&&(imcVal<=25)){
            str="Normal";
        }
        if((imcVal>25)&&(imcVal<=30)){
            str="Supoids";
        }
        if((imcVal>30)&&(imcVal<=40)){
            str="Obésité modérée";
        }
        if(imcVal>40){
            str="Obésité sévère";
        }
        return str;
    }
}
