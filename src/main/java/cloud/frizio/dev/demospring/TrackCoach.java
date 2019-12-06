package cloud.frizio.dev.demospring;

import cloud.frizio.dev.demospring.fortune.FortuneService;

public class TrackCoach implements Coach {

  // Define a private field for the dependency
  private FortuneService fortuneService;

  public void setFortuneService(FortuneService fortuneService) {
    this.fortuneService = fortuneService;
  }

  public TrackCoach() {

  }

  @Override
  public String getDailyWorkout() {
    return "Run a hard 5k";
  }

  @Override
  public String getLuckyFortune() {
    return "Gooooooooooood, " + this.fortuneService.getFortune();
  }

}
