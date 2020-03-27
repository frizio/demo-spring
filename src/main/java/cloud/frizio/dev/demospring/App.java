package cloud.frizio.dev.demospring;

import java.math.BigDecimal;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.statemachine.StateMachine;

import cloud.frizio.dev.demospring.statemachine.order.BeanConfig;
import cloud.frizio.dev.demospring.statemachine.order.OrderManager;
import cloud.frizio.dev.demospring.statemachine.order.automata.OrderEvents;
import cloud.frizio.dev.demospring.statemachine.order.automata.OrderStates;
import cloud.frizio.dev.demospring.statemachine.order.automata.PurchaseOrderConfig;
import cloud.frizio.dev.demospring.statemachine.order.bean.Order;

public class App {
  public static void main( String[] args ) {
    /*
    System.out.println( "Demo Spring Statemachine" );
    System.out.println(OrderStates.CREATED + ": " + OrderStates.CREATED.getDescription());
    System.out.println(OrderEvents.APPROVE + ": " + OrderEvents.APPROVE.getDescription());
    */

    AnnotationConfigApplicationContext context = 
        new AnnotationConfigApplicationContext(
              PurchaseOrderConfig.class,
              BeanConfig.class
            );

    OrderManager orderManager = context.getBean(OrderManager.class);

    ///////////////////////////////////
    // EXAMPLE 1:  Laptop Process Order
    ///////////////////////////////////
    
    Order laptop = new Order(1L, "Laptop", BigDecimal.valueOf(50));
    StateMachine<OrderStates,OrderEvents> laptopStateMachine = orderManager.newOrder( laptop );
    
    System.out.println("Laptop State: " + laptopStateMachine.getState().getId());
    orderManager.fire(laptopStateMachine, OrderEvents.APPROVE);
    
    System.out.println("Laptop State: " + laptopStateMachine.getState().getId());
    
    System.out.println(laptopStateMachine.getExtendedState().getVariables());
    

    ///////////////////////////////////
    // EXAMPLE 2:  Mouse Process Order
    ///////////////////////////////////
    /*
    Order mouse = new Order(2L, "Mouse", BigDecimal.valueOf(50));
    StateMachine<OrderStates,OrderEvents> mouseStateMachine = orderManager.newOrder( mouse );

    System.out.println("Mouse State: " + mouseStateMachine.getState().getId());
    orderManager.fire(mouseStateMachine, OrderEvents.APPROVE);
    
    System.out.println("Mouse State: " + mouseStateMachine.getState().getId());
    System.out.println(mouseStateMachine.getExtendedState().getVariables().get("order"));
    
    
    System.out.println( "Mouse Machine Completed:" + mouseStateMachine.isComplete() );
    orderManager.fire(mouseStateMachine, OrderEvents.PROCESS);
    System.out.println("Mouse State: " + mouseStateMachine.getState().getId());
    System.out.println( "Mouse Machine Completed:" + mouseStateMachine.isComplete() );
    */

    context.close();

  }
}
