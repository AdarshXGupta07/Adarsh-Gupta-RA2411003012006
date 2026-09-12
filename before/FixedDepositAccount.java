public class FixedDepositAccount extends Account {

    public FixedDepositAccount(int accountNumber, double balance) {
        super(accountNumber, balance);
    }

    public boolean withdraw(double amount) {
        throw new UnsupportedOperationException("Fixed deposits cannot be withdrawn early");
    }
}
