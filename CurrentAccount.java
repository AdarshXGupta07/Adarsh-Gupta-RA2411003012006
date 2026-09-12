public class CurrentAccount extends Account implements Withdrawable {

    public CurrentAccount(int accountNumber, String name, int age, double balance) {
        super(accountNumber, name, age, balance, "Current", 1000.0);
    }

    public boolean withdraw(double amount) {
        return takeMoneyOut(amount);
    }
}
