/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package app;

import dao.PartieDAO;
import java.util.List;
import model.Partie;

/**
 *
 * @author luidjy
 */
public class MainPartie {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Partie p1 = new Partie();
        p1.setScore(350);
        p1.setAliensDetruits(40);
        p1.setResultat("PERDU");
        p1.setIdJoueur(1); // il faut que le joueur 1 existe déjà
        PartieDAO.insert(p1);

        List<Partie> parties = PartieDAO.findAll();
        for (Partie p : parties) {
            System.out.println(p);
        }

        Partie partieTrouvee = PartieDAO.findById(1);
        System.out.println("FindById = " + partieTrouvee);

        if (partieTrouvee != null) {
            partieTrouvee.setScore(500);
            partieTrouvee.setAliensDetruits(60);
            partieTrouvee.setResultat("GAGNE");
            partieTrouvee.setIdJoueur(1);
            PartieDAO.update(partieTrouvee);
        }

        System.out.println("Liste après update :");
        parties = PartieDAO.findAll();
        for (Partie p : parties) {
            System.out.println(p);
        }

        int bestScore = PartieDAO.getBestScore();
        System.out.println("Meilleur score = " + bestScore);
    }
    
}
