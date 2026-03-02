/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
public class UpdateDAO {

    public int updateUser(User user) throws Exception {

        Connection c = null;
        PreparedStatement ps = null;

        String sql = "UPDATE public.joueurs "
                + "SET nom_joueur=?, mdp_joueur=?, creer_par=?, creer_le=CURRENT_TIMESTAMP, "
                + "modifier_par=?, modifier_le=CURRENT_TIMESTAMP, actif=? "
                + "WHERE joueur_id=?";

        try {
            c = Connectivity.getConnection();
            ps = c.prepareStatement(sql);

            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getCreerpar());
            ps.setString(4, user.getModifierpar());
            ps.setBoolean(5, user.isActif());
            ps.setInt(6, user.getUserid());

            return ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erreur updateUser : " + e.getMessage());
            return 0;

        } finally {
            if (ps != null) ps.close();
            if (c != null) c.close();
        }
    }
}