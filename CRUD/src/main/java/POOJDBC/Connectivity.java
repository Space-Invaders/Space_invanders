/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POOJDBC;


import model.Database;
import java.sql.DriverManager;
import java.sql.Connection;

/**
 *
 * @author luidjy
 */
public class Connectivity {
    public static Connection getConnection(){
        
        Connection connection = null;
        Database db = new Database();
        
        try{
            Class.forName("org.postgresql.Driver");
            connection = (Connection) DriverManager.getConnection(db.getConnectionUrl(),db.getUserName(),db.getPassWord());
            System.out.println("Database connected = "+connection);
        }catch(Exception e){
            System.out.println("Erreur connexion DB = "+e.getMessage());
        }
        return connection;
    }
    
}
