import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu(new MenuItem[] { new MenuItem("Chicken", new ArrayList<>(), 59.99),
                new MenuItem("Beef Stroganoff", new ArrayList<>(), 79.89),
                new MenuItem("Caesar Salad", new ArrayList<>(), 49.99) });
        RestaurantSystem system = new RestaurantSystem(3, menu);

        System.out.println("What do you want today? There is a menu:");
        MenuItem[] dishes = system.getMenu().getMenuItems();

        for (MenuItem dish : dishes)
            System.out.println(dish);

        Order order = new Order();
        Scanner scan = new Scanner(System.in);
        ArrayList<MenuItem> items = new ArrayList<>();

        while (true) {
            int index;
            String item = scan.nextLine();
            if (item.equals("Stop"))
                break;

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
        order.items = (MenuItem[]) items.toArray(new MenuItem[0]);
        system.order(order, new Observer() {
            public void stateUpdate(OrderState state) {
                if (state == OrderState.READY) {
                    System.out.println("Your order is ready!");
                }
            }
        });
    }
}
