import java.util.ArrayList;
import java.util.Random;
public class PuzzleJava {
    public static void main(String[] args) {
        Meth methods = new Meth();
        ArrayList<Integer> tenRandomRolls = methods.getTenRolls();
        System.out.println("The random array is: " + tenRandomRolls);
        System.out.println(methods.getRandomLetter());
        System.out.println(methods.generatePassword());
        System.out.println("Your cusomitzed password is: "+ methods.generatePassword(24));
        String[] arr = {"a","b","c","d","e","f"};
        methods.shuffeledArray(); 
    }
}