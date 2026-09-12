public class FixedDepositAccount extends Account {

    private int termInMonths;

    public FixedDepositAccount(int accountNumber, String name, int age, double balance, int termInMonths) {
        super(accountNumber, name, age, balance, "Fixed Deposit", 0.0);
        this.termInMonths = termInMonths;
    }

    public int getTermInMonths() {
        return this.termInMonths;
    }
}
