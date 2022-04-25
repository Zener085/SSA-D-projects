public class OrderInfo {
    public Order order;
    public ObserverStates orderObserver;
    public OrderState orderState;

    /** set new state of the order
     * @return true if the order is not ready, otherwise false */
    public boolean setNextState() {
        orderState = orderObserver.stateUpdate(orderState);
        return orderState != null;
    }
}
