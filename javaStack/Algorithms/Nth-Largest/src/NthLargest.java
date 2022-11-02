import java.util.Arrays;

public class NthLargest {

    public static void main(String[] args) {
        int[] arr = {12, 35, 1, 10, 34, 1 };
        int n = arr.length;
        int answer = findSecondLargest(arr, n);
        System.out.println("The second largest element in the array is: " + answer);

    }
    static int findSecondLargest(int[] arr, int n) {

        Arrays.sort(arr);
        int secondLargest = 0;
        int i = n-2;
        while (i >= 0) {
            if (arr[i] != arr[n - 1])
            {
                secondLargest = arr[i];
                break;
            }
            i--;
        }
        return secondLargest;
    }
}
