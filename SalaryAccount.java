public class SalaryAccount extends Account implements Depositable, Withdrawable, Transferable, StatementProvider, LoanEligible {

    private String company;

    public SalaryAccount(int accNo, String name, int age, double balance, String company) {
        super(accNo, name, age, balance, "Salary", 1000.0);
        this.company = company;
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

    public boolean applyForLoan(double amount) {
        if (amount > getBalance() * 10) {
            System.out.println("Loan of Rs. " + amount + " is too big for account " + getAccNo());
            return false;
        }
        System.out.println("Loan of Rs. " + amount + " approved for account " + getAccNo());
        return true;
    }

    public String getCompany() {
        return company;
    }
}
