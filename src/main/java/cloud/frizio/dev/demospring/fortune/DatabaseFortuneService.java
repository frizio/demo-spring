package cloud.frizio.dev.demospring.fortune;

import org.springframework.stereotype.Component;

@Component
public class DatabaseFortuneService implements FortuneService {

  @Override
  public String getFortune() {
    return null;
  }

}