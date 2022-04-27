import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Initialize restaurant with the menu
        Menu menu = new Menu(new MenuItem[] { new MenuItem("Chicken", new ArrayList<>(), 59.99),
                new MenuItem("Beef Stroganoff", new ArrayList<>(), 79.89),
                new MenuItem("Caesar Salad", new ArrayList<>(), 49.99) });
        RestaurantSystem system = new RestaurantSystem(3, menu);

        System.out.println("What do you want today? There is a menu:");
        MenuItem[] dishes = system.getMenu().getMenuItems();
        for (MenuItem dish : dishes) {
            System.out.println(dish);
        }

        Order order = new Order();
        Scanner scanner = new Scanner(System.in);
        ArrayList<MenuItem> items = new ArrayList<>();

        // Form an order
        while (true) {
            String item = scanner.nextLine();
            if (item.equals("Stop")) {
                break;
            }

            MenuItem menuItem = findMenuItem(system.getMenu(), item);
            if (menuItem == null) {
                System.out.println("There is no dish like that, try another.");
                continue;
            }

            items.add(menuItem);
        }

        // Push the formed order to the restaurant system
        order.items = (MenuItem[]) items.toArray(new MenuItem[0]);
        system.order(order, new Observer() {
            public void stateUpdate(OrderState state) {
                if (state == OrderState.READY) {
                    System.out.println("Your order is ready!");
                }
            }
        });
    }

    private static MenuItem findMenuItem(Menu menu, String description) {
        int index;
        for (index = 0; index < menu.getMenuItems().length; index++) {
            MenuItem menuItem = menu.getMenuItems()[index];
            if (menuItem.getDescription().equals(description)) {
                return menuItem;
            }
        }
        return null;
    }
}
