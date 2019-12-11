package cloud.frizio.dev.demospring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
  public static void main(String[] args) {

    // Get the bran from the Spring container
    AnnotationConfigApplicationContext context = 
        new AnnotationConfigApplicationContext(SportConfiguration.class);
    
    // Retrieve bean from spring container
    BasketCoach theCoach = context.getBean("basketCoach", BasketCoach.class);

    System.out.println(theCoach.getDailyWorkout());
    System.out.println(theCoach.getDailyFortune());
    System.out.println("Email: " + theCoach.getEmail());
    System.out.println("Team:  " + theCoach.getTeam());

    // Close the context
    context.close();
  }

}
