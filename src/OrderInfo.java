public class OrderInfo {
    public Order order;
    public Observer orderObserver;
    public OrderState orderState;

    /** set new state of the order
     * @return true if the order is not ready, otherwise false */
    public boolean setNextState() {
        orderState = orderState.next();
        return orderState != null;
    }
}
