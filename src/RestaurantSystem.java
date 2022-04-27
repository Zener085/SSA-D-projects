import java.util.ArrayList;

/** Main logic of restaurant system */
public class RestaurantSystem {
    private Table[] tables;
    private ArrayList<OrderInfo> orders;
    private Menu menu;

    public RestaurantSystem(int numberOfTables, Menu menu) {
        this.tables = new Table[numberOfTables];
        this.orders = new ArrayList<>();
        this.menu = menu;
    }

    public Menu getMenu() {
        return this.menu;
    }

    /** Order adding to observation */
    public void order(Order order, Observer observer) {
        this.orders.add(new OrderInfo(order, observer));
    }

    /** Table reservations
     * @param tableID index of table in tables array (Table[])
     * */
    public void reserveTable(int tableID) {
        this.tables[tableID].reserved = true;
    }
    /** To rate a dish
     * @param menuItem dish to rate
     * @param rating feedback about the dish
     * */
    public void rate(MenuItem menuItem, Rating rating) {
        menuItem.rate(rating);
    }

    /** Nested class Table
     * to create and use only inside RestaurantSystem
     * Stores information about table reservation
     * */
    private static class Table {
        public boolean reserved;

        public Table() {
        }
    }

    /** Nested class OrderInfo
     * to create and use only inside RestaurantSystem
     * Stores order info, client to notify (Observer), and order state
     * */
    private static class OrderInfo {
        public Order order;
        public Observer orderObserver;
        public OrderState orderState;

        public OrderInfo(Order order, Observer observer) {
            this.order = order;
            this.orderObserver = observer;
            this.orderState = OrderState.PENDING;
        }

        /** advanceState
         * notifies observer about state changes
         * @return true if order is not done else false
         * */
        public boolean advanceState() {
            this.orderState = this.orderState.next();
            if (this.orderState != null) {
                this.orderObserver.stateUpdate(this.orderState);
                return true;
            } else {
                return false;
            }
        }
    }
}