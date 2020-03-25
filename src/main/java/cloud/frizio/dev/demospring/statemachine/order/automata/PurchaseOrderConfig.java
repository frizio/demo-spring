package cloud.frizio.dev.demospring.statemachine.order.automata;

import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachineFactory;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;

import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;


@Configuration
@EnableStateMachineFactory
public class PurchaseOrderConfig extends EnumStateMachineConfigurerAdapter<OrderStates, OrderEvents>  {

  // Metodi necessari per la configurazione degli stati e delle transizioni ammesse in base agli eventi definiti
  
  @Override
  public void configure(StateMachineStateConfigurer<OrderStates, OrderEvents> states) throws Exception {
    states
      .withStates()
        .initial(OrderStates.CREATED)
        .state(OrderStates.APPROVED)
        .end(OrderStates.DENIED)
        .end(OrderStates.CANCELLED)
        .end(OrderStates.PROCESSED);
  }

  @Override
  public void configure(StateMachineTransitionConfigurer<OrderStates, OrderEvents> transitions) throws Exception {
    transitions
      .withExternal()
        .source(OrderStates.CREATED)
        .target(OrderStates.APPROVED)
        .event(OrderEvents.APPROVE)
      .and()
      .withExternal()
        .source(OrderStates.CREATED)
        .target(OrderStates.DENIED)
        .event(OrderEvents.DENY)
      .and()
      .withExternal()
        .source(OrderStates.APPROVED)
        .target(OrderStates.PROCESSED)
        .event(OrderEvents.PROCESS)
      .and()
      .withExternal()
        .source(OrderStates.APPROVED)
        .target(OrderStates.CANCELLED)
        .event(OrderEvents.CANCEL);
  }


}