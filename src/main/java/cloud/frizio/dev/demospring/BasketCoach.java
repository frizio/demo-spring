package cloud.frizio.dev.demospring;

import org.springframework.beans.factory.annotation.Value;

import cloud.frizio.dev.demospring.fortune.FortuneService;


public class BasketCoach implements Coach {

  private FortuneService fortuneService;

  @Value("${foo.email}")
  private String email;

  @Value("${foo.team}")
  private String team;

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

  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }

  public String getTeam() {
    return team;
  }
  public void setTeam(String team) {
    this.team = team;
  }
  
  
}