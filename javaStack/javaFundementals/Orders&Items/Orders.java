import java.util.*;
class Orders {
    private String name;
    private double total;
    private boolean ready;
    private ArrayList<Items> items = new ArrayList<Items>();
public Orders() {

}
public Orders(String name, double total, boolean ready, ArrayList<Items> item) {
    this.name = name;
    this.ready = ready;
    this.items = item;
    this.total = total;
}
public String getName() {
    return name;
}
public void setName(String name) {
    this.name = name;
}
public double getTotal() {
    return total;
}
public void setTotal(double total) {
    this.total = total;
}
public boolean isReady() {
    return ready;
}
public void setReady(boolean ready) {
    this.ready = ready;
}
public ArrayList<Items> getItems() {
    return items;
}
public void setItems(ArrayList<Items> items) {
    this.items = items;
}
}
