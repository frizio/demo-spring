package cloud.frizio.dev.demospring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cloud.frizio.dev.demospring.fortune.FortuneService;
import cloud.frizio.dev.demospring.fortune.SadFortuneService;

@Configuration
public class SportConfiguration { 

  @Bean
  public FortuneService sadFortuneService() {
    return new SadFortuneService();
  }

  @Bean
  public Coach basketCoach() {
    return new BasketCoach(this.sadFortuneService());
  }

}