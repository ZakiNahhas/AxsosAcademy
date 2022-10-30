import java.util.ArrayList;

class CoffeeKiosk {
    ArrayList<Items> menu = new ArrayList<Items>();
    ArrayList<Orders> orders = new ArrayList<Orders>();

    public CoffeeKiosk() {
        this.menu = new ArrayList<Items>();
        this.orders = new ArrayList<Orders>();
    }
    public void addMenuItem(String name, double price) {
        Items item = new Items(name, price);
        this.menu.add(item);
        item.setIndex(menu.indexOf(item));
    }

    public void displayMenu() {
        for (Items item :this.menu){
            System.out.println(item.getIndex() +" "+item.getName() +" -- "+ " $"+item.getPrice() );
        }
    }
    public void newOrder() {

        // Shows the user a message prompt and then sets their input to a variable, name
        System.out.println("Please enter customer name for new order:");
        String name = System.console().readLine();
        Orders order1 = new Orders(name);
        this.orders.add(order1);
        displayMenu();
        // Prompts the user to enter an item number
        System.out.println("Please enter a menu item index or q to quit:");
        String itemNumber = System.console().readLine();
        while(!itemNumber.equals("q")) {
            int itemIndex = Integer.parseInt(itemNumber);
            Items newOrder = this.menu.get(itemIndex);
            order1.addItem(newOrder);
            System.out.println("Please enter a menu item index or q to quit:");
            itemNumber = System.console().readLine();
        }
        order1.display();
    }


    public ArrayList<Items> getMenu() {
        return menu;
    }

    public void setMenu(ArrayList<Items> menu) {
        this.menu = menu;
    }

    public ArrayList<Orders> getOrders() {
        return orders;
    }

    public void setOrders(ArrayList<Orders> orders) {
        this.orders = orders;
    }
}
