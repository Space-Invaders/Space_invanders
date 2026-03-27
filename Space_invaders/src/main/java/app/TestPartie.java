/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package app;

import dao.PartieDAO;
import model.Partie;

import java.sql.Timestamp;
import java.util.List;

public class TestPartie {

    public static void main(String[] args) {

        PartieDAO dao = new PartieDAO();

        
        Partie partie = new Partie();
        partie.setIdJoueur(2); 
        partie.setScore(500);
        partie.setAliensDetruits(70);
        partie.setResultat("PERDU");
        partie.setDatePartie(new Timestamp(System.currentTimeMillis()));

        int res = dao.createPartie(partie);

        if (res > 0) {
            System.out.println("Partie insérée !");
        } else {
            System.out.println("Erreur insertion !");
        }

       
        try {
            List<Partie> parties = dao.findAll();

            System.out.println("\n📌 LISTE DES PARTIES :");

            for (Partie p : parties) {
                System.out.println("ID: " + p.getIdPartie());
                System.out.println("Joueur: " + p.getIdJoueur());
                System.out.println("Score: " + p.getScore());
                System.out.println("Aliens: " + p.getAliensDetruits());
                System.out.println("Résultat: " + p.getResultat());
                System.out.println("Date: " + p.getDatePartie());
                System.out.println("----------------------");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}