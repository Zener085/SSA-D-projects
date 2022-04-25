/** Interface of the observer pattern */
public interface Observer {
    /** Updates a state of the order
     * @param state state of the order */
    public void stateUpdate(OrderState state);
}
