/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import model.User;
import POOJDBC.Connectivity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author luidjy
 */
public class UserReadDAO {
    //Read

    public static List<User> findAll() throws Exception {
        List<User> result = new ArrayList<>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM public.joueurs";

        try {
            c = Connectivity.getConnection();
            ps = c.prepareStatement(sql);
            rs = ps.executeQuery();

            while(rs.next()){
                User lm = new User();
                
                lm.setUsername(rs.getString(1));
                lm.setPassword(rs.getString(2));
                lm.setCreerpar(rs.getString(3));
                lm.setCreerle(rs.getDate(4));
                lm.setModifierpar(rs.getString(5));
                lm.setModifierle(rs.getDate(6));
                lm.setActif(rs.getBoolean(7));
                lm.setUserid(rs.getInt(8));
                result.add(lm);
            }

        } catch (Exception e) {
            throw e;
        }finally
        {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (c != null) {
                c.close();
            }

        }

        return result;
    }
    
    
}
