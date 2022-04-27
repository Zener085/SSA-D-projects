import java.util.ArrayList;

/** Item (dish) of the menu */
public class MenuItem {
    private String description; // description of the dish
    private ArrayList<Rating> ratings; // array of ratings of the dish from people
    private double cost; // cost of the dish

    /** Constructor of the menu item
     * @param description description of the dish
     * @param ratings array of ratings of the dish
     * @param cost cost of the dish */
    public MenuItem(String description, ArrayList<Rating> ratings, double cost) {
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
    public ArrayList<Rating> getRatings() {
        return ratings;
    }

    /** Returns cost of the dish
     * @return cost of the dish */
    public double getCost() {
        return cost;
    }

    public void rate(Rating rating) {
        this.ratings.add(rating);
    }

    public String toString() {
        return description + ", стоимость: " + this.cost + ". Отзывы:" + this.ratings.toString();
    }
}