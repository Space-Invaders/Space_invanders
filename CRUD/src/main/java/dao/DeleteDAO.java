/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import POOJDBC.Connectivity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.User;

/**
 *
 * @author luidjy
 */
public class DeleteDAO {
    public int deleteUser(User user) throws Exception {

        Connection c = null;
        PreparedStatement ps = null;

        String sql = "UPDATE public.joueurs " 
                + "SET actif = false, delete_par = ?, delete_le = CURRENT_TIMESTAMP "
                + "WHERE joueur_id = ?";

        try {
            c = Connectivity.getConnection();
            ps = c.prepareStatement(sql);

            ps.setString(1, user.getCreerpar());   
            ps.setInt(2, user.getUserid());

            return ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erreur deleteUser : " + e.getMessage());
            return 0;

        } finally {
            if (ps != null) ps.close();
            if (c != null) c.close();
        }
    }
}
    

