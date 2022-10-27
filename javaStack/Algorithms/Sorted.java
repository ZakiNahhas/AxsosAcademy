public class Sorted {
    public static void main(String[] args) {
    int arr[] = {1,2,1,3,4,2};
    int n = arr.length;
    printDistinct(arr, n);
}
 static void printDistinct(int arr[], int n)
{
    // Pick all elements one by one
    for (int i = 0; i < n; i++)
    {
        int j;
        for (j = 0; j < i; j++)
        if (arr[i] == arr[j])
            break;
        if (i == j)
        System.out.print( arr[i] + " ");
    }
}
}