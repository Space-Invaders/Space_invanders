/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import POOJDBC.Connectivity;
import model.Partie;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author luidjy
 */
public class PartieDAO {

    public int createPartie(Partie partie) {
        String sql = "INSERT INTO public.partie (id_joueur, score, aliens_detruits, resultat, date_partie) "
                + "VALUES (?, ?, ?, ?, ?)";

        try (Connection c = Connectivity.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setInt(1, partie.getIdJoueur());
            ps.setInt(2, partie.getScore());
            ps.setInt(3, partie.getAliensDetruits());
            ps.setString(4, partie.getResultat());
            ps.setTimestamp(5, partie.getDatePartie());

            return ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erreur createPartie : " + e.getMessage());
            return 0;
        }
    }

    public List<Partie> findAll() {
        List<Partie> parties = new ArrayList<>();
        String sql = "SELECT id_partie, id_joueur, score, aliens_detruits, resultat, date_partie FROM public.partie";

        try (Connection c = Connectivity.getConnection(); PreparedStatement ps = c.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Partie partie = new Partie();
                partie.setIdPartie(rs.getLong("id_partie"));
                partie.setIdJoueur(rs.getInt("id_joueur"));
                partie.setScore(rs.getInt("score"));
                partie.setAliensDetruits(rs.getInt("aliens_detruits"));
                partie.setResultat(rs.getString("resultat"));
                partie.setDatePartie(rs.getTimestamp("date_partie"));
                parties.add(partie);
            }

        } catch (SQLException e) {
            System.out.println("Erreur findAll Partie : " + e.getMessage());
        }

        return parties;
    }

    public Partie findById(long idPartie) {
        String sql = "SELECT id_partie, id_joueur, score, aliens_detruits, resultat, date_partie "
                + "FROM public.partie WHERE id_partie = ?";

        try (Connection c = Connectivity.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setLong(1, idPartie);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Partie partie = new Partie();
                    partie.setIdPartie(rs.getLong("id_partie"));
                    partie.setIdJoueur(rs.getInt("id_joueur"));
                    partie.setScore(rs.getInt("score"));
                    partie.setAliensDetruits(rs.getInt("aliens_detruits"));
                    partie.setResultat(rs.getString("resultat"));
                    partie.setDatePartie(rs.getTimestamp("date_partie"));
                    return partie;
                }
            }

        } catch (SQLException e) {
            System.out.println("Erreur findById Partie : " + e.getMessage());
        }

        return null;
    }

    public int updatePartie(Partie partie) {
        String sql = "UPDATE public.partie "
                + "SET id_joueur = ?, score = ?, aliens_detruits = ?, resultat = ?, date_partie = ? "
                + "WHERE id_partie = ?";

        try (Connection c = Connectivity.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setInt(1, partie.getIdJoueur());
            ps.setInt(2, partie.getScore());
            ps.setInt(3, partie.getAliensDetruits());
            ps.setString(4, partie.getResultat());
            ps.setTimestamp(5, partie.getDatePartie());
            ps.setLong(6, partie.getIdPartie());

            return ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erreur updatePartie : " + e.getMessage());
            return 0;
        }
    }

    public int deletePartie(long idPartie) {
        String sql = "DELETE FROM public.partie WHERE id_partie = ?";

        try (Connection c = Connectivity.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setLong(1, idPartie);

            return ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erreur deletePartie : " + e.getMessage());
            return 0;
        }
    }
}
