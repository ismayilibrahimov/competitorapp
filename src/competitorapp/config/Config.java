package competitorapp.config;

import competitorapp.beans.Competitor;
import competitorapp.beans.User;
import java.io.Serializable;


public class Config implements Serializable {
    private User user;
    private Competitor[] competitors;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Competitor[] getCompetitors() {
        return competitors;
    }

    public void setCompetitors(Competitor[] competitors) {
        this.competitors = competitors;
    }

    @Override
    public String toString() {
        return "Config{" + "user=" + user + ", competitors=" + competitors + '}';
    }
    
    
    
    
}
