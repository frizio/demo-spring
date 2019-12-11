package cloud.frizio.dev.demospring;

import org.springframework.stereotype.Component;

@Component
public class BasketCoach implements Coach {

  @Override
  public String getDailyWorkout() {
    return "Try the shoots of three point";
  }

  @Override
  public String getDailyFortune() {
    return null;
  }

  
  
}