public class Counter {
    public void countOccurr(String[] arr1, String[] arr2) {
        int counter = 0;
        for(int i=0; i< arr1.length; i++) {
            for(int j = 0; j < arr2.length; j++) {
                if(arr1[i].equals(arr2[j])) {
                    counter++;
                }
            }
            System.out.println("the string "+arr2[i]+" exists "+counter + " times");
            counter = 0;
        }
    }
}
