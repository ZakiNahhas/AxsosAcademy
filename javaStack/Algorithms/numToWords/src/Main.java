import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println(numToWords(4));

    }

    public static String numToWords(int num) {
        HashMap<Integer, String> words = new HashMap<Integer, String>();
        words.put(1, "one");
        words.put(2, "two");
        words.put(3, "three");
        words.put(4, "four");
        words.put(5, "five");
        words.put(6, "six");
        words.put(7, "seven");
        words.put(8, "eight");
        words.put(9, "nine");
        words.put(0, "zero");
        HashMap<Integer, String> words2 = new HashMap<Integer, String>();
        words.put(1, "ten");
        words.put(2, "twenty");
        words.put(3, "thirty");
        words.put(4, "forty");
        words.put(5, "fifty");
        words.put(6, "sixty");
        words.put(7, "seventy");
        words.put(8, "eighty");
        words.put(9, "ninety");
        HashMap<Integer, String> words3 = new HashMap<Integer, String>();
        words.put(1, "one");
        words.put(2, "twenty");
        words.put(3, "thirty");
        words.put(4, "forty");
        words.put(5, "fifty");
        words.put(6, "sixty");
        words.put(7, "seventy");
        words.put(8, "eighty");
        words.put(9, "ninety");


        int length = String.valueOf(num).length();
        if (length == 1) {
            for (Map.Entry<Integer, String> set :
                words.entrySet()) {
                Integer x = set.getKey();
                if (x == num) {
                    return set.getValue();
                } else if (length == 2) {

                }
            }
        }
    }
}