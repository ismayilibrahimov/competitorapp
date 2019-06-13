package competitorapp.util;

import competitorapp.beans.Competitor;
import java.util.Scanner;


public class CompetitionUtil {
    public static Competitor[] addCompetitors(){
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("how many competitor: ");
        int count = scanner.nextInt();
        
        Competitor[] competitors = new Competitor[count];
        
        for(int i = 0; i < count; i++) {
            competitors[i] = addCompetitor();
        }
        
        return competitors;
        
    }
    
    public static Competitor addCompetitor() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("enter name: ");
        String name = scanner.nextLine();
        
        System.out.print("enter surname: ");
        String surname = scanner.nextLine();
        
        System.out.print("enter age: ");
        int age = scanner.nextInt();
        
        Competitor competitor = new Competitor(name, surname, age);
        
        return competitor;
    }
    
}
