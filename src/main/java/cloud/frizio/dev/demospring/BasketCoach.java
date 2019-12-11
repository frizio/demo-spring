package cloud.frizio.dev.demospring;

import cloud.frizio.dev.demospring.fortune.FortuneService;


public class BasketCoach implements Coach {

  private FortuneService fortuneService;

  public BasketCoach(FortuneService fortuneService) {
    this.fortuneService = fortuneService;
  }

  @Override
  public String getDailyWorkout() {
    return "Try the shoots of three point";
  }

  @Override
  public String getDailyFortune() {
    return this.fortuneService.getFortune();
  }

  
  
}