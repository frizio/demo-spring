package cloud.frizio.dev.demospring.statemachine.order.automata;

/*
*  Enum che rappresenta le TRANSIZIONI dell'automa.
*/
public enum OrderEvents {
  APPROVE ("Approve order"), 
  DENY    ("Deny order"),
  CANCEL  ("Calcel order"),
  PROCESS ("Process order");
  
  private String description;
  
  private OrderEvents(String description) {
    this.description = description;
  }
  
  public String getDescription() {
    return this.description;
  }
}