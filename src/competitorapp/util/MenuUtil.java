package competitorapp.util;

import competitorapp.beans.Competitor;
import competitorapp.beans.User;
import competitorapp.config.Config;
import java.util.Random;
import java.util.Scanner;

public class MenuUtil {

    public static void showMenu(Config config) {
        while (true) {
            Scanner scanner = new Scanner(System.in);

            String menu = "1. add competitor\n"
                    + "2. start competition\n"
                    + "3. check score\n"
                    + "4. check competitors\n"
                    + "5. logout\n";
            System.out.println(menu);
            System.out.print("select: ");
            int selected = scanner.nextInt();

            if (selected == 1) {
                System.out.print("competitor count: ");
                int count = scanner.nextInt();
                scanner.nextLine();
                Competitor[] competitors;
                if (config.getCompetitors() != null) {
                    competitors = new Competitor[config.getCompetitors().length + count];
                    
                    for(int i = 0; i < config.getCompetitors().length; i++) {
                        competitors[i] = config.getCompetitors()[i];
                    }

                    for (int i = config.getCompetitors().length; i < competitors.length; i++) {
                        System.out.print(i + 1 + ". enter name: ");
                        String name = scanner.nextLine();

                        System.out.print(i + 1 + ". enter surname: ");
                        String surname = scanner.nextLine();

                        System.out.print(i + 1 + ". enter age: ");
                        int age = scanner.nextInt();
                        scanner.nextLine();

                        Competitor competitor = new Competitor(name, surname, age);
                        competitors[i] = competitor;
                    }

                } else {
                    competitors = new Competitor[count];
                    
                    for (int i = 0; i < competitors.length; i++) {
                        System.out.print(i + 1 + ". enter name: ");
                        String name = scanner.nextLine();

                        System.out.print(i + 1 + ". enter surname: ");
                        String surname = scanner.nextLine();

                        System.out.print(i + 1 + ". enter age: ");
                        int age = scanner.nextInt();
                        scanner.nextLine();

                        Competitor competitor = new Competitor(name, surname, age);
                        competitors[i] = competitor;
                    }
                }

                
                config.setCompetitors(competitors);
                FileUtil.writeObjectToFile(config);

            } else if (selected == 2) {
                System.out.println("Competition started \n");
                Competitor[] competitors;
                if(config.getCompetitors() != null) {
                    competitors = config.getCompetitors();
                } else {
                    System.out.println("You have not any competitor yet! \n");
                    continue;
                }
                
                
                Random random = new Random();
                int rand = random.nextInt(competitors.length + 1);
                
                System.out.print("select competitor (max. " + competitors.length + "): ");
                int yourNumber = scanner.nextInt();
                
                if(yourNumber == rand) {
                    System.out.println("You won! Check your score!");
                    config.getUser().setScore(config.getUser().getScore() + 10);
                    FileUtil.writeObjectToFile(config);
                } else {
                    System.out.println("You failed!");
                }
                
            } else if (selected == 3) {
                if (config.getUser() != null) {
                    User user = config.getUser();
                    System.out.println("your score is " + user.getScore() + "\n");
                } else {
                    System.out.println("your score is 0 \n");
                }

            } else if (selected == 4) {
                if (config.getCompetitors() != null) {
                    Competitor[] competitors = config.getCompetitors();

                    for (int i = 0; i < competitors.length; i++) {
                        System.out.println(i+1 + " " + competitors[i]);
                    }
                    System.out.println("");
                } else {
                    System.out.println("You have not any competitor yet! \n");
                }
            } else if (selected == 5) {
                break;
            }
        }
    }

}
