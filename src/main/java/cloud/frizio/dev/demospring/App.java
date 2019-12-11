package cloud.frizio.dev.demospring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
  public static void main(String[] args) {

    // Load the spring configuration file
    ClassPathXmlApplicationContext context = 
        new ClassPathXmlApplicationContext("applicationContext.xml");
    
    // Retrieve bean from spring container
    Coach theCoach = context.getBean("tennisCoach", Coach.class);

    // Close the context
    context.close();
  }

}
