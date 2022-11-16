import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        LinkedList<Integer> list1 = new LinkedList<Integer>();
        LinkedList<Integer> list2 = new LinkedList<Integer>();
        list1.add(2);
        list1.add(0);
        list1.add(1);

        list2.add(8);
        list2.add(4);
        System.out.println(listSum(list1, list2));

    }
    public static int listSum(LinkedList<Integer> list1, LinkedList<Integer> list2) {
        double sum = 0;
        double sum2 = 0;
        for(int i =0; i<list1.size(); i++) {
            sum+=list1.get(i)*Math.pow(10,i);
            System.out.println(list1.get(i)*Math.pow(10,i));
        }
        for(int j =0; j<list2.size(); j++) {
            sum2+=list2.get(j)*Math.pow(10,j);
        }
        return (int)(sum + sum2);
    }
}