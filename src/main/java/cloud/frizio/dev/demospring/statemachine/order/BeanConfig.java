package cloud.frizio.dev.demospring.statemachine.order;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class BeanConfig {

	@Bean
	public OrderManager orderManager() {
		return new OrderManager();
	}

}
