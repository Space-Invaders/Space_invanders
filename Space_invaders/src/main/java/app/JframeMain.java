/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;

/**
 *
 * @author luidjy
 */
import dao.PartieDAO;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Timestamp;
import java.util.List;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import model.Objet;
import model.Partie;

public class JframeMain {

    public static void enregistrerPartie(int idJoueur, int score, int aliensDetruits, String resultat) {
        PartieDAO partieDAO = new PartieDAO();

        Partie partie = new Partie();
        partie.setIdJoueur(idJoueur);
        partie.setScore(score);
        partie.setAliensDetruits(aliensDetruits);
        partie.setResultat(resultat);
        partie.setDatePartie(new Timestamp(System.currentTimeMillis()));

        int res = partieDAO.createPartie(partie);

        if (res > 0) {
            System.out.println("Partie enregistrée avec succès !");
        } else {
            System.out.println("Erreur lors de l'enregistrement de la partie !");
        }
    }

    public static int getBestScore() {
        PartieDAO partieDAO = new PartieDAO();
        List<Partie> parties = partieDAO.findAll();

        int bestScore = 0;

        for (Partie p : parties) {
            if (p.getScore() > bestScore) {
                bestScore = p.getScore();
            }
        }

        return bestScore;
    }

    public static void afficherHistorique() {
        PartieDAO partieDAO = new PartieDAO();
        List<Partie> parties = partieDAO.findAll();

        System.out.println("===== HISTORIQUE DES PARTIES =====");

        for (Partie p : parties) {
            System.out.println("Id Partie : " + p.getIdPartie());
            System.out.println("Id Joueur : " + p.getIdJoueur());
            System.out.println("Score : " + p.getScore());
            System.out.println("Aliens détruits : " + p.getAliensDetruits());
            System.out.println("Résultat : " + p.getResultat());
            System.out.println("Date : " + p.getDatePartie());
            System.out.println("----------------------------------");
        }
    }

    public static void main(String[] args) {

        JFrame frame = new JFrame("Space Invaders");

        Random hasard = new Random();

        final int ID_JOUEUR_FIXE = 6;

        final Objet vaisseau = new Objet("Vaisseau", 560, 650, 80, 80, 0);

        final Objet[] balles = new Objet[50];
        final int[] indexBalle = {0};

        int nombreAlien = hasard.nextInt(4) + 2;
        final Objet[] tableauAlien = new Objet[nombreAlien];
        final boolean[] jeuTermine = {false};

        final int[] score = {0};
        final int[] aliensDetruits = {0};
        final boolean[] partieEnregistree = {false};

        for (int i = 0; i < tableauAlien.length; i++) {
            int positionX = hasard.nextInt(1000);
            int positionY = hasard.nextInt(200);
            int typeAlien = hasard.nextInt(3);

            tableauAlien[i] = new Objet(
                    "Alien" + i,
                    positionX,
                    positionY,
                    75,
                    75,
                    typeAlien
            );
        }

        final Image imageVaisseau = new ImageIcon(
                JframeMain.class.getResource("/images/ship.png")
        ).getImage();

        final Image alienVert = new ImageIcon(
                JframeMain.class.getResource("/images/alien-green.png")
        ).getImage();

        final Image alienRose = new ImageIcon(
                JframeMain.class.getResource("/images/alien-pink.png")
        ).getImage();

        final Image alienBleu = new ImageIcon(
                JframeMain.class.getResource("/images/alien-blue.png")
        ).getImage();

        final boolean[] gaucheAppuye = {false};
        final boolean[] droiteAppuye = {false};

        JPanel panelJeu = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                g.setColor(Color.BLACK);
                g.fillRect(0, 0, getWidth(), getHeight());

                g.setColor(Color.WHITE);
                g.setFont(g.getFont().deriveFont(22f));
                g.drawString("Score : " + score[0], 20, 30);
                g.drawString("Aliens détruits : " + aliensDetruits[0], 20, 60);
                g.drawString("Best Score : " + getBestScore(), 20, 90);

                if (jeuTermine[0]) {
                    g.setColor(Color.RED);
                    g.setFont(g.getFont().deriveFont(50f));
                    g.drawString("GAME OVER", 430, 400);
                }

                for (int i = 0; i < tableauAlien.length; i++) {

                    Image imageAlien;

                    if (tableauAlien[i].type == 0) {
                        imageAlien = alienVert;
                    } else if (tableauAlien[i].type == 1) {
                        imageAlien = alienRose;
                    } else {
                        imageAlien = alienBleu;
                    }

                    g.drawImage(
                            imageAlien,
                            tableauAlien[i].x,
                            tableauAlien[i].y,
                            tableauAlien[i].largeur,
                            tableauAlien[i].hauteur,
                            this
                    );
                }

                g.drawImage(
                        imageVaisseau,
                        vaisseau.x,
                        vaisseau.y,
                        vaisseau.largeur,
                        vaisseau.hauteur,
                        this
                );

                g.setColor(Color.YELLOW);

                for (int i = 0; i < balles.length; i++) {
                    if (balles[i] != null) {
                        g.fillRect(
                                balles[i].x,
                                balles[i].y,
                                balles[i].largeur,
                                balles[i].hauteur
                        );
                    }
                }
            }
        };

        panelJeu.setBackground(Color.BLACK);

        frame.add(panelJeu);
        frame.setSize(1200, 800);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        frame.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {

                switch (e.getKeyCode()) {
                    case KeyEvent.VK_LEFT:
                        gaucheAppuye[0] = true;
                        break;

                    case KeyEvent.VK_RIGHT:
                        droiteAppuye[0] = true;
                        break;

                    case KeyEvent.VK_SPACE:
                        balles[indexBalle[0]] = new Objet(
                                "Balle" + indexBalle[0],
                                vaisseau.x + (vaisseau.largeur / 2) - 4,
                                vaisseau.y,
                                8,
                                20,
                                0
                        );

                        indexBalle[0]++;

                        if (indexBalle[0] >= balles.length) {
                            indexBalle[0] = 0;
                        }
                        break;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

                switch (e.getKeyCode()) {
                    case KeyEvent.VK_LEFT:
                        gaucheAppuye[0] = false;
                        break;

                    case KeyEvent.VK_RIGHT:
                        droiteAppuye[0] = false;
                        break;
                }
            }
        });

        Collision.CollisionListener listener = new Collision.CollisionListener() {
            @Override
            public void onCollision(Objet balle, Objet alien) {

                for (int i = 0; i < balles.length; i++) {
                    if (balles[i] == balle) {
                        balles[i] = null;
                    }
                }

                score[0] = score[0] + 1;
                aliensDetruits[0] = aliensDetruits[0] + 1;

                alien.y = 0;
                alien.x = hasard.nextInt(1000);
                alien.type = hasard.nextInt(3);
            }
        };

        Collision.CollisionListener listenerGameOver = new Collision.CollisionListener() {
            @Override
            public void onCollision(Objet alien, Objet vaisseau) {

                jeuTermine[0] = true;

                if (!partieEnregistree[0]) {
                    enregistrerPartie(ID_JOUEUR_FIXE, score[0], aliensDetruits[0], "PERDU");
                    afficherHistorique();
                    partieEnregistree[0] = true;
                }
            }
        };

        Timer timerJeu = new Timer(50, e -> {
            if (jeuTermine[0]) {
                panelJeu.repaint();
                return;
            }

            if (gaucheAppuye[0] && !droiteAppuye[0]) {
                vaisseau.x = vaisseau.x - 8;
            }

            if (droiteAppuye[0] && !gaucheAppuye[0]) {
                vaisseau.x = vaisseau.x + 8;
            }

            if (vaisseau.x < 0) {
                vaisseau.x = 0;
            }

            if (vaisseau.x > panelJeu.getWidth() - vaisseau.largeur) {
                vaisseau.x = panelJeu.getWidth() - vaisseau.largeur;
            }

            for (int i = 0; i < balles.length; i++) {
                if (balles[i] != null) {
                    balles[i].y = balles[i].y - 12;

                    if (balles[i].y + balles[i].hauteur < 0) {
                        balles[i] = null;
                    }
                }
            }

            for (int i = 0; i < tableauAlien.length; i++) {
                tableauAlien[i].y = tableauAlien[i].y + 4;

                if (tableauAlien[i].y > panelJeu.getHeight()) {
                    tableauAlien[i].y = 0;
                    tableauAlien[i].x = hasard.nextInt(1000);
                    tableauAlien[i].type = hasard.nextInt(3);
                }
            }

            for (int i = 0; i < balles.length; i++) {
                if (balles[i] != null) {
                    for (int j = 0; j < tableauAlien.length; j++) {
                        Collision.verifierCollision(balles[i], tableauAlien[j], listener);

                        if (balles[i] == null) {
                            break;
                        }
                    }
                }
            }

            for (int i = 0; i < tableauAlien.length; i++) {
                Collision.verifierCollision(tableauAlien[i], vaisseau, listenerGameOver);
            }

            panelJeu.repaint();
        });

        timerJeu.start();

        frame.setFocusable(true);
        frame.setVisible(true);
        frame.requestFocusInWindow();
    }
}
