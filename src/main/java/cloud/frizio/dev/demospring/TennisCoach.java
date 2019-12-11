package cloud.frizio.dev.demospring;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import cloud.frizio.dev.demospring.fortune.FortuneService;

@Component
@Scope("singleton")
public class TennisCoach implements Coach {

  @Autowired
  @Qualifier("RESTFortuneService")
  private FortuneService fortuneService;

  @Value("${foo.team}")
  private String team;

  public TennisCoach() {
    System.out.println("Call TennisCoach default constructor");
  }

  @PostConstruct
  public void init() {
    System.out.println("Code executed after constructor and injection of the dependencies");
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

  @PreDestroy
  public void cleanup() {
    System.out.println("Code executed before the bean is destroyed");
  }

}