import java.util.ArrayList;

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

    public void order(Order order, Observer observer) {
        this.orders.add(new OrderInfo(order, observer));
    }

    public void reserveTable(int tableID) {
        this.tables[tableID].reserved = true;
    }

    public void rate(MenuItem menuItem, Rating rating) {
        menuItem.rate(rating);
    }

    private static class Table {
        public boolean reserved;

        public Table() {
        }
    }

    public static class OrderInfo {
        public Order order;
        public Observer orderObserver;
        public OrderState orderState;

        public OrderInfo(Order order, Observer observer) {
            this.order = order;
            this.orderObserver = observer;
            this.orderState = OrderState.PENDING;
        }

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