/** States of the order */
public enum OrderState {
    PENDING, // When order is paid, but not started to be cooked
    COOKING, // When restaurant cook dishes of the order
    READY; // When order is ready to send it

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
