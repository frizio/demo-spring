package cloud.frizio.dev.demospring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
  public static void main(String[] args) {
    // Load the spring configuration file
    ClassPathXmlApplicationContext context = 
        new ClassPathXmlApplicationContext("beanLifecycle-applicationContext.xml");
    
    // Retrieve bean from spring container
    Coach theCoach = context.getBean("myCoach", Coach.class);

    System.out.println(theCoach.getLuckyFortune());

    context.close();
  }

}
