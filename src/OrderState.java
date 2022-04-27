/** enumerator to store state of order */
public enum OrderState {
    PENDING,
    COOKING,
    READY;

    private OrderState() {
    }

    public OrderState next() {
        return switch (this) {
            case PENDING -> COOKING;
            case COOKING -> READY;
            default -> null;
        };
    }
}
