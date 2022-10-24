import java.util.Date;
public class AlfredQuotes {
    public String basicGreeting() {
        // You do not need to code here, this is an example method
        return "Hello, lovely to see you. How are you?";
    }
    public String angryAlfred(String mood) {
        if (mood.contains("Angry")) {
            return "I am really mad, so go KYS";
        } else {
        return "I am really happy to see you!";
}
    }
    
    public String guestGreeting(String name) {
        return "Hello, " + name + ". Lovely to see you baby.";
    }
    
    public String dateAnnouncement() {
        Date newD = new Date();
        return "It is currently " + newD;
    }
    
    public String respondBeforeAlexis(String conversation) {
        if (conversation.contains("Alexis")) {
            return "Right away, sir. She certainly isn't sophisticated enough for that.";
        } else if(conversation.contains("Alfred")) {
            return "At your service. As you wish, naturally.";
        } else {
            return "Right. And with that I shall retire.";
        }
    }
    public String guestGreeting(String name, String dayPeriod) {
        
        return "Good " + dayPeriod + " " + name;
    }
    
    
	// NINJA BONUS
	// See the specs to overload the guessGreeting method
    // SENSEI BONUS
    // Write your own AlfredQuote method using any of the String methods you have learned!
}
