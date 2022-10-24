public class JavaCafe {
    public static void main(String[] args) {
        // APP VARIABLES
        // Lines of text that will appear in the app. 
        String generalGreeting = "Welcome to Cafe Java, ";
        String pendingMessage = ", your order will be ready shortly";
        String readyMessage = ", your order is ready";
        String displayTotalMessage = "Your total is $";
        
        // Menu variables (add yours below)
        double mochaPrice = 3.5;
        double dripCoffee = 4.0;
        double latte = 5.0;
        double Cappuccino = 2.0;
    
        // Customer name variables (add yours below)
        String customer1 = "Cindhuri";
        String customer2 = "Sam";
        String customer3 = "Jimmy";
        String customer4 = "Noah";
    
        // Order completions (add yours below)
        boolean isReadyOrder1 = false;
        boolean isReadyOrder2 = true;
        boolean isReadyOrder3 = true;
        boolean isReadyOrder4 = false;
    
        // APP INTERACTION SIMULATION (Add your code for the challenges below)
        // Example:
        System.out.println(generalGreeting + customer1); // Displays "Welcome to Cafe Java, Cindhuri"
    	// ** Your customer interaction print statements will go here ** //
        System.out.println("********");
        System.out.println(pendingMessage + " MS." + " " + customer1);
        System.out.println("********");
        System.out.println("********");
        if (isReadyOrder4) {
            System.out.println(pendingMessage);
        } else {
            System.out.println(readyMessage + " your total is: " + Cappuccino);
        }
        if (isReadyOrder2) {
            System.out.println(readyMessage + " your total is: " + latte * 2);
        } else {
            System.out.println(pendingMessage);
        }
        if (isReadyOrder3) {
            double newPrice = latte - dripCoffee;
            System.out.println(readyMessage + " your total is: " + newPrice);
        } else {
            System.out.println(pendingMessage);
        }
    }
}