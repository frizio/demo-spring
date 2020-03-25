package cloud.frizio.dev.demospring;

import cloud.frizio.dev.demospring.statemachine.order.automata.OrderEvents;
import cloud.frizio.dev.demospring.statemachine.order.automata.OrderStates;

public class App {
  public static void main( String[] args ) {
      System.out.println( "Demo Spring Statemachine" );
      System.out.println(OrderStates.CREATED + ": " + OrderStates.CREATED.getDescription());
      System.out.println(OrderEvents.APPROVE + ": " + OrderEvents.APPROVE.getDescription());
  }
}
