package cloud.frizio.dev.demospring;

import cloud.frizio.dev.demospring.fortune.FortuneService;

public class TrackCoach implements Coach {

  // Define a private field for the dependency
  private FortuneService fortuneService;

  private String emailAddress;
  private String team;

  public void setFortuneService(FortuneService fortuneService) {
    this.fortuneService = fortuneService;
  }

  public TrackCoach() {

  }

  public String getEmailAddress() {
    return emailAddress;
  }
  public void setEmailAddress(String emailAddress) {
    this.emailAddress = emailAddress;
  }

  public String getTeam() {
    return team;
  }
  public void setTeam(String team) {
    this.team = team;
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
