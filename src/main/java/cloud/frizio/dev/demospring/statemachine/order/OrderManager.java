package cloud.frizio.dev.demospring.statemachine.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.StateMachineFactory;

import cloud.frizio.dev.demospring.statemachine.order.automata.OrderEvents;
import cloud.frizio.dev.demospring.statemachine.order.automata.OrderStates;
import cloud.frizio.dev.demospring.statemachine.order.bean.Order;

public class OrderManager {
  /*
  * L’interazione con la macchina a stati finiti che abbiamo definito per il processo di Ordine implica due aspetti fondamentali:
  * 1) generazione di una nuova istanza della macchina a stati per ogni richiesta di acquisto;
  * 2) interazione con la macchina a stati al fine di far procedere l’ordine, transitando tra i diversi stati previsti.
  *
  */

  @Autowired
  StateMachineFactory<OrderStates, OrderEvents> factory;

  // 1
  public StateMachine<OrderStates,OrderEvents> newOrder( Order order) {
      StateMachine<OrderStates,OrderEvents> stateMachine = factory.getStateMachine( "PO-" + order.getId() );
      stateMachine.getExtendedState().getVariables().put( "order", order );
      stateMachine.start();
      return stateMachine;
  }

  // 2 L’evoluzione della macchina tra i vari stati, si realizza attraverso l’invio di eventi o segnali alla macchina
  public boolean fire(StateMachine<OrderStates,OrderEvents> stateMachine, OrderEvents event) {
    return stateMachine.sendEvent( event );
}
  
}