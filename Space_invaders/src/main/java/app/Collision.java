/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;

import model.Objet;

/**
 *
 * @author luidjy
 */
public class Collision {

    public interface CollisionListener {

        void onCollision(Objet a, Objet b);
    }

    public static boolean detecterCollision(Objet a, Objet b) {
        if (a == null || b == null) {
            return false;
        }
        int ax = a.x;
        int ay = a.y;
        int alargeur = a.largeur;
        int ahauteur = a.hauteur;
        int margeAlien = 28;

        int bx = b.x + margeAlien;
        int by = b.y + margeAlien;
        int blargeur = b.largeur - (2 * margeAlien);
        int bhauteur = b.hauteur - (2 * margeAlien);

        if (a.nom.startsWith("Alien") && b.nom.equals("Vaisseau")) {
            int margeAlienX = 15;
            int margeAlienY = 15;

            int margeVaisseauX = 40;
            int margeVaisseauY = 28;

            ax = a.x + margeAlienX;
            ay = a.y + margeAlienY;
            alargeur = a.largeur - (2 * margeAlienX);
            ahauteur = a.hauteur - (2 * margeAlienY);

            bx = b.x + margeVaisseauX;
            by = b.y + margeVaisseauY;
            blargeur = b.largeur - (2 * margeVaisseauX);
            bhauteur = b.hauteur - (2 * margeVaisseauY);
        }

        return ax < bx + blargeur
                && ax + alargeur > bx
                && ay < by + bhauteur
                && ay + ahauteur > by;
    }

    public static void verifierCollision(Objet a, Objet b, CollisionListener listener) {
        if (detecterCollision(a, b)) {
            listener.onCollision(a, b);
        }
    }
}
