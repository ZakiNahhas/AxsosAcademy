import java.util.Arrays;

public class FindMissingNumber {
    public static void main(String[] args) {
        int [] numbers = {1,2,3,4,5,7,8,9,10};
        int answer = missingNum(numbers);
        System.out.println(answer);
    }
    public static int missingNum(int[] arr) {
        Arrays.sort(arr);
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            for (j = 0; j < 10; i++) {
                if (arr[i] != j) {
                    j = arr[i];
                }
            }
        }
        return j;
    }
}
