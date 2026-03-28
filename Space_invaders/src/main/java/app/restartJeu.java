/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;

import java.util.Random;
import model.Objet;

/**
 *
 * @author luidjy
 */
public class restartJeu {
    public static void resetJeu(
            Objet vaisseau,
            Objet[] balles,
            Objet[] aliens,
            int[] indexBalle,
            int[] score,
            int[] aliensDetruits,
            boolean[] jeuTermine,
            boolean[] partieEnregistree,
            Random hasard
    ) {

        // restart vaisseau
        vaisseau.x = 560;
        vaisseau.y = 650;

        // reset balles
        for (int i = 0; i < balles.length; i++) {
            balles[i] = null;
        }
        indexBalle[0] = 0;

        // restart aliens
        for (int i = 0; i < aliens.length; i++) {
            aliens[i].x = hasard.nextInt(1000);
            aliens[i].y = hasard.nextInt(200);
            aliens[i].type = hasard.nextInt(3);
        }

        // resta score
        score[0] = 0;
        aliensDetruits[0] = 0;

        // resta etat
        jeuTermine[0] = false;
        partieEnregistree[0] = false;

        System.out.println("Nouvelle partie lancée !");
    }
}