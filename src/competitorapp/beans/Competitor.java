package competitorapp.beans;

import java.io.Serializable;


public class Competitor implements Serializable {
    private String name;
    private String surname;
    private int age;

    public Competitor(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Competitor{" + "name=" + name + ", surname=" + surname + ", age=" + age + '}';
    }
    
    
    
}
