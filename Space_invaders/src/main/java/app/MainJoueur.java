/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package app;

import dao.JoueurDAO;
import model.Joueur;
import java.util.List;

/**
 *
 * @author luidjy
 */
public class MainJoueur {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        JoueurDAO joueurDAO = new JoueurDAO();

        Joueur joueur = new Joueur();
        joueur.setPseudo("Player2");

        int create = joueurDAO.createJoueur(joueur);
        System.out.println("Create joueur : " + create);

        List<Joueur> joueurs = joueurDAO.findAll();
        for (Joueur j : joueurs) {
            System.out.println(j);
        }

      //  Joueur joueurExistant = joueurDAO.findById(1);
       // if (joueurExistant != null) {
      //      joueurExistant.setPseudo("NouveauPseudo");
      //      int update = joueurDAO.updateJoueur(joueurExistant);
      //      System.out.println("Update joueur : " + update);
    //    }

      //  int delete = joueurDAO.deleteJoueur(1);
       // System.out.println("Delete joueur : " + delete);
    }
}
