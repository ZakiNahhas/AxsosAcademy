import java.util.*;
public class OrdersTest {
    public static void main(String[] args) {
        Items item1 = new Items();
        Items item2 = new Items();
        Items item3 = new Items();
        Items item4 = new Items();

        Orders order1 = new Orders();
        Orders order2 = new Orders();
        Orders order3 = new Orders();
        Orders order4 = new Orders();
        ArrayList<Items> items = new ArrayList<Items>();

        item1.setName("Mocha");
        item2.setName("Latte");
        item3.setName("Drip Coffee");
        item4.setName("Cappuccino");
        item1.setPrice(3.0);
        item2.setPrice(4.5);
        item3.setPrice(5.5);
        item4.setPrice(2.5);

        order1.setName("Cindhuri");
        order1.setReady(true);
        order2.setName("Zaki");
        order2.setReady(true);
        order2.setTotal(order2.getTotal());
        order3.setName("Khaled");
        order3.setTotal(order3.getTotal());
        order4.setName("Yousef");
        order2.getItems().add(item1);
        order4.setTotal(order4.getTotal());
        double total1 = order2.getTotal();
        total1 += item1.getPrice();

        order3.getItems().add(item3);
        double total2 = order3.getTotal();
        total2 += item3.getPrice();

        double total3 = order4.getTotal();
        order4.getItems().add(item4);
        total3 += item4.getPrice();
        order4.getItems().add(item4);
        total3 += item4.getPrice();
        order4.getItems().add(item4);
        total3 += item4.getPrice();
        
        if (order1.isReady()) {
            System.out.println("Your order is ready! " + order1.getName());
        } else {
            System.out.println("Your order is still in progress");
        }
        if (order2.isReady()) {
            System.out.println("Your order is ready! " + order2.getName());
        } else {
            System.out.println("Your order is still in progress");
        }



    }
}