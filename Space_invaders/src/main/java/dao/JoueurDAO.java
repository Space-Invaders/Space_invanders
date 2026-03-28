/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import POOJDBC.Connectivity;
import model.Joueur;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import model.Partie;

/**
 *
 * @author luidjy
 */
public class JoueurDAO {

    public int createJoueur(Joueur joueur) {
        String sql = "INSERT INTO public.joueur (pseudo) VALUES (?)";

        try (Connection c = Connectivity.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setString(1, joueur.getPseudo());

            return ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erreur createJoueur : " + e.getMessage());
            return 0;
        }
    }

    public List<Joueur> findAll() {
        List<Joueur> joueurs = new ArrayList<>();
        String sql = "SELECT id_joueur, pseudo FROM public.joueur";

        try (Connection c = Connectivity.getConnection(); PreparedStatement ps = c.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Joueur joueur = new Joueur();
                joueur.setIdJoueur(rs.getInt("id_joueur"));
                joueur.setPseudo(rs.getString("pseudo"));
                joueurs.add(joueur);
            }

        } catch (SQLException e) {
            System.out.println("Erreur findAll Joueur : " + e.getMessage());
        }

        return joueurs;
    }

    public Joueur findById(int idJoueur) {
        String sql = "SELECT id_joueur, pseudo FROM public.joueur WHERE id_joueur = ?";

        try (Connection c = Connectivity.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setInt(1, idJoueur);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Joueur joueur = new Joueur();
                    joueur.setIdJoueur(rs.getInt("id_joueur"));
                    joueur.setPseudo(rs.getString("pseudo"));
                    return joueur;
                }
            }

        } catch (SQLException e) {
            System.out.println("Erreur findById Joueur : " + e.getMessage());
        }

        return null;
    }

    public int updateJoueur(Joueur joueur) {
        String sql = "UPDATE public.joueur SET pseudo = ? WHERE id_joueur = ?";

        try (Connection c = Connectivity.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setString(1, joueur.getPseudo());
            ps.setInt(2, joueur.getIdJoueur());

            return ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erreur updateJoueur : " + e.getMessage());
            return 0;
        }
    }

    public int deleteJoueur(int idJoueur) {
        String sql = "DELETE FROM public.joueur WHERE id_joueur = ?";

        try (Connection c = Connectivity.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setInt(1, idJoueur);

            return ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erreur deleteJoueur : " + e.getMessage());
            return 0;
        }
    }

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
}
