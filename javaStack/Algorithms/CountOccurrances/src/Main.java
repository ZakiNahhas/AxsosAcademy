public class Main {
    public static void main(String[] args) {
        Counter counter = new Counter();

        String[] array = {"ab", "ab", "abc"};
        String [] array1={"ab", "abc", "bc"};
        counter.countOccurr(array1, array);
    }
}