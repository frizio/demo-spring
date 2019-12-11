package cloud.frizio.dev.demospring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import cloud.frizio.dev.demospring.fortune.FortuneService;

@Component
public class TennisCoach implements Coach {

  @Autowired
  @Qualifier("RESTFortuneService")
  private FortuneService fortuneService;

  @Value("${foo.team}")
  private String team;

  public TennisCoach() {
    System.out.println("Call TennisCoach default constructor");
  }

  public String getTeam() {
    return team;
  }

  @Override
  public String getDailyWorkout() {
    return "Practice your backhand volley " + this.getTeam();
  }

  @Override
  public String getDailyFortune() {
    return this.fortuneService.getFortune();
  }

}