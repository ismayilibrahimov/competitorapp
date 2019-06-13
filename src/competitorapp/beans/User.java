package competitorapp.beans;

import java.io.Serializable;


public class User implements Serializable {
    private final String username;
    private final String password;
    private int score;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "User{" + "username=" + username + ", password=" + password + ", score=" + score + '}';
    }
    
    
    
}
