package cloud.frizio.dev.demospring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import cloud.frizio.dev.demospring.statemachine.order.BeanConfig;
import cloud.frizio.dev.demospring.statemachine.order.OrderManager;
import cloud.frizio.dev.demospring.statemachine.order.automata.OrderEvents;
import cloud.frizio.dev.demospring.statemachine.order.automata.OrderStates;
import cloud.frizio.dev.demospring.statemachine.order.automata.PurchaseOrderConfig;

public class App {
  public static void main( String[] args ) {
    System.out.println( "Demo Spring Statemachine" );
    System.out.println(OrderStates.CREATED + ": " + OrderStates.CREATED.getDescription());
    System.out.println(OrderEvents.APPROVE + ": " + OrderEvents.APPROVE.getDescription());

    AnnotationConfigApplicationContext context = 
        new AnnotationConfigApplicationContext(
              PurchaseOrderConfig.class,
              BeanConfig.class
            );

    OrderManager orderManager = context.getBean(OrderManager.class);


    
    context.close();

  }
}
