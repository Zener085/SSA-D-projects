/** Interface of the observer pattern */
public interface Observer {
    /** Observes changes of the state of the order
     * @param state state of the order */
    public void stateUpdate(OrderState state);
}
