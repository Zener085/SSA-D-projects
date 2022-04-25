public class ObserverStates implements Observer{
    /** Updates a state of the order
     * @param state state of the order */
    @Override
    public OrderState stateUpdate(OrderState state) {
        switch (state) {
            case PENDING -> {
                return OrderState.COOKING;
            }
            case COOKING -> {
                return OrderState.READY;
            }
            default -> {
                return null;
            }
        }
    }
}
