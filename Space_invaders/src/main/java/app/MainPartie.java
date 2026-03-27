/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package app;

import dao.PartieDAO;
import model.Partie;
import java.sql.Timestamp;
import java.util.List;

/**
 *
 * @author luidjy
 */
public class MainPartie {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        PartieDAO partieDAO = new PartieDAO();

        Partie partie = new Partie();
        partie.setIdJoueur(1);
        partie.setScore(5000);
        partie.setAliensDetruits(30);
        partie.setResultat("GAGNE");
        partie.setDatePartie(new Timestamp(System.currentTimeMillis()));

        int create = partieDAO.createPartie(partie);
        System.out.println("Create partie : " + create);

        List<Partie> parties = partieDAO.findAll();
        for (Partie p : parties) {
            System.out.println(p);
        }
    }
}
