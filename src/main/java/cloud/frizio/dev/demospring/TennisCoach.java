package cloud.frizio.dev.demospring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cloud.frizio.dev.demospring.fortune.FortuneService;

@Component
public class TennisCoach implements Coach {

  private FortuneService fortuneService;

  public TennisCoach() {
    System.out.println("Call TennisCoach default constructor");
  }

  @Autowired
  public void setFortuneService(FortuneService fortuneService) {
    System.out.println("Call setFortuneService");
    this.fortuneService = fortuneService;
  }

  @Override
  public String getDailyWorkout() {
    return "Practice your backhand volley";
  }

  @Override
  public String getDailyFortune() {
    return this.fortuneService.getFortune();
  }

}