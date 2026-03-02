/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package app;

import POOJDBC.Connectivity;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author luidjy
 */
public class MainConnectivity {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Connection connection = Connectivity.getConnection();

        if (connection != null) {
            System.out.println("Connexion réussie !");
            try {
                connection.close();
                System.out.println("Connexion fermée.");
            } catch (SQLException e) 
            
            {
                System.out.println("Erreur fermeture : " + e.getMessage());
            }
        } else {
            System.out.println("Connexion échouée.");
        }    
    }
    
}
