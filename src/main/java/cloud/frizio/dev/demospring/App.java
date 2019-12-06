package cloud.frizio.dev.demospring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
  public static void main(String[] args) {
    // Load the spring configuration file
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    // Retrieve bean from spring container
    Coach theCoach = context.getBean("myTrackCoach", Coach.class);
    // Call methods on the bean
    System.out.println(theCoach.getDailyWorkout());
    // Call method to get the fortune
    System.out.println(theCoach.getLuckyFortune());
    // Close the context
    context.close();
  }

}
