package cloud.frizio.dev.demospring;


public class App {
    public static void main( String[] args ) {
        // Create the object
        Coach theCoach = new BaseballCoach();
        // Use the object
        System.out.println(theCoach.getDailyWorkout());
    }
}
