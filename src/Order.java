/** An order */
public class Order {
    public MenuItem[] items; // dishes of one order

    /** Constructor of the order */
    public Order(MenuItem[] items) {
        this.items = items;
    }
}