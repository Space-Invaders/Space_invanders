package app;

import dao.UserReadDAO;
import model.User;
import java.util.List;
/**
 *
 * @author luidjy
 */
public class ReadMainDAO {

    public static void main(String[] args) throws Exception {

        List<User> res = UserReadDAO.findAll();

        for (int i = 0; i < res.size(); i++) {
            System.out.println("UserId = " + res.get(i).getUserid());
            System.out.println("Username = " + res.get(i).getUsername());
        }
    }
}