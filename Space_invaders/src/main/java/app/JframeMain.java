package app;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import model.Objet;

public class JframeMain {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Space Invaders");

        Random hasard = new Random();

        final Objet vaisseau = new Objet("Vaisseau", 560, 650, 80, 80, 0);

        final Objet[] balles = new Objet[50];
        final int[] indexBalle = {0};

        int nombreAlien = hasard.nextInt(4) + 2;
        final Objet[] tableauAlien = new Objet[nombreAlien];

        for (int i = 0; i < tableauAlien.length; i++) {
            int positionX = hasard.nextInt(1000);
            int positionY = hasard.nextInt(200);
            int typeAlien = hasard.nextInt(3);

            tableauAlien[i] = new Objet("Alien" + i, positionX, positionY, 75, 75, typeAlien);
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
                        balles[indexBalle[0]] = new Objet("Balle", vaisseau.x + (vaisseau.largeur / 2) - 4, vaisseau.y, 8, 20, 0);

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

        Timer timerJeu = new Timer(40, e -> {

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

            panelJeu.repaint();
        });

        timerJeu.start();

        frame.setFocusable(true);
        frame.setVisible(true);
        frame.requestFocusInWindow();
    }
}
