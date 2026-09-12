public class SavingsAccount extends Account implements Withdrawable {

    public SavingsAccount(int accountNumber, String name, int age, double balance) {
        super(accountNumber, name, age, balance, "Savings", 500.0);
    }

    public boolean withdraw(double amount) {
        return takeMoneyOut(amount);
    }
}
