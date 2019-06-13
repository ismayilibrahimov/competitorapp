package competitorapp;

import competitorapp.beans.User;
import competitorapp.config.Config;
import competitorapp.util.FileUtil;
import competitorapp.util.MenuUtil;
import competitorapp.util.UserUtil;


public class CompetitorApp {

    public static void main(String[] args) {
        
        Config c = (Config) FileUtil.readObjectFromFile();
        
        if(c==null) {
            c = new Config();
            FileUtil.writeObjectToFile(c);
        }
        

        User user = UserUtil.login(2);
        
        if(user != null){
            System.out.println("Welcome to Competitor App " + user.getUsername());
            MenuUtil.showMenu(c);
        }

       
    }

}
