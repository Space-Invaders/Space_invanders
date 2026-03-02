/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package app;

import dao.DeleteDAO;
import model.User;

/**
 *
 * @author luidjy
 */
public class MainDeleteDAO {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception  {
        // TODO code application logic here
        User user = new User();

        user.setUserid(6);        
        user.setCreerpar("luidjy"); 

        DeleteDAO dao = new DeleteDAO();
        int result = dao.deleteUser(user);

        System.out.println(result > 0 ? "Delete réussi !" : "Delete échoué !");
    }
 }
    

