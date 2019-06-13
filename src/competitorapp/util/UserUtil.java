package competitorapp.util;

import competitorapp.beans.User;
import competitorapp.config.Config;
import java.util.Scanner;

public class UserUtil {

    public static User login(String username, String password) {
        if ("admin".equals(username) && "12345".equals(password)) {
            User user = new User(username, password);
            return user;
        }
        return null;
    }

    public static User login() {
        Config c = (Config) FileUtil.readObjectFromFile();
        User user;

        if (c.getUser() == null) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("enter username:");
            String username = scanner.nextLine();

            System.out.println("enter password:");
            String password = scanner.nextLine();

            user = UserUtil.login(username, password);
            c.setUser(user);
            FileUtil.writeObjectToFile(c);
        } else {
            user = c.getUser();
        }

        return user;
    }

    public static User login(int tryCount) {
        for (int i = 0; i < tryCount; i++) {
            User user = login();
            if (user != null) {
                return user;
            }
        }
        throw new IllegalArgumentException("username or password is incorrect!");
    }

}
