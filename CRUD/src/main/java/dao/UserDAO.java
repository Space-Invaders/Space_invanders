package dao;

import model.User;
import POOJDBC.Connectivity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 *
 * @author luidjy
 */
public class UserDAO {

    public int createuser(User user) {

        String sql =
            "INSERT INTO public.joueurs " +
            "(nom_joueur, mdp_joueur, creer_par, creer_le, modifier_par, modifier_le, actif) " +
            "VALUES (?, ?, ?, CURRENT_TIMESTAMP, ?, CURRENT_TIMESTAMP, ?)";

        try (Connection con = Connectivity.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getCreerpar());
            ps.setString(4, user.getModifierpar());
            ps.setBoolean(5, user.isActif());

            return ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erreur createuser : " + e.getMessage());
            return 0;
        }
    }
}