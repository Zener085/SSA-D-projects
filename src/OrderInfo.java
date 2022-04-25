/** Changes the state of the order */
public class OrderInfo {
    public Order order; // the order
    public Observer orderObserver; // observer for the order
    public OrderState orderState; // state of the order

    /** set new state of the order
     * @return true if the order is not ready, otherwise false */
    public boolean setNextState() {
        orderState = orderState.next();
        if (orderState != null) {
            orderObserver.stateUpdate(orderState);
            return true;
        }
        return false;
    }
}
