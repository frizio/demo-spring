package cloud.frizio.dev.demospring;

import cloud.frizio.dev.demospring.fortune.FortuneService;

/**
 * FootballCoach
 */
public class FootballCoach implements Coach {

  // Define a private field for the dependency
  private FortuneService fortuneService;

  public FootballCoach() {
    
  }

  // Define a constructor for dependency injection
  public FootballCoach( FortuneService fortuneService ) {
    this.fortuneService = fortuneService;
  }

  @Override
  public String getDailyWorkout() {
    return "Run Run Run for 1000 yard!!!";
  }

  @Override
  public String getLuckyFortune() {
    return "Just do it " + this.fortuneService.getFortune();
  }

  // Init method
  public void doMyStartupStuff() {
    System.out.println("Call init method");
    System.out.println("Open here db connection, sockets or files");
  }

  // Destroy method
  public void doMyCleanupStuff() {
    System.out.println("Call destroy method");
    System.out.println("Close and cleanup here here db connection, sockets or files");
  }
  
}