package bank.capability;

public interface Transferable {
    boolean transfer(Depositable to, double amount);
}
