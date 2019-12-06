package cloud.frizio.dev.demospring;

import cloud.frizio.dev.demospring.fortune.FortuneService;

/**
 * FootballCoach
 */
public class FootballCoach implements Coach {

  // Define a private field for the dependency
  private FortuneService fortuneService;

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

  
}