package test;

import entity.User;
import facades.UserFacade;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class Tester {

    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeySpecException {
        //Test user
        User user = new User("user", "test");
        user.AddRole("User");
        //Test admin
        User admin = new User("admin", "test");
        admin.AddRole("Admin");
        //Test user_admin
        User both = new User("user_admin", "test");
        both.AddRole("User");
        both.AddRole("Admin");
        //Test member
        User member = new User("member", "test");
        member.AddRole("member");

        UserFacade uf = new UserFacade();
        uf.createUser(user);
        uf.createUser(admin);
        uf.createUser(both);
    }
}
