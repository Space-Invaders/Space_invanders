/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package app;
import dao.UpdateDAO;
import model.User;


/**
 *
 * @author luidjy
 */
public class MainUpdateDAO {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {

        User user = new User();

        user.setUserid(12);

        user.setUsername("nouveau_nom");
        user.setPassword("nouveau_mdp");
        user.setCreerpar("luidjy");
        user.setModifierpar("luidjy");
        user.setActif(true);

        UpdateDAO dao = new UpdateDAO();
        int result = dao.updateUser(user);

        if (result > 0) {
            System.out.println("Update réussi !");
        } else {
            System.out.println("Update échoué !");
        }
    }
 }
    

