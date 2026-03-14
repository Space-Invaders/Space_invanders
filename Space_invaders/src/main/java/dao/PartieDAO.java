/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import POOJDBC.Connectivity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Partie;

/**
 *
 * @author luidjy
 */
public class PartieDAO {
    public static void insert(Partie partie) {
        String sql = "INSERT INTO partie(score, aliens_detruits, resultat, id_joueur) VALUES (?, ?, ?, ?)";

        try (Connection con = Connectivity.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, partie.getScore());
            ps.setInt(2, partie.getAliensDetruits());
            ps.setString(3, partie.getResultat());
            ps.setInt(4, partie.getIdJoueur());

            ps.executeUpdate();
            System.out.println("Partie ajoutée avec succès.");

        } catch (Exception e) {
            System.out.println("Erreur insert partie = " + e.getMessage());
        }
    }

    public static List<Partie> findAll() {
        List<Partie> liste = new ArrayList<>();
        String sql = "SELECT * FROM partie ORDER BY id_partie";

        try (Connection con = Connectivity.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Partie p = new Partie();
                p.setIdPartie(rs.getInt("id_partie"));
                p.setScore(rs.getInt("score"));
                p.setAliensDetruits(rs.getInt("aliens_detruits"));
                p.setResultat(rs.getString("resultat"));
                p.setDatePartie(rs.getTimestamp("date_partie"));
                p.setIdJoueur(rs.getInt("id_joueur"));
                liste.add(p);
            }

        } catch (Exception e) {
            System.out.println("Erreur findAll partie = " + e.getMessage());
        }

        return liste;
    }

    public static Partie findById(int id) {
        String sql = "SELECT * FROM partie WHERE id_partie = ?";
        Partie p = null;

        try (Connection con = Connectivity.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                p = new Partie();
                p.setIdPartie(rs.getInt("id_partie"));
                p.setScore(rs.getInt("score"));
                p.setAliensDetruits(rs.getInt("aliens_detruits"));
                p.setResultat(rs.getString("resultat"));
                p.setDatePartie(rs.getTimestamp("date_partie"));
                p.setIdJoueur(rs.getInt("id_joueur"));
            }

        } catch (Exception e) {
            System.out.println("Erreur findById partie = " + e.getMessage());
        }

        return p;
    }

    public static void update(Partie partie) {
        String sql = "UPDATE partie SET score = ?, aliens_detruits = ?, resultat = ?, id_joueur = ? WHERE id_partie = ?";

        try (Connection con = Connectivity.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, partie.getScore());
            ps.setInt(2, partie.getAliensDetruits());
            ps.setString(3, partie.getResultat());
            ps.setInt(4, partie.getIdJoueur());
            ps.setInt(5, partie.getIdPartie());

            ps.executeUpdate();
            System.out.println("Partie modifiée avec succès.");

        } catch (Exception e) {
            System.out.println("Erreur update partie = " + e.getMessage());
        }
    }

    public static void delete(int id) {
        String sql = "DELETE FROM partie WHERE id_partie = ?";

        try (Connection con = Connectivity.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Partie supprimée avec succès.");

        } catch (Exception e) {
            System.out.println("Erreur delete partie = " + e.getMessage());
        }
    }

    public static int getBestScore() {
        String sql = "SELECT MAX(score) AS meilleur_score FROM partie";

        try (Connection con = Connectivity.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {
                return rs.getInt("meilleur_score");
            }

        } catch (Exception e) {
            System.out.println("Erreur getBestScore = " + e.getMessage());
        }

        return 0;
    }
    
}
