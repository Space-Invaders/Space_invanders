package app;

import dao.UserDAO;
import model.User;
/**
 *
 * @author luidjy
 */
public class UserApp {

    public static void main(String[] args) {

        User user = new User();

        user.setUsername("luidjy todyi");
        user.setPassword("admin");
        user.setCreerpar("admin");
        user.setModifierpar("admin");
        user.setActif(true);

        UserDAO dao = new UserDAO();
        int result = dao.createuser(user);

        if (result > 0) {
            System.out.println("insertion reussie !");
        } else {
            System.out.println("erreur insertion !");
        }
    }
}