/** Item (dish) of the menu */
public class MenuItem {
    private String description; // description of the dish
    private Rating[] ratings; // array of ratings of the dish from people
    private double cost; // cost of the dish

    /** Constructor of the menu item
     * @param description description of the dish
     * @param ratings array of ratings of the dish
     * @param cost cost of the dish */
    public MenuItem(String description, Rating[] ratings, double cost) {
        this.description = description;
        this.ratings = ratings;
        this.cost = cost;
    }

    /** Returns description of the dish
     * @return description of the dish */
    public String getDescription() {
        return description;
    }

    /** Returns ratings of the dish
     * @return array of ratings of the dish */
    public Rating[] getRatings() {
        return ratings;
    }

    /** Returns cost of the dish
     * @return cost of the dish */
    public double getCost() {
        return cost;
    }
}