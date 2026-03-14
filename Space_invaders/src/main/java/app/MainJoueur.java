/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package app;

import dao.JoueurDAO;
import java.util.List;
import model.Joueur;

/**
 *
 * @author luidjy
 */
public class MainJoueur {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Joueur j1 = new Joueur();
        j1.setPseudo("Player1");
        JoueurDAO.insert(j1);

        List<Joueur> joueurs = JoueurDAO.findAll();
        for (Joueur j : joueurs) {
            System.out.println(j);
        }

        Joueur joueurTrouve = JoueurDAO.findById(1);
        System.out.println("FindById = " + joueurTrouve);

        if (joueurTrouve != null) {
            joueurTrouve.setPseudo("PlayerOne");
            JoueurDAO.update(joueurTrouve);
        }

        System.out.println("Liste après update :");
        joueurs = JoueurDAO.findAll();
        for (Joueur j : joueurs) {
            System.out.println(j);
        }
        // JoueurDAO.delete(1);
    }
    
}
