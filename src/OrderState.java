/** States of the order */
public enum OrderState {
    PENDING,
    COOKING,
    READY;

    /** Switches order to the next state
     * @param state actual state of the order
     * @return next state of the order */
    public OrderState next(){
        switch (this) {
            case PENDING -> {return COOKING;}
            case COOKING -> {return READY;}
            default -> {return null;}
        }
    }
}
