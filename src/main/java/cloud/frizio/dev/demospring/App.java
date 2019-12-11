package cloud.frizio.dev.demospring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
  public static void main(String[] args) {

    // Get the bran from the Spring container
    AnnotationConfigApplicationContext context = 
        new AnnotationConfigApplicationContext(SportConfiguration.class);
    
    // Retrieve bean from spring container
    Coach theCoach = context.getBean("basketCoach", Coach.class);

    System.out.println(theCoach.getDailyWorkout());
    System.out.println(theCoach.getDailyFortune());

    // Close the context
    context.close();
  }

}
