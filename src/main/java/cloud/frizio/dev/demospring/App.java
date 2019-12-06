package cloud.frizio.dev.demospring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
  public static void main(String[] args) {
    // Load the spring configuration file
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    // Retrieve bean from spring container
    TrackCoach theCoach = context.getBean("myTrackCoach", TrackCoach.class);
    // Call methods on the bean
    System.out.println(theCoach.getDailyWorkout());
    // Call method to get the fortune
    System.out.println(theCoach.getLuckyFortune());
    // Get the litaral values
    System.out.println("Email: " + theCoach.getEmailAddress() + " Team: " + theCoach.getTeam());
    // Close the context
    context.close();
  }

}
