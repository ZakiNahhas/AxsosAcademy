import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
    public static String reverse(String word) {
//        StringBuilder sb = new StringBuilder();
        String word1 = "";
        char[] chars = word.toCharArray();
        ArrayList<String> arr1 = new ArrayList<String>();
        for(int i =0; i<word.length(); i++) {
            if (word.contains(" ")) {
                arr1.add(word);
            }
        }
    }
}