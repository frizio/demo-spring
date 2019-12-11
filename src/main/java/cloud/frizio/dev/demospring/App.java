package cloud.frizio.dev.demospring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
  public static void main(String[] args) {
    // Load the spring configuration file
    ClassPathXmlApplicationContext context = 
        new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");
    
    // Retrieve bean from spring container
    Coach theCoach = context.getBean("myCoach", Coach.class);

    Coach alphaCoach = context.getBean("myCoach", Coach.class);
    
    // Check if the beans are the same (singleton)
    boolean result = (theCoach == alphaCoach);
    System.out.println("\nPointing to the same object? " + result);
    System.out.println("\nMemory location for theCoach" + theCoach);
    System.out.println("\nMemory location for alphaCoach" + alphaCoach);
    System.out.println("\n");

    context.close();
  }

}
