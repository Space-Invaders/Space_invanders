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
import model.Joueur;

/**
 *
 * @author luidjy
 */
public class JoueurDAO {
    public static void insert(Joueur joueur) {
        String sql = "INSERT INTO joueur(pseudo) VALUES (?)";

        try (Connection con = Connectivity.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, joueur.getPseudo());
            ps.executeUpdate();
            System.out.println("Joueur ajouté avec succès.");

        } catch (Exception e) {
            System.out.println("Erreur insert joueur = " + e.getMessage());
        }
    }

    public static List<Joueur> findAll() {
        List<Joueur> liste = new ArrayList<>();
        String sql = "SELECT * FROM joueur ORDER BY id_joueur";

        try (Connection con = Connectivity.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Joueur j = new Joueur();
                j.setIdJoueur(rs.getInt("id_joueur"));
                j.setPseudo(rs.getString("pseudo"));
                liste.add(j);
            }

        } catch (Exception e) {
            System.out.println("Erreur findAll joueur = " + e.getMessage());
        }

        return liste;
    }

    public static Joueur findById(int id) {
        String sql = "SELECT * FROM joueur WHERE id_joueur = ?";
        Joueur j = null;

        try (Connection con = Connectivity.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                j = new Joueur();
                j.setIdJoueur(rs.getInt("id_joueur"));
                j.setPseudo(rs.getString("pseudo"));
            }

        } catch (Exception e) {
            System.out.println("Erreur findById joueur = " + e.getMessage());
        }

        return j;
    }

    public static void update(Joueur joueur) {
        String sql = "UPDATE joueur SET pseudo = ? WHERE id_joueur = ?";

        try (Connection con = Connectivity.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, joueur.getPseudo());
            ps.setInt(2, joueur.getIdJoueur());
            ps.executeUpdate();
            System.out.println("Joueur modifié avec succès.");

        } catch (Exception e) {
            System.out.println("Erreur update joueur = " + e.getMessage());
        }
    }

    public static void delete(int id) {
        String sql = "DELETE FROM joueur WHERE id_joueur = ?";

        try (Connection con = Connectivity.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Joueur supprimé avec succès.");

        } catch (Exception e) {
            System.out.println("Erreur delete joueur = " + e.getMessage());
        }
    }
    
}
