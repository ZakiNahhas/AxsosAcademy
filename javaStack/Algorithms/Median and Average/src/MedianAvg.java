import java.util.Arrays;

public class MedianAvg {
    public int medianAverage(int[] arr1, int[] arr2) {
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int[] array = new int[arr1.length];
        for(int i=0;i<arr1.length;i++)
            array[i] = arr1[i] + arr2[i];
        double median = 0;
        if (array.length % 2 == 1) {
            median=array[(array.length+1)/2-1];
        }
        else
        {
            median=(array[array.length/2-1]+array[array.length/2])/2;
        }
        return (int)median;
    }
}
