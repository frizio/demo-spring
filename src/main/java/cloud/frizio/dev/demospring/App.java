package cloud.frizio.dev.demospring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
  public static void main(String[] args) {

    // Load the spring configuration file
    ClassPathXmlApplicationContext context = 
        new ClassPathXmlApplicationContext("applicationContext.xml");
    
    // Get the bean from the container
    Coach theCoach = context.getBean("tennisCoach", Coach.class);

    // Call a method on the bean
    System.out.println(theCoach.getDailyWorkout());

    System.out.println(context.getBean("basketCoach", Coach.class).getDailyWorkout());

    // Close the context
    context.close();
  }

}
