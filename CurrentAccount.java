public class CurrentAccount extends Account implements Depositable, Withdrawable, Transferable, StatementProvider {

    public CurrentAccount(int accNo, String name, int age, double balance) {
        super(accNo, name, age, balance, "Current", 1000.0);
    }

    public boolean withdraw(double amount) {
        return take(amount);
    }

    public boolean transfer(Depositable to, double amount) {
        if (!take(amount)) {
            return false;
        }
        return to.deposit(amount);
    }
}
