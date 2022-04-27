//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.ArrayList;
import java.util.Scanner;

public class RestaurantSystem {
    private Table[] tables;
    private ArrayList<OrderInfo> orders;
    private Menu menu;

    public static void main(String[] args) {
        RestaurantSystem system = new RestaurantSystem(3);
        MenuItem[] menuItems = new MenuItem[]{new MenuItem("Chicken", new ArrayList(), 59.99), new MenuItem("Beef Stroganoff", new ArrayList(), 79.89), new MenuItem("Caesar Salad", new ArrayList(), 49.99)};
        system.menu = new Menu(menuItems);
        System.out.println("What do you want today? There is a menu:");
        MenuItem[] dishes = system.getMenu().getMenuItems();

        for(MenuItem dish : dishes)
            System.out.println(dish);

        Order order = new Order();
        Scanner scan = new Scanner(System.in);
        ArrayList<MenuItem> items = new ArrayList();

        while(true) {
            int index;
            String item = scan.nextLine();
            if (item.equals("Stop")) break;

            if (item.equals("Chicken")) {
                index = 0;
            } else if (item.equals("Beef Stroganoff")) {
                index = 1;
            } else if (item.equals("Caesar Salad")) {
                index = 2;
            } else {
                System.out.println("There is no dish like that, try another.");
                continue;
            }
            items.add(system.getMenu().getMenuItems()[index]);
            }
        order.items = (MenuItem[])items.toArray(new MenuItem[0]);
        system.order(order, new Observer() {
            public void stateUpdate(OrderState state) {
                if (state == OrderState.READY) {
                    System.out.println("Your order is ready!");
                }
            }
        });
    }

    public RestaurantSystem(int numberOfTables) {
        this.tables = new Table[numberOfTables];
        this.orders = new ArrayList<>();
    }

    public Menu getMenu() {
        return this.menu;
    }

    public void order(Order order, Observer observer) {
        this.orders.add(new OrderInfo());
        (this.orders.get(this.orders.size() - 1)).order = order;
        (this.orders.get(this.orders.size() - 1)).orderObserver = observer;
        (this.orders.get(this.orders.size() - 1)).orderState = OrderState.PENDING;
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

        public OrderInfo() {
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