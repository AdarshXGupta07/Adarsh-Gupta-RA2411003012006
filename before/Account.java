public class Account {

    private int accountNumber;
    private double balance;

    public Account(int accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public boolean withdraw(double amount) {
        this.balance = this.balance - amount;
        System.out.println("Withdrew Rs. " + amount + " from account " + this.accountNumber);
        return true;
    }

    public int getAccountNumber() {
        return this.accountNumber;
    }

    public double getBalance() {
        return this.balance;
    }
}
