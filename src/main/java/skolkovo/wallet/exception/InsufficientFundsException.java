package skolkovo.wallet.exception;

public class InsufficientFundsException extends RuntimeException {
    public InsufficientFundsException() {
        super("Insufficient funds for operation");
    }
}
