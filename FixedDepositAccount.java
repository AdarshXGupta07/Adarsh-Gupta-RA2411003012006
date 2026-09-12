public class FixedDepositAccount extends Account implements Depositable, StatementProvider {

    private int months;

    public FixedDepositAccount(int accNo, String name, int age, double balance, int months) {
        super(accNo, name, age, balance, "Fixed Deposit", 0.0);
        this.months = months;
    }

    public int getMonths() {
        return months;
    }
}
