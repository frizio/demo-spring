package cloud.frizio.dev.demospring.statemachine.order.automata;


import java.util.Date;

import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.ExtendedState;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.action.Action;
import org.springframework.statemachine.config.EnableStateMachineFactory;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;

import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;

import cloud.frizio.dev.demospring.statemachine.order.bean.Order;

@Configuration
@EnableStateMachineFactory
public class PurchaseOrderConfig extends EnumStateMachineConfigurerAdapter<OrderStates, OrderEvents>  {

  // Metodi necessari per la configurazione degli stati e delle transizioni ammesse in base agli eventi definiti
  
  @Override
  public void configure(StateMachineStateConfigurer<OrderStates, OrderEvents> states) throws Exception {
    states
      .withStates()
        .initial(OrderStates.CREATED)
        .state( OrderStates.APPROVED, entryAction(), exitAction() )
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
        .action( approveAction() )
      .and()
      .withExternal()
        .source(OrderStates.CREATED)
        .target(OrderStates.DENIED)
        .event(OrderEvents.DENY)
        .action( denyAction() )
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
 
  // Actions 
  
  public Action<OrderStates, OrderEvents> approveAction() {
    return new Action<OrderStates, OrderEvents>() {
      @Override
      public void execute(StateContext<OrderStates, OrderEvents> context) {
        Order order = findOrder( context.getExtendedState() );
        if ( order != null ) {
          order.setNumber( (int)(Math.random()*100000) );
          order.setApprovalDate( new Date() );
        }
      }
    };
  }

  public Action<OrderStates, OrderEvents> denyAction() {
      return new Action<OrderStates, OrderEvents>() {
        @Override
        public void execute(StateContext<OrderStates, OrderEvents> context) {
          Order order = findOrder( context.getExtendedState() );
          if ( order != null ) {
            order.setCancelDate( new Date() );
          }
        }
      };
  }

  private Order findOrder( ExtendedState extendedState ) {
    for ( Object obj : extendedState.getVariables().values() ) {
        if ( obj instanceof Order ) {
            return (Order) obj;
        }
    }
    return null;
  }

  public Action<OrderStates, OrderEvents> entryAction() {
    return new Action<OrderStates, OrderEvents>() {
        @Override
        public void execute(StateContext<OrderStates, OrderEvents> context) {
            System.out.println( "Entering IN state " + context.getTarget().getId() );
        }
    };
}
    
public Action<OrderStates, OrderEvents> exitAction() {
    return new Action<OrderStates, OrderEvents>() {
        @Override
        public void execute(StateContext<OrderStates, OrderEvents> context) {
            System.out.println( "Exiting FROM state " + context.getSource().getId() );
        }
    };
}

}