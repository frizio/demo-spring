package cloud.frizio.dev.demospring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
  public static void main(String[] args) {

    // Get the bran from the Spring container
    AnnotationConfigApplicationContext context = 
        new AnnotationConfigApplicationContext(SportConfiguration.class);
    
    // Retrieve bean from spring container
    Coach theCoach = context.getBean("tennisCoach", Coach.class);

    System.out.println(theCoach.getDailyWorkout());

    // Close the context
    context.close();
  }

}
