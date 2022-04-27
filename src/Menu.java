/** A menu stores dishes that users can choose */
public class Menu {
    private MenuItem[] menuItems;

    public Menu(MenuItem[] menuItems) {
        this.menuItems = menuItems;
    }

    public MenuItem[] getMenuItems() {
        return this.menuItems;
    }
}
